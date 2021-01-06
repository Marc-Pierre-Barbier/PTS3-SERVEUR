package game;

import game.cards.Card;
import game.deck.Deck;

public class DeckSerializer {
	/**
	 * transforme le deck en chaine envoyable au client
	 * @param d
	 * @return
	 */
	public static String serializeDeck(Deck d)
	{
		StringBuilder str = new StringBuilder(d.getCards().size()*2);
		for(Card c : d.getCards())
		{
			str.append(c+",");
		}
		return str.toString();
		
	}
}
