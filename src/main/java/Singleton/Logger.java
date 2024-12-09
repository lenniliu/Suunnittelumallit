package Singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    // Single instance of Logger
    private static Logger instance;

    // Current file name for logging
    private String fileName;

    // BufferedWriter for writing log messages
    private BufferedWriter writer;

    // Private constructor to prevent instantiation
    private Logger() {
        // Default log file name
        this.fileName = "default_log.txt";
        try {
            openFile();
        } catch (IOException e) {
            System.err.println("Failed to open log file: " + e.getMessage());
        }
    }

    // Method to get the singleton instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to write log messages
    public synchronized void write(String message) {
        try {
            if (writer != null) {
                writer.write(message);
                writer.newLine();
                writer.flush();
            } else {
                System.err.println("Logger is not initialized with a file.");
            }
        } catch (IOException e) {
            System.err.println("Failed to write log message: " + e.getMessage());
        }
    }

    // Method to dynamically set the file name
    public synchronized void setFileName(String newFileName) {
        try {
            close();
            this.fileName = newFileName;
            openFile();
        } catch (IOException e) {
            System.err.println("Failed to set log file: " + e.getMessage());
        }
    }

    // Method to open the file
    private void openFile() throws IOException {
        writer = new BufferedWriter(new FileWriter(fileName, true)); // Append mode
    }

    // Method to close the logger
    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
                writer = null;
            }
        } catch (IOException e) {
            System.err.println("Failed to close the log file: " + e.getMessage());
        }
    }
}

