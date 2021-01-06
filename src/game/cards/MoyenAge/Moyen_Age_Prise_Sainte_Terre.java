package game.cards.MoyenAge;

import game.cards.SpecialCard.LonerCard;

public class Moyen_Age_Prise_Sainte_Terre extends LonerCard {
   
    /**
     * retourne un entier coresspondant a l'attaque de la carte
     *
     * @return
     */
    @Override
    public int getDefaultAttack() {
        return 5;
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
