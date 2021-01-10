package game.cards.SpecialCard;

import java.util.Iterator;

import game.Board;
import game.cards.Card;

public abstract class StrongifyBufCard extends BufCard{
	@Override
	public void onCardPlaced(Board board) {
		super.onCardPlaced(board);
		Iterator<Card> it = board.getIterator();
		while(it.hasNext())
		{
			Card card = it.next();
			if(card != null)
			{
				card.makeStronger(1);
			}
		}
	}
}
