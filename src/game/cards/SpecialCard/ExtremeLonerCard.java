package game.cards.SpecialCard;

import game.Board;
import game.cards.Card;

public abstract class ExtremeLonerCard extends Card{
	@Override
	public void onCardPlaced(Board board) {
		if(board.getBoardSize() != 1)
		{
			makeStronger(-2);
			heal(-2);
		}
		super.onCardPlaced(board);
	}
}
