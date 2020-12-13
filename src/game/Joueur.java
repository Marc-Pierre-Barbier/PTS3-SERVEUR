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
		
		boolean phaseActive=true;
		//debut de l'écoude des action client
		while(phaseActive)
		{
			String command;
			command = (String) coms.recieve();

			System.out.println("GOT COMMAND :"+command);
			if(command != null)
			{
				switch (command) {
				
				case Command.PING:
					coms.send(Command.PONG);
					System.out.println("pong");
					break;
					
				case Command.PASS_TURN:
					phaseActive=false;
					break;
					
				case Command.PUT_CARD:
					putCard(adversaire,board);
					break;
				case "time out":
					System.exit(0);
					break;
					
				default:
					coms.send(Command.POPUP);
					coms.send("vous ne pouvez pas faire sa a la premiére phase");
					break;
				}
			}
			
			//on maintien l'adversaire actif en lui envoyant un ping
			adversaire.ping();
		}
	}

	private void putCard(Joueur adversaire, Board board) throws IOException {
		Object info = coms.recieve();
		if(info instanceof String) {
			System.err.println((String)info);
		}else {
			int cardId = (int)info;
			
			Class<? extends Card> cardClass = CardRegistery.get(cardId);
			
			int zone = (int)coms.recieve();
			
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

	/**
	 * envoie ping au jour et retourne vrai si le joueur a repondu
	 * @return
	 */
	private boolean ping() {
		try {
			coms.send(Command.PING);
		} catch (IOException e) {
			return false;
		}
		return coms.recieve().equals(Command.PONG);//pong
		
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
