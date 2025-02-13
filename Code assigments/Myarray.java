import java.util.Random;

public class Myarray {

    private static long search(int n, int loop) {
        Random rnd = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(n * 2);
        }
        int[] keys = new int[loop];
        for (int k = 0; k < loop; k++) {
            keys[k] = rnd.nextInt(n * 2);
        }
        int sum = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            int key = keys[i];
            for (int j = 0; j < n; j++) {
                if (key == array[j]) {
                    sum++;
                    break;
                }
            }
        }
        long t1 = System.nanoTime();
        return (t1 - t0);
    }

    public static void main(String[] args) {
        int n = 50000;     // Storleken på arrayen
        int loop = 100000;  // antalet keys (större än n)
        long timeTaken = search(n, loop);
        
        System.out.println("tid tagen för sökning: " + timeTaken + " nanoseconds.");
    }
}


        
   /* public static void main(String[] arg) {
        // Run the benchmark 10 times
        for (int i = 0; i < 10; i++) {
            long t = bench(1000, 1000);
            System.out.println(" access: " + t + " ns");
        }
    }

    // Method to perform the benchmark by running the loop and measuring the time taken
    public static int run(int[] array, int[] indx) {
        int sum = 0;
        // Loop to access the array elements based on random indices
        for (int i = 0; i < indx.length; i++) {
            sum = sum + array[indx[i]]; // Access array using indices from indx
        }
        return sum;
    }

    // Benchmark method to initialize data and measure the performance
    public static long bench(int n, int loop) {
        int[] array = new int[n];
        // Initialize the array with sequential values
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        Random rnd = new Random();
        int[] indx = new int[loop];
        // Create an array of random indices
        for (int i = 0; i < loop; i++) {
            indx[i] = rnd.nextInt(n);
        }

        // Measure the time taken to execute the run method
        long t0 = System.nanoTime();
        run(array, indx);
        long t1 = System.nanoTime();
        return (t1 - t0);
    }
    */

        
    /* public static void main(String[] args) {
        // Example call to bench method
        long result = bench(1000, 1000); // Adjust n and loop as needed
        System.out.println("Time taken: " + result + " nanoseconds");
    }

    // Modified run method to measure loop overhead only
    public static int run(int[] array, int[] indx) {
        int sum = 0;
        for (int i = 0; i < indx.length; i++) {
            // Increment sum by 1 instead of reading from the array
            sum++;
        }
        return sum;
    }

    public static long bench(int n, int loop) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        Random rnd = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop; i++) {
            indx[i] = rnd.nextInt(n);
        }

        long t0 = System.nanoTime();
        run(array, indx);
        long t1 = System.nanoTime();
        return (t1 - t0); */
    
   /* public static void main(String[] args) {
        // You can call the bench method from here if needed
        long result = bench(1000, 1000); // Example call
        System.out.println("Time taken: " + result + " nanoseconds");
    }

    public static int run(int[] array, int[] indx) {
        int sum = 0;
        for (int i = 0; i < indx.length; i++) {
            sum = sum + array[indx[i]];
        }
        return sum;
    }

    public static long bench(int n, int loop) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        Random rnd = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop; i++) {
            indx[i] = rnd.nextInt(n);
        }

        long t0 = System.nanoTime();
        run(array, indx);
        long t1 = System.nanoTime();
        return (t1 - t0);
    }
        */

    
    
    
    
    
    /* public static void main(String[] args)
    {

        public static int run(int[] array, int[] indx) 
        {
            int sum = 0;
            for (int i = 0; i < indx.length; i++) 
            {
                sum = sum + array[indx[i]];
            }
            return sum;
        }
        public static long bench(int n, int loop) 
        {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) array[i] = i;
            
            Random rnd = new Random();
            int[] indx = new int[loop];
            for (int i = 0; i < loop; i++) indx[i] = rnd.nextInt(n);
            
            int sum = 0;
            long t0 = System.nanoTime();
            run(array, indx);
            long t1 = System.nanoTime();
            return (t1 - t0);
        }
    }
        */




/*    public static void main(String []args)
{
        
                
        int[] given = {0,1,2,3,4,5,6,7,8,9};
        Random rnd = new Random();
        int sum = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < 1000; i++) // we are looping 1000 times and dividing the number, 
        // with 1000 thus giving us a average over more data. 793ns (1), 714ns (2), 532ns (3), 445ns(4)
        {
        sum += given[rnd.nextInt(10)];
        }
        long t1 = System.nanoTime();
        System.out.println(" one read operation in " + (t1 - t0)/1000 + " nanoseconds");
*/


    
    
    

    
    /*     
        int[] given = {0,1,2,3,4,5,6,7,8,9}; //avr time 400ns (1), avr time 500ns (2)
        int sum = 0; //avr time 1000ns (1), avr time 600ns (2)
        for (int i = 0; i < 10; i++) 
        {
        long t0 = System.nanoTime();
        sum += given[i];
        long t1 = System.nanoTime();
        System.out.println("one operation in " + (t1 - t0) + " ns");
        }
*/









