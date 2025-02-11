import java.util.Random;

public class SearchBenchmark {

    // Function to generate a sorted array
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    // Function to perform a linear search on an unsorted array
    private static boolean linearSearchUnsorted(int[] array, int key) {
        for (int i : array) {
            if (i == key) return true;
        }
        return false;
    }

    // Function to perform a linear search on a sorted array
    private static boolean linearSearchSorted(int[] array, int key) {
        for (int i : array) {
            if (i == key) return true;
            if (i > key) return false; // Early exit if next element is greater
        }
        return false;
    }

    // Function to benchmark
    private static void benchmark(int arraySize) {
        int[] sortedArray = sorted(arraySize);
        Random rnd = new Random();

        // Benchmark linear search on sorted array
        int key = rnd.nextInt(arraySize * 10); // Generate random key to search
        long startTimeSorted = System.nanoTime();
        linearSearchSorted(sortedArray, key);
        long endTimeSorted = System.nanoTime();
        long durationSorted = (endTimeSorted - startTimeSorted);

        // Benchmark linear search on unsorted array (by shuffling)
        int[] unsortedArray = sortedArray.clone();
        shuffleArray(unsortedArray);
        long startTimeUnsorted = System.nanoTime();
        linearSearchUnsorted(unsortedArray, key);
        long endTimeUnsorted = System.nanoTime();
        long durationUnsorted = (endTimeUnsorted - startTimeUnsorted);

        // Output results
        System.out.println("Array size: " + arraySize);
        System.out.println("Sorted search time: " + durationSorted + " ns");
        System.out.println("Unsorted search time: " + durationUnsorted + " ns");
        System.out.println();
    }

    // Function to shuffle an array (Fisher-Yates shuffle)
    private static void shuffleArray(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        // Run benchmarks for various array sizes
        benchmark(100);
        benchmark(200);
        benchmark(400);
        benchmark(800);
        benchmark(1600);
        benchmark(1000000);
    }
}
