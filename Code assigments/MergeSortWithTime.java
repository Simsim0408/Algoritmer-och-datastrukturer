public class MergeSortWithTime {

    // Public sort method
    public static void sort(int[] org) {
        if (org.length == 0) return; // No need to sort an empty array
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length - 1); // Call the private sort function
    }

    // Private sort method (recursive)
    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo < hi) { // If there's more than one element to sort
            int mid = lo + (hi - lo) / 2;
            sort(org, aux, lo, mid);        // Sort the left half
            sort(org, aux, mid + 1, hi);    // Sort the right half
            merge(org, aux, lo, mid, hi);   // Merge the sorted halves
        }
    }

    // Merge function
    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // Copy the original array into the auxiliary array
        for (int i = lo; i <= hi; i++) {
            aux[i] = org[i];
        }

        int i = lo, j = mid + 1;

        // Merge the two halves back into the original array
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                org[k] = aux[j++];
            } else if (j > hi) {
                org[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                org[k] = aux[i++];
            } else {
                org[k] = aux[j++];
            }
        }
    }

    // Main method to test and measure runtime
    public static void main(String[] args) {
        // Generate a random array of n elements
        int n = 64000; // Set this to any size you want
        int[] array = new int[n];

        // Fill the array with random numbers
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 10000); // Random numbers between 0 and 9999
        }

        // Measure the start time
        long startTime = System.nanoTime();

        // Call the merge sort method
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
