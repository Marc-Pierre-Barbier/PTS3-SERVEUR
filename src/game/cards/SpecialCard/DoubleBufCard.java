package game.cards.SpecialCard;

import java.util.Iterator;

import game.Board;
import game.cards.Card;

public abstract class DoubleBufCard extends BufCard{
	@Override
	public void onCardPlaced(Board board) {
		super.onCardPlaced(board);
		Iterator<Card> it = board.getIterator();
		while(it.hasNext())
		{
			Card card = it.next();
			card.heal(1);
			card.makeStronger(1);
		}
	}
}
