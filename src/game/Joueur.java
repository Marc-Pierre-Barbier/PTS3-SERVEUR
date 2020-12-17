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
		coms.send(Command.GET_DECK);
		String deckname = coms.recieve();
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
	 * cette commande doit être utilisé a chaque début de tour elle permet d'augmenter la mana du joueur
	 * @throws IOException
	 */
	public void prepMana() throws IOException {
		//on prepare la mana
		if(currentMana < 10)currentMana++;
		mana=currentMana;
		coms.send(Command.SETMANA);
		coms.send(mana);
	}


	/**
	 * premiére phase de jeu avant d'attacker
	 * @param adversaire
	 * @param board 
	 * @throws IOException
	 */
	public void mainPhase1(Joueur adversaire, Board board) throws IOException {
		System.out.println("NOW WE SHOULDN'T SEND COMMAND");
		
		boolean phaseActive=true;
		//on retire le time out sur l'adversaire car sa peut causer des désyncronisatoin et des crash
		adversaire.getComs().getSocket().setSoTimeout(Integer.MAX_VALUE);
		//debut de l'écoude des action client
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
		String info = coms.recieve();
		//si ce n'est pas un nombre
		if(!info.matches("-?\\d+")) {
			//alors on affiche l'inforamtion si la sortie d'erreur
			System.err.println(info);
		}else {
			//on recupére la carte
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
		coms.send(Command.POPUP);
		coms.send(message);
	}

	public void yourturn() throws IOException {
		//on affiche le debut de tour
		coms.send(Command.YOURTURN);
	}

	public boolean isHandFull() {
		return hand.isFull();
	}

	public void meule(int nbcard) throws IOException {
		coms.send(Command.MEULE);
		coms.send(nbcard);
		deck.draw(1);
	}
}
