package game.cards;

public abstract class Card{
	
	private int attack;
	private int health;
	private boolean hasAttacked=true;
	
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
    
    /**
     * diminue les point de vie de la carte
     * @param amountOfHpToLose nombre de hp a perdre
     * @return renvoie true sur si la carte est a 0hp
     */
    public boolean takeDamage(int amountOfHpToLose)
    {
    	if(health <= amountOfHpToLose)
    	{
    		health = 0;
    	}else {
    		health -= amountOfHpToLose;
    	}
		return health == 0;
    }
    
	public boolean hasAlreadyAttacked() {
		return hasAttacked;
	}
	
	public void hasAttacked() {
		hasAttacked = true;
	}
	
	public void resetAttack() {
		hasAttacked=false;
	}
}

