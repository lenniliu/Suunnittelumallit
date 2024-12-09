package FactoryMethod;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the RPG Map Generator!");
        System.out.println("Choose the map type:");
        System.out.println("1. City Map");
        System.out.println("2. Wilderness Map");

        int choice = scanner.nextInt();
        System.out.println("Enter the map width:");
        int width = scanner.nextInt();
        System.out.println("Enter the map height:");
        int height = scanner.nextInt();

        Map map;

        // Factory method to create a map
        if (choice == 1) {
            map = new CityMap(width, height);
        } else {
            map = new WildernessMap(width, height);
        }

        // Display the map
        System.out.println("Generated Map:");
        map.display();

        scanner.close();
    }
}

