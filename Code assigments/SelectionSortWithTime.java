public class SelectionSortWithTime {

    // Selection sort algorithm
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int cand = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[cand]) {
                    cand = j;
                }
            }
            // Swap the smallest element found with the current element
            int temp = array[i];
            array[i] = array[cand];
            array[cand] = temp;
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
        
        // Call selectionSort on the array
        selectionSort(array);
        
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
