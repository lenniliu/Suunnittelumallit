package Singleton;


public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of the Logger
        Logger logger = Logger.getInstance();

        // Write initial log messages
        logger.write("Starting application...");
        logger.write("Performing setup...");

        // Change the log file name
        logger.setFileName("new_log.txt");

        // Write more log messages
        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");

        // Close the logger
        logger.close();

        // Demonstrate reusing the logger after reopening
        logger.setFileName("final_log.txt");
        logger.write("Application is shutting down...");
        logger.close();
    }
}

