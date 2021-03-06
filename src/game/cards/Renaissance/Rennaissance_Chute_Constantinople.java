package game.cards.Renaissance;

import game.cards.Card;
import game.cards.SpecialCard.IPlayerFocused;

public class Rennaissance_Chute_Constantinople extends Card implements IPlayerFocused {
   
    /**
     * retourne un entier coresspondant a l'attaque de la carte
     *
     * @return
     */
    @Override
    public int getDefaultAttack() {
        return 4;
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
        return 6;
    }

   
}
