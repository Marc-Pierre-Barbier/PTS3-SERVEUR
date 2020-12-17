package game.cards;

import java.util.ArrayList;
import java.util.List;

import game.cards.MoyenAge.Moyen_Age_Charlemagne;
import game.cards.MoyenAge.Moyen_Age_CharlesV;
import game.cards.MoyenAge.Moyen_Age_CharlesVII;
import game.cards.MoyenAge.Moyen_Age_Chretien_De_Troyes;
import game.cards.MoyenAge.Moyen_Age_Christine;
import game.cards.MoyenAge.Moyen_Age_Clovis;
import game.cards.MoyenAge.Moyen_Age_Croisade;
import game.cards.MoyenAge.Moyen_Age_Etienne;
import game.cards.MoyenAge.Moyen_Age_Ferré;
import game.cards.MoyenAge.Moyen_Age_Guerre_100;
import game.cards.MoyenAge.Moyen_Age_Guillaume;
import game.cards.MoyenAge.Moyen_Age_Heresie_Cathares;
import game.cards.MoyenAge.Moyen_Age_Hugue;
import game.cards.MoyenAge.Moyen_Age_Isabelle;
import game.cards.MoyenAge.Moyen_Age_Jean;
import game.cards.MoyenAge.Moyen_Age_Jean_Vienne;
import game.cards.MoyenAge.Moyen_Age_Jeanne;
import game.cards.MoyenAge.Moyen_Age_Louis;
import game.cards.MoyenAge.Moyen_Age_Malediction_Templier;
import game.cards.MoyenAge.Moyen_Age_Peste;
import game.cards.MoyenAge.Moyen_Age_Philippe;
import game.cards.MoyenAge.Moyen_Age_PhilippeIV;
import game.cards.MoyenAge.Moyen_Age_Philippe_Cacqueray;
import game.cards.MoyenAge.Moyen_Age_Pierre;
import game.cards.MoyenAge.Moyen_Age_Pierre_Ermite;
import game.cards.MoyenAge.Moyen_Age_Pouvoir_Du_Franc;
import game.cards.MoyenAge.Moyen_Age_Prise_Sainte_Terre;
import game.cards.MoyenAge.Moyen_Age_Roland;
import game.cards.MoyenAge.Moyen_Age_Sire_Jean;
import game.cards.MoyenAge.Moyen_Age_Traite_Verdun;
import game.cards.Mythes.Mythes_12_Travaux;
import game.cards.Mythes.Mythes_Achille;
import game.cards.Mythes.Mythes_Amazones;
import game.cards.Mythes.Mythes_Castor_Pollux;
import game.cards.Mythes.Mythes_Chant_Sirene;
import game.cards.Mythes.Mythes_Chaos;
import game.cards.Mythes.Mythes_Cheval_Troie;
import game.cards.Mythes.Mythes_Chiron;
import game.cards.Mythes.Mythes_Dédale;
import game.cards.Mythes.Mythes_Enigme_Sphinx;
import game.cards.Mythes.Mythes_Eole;
import game.cards.Mythes.Mythes_Erinyes;
import game.cards.Mythes.Mythes_Guerre_Sept_Chefs;
import game.cards.Mythes.Mythes_Hades;
import game.cards.Mythes.Mythes_Heracles;
import game.cards.Mythes.Mythes_Hermione;
import game.cards.Mythes.Mythes_Icar;
import game.cards.Mythes.Mythes_Kunée;
import game.cards.Mythes.Mythes_Minos;
import game.cards.Mythes.Mythes_Oedipie;
import game.cards.Mythes.Mythes_Perséphone;
import game.cards.Mythes.Mythes_Poseidon;
import game.cards.Mythes.Mythes_Psyché;
import game.cards.Mythes.Mythes_Rapt;
import game.cards.Mythes.Mythes_Sémélé;
import game.cards.Mythes.Mythes_Thanatos;
import game.cards.Mythes.Mythes_Titanomachie;
import game.cards.Mythes.Mythes_Toison;
import game.cards.Mythes.Mythes_Zeus;
import game.cards.Mythes.Mythes_Zeus_VS_Typhon;
import game.cards.Renaissance.Renaissance_Copernic;
import game.cards.Renaissance.Renaissance_Mehmet;
import game.cards.Renaissance.Renaissance_Soliman;
import game.cards.Renaissance.Rennaissance_Casimir;
import game.cards.Renaissance.Rennaissance_Charles;
import game.cards.Renaissance.Rennaissance_Chatherine;
import game.cards.Renaissance.Rennaissance_Chute_Constantinople;
import game.cards.Renaissance.Rennaissance_Concile_Trente;
import game.cards.Renaissance.Rennaissance_Constantin;
import game.cards.Renaissance.Rennaissance_Decouverte_Amerique;
import game.cards.Renaissance.Rennaissance_Elisabeth;
import game.cards.Renaissance.Rennaissance_Ferdinand;
import game.cards.Renaissance.Rennaissance_Fin_Guerre_Cent_Ans;
import game.cards.Renaissance.Rennaissance_Francois;
import game.cards.Renaissance.Rennaissance_Guerres_Italie;
import game.cards.Renaissance.Rennaissance_Henri;
import game.cards.Renaissance.Rennaissance_Henri_8;
import game.cards.Renaissance.Rennaissance_Isabelle;
import game.cards.Renaissance.Rennaissance_Ivan;
import game.cards.Renaissance.Rennaissance_Leonard;
import game.cards.Renaissance.Rennaissance_Machiavel;
import game.cards.Renaissance.Rennaissance_Michel_Ange;
import game.cards.Renaissance.Rennaissance_Nobunaga;
import game.cards.Renaissance.Rennaissance_Presse_Imprimer;
import game.cards.Renaissance.Rennaissance_Rabelais;
import game.cards.Renaissance.Rennaissance_Reforme;
import game.cards.Renaissance.Rennaissance_Shakespeare;
import game.cards.Renaissance.Rennaissance_Skanderberg;
import game.cards.Renaissance.Rennaissance_Succession_Bourgogne;
import game.cards.Renaissance.Rennaissance_Vlad;

