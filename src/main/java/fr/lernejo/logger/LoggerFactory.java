package fr.lernejo.logger;

import org.jetbrains.annotations.NotNull;

public class LoggerFactory {

	public static @NotNull Logger getLogger(Class<?> callerClass, String name) {
		return new ContextualLogger(callerClass, new CompositeLogger(
			new ConsoleLogger(),
			new FileLogger(System.getProperty("user.home") + "/Desktop/file.txt")
		));
	}
}
