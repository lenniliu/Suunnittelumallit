package Decorator;

public class EncryptedPrinter implements Printer {
    private final Printer printer;
    private final int shift = 3; // Caesar cipher shift

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        // Encrypt the message
        String encryptedMessage = encrypt(message);

        // Use the wrapped Printer to print the encrypted message
        printer.print(encryptedMessage);
    }

    private String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            // Simple Caesar cipher: shift letters; leave other characters unchanged
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + shift) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }
}

