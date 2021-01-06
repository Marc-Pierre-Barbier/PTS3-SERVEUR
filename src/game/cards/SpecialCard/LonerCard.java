package game.cards.SpecialCard;

import game.Board;
import game.cards.Card;

public abstract class LonerCard extends Card{
	@Override
	public void onCardPlaced(Board board) {
		if(board.getBoardSize() == 1)
		{
			makeStronger(3);
		}
		super.onCardPlaced(board);
	}
}
