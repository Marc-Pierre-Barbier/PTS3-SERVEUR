package game.cards.SpecialCard;

import game.cards.Card;

public abstract class RegeneratingCard extends Card{
	@Override
	public void onTurnStart() {
		heal(1);
		super.onTurnStart();
	}
}
