package game;

import java.util.ArrayList;
import java.util.List;

import game.cards.Card;
import game.deck.Deck;

public class Hand {
	List<Card> hand;
	private Deck deck;
	private static final int MAX_CARD_IN_HAND = 5;

	public Hand(Deck deck) {
		this.deck=deck;
		this.hand = new ArrayList<>();
	}

	/**
	 * permet de piocher des carte depuis le deck et de les mettre dans la main
	 * @param i nombre de carte pioché
	 *
	 * si la main est pleine alors il arettra de pioché et se mettera a meulé
	 */
	public void draw(int i) {
		for(int j=0 ; j < i ; j++)
		{
			if(!isFull())hand.add(deck.draw());
			else{
				//si la main est pleine alors la carte pioché est perdu
				deck.draw();
			}
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

	public boolean isFull() {
		return hand.size() == MAX_CARD_IN_HAND;
	}
}
