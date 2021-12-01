package fr.lernejo.logger;

public class CompositeLogger implements Logger {
	private final Logger[] loggers = new Logger[2];

	public CompositeLogger(Logger logger1, Logger logger2) {
		loggers[0] = logger1;
		loggers[1] = logger2;
	}

	@Override
	public void log(String message) {
		loggers[0].log(message);
		loggers[1].log(message);
	}
}
