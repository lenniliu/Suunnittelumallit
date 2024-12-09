package Prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRecommendationSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Recommendation> recommendations = new ArrayList<>();

    public static void main(String[] args) {
        // Create a few sample books and recommendations
        Book book1 = new Book("1984", "George Orwell", "Dystopian", 1949);
        Book book2 = new Book("Brave New World", "Aldous Huxley", "Dystopian", 1932);
        Book book3 = new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951);

        Recommendation rec1 = new Recommendation("Dystopian Fans");
        rec1.addBook(book1);
        rec1.addBook(book2);

        Recommendation rec2 = new Recommendation("Young Adults");
        rec2.addBook(book3);

        recommendations.add(rec1);
        recommendations.add(rec2);

        // Start the CLI menu
        while (true) {
            System.out.println("\nBook Recommendation System");
            System.out.println("1. View Recommendations");
            System.out.println("2. Clone and Modify Recommendation");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    viewRecommendations();
                    break;
                case 2:
                    cloneAndModifyRecommendation();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to view all existing recommendations
    private static void viewRecommendations() {
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("\nRecommendation " + (i + 1) + ":");
            recommendations.get(i).displayRecommendation();
        }
    }

    // Method to clone and modify an existing recommendation
    private static void cloneAndModifyRecommendation() {
        System.out.print("Enter the number of the recommendation to clone: ");
        int index = scanner.nextInt() - 1;  // User input is 1-based index
        scanner.nextLine(); // Consume newline

        if (index < 0 || index >= recommendations.size()) {
            System.out.println("Invalid recommendation number.");
            return;
        }

        Recommendation originalRec = recommendations.get(index);
        Recommendation clonedRec = originalRec.clone();

        System.out.print("Enter new target audience for the cloned recommendation: ");
        String newAudience = scanner.nextLine();
        clonedRec.setTargetAudience(newAudience);

        // Optionally, allow user to modify books in the cloned recommendation
        System.out.println("Would you like to add or remove books?");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Skip");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (option == 1) {
            System.out.print("Enter book title to add: ");
            String title = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();
            System.out.print("Enter book genre: ");
            String genre = scanner.nextLine();
            System.out.print("Enter publication year: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Book newBook = new Book(title, author, genre, year);
            clonedRec.addBook(newBook);
        } else if (option == 2) {
            System.out.print("Enter the title of the book to remove: ");
            String titleToRemove = scanner.nextLine();
            for (Book book : clonedRec.getBooks()) {
                if (book.getTitle().equalsIgnoreCase(titleToRemove)) {
                    clonedRec.removeBook(book);
                    System.out.println("Book removed.");
                    break;
                }
            }
        }

        // Add the cloned recommendation to the list
        recommendations.add(clonedRec);
        System.out.println("Cloned recommendation added.");
    }
}

