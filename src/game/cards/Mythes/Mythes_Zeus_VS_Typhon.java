package game.cards.Mythes;

import game.cards.Card;
import game.cards.SpecialCard.ILifeSteal;

public class Mythes_Zeus_VS_Typhon extends Card implements ILifeSteal{
   

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
        return 8;
    }



    /**
     * cette fonction retourne le coût en mana de la carte qui sera afficher
     *
     * @return le cout
     */
    @Override
    public int getCost() {
        return 8;
    }

   
}
