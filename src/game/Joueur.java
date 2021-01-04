package game;

import java.io.IOException;

import game.cards.Card;
import game.cards.CardRegistery;
import game.deck.Deck;
import game.deck.DeckRegistery;

public class Joueur {
	private ComsJoueur coms;
	private Deck deck;
	private Hand hand;
	private Board board;
	private int pV;
	// la quantité maximum de mana elle augment de 1 par tours
	private int currentMana = 0;
	// la mana actuele du joueur
	private int mana;

	public Joueur(ComsJoueur connectionJoueur) {
		coms = connectionJoueur;
		pV = 20;
		this.board = new Board();
	}

	/**
	 * cette fonction permet d'obtenir le deck du joueur et de préparer la main
	 * 
	 * @throws IOException
	 */
	public void requestDataEarlyGameData() throws IOException {
		coms.send(Command.GET_DECK);
		String deckname = coms.recieve();
		deck = DeckRegistery.get(deckname);
		deck.shuffle();
		hand = new Hand(deck);
		coms.send(DeckSerializer.serializeDeck(deck));
		draw(5);
		coms.send(Command.SET_HP);
		coms.send(pV);
		coms.send(Command.SET_ENEMY_HP);
		coms.send(pV);

	}

	/**
	 * cette fonction permet de pioche une quantité donné
	 * 
	 * @param amount la quantié
	 * @throws IOException
	 */
	public void draw(int amount) throws IOException {
		coms.send(Command.DRAW);
		coms.send(amount);
		hand.draw(amount);
	}

	/**
	 * affiche sur l'ecran que c'est le tours de l'adversaire
	 * 
	 * @throws IOException
	 */
	public void debutTourEnemie() throws IOException {
		coms.send(Command.ENEMYTURN);
	}

	/**
	 * affiche un menu de victoire
	 * 
	 * @throws IOException
	 */
	public void win() throws IOException {
		coms.send(Command.WIN);
	}

	/**
	 * affiche un menu de defaite
	 * 
	 * @throws IOException
	 */
	public void lose() throws IOException {
		coms.send(Command.LOSE);
	}

	/**
	 * cette commande doit être utilisé a chaque début de tour elle permet
	 * d'augmenter la mana du joueur
	 * 
	 * @throws IOException
	 */
	public void prepMana() throws IOException {
		// on prepare la mana
		if (currentMana < 10)
			currentMana++;
		mana = currentMana;
		coms.send(Command.SETMANA);
		coms.send(mana);
	}

