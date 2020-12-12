package game.deck;

import java.util.Stack;

import game.cards.Card;
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

public class Mythes extends Deck{
	Stack<Card> cards;
	public Mythes()
	{
		cards = new Stack<>();
		cards.add(new Mythes_12_Travaux());         
		cards.add(new Mythes_Hermione());
		cards.add(new Mythes_Achille());            
		cards.add(new Mythes_Icar());
		cards.add(new Mythes_Amazones());           
		cards.add(new Mythes_Kunée());
		cards.add(new Mythes_Castor_Pollux());      
		cards.add(new Mythes_Minos());
		cards.add(new Mythes_Chant_Sirene());       
		cards.add(new Mythes_Oedipie());
		cards.add(new Mythes_Chaos());              
		cards.add(new Mythes_Perséphone());
		cards.add(new Mythes_Cheval_Troie());       
		cards.add(new Mythes_Poseidon());
		cards.add(new Mythes_Chiron());             
		cards.add(new Mythes_Psyché());
		cards.add(new Mythes_Dédale());             
		cards.add(new Mythes_Rapt());
		cards.add(new Mythes_Enigme_Sphinx());      
		cards.add(new Mythes_Sémélé());
		cards.add(new Mythes_Eole());               
		cards.add(new Mythes_Thanatos());
		cards.add(new Mythes_Erinyes());            
		cards.add(new Mythes_Titanomachie());
		cards.add(new Mythes_Guerre_Sept_Chefs());  
		cards.add(new Mythes_Toison());
		cards.add(new Mythes_Hades());              
		cards.add(new Mythes_Zeus());
		cards.add(new Mythes_Heracles());           
		cards.add(new Mythes_Zeus_VS_Typhon());
	}
	
	
	@Override
	public Stack<Card> getCards() {
		return cards;
	}
	
}
