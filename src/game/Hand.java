package game;

import java.util.ArrayList;
import java.util.List;

import game.cards.Card;
import game.deck.Deck;

public class Hand {
	List<Card> hand;
	private Deck deck;

	public Hand(Deck deck) {
		this.deck=deck;
		this.hand = new ArrayList<>();
	}

	//TODO limiter le nombre de carte 
	public void draw(int i) {
		for(int j=0 ; j < i ; j++)
		{
			hand.add(deck.getCards().pop());
		}
	}

	/**
	 * retourne l'index de la carte
	 * @param c la classe  de la carte cherché
	 * @return -1 si elle n'est pas trouver
	 */
	public int contains(Class<? extends Card> c) {
		int index = 0;
		for(Card ca : hand)
		{
			if(ca.getClass().equals(c))
			{
				return index; 
			}
			index++;
		}
		return -1;
	}

	public Card remove(int index) {
		return hand.remove(index);
	}

}
