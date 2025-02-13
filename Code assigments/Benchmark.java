public class Benchmark {

    // Method to benchmark appending a variable size list to a fixed size list
    public static void benchmarkVaryA(int fixedBSize, int[] aSizes) {
        LinkedLinst b = new LinkedLinst(fixedBSize); // Fixed size list b

        System.out.println("Benchmark: Varying list a, fixed list b size = " + fixedBSize);
        for (int aSize : aSizes) {
            LinkedLinst a = new LinkedLinst(aSize); // Varying size list a

            long startTime = System.nanoTime(); // Start the timer
            a.append(b);  // Append b to a
            long endTime = System.nanoTime();   // End the timer

            long duration = (endTime - startTime);  // Calculate the duration
            System.out.println("Appending list a of size " + aSize + " took " + duration + " ns.");
        }
    }

    // Method to benchmark appending a fixed size list to a variable size list
    public static void benchmarkVaryB(int fixedASize, int[] bSizes) {
        LinkedLinst a = new LinkedLinst(fixedASize); // Fixed size list a

        System.out.println("Benchmark: Fixed list a size = " + fixedASize + ", varying list b");
        for (int bSize : bSizes) {
            LinkedLinst b = new LinkedLinst(bSize); // Varying size list b

            long startTime = System.nanoTime(); // Start the timer
            a.append(b);  // Append b to a
            long endTime = System.nanoTime();   // End the timer

            long duration = (endTime - startTime);  // Calculate the duration
            System.out.println("Appending list b of size " + bSize + " took " + duration + " ns.");
        }
    }

    public static void main(String[] args) {
        // Varying size of list a
        int[] aSizes = {100, 1000, 5000, 10000, 50000}; // List of sizes to vary for a
        int fixedBSize = 100;  // Fixed size for b
        benchmarkVaryA(fixedBSize, aSizes);  // Run benchmark varying size of a

        // Varying size of list b
        int[] bSizes = {100, 1000, 5000, 10000, 50000}; // List of sizes to vary for b
        int fixedASize = 100;  // Fixed size for a
        benchmarkVaryB(fixedASize, bSizes);  // Run benchmark varying size of b
    }
}
