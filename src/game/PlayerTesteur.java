package game;

import java.io.IOException;
import java.net.Socket;

public class PlayerTesteur {
	
	
	public static boolean playerTest(Socket joueur)
	{
		ComsJoueur com;
		try {
			com = new ComsJoueur(joueur);
		} catch (IOException e) {
			return false;
		}
		
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
		
		try {
			com.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
