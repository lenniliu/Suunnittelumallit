package AbstractFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Select a style
        System.out.println("Select UI Style:");
        System.out.println("1. Style A");
        System.out.println("2. Style B");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        UIFactory factory = choice == 1 ? new AFactory() : new BFactory();

        // Create elements using the selected factory
        Button button = factory.createButton("Click Me");
        TextField textField = factory.createTextField("Enter Text");
        Checkbox checkbox = factory.createCheckbox("Check Me");

        // Display the UI elements
        System.out.println("Initial UI:");
        button.display();
        textField.display();
        checkbox.display();

        // Change the text dynamically
        System.out.println("\nUpdate Text for Button:");
        String newButtonText = scanner.nextLine();
        button.setText(newButtonText);

        System.out.println("Update Text for TextField:");
        String newTextFieldText = scanner.nextLine();
        textField.setText(newTextFieldText);

        System.out.println("Update Text for Checkbox:");
        String newCheckboxText = scanner.nextLine();
        checkbox.setText(newCheckboxText);

        // Display the updated UI elements
        System.out.println("\nUpdated UI:");
        button.display();
        textField.display();
        checkbox.display();

        scanner.close();
    }
}

