package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingConsole {

	private static final Logger log = LogManager.getLogger(LoggingConsole.class.getName());

	public static void main(String[] args) {
		log.debug("Debug message logged");
		log.error("Error message logged");
		log.fatal("Fatal Message Logged");
		System.out.println("This is working");

	}

}
