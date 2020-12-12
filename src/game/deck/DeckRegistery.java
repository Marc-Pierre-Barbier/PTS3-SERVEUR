package game.deck;

public class DeckRegistery {
	public static Deck get(String name)
	{
		switch (name) {
		case "mythes":
			return new Mythes();
		case "moyenage":
			return new MoyeneAge();
		case "rennaissance":
			return new Renaissance();
		default:
			return new MoyeneAge();
		}
	}
}
