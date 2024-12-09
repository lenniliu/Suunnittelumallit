package Iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int prev = 0;
    private int current = 1;
    private int count = 0;
    private final int maxCount;

    public FibonacciIterator(int maxCount) {
        this.maxCount = maxCount;  // Define how many numbers to generate
    }

    @Override
    public boolean hasNext() {
        return count < maxCount;  // We stop when we have generated the required number of Fibonacci numbers
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more Fibonacci numbers.");
        }

        int nextNumber = prev;
        prev = current;
        current = prev + nextNumber;
        count++;
        return nextNumber;
    }
}