	/**
	 * premiére phase de jeu avant d'attacker
	 * 
	 * @param adversaire
	 * @param board
	 * @throws IOException
	 */
	public void mainPhase1(Joueur adversaire) throws IOException {
		boolean phaseActive = true;
		// on retire le time out sur l'adversaire car sa peut causer des
		// désyncronisatoin et des crash
		adversaire.getComs().getSocket().setSoTimeout(Integer.MAX_VALUE);
		// debut de l'écoude des action client
		int alive = 0;
		while (phaseActive) {
			coms.getSocket().setSoTimeout(500);
			String command = coms.recieve();
			coms.getSocket().setSoTimeout(Integer.MAX_VALUE);
			if (command != null && !command.equals("time out")) {
				alive = 0;
				System.out.println("GOT COMMAND :" + command);

				switch (command) {

				case Command.PING:
					coms.send(Command.PONG);
					break;

				case Command.PASS_TURN:
					phaseActive = false;
					break;

				case Command.PUT_CARD:
					System.out.println("entering put card");
					putCard(adversaire, board);
					break;

				default:
					System.err.println("unknown command " + command);
				}

			} else {
				alive++;
				// 3000xalive =300s = 5minutes
				// si au bout de 5 minute le client ne repond pas on envoie une erreur
				if (alive > 300000) {
					throw new IOException("dead client");
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}

		}
	}

	// cette mothode est utilisé l'orse qu'un joueur utilise Command.PLACECARD
	// elle verifie si le joueur peut la jouer et refuse ou confirme en fonction
	private void putCard(Joueur adversaire, Board board) throws IOException {
		String info = coms.recieve();
		// si ce n'est pas un nombre
		if (!isInt(info)) {
			// alors on affiche l'inforamtion si la sortie d'erreur
			System.err.println(info);
		} else {
			// on recupére la carte
			int cardId = Integer.parseInt(info);

			Class<? extends Card> cardClass = CardRegistery.get(cardId);
			System.out.println(cardClass.getName());

			int zone = Integer.parseInt(coms.recieve());

			Card handCard = hand.contains(cardClass);

			// si la carte n'est pas trouve ou si elle coute trop cher
			if (handCard == null || mana < handCard.getCost()) {
				// on refuse le placement
				System.out.println("no mana or no card");
				coms.send(Command.NOK);
			} else {
				if (board.isZoneAvaliable(zone)) {
					hand.remove(handCard);
					board.setCard(zone, handCard);
					adversaire.enemyPlay(cardId, zone);
					coms.send(Command.OK);

					coms.send(Command.SETMANA);
					mana -= handCard.getCost();
					coms.send(mana);
				} else {
					System.out.println("the zone is not avaliable");
					coms.send(Command.NOK);
				}
			}
		}

	}

	private boolean isInt(String info) {
		return info.matches("-?\\d+");
	}

	/**
	 * cette fonctoin est appelé affin de placer une carte sur le plateur énemie
	 * 
	 * @param cardId
	 * @param zone
	 * @throws IOException
	 */
	private void enemyPlay(int cardId, int zone) throws IOException {
		coms.send(Command.PUT_ENEMY_CARD);
		coms.send(cardId);
		coms.send(zone);
	}

	/**
	 * cette methode a pour but d'executé les evenement de fin de trous des cartes
	 */
	public void endPhase() {
		// TODO Auto-generated method stub
	}

	public ComsJoueur getComs() {
		return coms;
	}

	public void setPV(int pV) {
		this.pV = pV;
	}

	public boolean isDead() {
		return pV == 0;
	}

	public boolean isAlive() {
		return !isDead();
	}

	/**
	 * envoie le message donné qui aparaitera alors comme une toast
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
		coms.send(Command.POPUP);
		coms.send(message);
	}

	/**
	 * affiche le debut de tours
	 * 
	 * @throws IOException
	 */
	public void yourturn() throws IOException {
		// on affiche le debut de tour
		coms.send(Command.YOURTURN);
	}

	public boolean isHandFull() {
		return hand.isFull();
	}

	/**
	 * retire le nombre de carte donné du deck
	 * 
	 * @param nbcard nombre de carte a supprimé
	 * @throws IOException
	 */
	public void meule(int nbcard) throws IOException {
		coms.send(Command.MEULE);
		coms.send(nbcard);
		deck.draw(1);
	}

	public void battlePhase(Joueur adversaire) throws IOException {
		coms.send(Command.BATTLE);

		boolean phaseActive = true;

		adversaire.getComs().getSocket().setSoTimeout(Integer.MAX_VALUE);
		// debut de l'écoude des action client

		while (phaseActive) {
			coms.getSocket().setSoTimeout(500);
			String command = coms.recieve();
			coms.getSocket().setSoTimeout(Integer.MAX_VALUE);
			if (command != null && !command.equals("time out")) {
				System.out.println("GOT COMMAND :" + command);

				switch (command) {

				case Command.PING:
					coms.send(Command.PONG);
					break;

				case Command.PASS_TURN:
					phaseActive = false;
					break;

				case Command.ATTACK:
					// numero de la zone de la carte attaquante
					String carteAttaquante = coms.recieve();
					// numero de la zone de la carte ciblé
					String carteCible = coms.recieve();
					if (!isInt(carteAttaquante) || !isInt(carteCible))
						throw new RuntimeException("non number zone recived in attack phase");
					Card attackingCard = board.getCardInZone(Integer.parseInt(carteAttaquante));

					if (attackingCard == null) {
						throw new RuntimeException("invalid attack");
					} else {
						if (carteCible.equals("100")) {
							boolean isadvDead = handleAttackAgainstPlayer(attackingCard, adversaire);
							if(isadvDead)
							{
								phaseActive = false;
							}
						} else {
							handleAttackAgainstCard(attackingCard, carteCible, adversaire);
						}
					}
					break;

				default:
					System.err.println("unknown command " + command);
				}

			}
		}
	}

	private boolean handleAttackAgainstPlayer(Card attackingCard, Joueur adversaire) throws IOException {
		boolean result = adversaire.takeDamage(attackingCard.getAttack());
		if(!result)
		{
			adversaire.updateHp(this);
			return false;
		}
		return true;
	}

	private void updateHp(Joueur adversaire) throws IOException {
		coms.send(Command.SET_HP);
		coms.send(pV);
		adversaire.coms.send(Command.SET_ENEMY_HP);
		adversaire.coms.send(pV);
		
	}

	private void handleAttackAgainstCard(Card attackingCard, String carteCible, Joueur adversaire) throws IOException {
		Card attackedCard = adversaire.getBoard().getCardInZone(Integer.parseInt(carteCible));

		if (attackedCard == null) {
			throw new RuntimeException(
					"error invalid  carteCible:" + carteCible + " carteAttaquante : " + attackingCard);
		}

		boolean isDestroyed = attackedCard.takeDamage(attackingCard.getAttack());
		if (isDestroyed) {
			// on suprime la carte du terrain
			board.setCard(Integer.parseInt(carteCible), null);

			// demande a l'adversaire de retirer la carte de son terrain
			adversaire.getComs().send(Command.DESTROY_CARD);
			adversaire.getComs().send(carteCible);

			// retire la carte au terrain adverse
			this.getComs().send(Command.DESTROY_ADV_CARD);
			this.getComs().send(carteCible);

			// appelle les effet de quand la carte est détruite
			// NOTE : non implémenter dans les cartes individuelles par manque de temps
			attackedCard.onCardDestroyed();
		}

	}

	private Board getBoard() {
		return board;
	}
	
	/**
	 * inflige des degats au joueur
	 * @param amount
	 * @return true si les pv du joueur on attein zero
	 */
	private boolean takeDamage(int amount)
	{
		pV -= amount;
		pV = pV > 0 ? pV : 0;
		return pV == 0;
		
	}
}
