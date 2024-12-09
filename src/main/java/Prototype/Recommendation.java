package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // Method to clone the recommendation with a deep copy of the book list
    public Recommendation clone() {
        Recommendation cloned = new Recommendation(this.targetAudience);
        for (Book book : this.books) {
            cloned.addBook(book.clone());  // Deep clone the list of books
        }
        return cloned;
    }

    // Method to display the recommendation
    public void displayRecommendation() {
        System.out.println("Recommendation for: " + targetAudience);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Method to remove a book from the recommendation
    public void removeBook(Book book) {
        books.remove(book);
    }
}

