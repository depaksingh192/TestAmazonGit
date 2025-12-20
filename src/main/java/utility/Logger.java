package utility;

import org.slf4j.LoggerFactory;

public class Logger{

	    private org.slf4j.Logger logger;

	    // Constructor to initialize the logger for a specific class
	    public Logger(Class<?> clazz) {
	        this.logger = LoggerFactory.getLogger(clazz);
	    }

	    // Log an INFO message and print to System.out
	    public void info(String message) {
	        System.out.println(message); // Print to console
	        logger.info(message); // Log the message
	    }

	    // Log a DEBUG message
	    public void debug(String message) {
	        logger.debug(message);
	    }

	    // Log an ERROR message
	    public void error(String message) {
	        logger.error(message);
	    }

	    // Log a WARN message
	    public void warn(String message) {
	        logger.warn(message);
	    }
	}

