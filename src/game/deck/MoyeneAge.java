package game.deck;

import java.util.Stack;

import game.cards.Card;
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

public class MoyeneAge extends Deck{
	Stack<Card> cards;
	public MoyeneAge()
	{
		cards = new Stack<>();
		cards.add(new  Moyen_Age_Charlemagne());
		cards.add(new  Moyen_Age_CharlesVII());
		cards.add(new  Moyen_Age_CharlesV());
		cards.add(new  Moyen_Age_Chretien_De_Troyes());
		cards.add(new  Moyen_Age_Christine());
		cards.add(new  Moyen_Age_Clovis());
		cards.add(new  Moyen_Age_Croisade());
		cards.add(new  Moyen_Age_Etienne());
		cards.add(new  Moyen_Age_Ferré());
		cards.add(new  Moyen_Age_Guerre_100());
		cards.add(new  Moyen_Age_Guillaume());
		cards.add(new  Moyen_Age_Heresie_Cathares());
		cards.add(new  Moyen_Age_Hugue());
		cards.add(new  Moyen_Age_Isabelle());
		cards.add(new  Moyen_Age_Jean());
		cards.add(new  Moyen_Age_Jeanne());
		cards.add(new  Moyen_Age_Jean_Vienne());
		cards.add(new  Moyen_Age_Louis());
		cards.add(new  Moyen_Age_Malediction_Templier());
		cards.add(new  Moyen_Age_Peste());
		cards.add(new  Moyen_Age_Philippe_Cacqueray());
		cards.add(new  Moyen_Age_PhilippeIV());
		cards.add(new  Moyen_Age_Philippe());
		cards.add(new  Moyen_Age_Pierre_Ermite());
		cards.add(new  Moyen_Age_Pierre());
		cards.add(new  Moyen_Age_Pouvoir_Du_Franc());
		cards.add(new  Moyen_Age_Prise_Sainte_Terre());
		cards.add(new  Moyen_Age_Roland());
		cards.add(new  Moyen_Age_Sire_Jean());
		cards.add(new  Moyen_Age_Traite_Verdun());
	}
	
	
	@Override
	public Stack<Card> getCards() {
		return cards;
	}

	
}
