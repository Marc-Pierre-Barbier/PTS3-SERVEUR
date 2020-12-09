package game;

import java.io.IOException;
import java.net.Socket;

public class Match extends Thread {
	Joueur joueur1, joueur2;
	int tour = 1;

	public Match(Socket j1, Socket j2) throws IOException {
		super();
		// random j2/j1
		if (Math.random() > 0.5F) {
			joueur1 = new Joueur(j1);
			joueur2 = new Joueur(j2);
		} else {
			joueur1 = new Joueur(j2);
			joueur2 = new Joueur(j1);
		}

		joueur1.requestDataEarlyGameData();
		joueur2.requestDataEarlyGameData();
		Thread connect = new Thread();
		connect.run();
		System.out.println("ready");
		start();
	}

	// gameplay
	@Override
	public void run() {
		while (joueur1.PV != 0 || joueur2.PV != 0) {
			try {
				tour(joueur1);
				tour(joueur2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			endMatch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//annonce du vainqueur et du perdant
	private void endMatch() throws IOException {
		if(joueur1.PV == 0) {
			joueur2.win();
			joueur1.lose();
		}else {
			joueur1.win();
			joueur2.lose();
		}
	}

	//enchainement d'action que fait un joueur durant son tour
	private void tour(Joueur joueur) throws IOException {
		joueur1.coms.send("pupup");
		joueur1.coms.send("tour : " + tour);
		joueur2.coms.send("pupup");
		joueur2.coms.send("tour : " + tour);
		joueur.draw(1); //pioche 1 carte
		joueur.standyPhase(); //Activation des effets avant que le tour du @joueur commence
		joueur.mainPhase1(); //Joue autant de carte qu'il veut/peut
		battlePhase(joueur);//lance des attaques à son adversaire qui peut répliquer
		joueur.mainPhase2();//Nouvelle phase ou le @joueur peut jouer ses cartes si il veut/peut
		joueur.endPhase();//fin du tour du @joueur
	}

	private void battlePhase(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}
}
