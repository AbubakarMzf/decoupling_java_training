package fr.lernejo.logger;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class LoggerFactory {

	@Contract(value = "_ -> new", pure = true)
	public static @NotNull Logger getLogger(String name) {
		return new ConsoleLogger();
	}
}
