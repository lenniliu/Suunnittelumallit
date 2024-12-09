package Decorator;

public class Main {
    public static void main(String[] args) {
        // Basic Printer
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print("Hello World!");

        // File Printer wrapping the Basic Printer
        Printer filePrinter = new FilePrinter(new BasicPrinter());
        filePrinter.print("Hello World!");

        // Encrypted Printer wrapping the File Printer, which wraps the Basic Printer
        Printer encryptedPrinter = new EncryptedPrinter(new FilePrinter(new BasicPrinter()));
        encryptedPrinter.print("Hello World!");
    }
}

