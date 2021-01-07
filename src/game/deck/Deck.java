package game.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import game.cards.Card;

public abstract class Deck {

	public abstract Stack<Card> getCards();

    /**
     * mélange le deck
     * /!\ il faut envoyer le deck au client une fois mélanger
     */
    public void shuffle()
    {
        Collections.shuffle(getCards());
    }

    /**
     * retire une carte de deck
     * @return la carte retirer
     */
    public Card draw()
    {
        return getCards().pop();
    }

    /**
     * retire une liste de carte
     * @param amount
     * @return
     */
    public List<Card> draw(int amount)
    {
        List<Card> cards = new ArrayList<>();
        for(int i = 0 ; i < amount ; i++)
        {
            cards.add(draw());
        }
        return cards;
    }
    
    public boolean isEmpty()
    {
    	return getCards().isEmpty();
    }
}
