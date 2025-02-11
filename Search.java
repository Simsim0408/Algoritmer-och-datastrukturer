import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Define the sizes of the arrays to test, including 1 million
        int[] sizes = {100, 200, 400, 800, 1600, 1000000};

        // Perform benchmarks for both unsorted and binary searches
        for (int size : sizes) {
            int[] array = new int[size];
            Random rnd = new Random();

            // Fill the array with random values
            for (int i = 0; i < size; i++) {
                array[i] = rnd.nextInt(size * 10); // Use a broader range to minimize key collisions
            }

            // Sort the array for binary search
            java.util.Arrays.sort(array);

            // Define a random key to search for
            int key = rnd.nextInt(size * 10);

            // Measure time for unsorted search
            long t0 = System.nanoTime();
            boolean foundUnsorted = search_unsorted(array, key);
            long t1 = System.nanoTime();
            System.out.printf("Unsorted search - Array size: %d, Time taken: %d ns, Key found: %b%n", size, (t1 - t0), foundUnsorted);

            // Measure time for binary search (sorted array)
            t0 = System.nanoTime();
            boolean foundBinary = Search.binary_search(array, key);
            t1 = System.nanoTime();
            System.out.printf("Binary search (sorted) - Array size: %d, Time taken: %d ns, Key found: %b%n", size, (t1 - t0), foundBinary);
        }
    }

    // Unsorted search (linear)
    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    // Binary Search inside a static nested class
    public static class Search {
        public static boolean binary_search(int[] array, int key) {
            int first = 0;
            int last = array.length - 1;

            while (first <= last) {
                // jump to the middle
                int index = (first + last) / 2;

                if (array[index] == key) {
                    // Found the key, print the time taken
                    return true;
                }

                // Adjust the search range based on comparison
                if (array[index] < key) {
                    first = index + 1;
                } else {
                    last = index - 1;
                }
            }
            // Key not found
            return false;
        }
    }
}
