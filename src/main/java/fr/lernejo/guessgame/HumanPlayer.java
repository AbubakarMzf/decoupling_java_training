package fr.lernejo.guessgame;

import java.util.Scanner;

public class HumanPlayer implements Player {
	@Override
	public long askNextGuess() {
		return new Scanner(System.in).nextLong();
	}

	/**
	 * Called by {@link Simulation} to inform that the previous guess was lower or greater that the number to find.
	 */
	@Override
	public void respond(boolean lowerOrGreater) {
	}
}
