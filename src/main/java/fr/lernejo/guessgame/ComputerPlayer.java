package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class ComputerPlayer implements Player {
	private Long lastGuess;
	private boolean response;

	@Override
	public long askNextGuess() {
		if (lastGuess == null) {
			lastGuess = new SecureRandom().nextLong();
		}
		lastGuess = response ? lastGuess + 1 : lastGuess - 1;
		return lastGuess;
	}

	/**
	 * Called by {@link Simulation} to inform that the previous guess was lower or greater that the number to find.
	 */
	@Override
	public void respond(boolean lowerOrGreater) {
		response = lowerOrGreater;
	}
}
