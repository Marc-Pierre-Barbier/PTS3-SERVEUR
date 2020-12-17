package game.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import game.cards.Card;

public abstract class Deck {

	public abstract Stack<Card> getCards();

    public void shuffle()
    {
        Collections.shuffle(getCards());
    }


    public Card draw()
    {
        return getCards().pop();
    }

    public List<Card> draw(int amount)
    {
        List<Card> cards = new ArrayList<>();
        for(int i = 0 ; i < amount ; i++)
        {
            cards.add(getCards().pop());
        }
        return cards;
    }
}