/**
 * cette carte est un registre contenant toutes les cartes cela permet de sérialisé les cartes entre le client et le servuer avec un minimum d'information
 */
public class CardRegistery {
    public static List<Class<? extends Card>> registry;

    private static void initCardRegistery()
    {
        registry = new ArrayList<>();

        //Ce sont les cartes du deck Mythes et légendes grecs
        //Créatures
        registry.add(Mythes_Perséphone.class);
        registry.add(Mythes_Chiron.class);
        registry.add(Mythes_Dédale.class);
        registry.add(Mythes_Erinyes.class);
        registry.add(Mythes_Oedipie.class);
        registry.add(Mythes_Thanatos.class);
        registry.add(Mythes_Zeus.class);
        registry.add(Mythes_Hades.class);
        registry.add(Mythes_Poseidon.class);
        registry.add(Mythes_Chaos.class);
        registry.add(Mythes_Heracles.class);
        registry.add(Mythes_Achille.class);
        registry.add(Mythes_Minos.class);
        registry.add(Mythes_Psyché.class);
        registry.add(Mythes_Castor_Pollux.class);
        registry.add(Mythes_Sémélé.class);
        registry.add(Mythes_Hermione.class);
        registry.add(Mythes_Amazones.class);
        registry.add(Mythes_Eole.class);
        //Sorts
        registry.add(Mythes_Titanomachie.class);
        registry.add(Mythes_12_Travaux.class);
        registry.add(Mythes_Icar.class);
        registry.add(Mythes_Chant_Sirene.class);
        registry.add(Mythes_Rapt.class);
        registry.add(Mythes_Toison.class);
        registry.add(Mythes_Zeus_VS_Typhon.class);
        registry.add(Mythes_Enigme_Sphinx.class);
        registry.add(Mythes_Cheval_Troie.class);
        registry.add(Mythes_Kunée.class);
        registry.add(Mythes_Guerre_Sept_Chefs.class);

        //Cartes du deck Rennaissance
        //créatures
        registry.add(Renaissance_Soliman.class);
        registry.add(Rennaissance_Francois.class);
        registry.add(Rennaissance_Charles.class);
        registry.add(Rennaissance_Casimir.class);
        registry.add(Rennaissance_Henri.class);
        registry.add(Rennaissance_Henri_8.class);
        registry.add(Rennaissance_Constantin.class);
        registry.add(Renaissance_Mehmet.class);
        registry.add(Renaissance_Copernic.class);
        registry.add(Rennaissance_Leonard.class);
        registry.add(Rennaissance_Michel_Ange.class);
        registry.add(Rennaissance_Rabelais.class);
        registry.add(Rennaissance_Machiavel.class);
        registry.add(Rennaissance_Ivan.class);
        registry.add(Rennaissance_Elisabeth.class);
        registry.add(Rennaissance_Vlad.class);
        registry.add(Rennaissance_Nobunaga.class);
        registry.add(Rennaissance_Chatherine.class);
        registry.add(Rennaissance_Ferdinand.class);
        registry.add(Rennaissance_Isabelle.class);
        registry.add(Rennaissance_Skanderberg.class);
        registry.add(Rennaissance_Shakespeare.class);
        //sorts
        registry.add(Rennaissance_Fin_Guerre_Cent_Ans.class);
        registry.add(Rennaissance_Guerres_Italie.class);
        registry.add(Rennaissance_Chute_Constantinople.class);
        registry.add(Rennaissance_Presse_Imprimer.class);
        registry.add(Rennaissance_Decouverte_Amerique.class);
        registry.add(Rennaissance_Concile_Trente.class);
        registry.add(Rennaissance_Succession_Bourgogne.class);
        registry.add(Rennaissance_Reforme.class);

        //Cartes du deck Moyen-age
        //créatures
        registry.add(Moyen_Age_Clovis.class);
        registry.add(Moyen_Age_Charlemagne.class);
        registry.add(Moyen_Age_Hugue.class);
        registry.add(Moyen_Age_Philippe.class);
        registry.add(Moyen_Age_Louis.class);
        registry.add(Moyen_Age_CharlesV.class);
        registry.add(Moyen_Age_CharlesVII.class);
        registry.add(Moyen_Age_PhilippeIV.class);
        registry.add(Moyen_Age_Jeanne.class);
        registry.add(Moyen_Age_Jean.class);
        registry.add(Moyen_Age_Pierre.class);
        registry.add(Moyen_Age_Etienne.class);
        registry.add(Moyen_Age_Ferré.class);
        registry.add(Moyen_Age_Isabelle.class);
        registry.add(Moyen_Age_Jean_Vienne.class);
        registry.add(Moyen_Age_Sire_Jean.class);
        registry.add(Moyen_Age_Philippe_Cacqueray.class);
        registry.add(Moyen_Age_Guillaume.class);
        registry.add(Moyen_Age_Christine.class);
        registry.add(Moyen_Age_Chretien_De_Troyes.class);
        registry.add(Moyen_Age_Pierre_Ermite.class);
        registry.add(Moyen_Age_Roland.class);
        //sorts
        registry.add(Moyen_Age_Traite_Verdun.class);
        registry.add(Moyen_Age_Peste.class);
        registry.add(Moyen_Age_Croisade.class);
        registry.add(Moyen_Age_Guerre_100.class);
        registry.add(Moyen_Age_Malediction_Templier.class);
        registry.add(Moyen_Age_Prise_Sainte_Terre.class);
        registry.add(Moyen_Age_Heresie_Cathares.class);
        registry.add(Moyen_Age_Pouvoir_Du_Franc.class);
    }

    /**
     * retourne l'index de la carte donné en argument
     * @param class1 la class de la carte
     * @return index
     */
    public static int get(Class<? extends Card> class1) {
    	checkRegistry();
        int a = registry.indexOf(class1);
        return a != -1 ? a : 0;
    }

    /**
     * retourne la class de la carte a l'index donné
     * @param index index de la class
     * @return class de la carte
     */
    public static Class<? extends Card> get(int index) {
    	checkRegistry();
    	if(registry.size() <= index || index < 0) return null;
        return registry.get(index);
    }

    /**
     * verifie si le registre existe sinon le crée
     */
    private static void checkRegistry()
    {
    	if(registry == null)initCardRegistery();
    }
}