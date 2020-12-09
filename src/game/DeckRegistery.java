package game;

import game.deck.Deck;
import game.deck.DemoDeck;

public class DeckRegistery {
	public static Deck get(String name)
	{
		switch (name) {
		default:
			return new DemoDeck();
		}
	}
}
