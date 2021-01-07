package game.cards.SpecialCard;

import game.cards.Card;

public abstract class VigilanceCard extends Card{
	int nbAttack = 2;
	
	public boolean hasAlreadyAttacked() {
		return nbAttack==2;
	}
	
	public void hasAttacked() {
		nbAttack++;
	}
	
	public void resetAttack() {
		nbAttack=0;
	}
}
