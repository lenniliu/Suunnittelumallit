package Strategy;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int smallSize = 30;
        int largeSize = 100_000;

        int[] smallArray = generateRandomArray(smallSize);
        int[] largeArray = generateRandomArray(largeSize);

        SortingContext context = new SortingContext();

        System.out.println("Sorting small array...");
        testSorting(context, new BubbleSort(), smallArray.clone(), "Bubble Sort");
        testSorting(context, new QuickSort(), smallArray.clone(), "Quick Sort");
        testSorting(context, new MergeSort(), smallArray.clone(), "Merge Sort");

        System.out.println("\nSorting large array...");
        testSorting(context, new BubbleSort(), largeArray.clone(), "Bubble Sort"); // Expected to be very slow
        testSorting(context, new QuickSort(), largeArray.clone(), "Quick Sort");
        testSorting(context, new MergeSort(), largeArray.clone(), "Merge Sort");
    }

    private static void testSorting(SortingContext context, SortingStrategy strategy, int[] array, String strategyName) {
        context.setStrategy(strategy);
        long startTime = System.currentTimeMillis();
        context.executeStrategy(array);
        long endTime = System.currentTimeMillis();
        System.out.println(strategyName + " took " + (endTime - startTime) + " ms");
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10_000); // Random integers in range 0-9999
        }
        return array;
    }
}

