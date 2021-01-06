package game.cards.SpecialCard;

public abstract class SelfHarmCard extends SteroidsCard{
	@Override
	public void onTurnStart() {
		heal(-1);
		super.onTurnStart();
	}
}
