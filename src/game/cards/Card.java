package game.cards;

public abstract class Card{
	
	private int attack;
	private int health;
	
	public Card() {
		attack = getDefaultAttack();
		health = getDefaultHealth();
	}
    /**
     * retourne un entier coresspondant a l'attaque de la carte
     * @return
     */
    public final int getAttack() {
    	return attack;
    }
    
	/**
     * retourne la santé de la carte
     * @return
     */
    public final int getHealth() {
		return health;
	}

    /**
     * l'attack par defaut des cartes
     * @return
     */
    public abstract int getDefaultAttack();

    /**
     * les point de vie par default de la carte
     * @return
     */
    public abstract int getDefaultHealth();
    
    /**
     * evenement déclanché au placement de la carte
     */
    public void onCardPlaced(){};
    /**
     * évenement déclenché a la mort de la carte
     */
    public void onCardDestroyed(){};
    /**
     * évenement déclenché au debut de tour
     */
    public void onTurnStart(){};
    
    @Override
    public String toString() {
    	return ""+CardRegistery.get(this.getClass());
    }
    
    /**
     * retourne le cout de la carte
     * @return
     */
    public abstract int getCost();
}

