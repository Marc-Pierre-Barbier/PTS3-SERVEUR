package game;

import game.cards.Card;
import game.deck.Deck;

public class DeckSerializer {
	public static String serializeDeck(Deck d)
	{
		return forwardSerialisze(d);
		
	}
	
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
