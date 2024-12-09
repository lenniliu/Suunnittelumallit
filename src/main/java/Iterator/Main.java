package Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int numberOfFibonacciNumbers = 10;

        // Create a FibonacciSequence that will generate 10 numbers
        FibonacciSequence fibonacciSequence = new FibonacciSequence(numberOfFibonacciNumbers);

        // Get the iterator from the FibonacciSequence
        Iterator<Integer> iterator = fibonacciSequence.iterator();

        // Iterate through the Fibonacci sequence and print each number
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
