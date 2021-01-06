package game;

import java.util.Arrays;
import java.util.Iterator;

import game.cards.Card;

/**
 * cette classe est le terrain du jeu
 * il y a un terrain par joueur
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

	public Card getCardInZone(int zone) {
		return board[zone];
	}

	public Iterator<Card> getIterator(){
          return Arrays.stream(board).iterator();
    }

	public int getZoneOf(Card cardToUpDate) {
		int index = 0;
		for(Card c : board)
		{
			//si c'est la meme instance
			if(c == cardToUpDate)
			{
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public int getBoardSize()
	{
		int nbCardOnBoard = 0;
		for(Card c : board)
		{
			//si c'est la meme instance
			if(c != null)
			{
				nbCardOnBoard++;
			}
		}
		return nbCardOnBoard;
	}

}
