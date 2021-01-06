package game.cards.SpecialCard;

import game.cards.Card;

public abstract class SteroidsCard extends Card{

	@Override
	public void onTurnStart() {
		makeStronger(1);
		super.onTurnStart();
	}
}
