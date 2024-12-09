package Proxy;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add unprotected and protected documents
        library.addUnprotectedDocument("doc1", "Public content of Document 1");
        library.addProtectedDocument("doc2", "Confidential content of Document 2", "alice", "bob");
        library.addProtectedDocument("doc3", "Highly confidential Document 3 content", "alice");

        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        try {
            // Access unprotected document
            System.out.println("Accessing doc1 by Charlie:");
            System.out.println(library.getDocument("doc1").getContent(charlie));

            // Access protected document by an allowed user
            System.out.println("\nAccessing doc2 by Alice:");
            System.out.println(library.getDocument("doc2").getContent(alice));

            // Access protected document by a non-allowed user
            System.out.println("\nAccessing doc2 by Charlie:");
            System.out.println(library.getDocument("doc2").getContent(charlie));
        } catch (AccessDeniedException e) {
            System.err.println(e.getMessage());
        }

        try {
            // Access another protected document
            System.out.println("\nAccessing doc3 by Bob:");
            System.out.println(library.getDocument("doc3").getContent(bob));
        } catch (AccessDeniedException e) {
            System.err.println(e.getMessage());
        }
    }
}

