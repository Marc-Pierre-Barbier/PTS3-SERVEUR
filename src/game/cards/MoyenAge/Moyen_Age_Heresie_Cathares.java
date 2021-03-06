package game.cards.MoyenAge;

import game.cards.Card;
import game.cards.SpecialCard.IShortRange;

public class Moyen_Age_Heresie_Cathares extends Card implements IShortRange{
    

    /**
     * retourne un entier coresspondant a l'attaque de la carte
     *
     * @return
     */
    @Override
    public int getDefaultAttack() {
        return 6;
    }

    /**
     * retourne la santé de la carte
     *
     * @return
     */
    @Override
    public int getDefaultHealth() {
        return 6;
    }

    /**
     * cette fonction retourne le coût en mana de la carte qui sera afficher
     *
     * @return le cout
     */
    @Override
    public int getCost() {
        return 7;
    }
}
