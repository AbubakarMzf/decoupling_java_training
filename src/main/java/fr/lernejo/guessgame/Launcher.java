package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

	public static void main(String[] args) {
		if (args == null || args.length <= 1) {
			System.out.println("Please enter an argument");
			assert args != null;
			System.out.println("Usage: " + args[0] + " -interactive/-auto <n>");
			System.out.println("\t-interactive\tStart game with a number to guess between 0 and 100 & an infinite amount of trials (Player is you)");
			System.out.println("\t-auto <n>\tStart game with a number between 0 and <n> and 1000 trials (Player is Computer)");
			return;
		}
		if (args[1].endsWith("-interactive")) {
			Simulation simulation = new Simulation(new HumanPlayer());
			simulation.initialize(new SecureRandom().nextInt(100));
			simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
		}
		if (args[1].endsWith("-auto")) {
			Integer autoNumber = null;
			if (args.length >= 3) {
				try {
					autoNumber = Integer.parseInt(args[2]);
				} catch (NumberFormatException ignored) {}
			}
			if (autoNumber == null) {
				System.out.println("Please specify a correct number");
				return;
			}
			Simulation simulation = new Simulation(new ComputerPlayer());
			simulation.initialize(autoNumber);
			simulation.loopUntilPlayerSucceed(1000);
		}
	}
}
