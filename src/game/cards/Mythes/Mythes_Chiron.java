package game.cards.Mythes;

import game.cards.Card;

public class Mythes_Chiron extends Card{
    

    /**
     * retourne un entier coresspondant a l'attaque de la carte
     *
     * @return
     */
    @Override
    public int getDefaultAttack() {
        return 3;
    }

    /**
     * retourne la santé de la carte
     *
     * @return
     */
    @Override
    public int getDefaultHealth() {
        return 2;
    }

    
    /**
     * cette fonction retourne le coût en mana de la carte qui sera afficher
     *
     * @return le nom
     */
    @Override
    public int getCost() {
        return 3;
    }

    
}
