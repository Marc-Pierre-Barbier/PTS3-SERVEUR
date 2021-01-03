package game;

import java.io.IOException;

public class PlayerTesteur {

	/**
	 * test si un joueur est planté ou non
	 * @param com un ComsJoeur correspondant au joueur
	 * @return false si le joeur est hs
	 */
	public static boolean playerTest(ComsJoueur com)
	{
		try {
			com.send(Command.PING);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("une erreur c'est produite l'ors du ping");
			return false;
		}
		
		try {
			//pong
			com.recieve();
		} catch (Exception e) {
			System.out.println("le client a été trop long pour répondre ou une erreur reseau c'est porduite");
			return false;
		}
		return true;
	}
}
