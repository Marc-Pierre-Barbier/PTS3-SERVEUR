package game;

import java.io.IOException;
import java.util.Random;

public class Match extends Thread {
	Joueur joueur1, joueur2;
	private Board board;
	private Random rand;

	public Match(ComsJoueur joueur1Com, ComsJoueur joueur2Com) throws IOException {
		super();
		this.board=new Board();
		// random j2/j1
		rand = new Random();
		if (rand.nextBoolean()) {
			joueur1 = new Joueur(joueur1Com);
			joueur2 = new Joueur(joueur2Com);
		} else {
			joueur1 = new Joueur(joueur2Com);
			joueur2 = new Joueur(joueur1Com);
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
		if(PlayerTesteur.playerTest(joueur1.getComs()))
		{
			try {
				joueur1.win();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(PlayerTesteur.playerTest(joueur2.getComs()))
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
		

		//si la main du joeur n'est pas pleine
		if(!joueur.isHandFull())joueur.draw(1); //pioche 1 carte
		else{
			//sinon on pert une carte
			joueur.meule(1);
		}
		//on prepare la mana
		joueur.prepMana();
		//on dit au joeur que c'est a lui de jouer
		joueur.yourturn();
		//et on dit au joueur oposé que ce n'est pas le tien
		enemy.debutTourEnemie();


		joueur.mainPhase1(enemy,board); //Joue autant de carte qu'il veut/peut
		battlePhase(joueur);//lance des attaques à son adversaire qui peut répliquer
		//cette phases ne serira surment pas car nous manquon de temps pour implrementer les fonctionnalité specifique de certaine cartes
		joueur.endPhase();//fin du tour du @joueur
	}

	private void battlePhase(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}
}
