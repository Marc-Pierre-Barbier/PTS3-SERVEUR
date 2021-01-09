package game.cards.Mythes;

import game.cards.SpecialCard.ExtremeLonerCard;

public class Mythes_Erinyes extends ExtremeLonerCard{
  

    /**
     * retourne un entier coresspondant a l'attaque de la carte
     *
     * @return
     */
    @Override
    public int getDefaultAttack() {
        return 7;
    }

    /**
     * retourne la santé de la carte
     *
     * @return
     */
    @Override
    public int getDefaultHealth() {
        return 7;
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
