import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import game.ComsJoueur;
import game.Match;
import game.PlayerTesteur;

public class Serveur {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		final String host = "localhost";
		final int port = 10430;

		//socket du serveur permet la connection de client
		ServerSocket tCPserver = null;
		try {
			tCPserver = new ServerSocket(port, 50, InetAddress.getByName(host));
		} catch (UnknownHostException e1) {// cette exception ne s'affichera jammais vu que l'on utilise localhost
		} catch (IOException e1) {
			System.err.println(
					"erreur le serveur n'a pas put dermarer \nil est probablement blocké par un autre processus paralélle");
			return;
		}

		System.out.println("server ready");

		//la file d'attente
		Socket joueur1EnAttente = null;
		ComsJoueur joueur1Com = null;
		Socket joueur2EnAttente = null;
		ComsJoueur joueur2Com = null;
		
		while (true) {
			if (joueur1EnAttente == null) {
				try {
					joueur1EnAttente = tCPserver.accept();
					joueur1Com = new ComsJoueur(joueur1EnAttente);
					System.out.println("joueur1 trouvé");
				} catch (IOException e) {
					joueur1EnAttente = null;
					joueur1Com=null;
				}
			}
			if (joueur2EnAttente == null) {
				try {
					joueur2EnAttente = tCPserver.accept();
					joueur2Com = new ComsJoueur(joueur2EnAttente);
					System.out.println("joueur2 trouvé");
				} catch (IOException e) {
					joueur2EnAttente = null;
					joueur2Com=null;
				}
			}
			if (joueur1EnAttente != null && joueur1Com != null && joueur2EnAttente != null && joueur2Com != null) {
				try {
					if (PlayerTesteur.playerTest(joueur1Com)) {
						if (PlayerTesteur.playerTest(joueur2Com)) {
							new Match(joueur1Com,joueur2Com);
							System.out.println("match lancé");
							joueur2EnAttente = null;
							joueur2Com=null;
							joueur1EnAttente = null;
							joueur1Com=null;
						} else {
							// le joueur est cassé donc on le retire de la file d'attente
							System.out.println("j2 invalid");
							joueur2EnAttente.close();
							joueur2EnAttente = null;
							joueur2Com=null;
						}
					} else {
						// le joueur est cassé donc on le retire de la file d'attente
						System.out.println("j1 invalid");
						joueur1EnAttente.close();
						joueur1EnAttente = null;
						joueur1Com=null;
					}

				} catch (IOException e) {
					System.out.println("client dead");
				}
			}
		}
	}

}
