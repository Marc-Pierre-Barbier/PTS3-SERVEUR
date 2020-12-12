package game.deck;

import java.util.Collections;
import java.util.Stack;

import game.cards.Card;

public abstract class Deck {

	public abstract Stack<Card> getCards();

    public void shuffle()
    {
        Collections.shuffle(getCards());
    }

}
