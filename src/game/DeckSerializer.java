package game;

import game.cards.Card;
import game.deck.Deck;

public class DeckSerializer {
	public static String serializeDeck(Deck d)
	{
		StringBuilder str = new StringBuilder(d.getCards().size()*2);
		for(Card c : d.getCards())
		{
			str.append(c.toString()+",");
		}
		return str.toString();
	}
	
	public static Deck deSerializeDeck(String g)
	{
		return null;
		
	}
}
