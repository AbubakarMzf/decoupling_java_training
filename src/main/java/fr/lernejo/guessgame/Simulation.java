package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

	private final Logger logger = LoggerFactory.getLogger("simulation");
	private final Player player;
	private long numberToGuess;

	public Simulation(Player player) {
		this.player = player;
	}

	public void initialize(long numberToGuess) {
		this.numberToGuess = numberToGuess;
	}

	/**
	 * @return true if the player have guessed the right number
	 */
	private boolean nextRound() {
		logger.log("Devinez le nombre : ");
		long guess = player.askNextGuess();
		if (guess == numberToGuess)
			return true;
		if (guess > numberToGuess) {
			logger.log("C'est moins !");
			player.respond(false);
		} else {
			logger.log("C'est plus !");
			player.respond(true);
		}
		return false;
	}

	public void loopUntilPlayerSucceed() {
		while (!nextRound()) {
			nextRound();
		}
	}
}
