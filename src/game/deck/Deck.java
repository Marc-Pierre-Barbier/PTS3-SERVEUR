package game.deck;

import java.io.Serializable;
import java.util.Collections;
import java.util.Stack;

import game.cards.Card;

public abstract class Deck implements Serializable{
	private static final long serialVersionUID = -4305303353908447343L;

	public abstract Stack<Card> getCards();

    public void shuffle()
    {
        Collections.shuffle(getCards());
    }

    /**
     * retourne le nom du deck ex: ww2 , science
     * ce nom doit être unique
     * @return
     */
    public abstract String getDeckName();
}
