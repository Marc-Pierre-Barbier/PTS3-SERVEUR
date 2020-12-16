package game;

import java.io.IOException;

import game.cards.Card;
import game.cards.CardRegistery;
import game.deck.Deck;
import game.deck.DeckRegistery;

public class Joueur {
	private ComsJoueur coms;
	private Deck deck;
	private Hand hand;
	private int pV;
	private int currentMana=0;
	private int mana;

	
	public Joueur(ComsJoueur connectionJoueur) throws IOException {
		coms=connectionJoueur;
		pV =20;
	}

	public void requestDataEarlyGameData() throws IOException {
		coms.send("getDeck");
		String deckname = (String) coms.recieve();
		deck = DeckRegistery.get(deckname);
		deck.shuffle();
		hand = new Hand(deck);
		coms.send(DeckSerializer.serializeDeck(deck));
		draw(5);
		
	}
	
	public void draw(int amount) throws IOException
	{
		coms.send(Command.DRAW);
		coms.send(amount);
		hand.draw(amount);
	}

	public void debutTourEnemie() throws IOException {
		coms.send(Command.ENEMYTURN);
	}

	public void win() throws IOException {
		coms.send(Command.WIN);
	}
	
	public void lose() throws IOException {
		coms.send(Command.LOSE);
	}

	/**
	 * premiére phase de jeu avant d'attacker
	 * @param adversaire
	 * @param board 
	 * @throws IOException
	 */
	public void mainPhase1(Joueur adversaire, Board board) throws IOException {
		//on prepare la mana
		if(currentMana < 10)currentMana++;
		mana=currentMana;
		coms.send(Command.SETMANA);
		coms.send(mana);
		
		//on affiche le debut de tour
		coms.send(Command.YOURTURN);
		System.out.println("NOW WE SHOULDN'T SEND COMMAND");
		
		boolean phaseActive=true;
		//debut de l'écoude des action client
		adversaire.getComs().getSocket().setSoTimeout(Integer.MAX_VALUE);
		while(phaseActive)
		{
			coms.getSocket().setSoTimeout(500);
			String command = (String) coms.recieve();
			coms.getSocket().setSoTimeout(Integer.MAX_VALUE);
			if(command != null && !command.equals("time out"))
			{
				System.out.println("GOT COMMAND :"+command);

				switch (command) {
				
				case Command.PING:
					coms.send(Command.PONG);
					break;
					
				case Command.PASS_TURN:
					phaseActive=false;
					break;
					
				case Command.PUT_CARD:
					System.out.println("entering put card");
					putCard(adversaire,board);
					break;
					
				default:
					System.err.println("unknown command "+command);
				}
				
			}
		}
	}

	private void putCard(Joueur adversaire, Board board) throws IOException {
		//crash here
		String info = (String) coms.recieve();
		//si ce n'est pas un nombre
		if(!info.matches("-?\\d+")) {
			System.err.println(info);
		}else {
			int cardId = Integer.parseInt(info);
			
			Class<? extends Card> cardClass = CardRegistery.get(cardId);
			System.out.println(cardClass.getName());
			
			
			int zone = Integer.parseInt(coms.recieve());
			
			int handIndex = hand.contains(cardClass);
			if(handIndex == -1)coms.send(Command.NOK);
			else {
				if(board.isZoneAvaliable(zone))
				{
					Card card = hand.remove(handIndex);
					board.setCard(zone, card);
					adversaire.enemyPlay(cardId,zone);
					coms.send(Command.OK);
				}else {
					coms.send(Command.NOK);
				}
			}
		}
		
	}

	private void enemyPlay(int cardId,int zone) throws IOException {
		coms.send(Command.PUT_ENEMY_CARD);
		coms.send(cardId);
		coms.send(zone);
	}

	public void mainPhase2() {
		// TODO Auto-generated method stub
		
	}

	public void endPhase() {
		// TODO Auto-generated method stub
		
	}

	public ComsJoueur getComs() {
		return coms;
	}
	
	public void setPV(int pV) {
		this.pV = pV;
	}
	
	public boolean isDead()
	{
		return pV == 0;
	}
	
	public boolean isAlive()
	{
		return !isDead();
	}
	
	public void sendMessage(String message) throws IOException
	{
		coms.send("pupup");
		coms.send(message);
	}
}
