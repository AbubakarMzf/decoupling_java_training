package fr.lernejo.logger;

import org.jetbrains.annotations.NotNull;

public class LoggerFactory {

	public static @NotNull Logger getLogger(String name) {
		return new ContextualLogger(name, new CompositeLogger(
			new ConsoleLogger(),
			new FilteredLogger(
				new FileLogger(System.getProperty("user.home") + "/Desktop/file.txt"),
				s -> s.contains("Simulation")
			)
		));
	}
}
