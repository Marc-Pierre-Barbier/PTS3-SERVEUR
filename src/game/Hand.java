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
	 * retourne la carte si elle est contenu dans la main de la carte
	 * @param c la classe  de la carte cherché
	 * @return null si elle n'est pas trouver
	 */
	public Card contains(Class<? extends Card> c) {
		for(Card ca : hand)
		{
			if(ca.getClass().equals(c))
			{
				return ca;
			}
		}
		return null;
	}

	/**
	 * retire la carte
	 * @param c carte a retirer
	 * @return si la carte a été retirer
	 */
	public Boolean remove(Card c)
	{
		return hand.remove(c);

	}

	public boolean isFull() {
		return hand.size() == MAX_CARD_IN_HAND;
	}

	public void print() {
		for(Card c : hand)
		{
			System.out.println(c.getClass().getSimpleName());
		}
	}
}
