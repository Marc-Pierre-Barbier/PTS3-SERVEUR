import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import game.Match;
import game.PlayerTesteur;

public class Serveur {

	public static void main(String[] args) {
		final String host = "localhost";
		final int port = 10430;

		ServerSocket tCPserver = null;
		try {
			tCPserver = new ServerSocket(port, 50, InetAddress.getByName(host));
			tCPserver.setSoTimeout(250);// 250 de ping max
		} catch (UnknownHostException e1) {// cette exception ne s'affichera jammais vu que l'on utilise localhost
		} catch (IOException e1) {
			System.err.println(
					"erreur le serveur n'a pas put dermarer \nil est probablement blocké par un autre processus paralélle");
			return;
		}

		// l'udp est un protocole plus rapide que le tcp si on a des probleme de latence
		// voila une solution
		// mais il est moin fiable
		// DatagramSocket uDPServeur = new DatagramSocket(port);
		// uDPServeur.setSoTimeout(500);//si au bout d'une demi-seconde on a pas de
		// réponse alors le client est hs

		System.out.println("server ready");

		Socket joueur1EnAttente = null;
		Socket joueur2EnAttente = null;
		while (true) {
			if (joueur1EnAttente == null) {
				try {
					joueur1EnAttente = tCPserver.accept();
					System.out.println("joueur1 trouvé");
				} catch (IOException e) {
					joueur1EnAttente = null;
				}
			}
			if (joueur2EnAttente == null) {
				try {
					joueur2EnAttente = tCPserver.accept();
					System.out.println("joueur2 trouvé");
				} catch (IOException e) {
					joueur2EnAttente = null;
				}
			}
			if (joueur1EnAttente != null && joueur2EnAttente != null) {
				try {
					if (PlayerTesteur.playerTest(joueur1EnAttente)) {
						if (PlayerTesteur.playerTest(joueur2EnAttente)) {
							new Match(joueur1EnAttente, joueur2EnAttente);
							System.out.println("match lancé");
						} else {
							// le joueur est cassé donc on le retire de la file d'attente
							joueur2EnAttente = null;
						}
					} else {
						// le joueur est cassé donc on le retire de la file d'attente
						joueur1EnAttente = null;
					}

				} catch (IOException e) {
					System.out.println("client dead");
				}
			}
		}
	}

}
