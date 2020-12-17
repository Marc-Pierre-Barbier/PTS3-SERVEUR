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
		//la direction reste incertaine car on n'est pas sur de l'ordre des données recut
		return forwardSerialisze(d);
		
	}

	/**
	 * sérialise le deck a l'envers
	 * @param d
	 * @return
	 */
	private static String reverseSerialisze(Deck d)
	{
		StringBuilder str = new StringBuilder(d.getCards().size()*2);
		Card[] cardArray = d.getCards().toArray(new Card[0]);
		for(int i = cardArray.length -1 ; i >= 0 ; i--)
		{
			str.append(cardArray[i]+",");
		}
		return str.toString();
	}

	/**
	 * sérialise la deck a l'endroit
	 * @param d
	 * @return
	 */
	private static String forwardSerialisze(Deck d)
	{
		StringBuilder str = new StringBuilder(d.getCards().size()*2);
		for(Card c : d.getCards())
		{
			str.append(c+",");
		}
		return str.toString();
	}
}
