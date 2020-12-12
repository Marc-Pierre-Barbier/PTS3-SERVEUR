package game;

import game.cards.Card;

public class Board {

	private Card[] board;
	
	public Board() {
		board = new Card[5];
	}
	
	public boolean isZoneAvaliable(int zone) {
		return board[zone] == null;
	}
	
	public void setCard(int index, Card c)
	{
		board[index]=c;
	}

}
