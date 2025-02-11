public class WrapAroundQueue<T> {
    private T[] queue;
    private int i, k, n;  // i = front, k = rear, n = size of array
    private int size;

    // Constructor to initialize the queue
    public WrapAroundQueue(int capacity) {
        queue = (T[]) new Object[capacity];  // Casting Object[] to T[]
        i = 0;
        k = 0;
        n = capacity;
        size = 0;
    }

    // Enqueue method to add an element to the queue
    public void enqueue(T item) {
        if (size == n) {
            expandArray();  // Expand the array if it's full
        }
        queue[k] = item;
        k = (k + 1) % n;
        size++;
    }

    // Dequeue method to remove an element from the queue
    public T dequeue() {
        if (size == 0) {
            throw new IllegalStateException("kö är tom");
        }
        T item = queue[i];
        queue[i] = null;  // Remove reference to avoid memory leak
        i = (i + 1) % n;
        size--;
        return item;
    }

    // Method to expand the array when the queue is full
    private void expandArray() {
        int newCapacity = n * 2;
        T[] newQueue = (T[]) new Object[newCapacity];  // New larger array

        for (int j = 0; j < size; j++) {
            newQueue[j] = queue[(i + j) % n];
        }

        queue = newQueue;
        i = 0;
        k = size;
        n = newCapacity;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == n;
    }

    // Method to get the current size of the queue
    public int size() {
        return size;
    }

    // Main method for testing the WrapAroundQueue
    public static void main(String[] args) {
        // Create a queue with a capacity of 5
        WrapAroundQueue<Integer> queue = new WrapAroundQueue<>(5);

        // Add some elements to the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // Try to add one more element, which will trigger array expansion
        queue.enqueue(6);

        // Remove a few elements from the queue and print them
        System.out.println("Dequeued: " + queue.dequeue());  // 1
        System.out.println("Dequeued: " + queue.dequeue());  // 2

        // Add more elements to the queue
        queue.enqueue(7);
        queue.enqueue(8);

        // Display the elements by dequeuing them one by one
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
}




public class WrapAroundQueue<T> {
    private T[] queue;
    private int y, x, n;  // y = front, x = rear, n = size of array
    private int size;

    // Konstruktor för att initiera kön
    public WrapAroundQueue(int capacity) {
        queue = (T[]) new Object[capacity];  // Casta Object[] till T[]
        y = 0;
        x = 0;
        n = capacity;
        size = 0;
    }

    // Enqueue-metod för att lägga till ett element i kön
    public void enqueue(T item) {
        if (size == n) {
            expandArray();  // Utöka arrayen om den är full
        }
        queue[x] = item;
        x = (x + 1) % n;
        size++;
    }

    // Dequeue-metod för att ta bort ett element från kön
    public T dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Kön är tom");
        }
        T item = queue[y];
        queue[y] = null;  // Ta bort referensen för att undvika minnesläckor
        y = (y + 1) % n;
        size--;
        return item;
    }

    // Metod för att utöka arrayen när kön är full
    private void expandArray() {
        int newCapacity = n * 2;
        T[] newQueue = (T[]) new Object[newCapacity];  // Ny större array

        for (int z = 0; z < size; z++) {
            newQueue[z] = queue[(y + z) % n];
        }

        queue = newQueue;
        y = 0;
        x = size;
        n = newCapacity;
    }

    // Metod för att kontrollera om kön är tom
    public boolean isEmpty() {
        return size == 0;
    }

    // Metod för att kontrollera om kön är full
    public boolean isFull() {
        return size == n;
    }

    // Metod för att få köns nuvarande storlek
    public int size() {
        return size;
    }
}

