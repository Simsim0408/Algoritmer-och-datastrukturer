public class QueueBenchmark {  // This class contains the main method and should be public
    public static void main(String[] args) {
        int n = 1000000; // Number of operations to run
        
        // Benchmark for the modified queue (with tail pointer)
        Queue modifiedQueue = new Queue();
        long startTime = System.currentTimeMillis();
        
        // Enqueue n elements
        for (int i = 0; i < n; i++) {
            modifiedQueue.enqueue(i);
        }
        
        // Dequeue n elements
        for (int i = 0; i < n; i++) {
            modifiedQueue.dequeue();
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for modified queue with tail pointer: " + (endTime - startTime) + "ms");
    }
}

// Non-public Queue class, part of the same file
class Queue {
    private Node head;  // First element (front of the queue)
    private Node tail;  // Last element (end of the queue)

    // Node class for storing the items
    private class Node {
        Integer item;
        Node next;

        private Node(Integer item) {
            this.item = item;
            this.next = null;
        }
    }

    // Constructor to initialize an empty queue
    public Queue() {
        head = null;
        tail = null;
    }

    // Enqueue operation: add an item to the end of the queue
    public void enqueue(Integer item) {
        Node newNode = new Node(item);
        if (tail == null) {  // If the queue is empty
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;  // Update tail to point to the new node
        }
    }

    // Dequeue operation: remove and return the item from the front of the queue
    public Integer dequeue() {
        if (head == null) {  // If the queue is empty
            return null;
        }
        Integer item = head.item;
        head = head.next;
        if (head == null) {  // If the queue becomes empty after the dequeue
            tail = null;  // Reset tail to null as well
        }
        return item;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // View the item at the front of the queue without removing it
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.item;
    }
}
