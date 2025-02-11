public class DynamicStack2 {
    private int[] items; // Array to store stack elements
    private int top; // Index of the next available position in the stack
    private int size; // Current size of the stack array

    // Constructor initializes the stack with a default size
    public DynamicStack2() {
        size = 4; // Initial size of the stack array
        items = new int[size];
        top = 0; // The stack is initially empty
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (top == size) { // Check if stack is full
            resize(size * 2); // Double the size of the stack array
        }
        items[top++] = value; // Add the new element and increment top
    }

    // Method to pop an element from the stack
    public int pop() {
        if (top == 0) { // Check if the stack is empty
            System.out.println("Stack underflow. No element to pop.");
            return -1; // Return a sentinel value indicating an empty stack
        }
        int value = items[--top]; // Decrement top and get the value
        items[top] = 0; // Optional: Clear the value from the stack array

        // Shrink the stack if it's less than a quarter full, with a minimum size
        if (top > 0 && top == size / 4) {
            resize(Math.max(4, size / 2)); // Shrink the size, ensuring a minimum of 4
        }
        return value;
    }

    // Method to resize the stack array
    private void resize(int newSize) {
        int[] newItems = new int[newSize]; // Create a new array with the new size
        for (int i = 0; i < top; i++) {
            newItems[i] = items[i]; // Copy elements to the new array
        }
        items = newItems; // Replace old array with the new one
        size = newSize; // Update size
    }

    // Main method to test the dynamic stack
    public static void main(String[] args) {
        DynamicStack2 stack = new DynamicStack2();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50); // Should trigger a resize to 8

        System.out.println("Pop: " + stack.pop()); // Should print 50
        System.out.println("Pop: " + stack.pop()); // Should print 40
        System.out.println("Pop: " + stack.pop()); // Should print 30
        System.out.println("Pop: " + stack.pop()); // Should print 20
        System.out.println("Pop: " + stack.pop()); // Should print 10

        // Test underflow
        System.out.println("Pop: " + stack.pop()); // Should print underflow message and return -1
    }
}
