package game.cards.Renaissance;

import game.cards.SpecialCard.HasteCard;
import game.cards.SpecialCard.IToxic;

public class Rennaissance_Decouverte_Amerique extends HasteCard implements IToxic{
   

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
        return 1;
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
