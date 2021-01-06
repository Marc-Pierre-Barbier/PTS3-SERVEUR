package game.cards.MoyenAge;

import game.cards.SpecialCard.ILifeSteal;
import game.cards.SpecialCard.SteroidsCard;

public class Moyen_Age_Croisade extends SteroidsCard implements ILifeSteal{

    /**
     * retourne un entier coresspondant a l'attaque de la carte
     *
     * @return
     */
    @Override
    public int getDefaultAttack() {
        return 1;
    }

    /**
     * retourne la santé de la carte
     *
     * @return
     */
    @Override
    public int getDefaultHealth() {
        return 3;
    }


    /**
     * cette fonction retourne le coût en mana de la carte qui sera afficher
     *
     * @return le cout
     */
    @Override
    public int getCost() {
        return 5;
    }
}
