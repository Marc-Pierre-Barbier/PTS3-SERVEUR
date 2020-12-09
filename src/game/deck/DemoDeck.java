package game.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import game.cards.Card;
import game.cards.DemoCard;
import game.cards.DemoCard2;

public class DemoDeck extends Deck{
	Stack<Card> cards;
	public DemoDeck()
	{
		cards = new Stack<>();
		for(int i = 0 ; i < 50 ; i++)
		{
			if(Math.random() > 0.5)cards.add(new DemoCard());
			else cards.add(new DemoCard2());
		}
	}

	@Override
	public Stack<Card> getCards() {
		// TODO Auto-generated method stub
		return cards;
	}

	@Override
	public String getDeckName() {
		return "DemoDeck";
	}
}
