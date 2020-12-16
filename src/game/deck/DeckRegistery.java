package game.deck;

public class DeckRegistery {
	public static Deck get(String name)
	{
		switch (name.trim()) {
		case "mythes et legendes grecs":
			return new Mythes();
		case "moyen-age francais":
			return new MoyeneAge();
		case "renaissance":
			return new Renaissance();
		default:
			System.out.println(name);
			return new MoyeneAge();
		}
	}
}
