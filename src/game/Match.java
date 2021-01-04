package game;

import java.io.IOException;
import java.util.Random;

public class Match extends Thread {
	Joueur joueur1, joueur2;
	private Random rand;

	public Match(ComsJoueur joueur1Com, ComsJoueur joueur2Com) throws IOException {
		super();
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
		//cette variable permet de decider le gagnant en cas d'erreur reseau
		boolean isJ1Turn=true;
		while (joueur1.isAlive() &&  joueur2.isAlive()) {
			try {
				tour(joueur1);
				isJ1Turn=false;
				if(joueur2.isAlive())tour(joueur2);
				isJ1Turn=true;
			} catch (IOException e) {
				endGameAfterIssue(isJ1Turn);
				return;
			}
		}
		try {
			endMatch();
		} catch (IOException e) {
			endGameAfterIssue(isJ1Turn);
		}
	}

	/**
	 * si le jeu a un crash il faut que si un joueur ai perdu la connection l'autre gagne
	 * @param isJ1Turn 
	 */
	private void endGameAfterIssue(boolean isJ1Turn) {
		if(PlayerTesteur.playerTest(joueur1.getComs()))
		{
			try {
				if(isJ1Turn)joueur1.win();
				else joueur1.lose();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(PlayerTesteur.playerTest(joueur2.getComs()))
		{
			try {
				if(!isJ1Turn)joueur2.win();
				else joueur2.lose();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			joueur1.getComs().close();
		} catch (IOException e) {}
		try {
			joueur2.getComs().close();
		} catch (IOException e) {}
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
		joueur1.getComs().close();
		joueur2.getComs().close();
	}

	/**
	 * enchainement d'acction effectué durant un tours
	 * @param joueur joueur effectuant les actions
	 * @throws IOException
	 */
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
		//on dit au joueur que c'est a lui de jouer
		joueur.yourturn();
		//et on dit au joueur oposé que ce n'est pas le tien
		enemy.debutTourEnemie();


		joueur.mainPhase1(enemy); //Joue autant de carte qu'il veut/peut
		joueur.battlePhase(enemy);//lance des attaques à son adversaire qui peut répliquer
		//cette phases ne serira surment pas car nous manquon de temps pour implrementer les fonctionnalité specifique de certaine cartes
		if(enemy.isAlive())joueur.endPhase();//fin du tour du @joueur
	}

}
