package game.deck;

import java.util.Stack;

import game.cards.Card;
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

public class Renaissance extends Deck{
	Stack<Card> cards;
	public Renaissance()
	{
		cards = new Stack<>();
		cards.add(new  Renaissance_Copernic());
		cards.add(new  Renaissance_Mehmet());
		cards.add(new  Renaissance_Soliman());
		cards.add(new  Rennaissance_Casimir());
		cards.add(new  Rennaissance_Charles());
		cards.add(new  Rennaissance_Chatherine());
		cards.add(new  Rennaissance_Chute_Constantinople());
		cards.add(new  Rennaissance_Concile_Trente());
		cards.add(new  Rennaissance_Constantin());
		cards.add(new  Rennaissance_Decouverte_Amerique());
		cards.add(new  Rennaissance_Elisabeth());
		cards.add(new  Rennaissance_Ferdinand());
		cards.add(new  Rennaissance_Fin_Guerre_Cent_Ans());
		cards.add(new  Rennaissance_Francois());
		cards.add(new  Rennaissance_Guerres_Italie());
		cards.add(new  Rennaissance_Henri_8());
		cards.add(new  Rennaissance_Henri());
		cards.add(new  Rennaissance_Isabelle());
		cards.add(new  Rennaissance_Ivan());
		cards.add(new  Rennaissance_Leonard());
		cards.add(new  Rennaissance_Machiavel());
		cards.add(new  Rennaissance_Michel_Ange());
		cards.add(new  Rennaissance_Nobunaga());
		cards.add(new  Rennaissance_Presse_Imprimer());
		cards.add(new  Rennaissance_Rabelais());
		cards.add(new  Rennaissance_Reforme());
		cards.add(new  Rennaissance_Shakespeare());
		cards.add(new  Rennaissance_Skanderberg());
		cards.add(new  Rennaissance_Succession_Bourgogne());
		cards.add(new  Rennaissance_Vlad());
	}
	
	@Override
	public Stack<Card> getCards() {
		return cards;
	}


	
}
