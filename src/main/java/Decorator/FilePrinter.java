package Decorator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer {
    private final Printer printer;
    private final String fileName = "output.txt"; // Hardcoded file name

    public FilePrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        // Print the original message using the wrapped Printer
        printer.print(message);

        // Write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}


