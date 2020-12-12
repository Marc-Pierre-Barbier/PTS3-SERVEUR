package game;

import java.io.IOException;
import java.net.Socket;

public class Match extends Thread {
	Joueur joueur1, joueur2;
	int tour = 1;
	private Board board;

	public Match(Socket j1, Socket j2) throws IOException {
		super();
		this.board=new Board();
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
		while (joueur1.isAlive() &&  joueur2.isAlive()) {
			try {
				tour(joueur1);
				tour(joueur2);
			} catch (IOException e) {
				endGameAfterIssue();
			}
		}
		try {
			endMatch();
		} catch (IOException e) {
			endGameAfterIssue();
		}
	}

	private void endGameAfterIssue() {
		if(PlayerTesteur.playerTest(joueur1.getConnection()))
		{
			try {
				joueur1.win();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(PlayerTesteur.playerTest(joueur2.getConnection()))
		{
			try {
				joueur2.win();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		joueur1.setPV(0);
		joueur2.setPV(0);
	}

	//annonce du vainqueur et du perdant
	private void endMatch() throws IOException {
		if(joueur1.isDead()) {
			joueur2.win();
			joueur1.lose();
		}else {
			joueur1.win();
			joueur2.lose();
		}
	}

	//enchainement d'action que fait un joueur durant son tour
	private void tour(Joueur joueur) throws IOException {
		//on affiche le message du debut de tour enemie
		Joueur enemy = joueur.equals(joueur1) ? joueur2 : joueur1;
		
		enemy.debutTourEnemie();

		joueur.draw(1); //pioche 1 carte
		
		joueur.mainPhase1(enemy,board); //Joue autant de carte qu'il veut/peut
		battlePhase(joueur);//lance des attaques à son adversaire qui peut répliquer
		joueur.mainPhase2();//Nouvelle phase ou le @joueur peut jouer ses cartes si il veut/peut
		joueur.endPhase();//fin du tour du @joueur
	}

	private void battlePhase(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}
}
