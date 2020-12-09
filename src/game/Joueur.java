package game;

import java.io.IOException;
import java.net.Socket;

import game.deck.Deck;

public class Joueur {

	Socket connection;
	ComsJoueur coms;
	Deck deck;
	Hand hand;
	int PV;
	
	public Joueur(Socket connectionJoueur) throws IOException {
		connection=connectionJoueur;
		coms = new ComsJoueur(connection);
		hand = new Hand();
		PV =20;
	}

	public void requestDataEarlyGameData() throws IOException {
		coms.send("getDeck");
		String deckname = (String) coms.recieve();
		deck = DeckRegistery.get(deckname);
		deck.shuffle();
		coms.send(DeckSerializer.serializeDeck(deck));
		draw(5);
		
	}
	
	public void draw(int amount) throws IOException
	{
		coms.send("draw");
		coms.send(amount);
		hand.draw(amount);
	}

	public void standyPhase() throws IOException {
		coms.send("yourTurn");
	}

	public void win() throws IOException {
		coms.send("win");
	}
	
	public void lose() throws IOException {
		coms.send("lose");
	}

	public void mainPhase1() {
		// TODO Auto-generated method stub
		
	}

	public void mainPhase2() {
		// TODO Auto-generated method stub
		
	}

	public void endPhase() {
		// TODO Auto-generated method stub
		
	}

}
