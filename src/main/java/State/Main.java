package State;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter character = new GameCharacter("Hero");

        while (character.getLevel() < 4) {
            character.displayStatus();
            System.out.println("Available actions: train, meditate, fight");
            System.out.print("Choose an action: ");
            String action = scanner.nextLine();

            switch (action.toLowerCase()) {
                case "train":
                    character.train();
                    break;
                case "meditate":
                    character.meditate();
                    break;
                case "fight":
                    character.fight();
                    break;
                default:
                    System.out.println("Invalid action. Try again.");
            }
        }

        System.out.println("Congratulations! You have completed the game!");
        scanner.close();
    }
}

