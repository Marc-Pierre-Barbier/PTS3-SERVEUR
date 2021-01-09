package game.cards.MoyenAge;

import game.cards.Card;
import game.cards.SpecialCard.IInvisible;

public class Moyen_Age_PhilippeIV extends Card implements IInvisible{
   
    /**
     * retourne un entier coresspondant a l'attaque de la carte
     *
     * @return
     */
    @Override
    public int getDefaultAttack() {
        return 2;
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
