package Iterator;

import java.util.Iterator;



public class FibonacciSequence implements Sequence {
    private final int maxCount;

    public FibonacciSequence(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public Iterator<Integer> getIterator() {
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(maxCount);  // Create and return a new iterator for the sequence
    }
}

