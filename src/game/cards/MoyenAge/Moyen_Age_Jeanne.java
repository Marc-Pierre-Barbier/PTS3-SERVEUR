package game.cards.MoyenAge;

import game.cards.Card;
import game.cards.SpecialCard.ILifeSteal;

public class Moyen_Age_Jeanne extends Card implements ILifeSteal{
   
    /**
     * retourne un entier coresspondant a l'attaque de la carte
     *
     * @return
     */
    @Override
    public int getDefaultAttack() {
        return 3;
    }

    /**
     * retourne la santé de la carte
     *
     * @return
     */
    @Override
    public int getDefaultHealth() {
        return 4;
    }



    /**
     * cette fonction retourne le coût en mana de la carte qui sera afficher
     *
     * @return le cout
     */
    @Override
    public int getCost() {
        return 4;
    }
}
