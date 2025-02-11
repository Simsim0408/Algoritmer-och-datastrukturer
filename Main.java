import java.util.Random;  // Import the Random class





public class Main {

    public static void main(String[] args) {
        // Define the sizes of the arrays to test
        int[] sizes = {100, 200, 400, 800, 1600};

        // Perform benchmarks for unsorted search
        for (int size : sizes) {
            int[] array = new int[size];
            Random rnd = new Random();

            // Fill the array with random values
            for (int i = 0; i < size; i++) {
                array[i] = rnd.nextInt(size * 10); // Use a broader range to minimize key collisions
            }

            // Define a random key to search for
            int key = rnd.nextInt(size * 10);

            // Measure time for unsorted search
            long t0 = System.nanoTime();
            boolean found = search_unsorted(array, key);
            long t1 = System.nanoTime();

            // Print the results
            System.out.printf("Array size: %d, Time taken: %d ns, Key found: %b%n", size, (t1 - t0), found);
        }
    }

    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }
}
