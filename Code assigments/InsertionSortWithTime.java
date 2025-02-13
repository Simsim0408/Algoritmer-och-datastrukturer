public class InsertionSortWithTime {

    // Insertion sort algorithm
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // For each element from i towards 1, swap the item found with the item before it if it is smaller
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    // Main method to test and measure runtime
    public static void main(String[] args) {
        // Generate a random array of n elements
        int n = 64000; // You can set this to any size you want
        int[] array = new int[n];

        // Fill the array with random numbers
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 10000); // Random numbers between 0 and 9999
        }

        // Measure the start time
        long startTime = System.nanoTime();

        // Call the sort method on the array
        sort(array);

        // Measure the end time
        long endTime = System.nanoTime();

        // Calculate the time taken in nanoseconds and convert to milliseconds
        long duration = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds

        // Output the runtime
        System.out.println("Time taken to sort " + n + " elements: " + duration + " ms");

        // Optional: Verify the array is sorted by printing the first 10 elements
        for (int i = 0; i < Math.min(n, 10); i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
