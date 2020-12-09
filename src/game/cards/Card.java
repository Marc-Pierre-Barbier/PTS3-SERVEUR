package game.cards;

import java.io.Serializable;

public abstract class Card  implements Serializable{
	

    /**
     * retourne un entier coresspondant a l'attaque de la carte
     * @return
     */
    public abstract int getAttack();

    /**
     * retourne la santé de la carte
     * @return
     */
    public abstract int getHealth();

    
    @Override
    public String toString() {
    	return ""+CardRegistery.get(this.getClass());
    }
    
    public abstract int getCost();
}

