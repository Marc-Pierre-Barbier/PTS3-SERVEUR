package game.cards.Renaissance;

import game.cards.SpecialCard.VigilanceCard;

public class Rennaissance_Concile_Trente extends VigilanceCard {
   
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
        return 4;
    }

   
    /**
     * cette fonction retourne le coût en mana de la carte qui sera afficher
     *
     * @return le cout
     */
    @Override
    public int getCost() {
        return 3;
    }

    
}
