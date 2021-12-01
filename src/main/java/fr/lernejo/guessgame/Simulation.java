package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

	private final Logger logger = LoggerFactory.getLogger(Simulation.class,"simulation");
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
		if (player.getClass() == HumanPlayer.class)
			logger.log("Devinez le nombre : ");
		long guess = player.askNextGuess();
		if (player.getClass() == ComputerPlayer.class)
			logger.log("Tentative : " + guess);
		if (guess == numberToGuess)
			return true;
		if (guess > numberToGuess) {
			logger.log("C'est moins !");
			player.respond(false);
		} else {
			if (guess > 0) {
				logger.log("C'est plus !");
				player.respond(true);
			}
		}
		return false;
	}

	public void loopUntilPlayerSucceed(long maximumLoops) {
		boolean won = false;
		long start = System.currentTimeMillis();
		for (int i = 0; i < maximumLoops; i++) {
			if (nextRound()) {
				won = true;
				break;
			}
		}
		long elapsedTime = System.currentTimeMillis() - start;
		logger.log(won ? "Félicitations !" : "Vous avez perdu !");
		logger.log("Temps total : " + new SimpleDateFormat("mm:ss.SSS").format(new Date(elapsedTime)));
	}
}