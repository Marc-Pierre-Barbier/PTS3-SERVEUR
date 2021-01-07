package game.cards.MoyenAge;

import game.cards.SpecialCard.SelfHarmCard;

public class Moyen_Age_Malediction_Templier extends SelfHarmCard{
   

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
        return 5;
    }

   

    /**
     * cette fonction retourne le coût en mana de la carte qui sera afficher
     *
     * @return le cout
     */
    @Override
    public int getCost() {
        return 1;
    }

   
}
