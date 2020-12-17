package game.deck;

/**
 * registre de deck
 * le client ne sais pas quelles cartes apartienne a quel deck
 * cette information est conservé uniquement sur le serveur donc le client demande un deck
 * et le serveur le sert
 * d'ou l'interet d'un registre de deck
 */
public class DeckRegistery {

	/**
	 * retourne un nouveau deck en fonction du nom donné
	 * @param name
	 * @return
	 */
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
			System.out.println("deck non trouvé :"+name);
			return new MoyeneAge();
		}
	}
}
