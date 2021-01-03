package game;

import game.cards.Card;

/**
 * cette classe est le terrain du jeu
 * tout les carte placé sur le terrain sont stocké ici
 */
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
