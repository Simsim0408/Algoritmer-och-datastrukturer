class DynamicStack {
    private int[] items;
    private int top;
    private int size;

    // Constructor initializes the stack with an initial size of 4
    public DynamicStack() {
        size = 4; // Start with an initial size of 4
        items = new int[size]; // Create an array of initial size
        top = 0; // Top points to the next available position (initially 0)
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (top == size) { // Check if the stack is full
            resize(size * 2); // Double the size of the stack
        }
        items[top++] = value; // Place the value and increment the top pointer
    }

    // Method to pop an element from the stack
    public int pop() {
        if (top == 0) { // Check if the stack is empty
            throw new StackUnderflowException("Stack underflow. No element to pop.");
        }
        int value = items[--top]; // Decrement the top pointer and get the value
        items[top] = 0; // Clear the position for clarity (optional)

        // Check if the stack is one-quarter full and needs resizing down
        if (top > 0 && top == size / 4 && size > 4) {
            resize(size / 2); // Halve the size of the stack
        }

        return value; // Return the popped value
    }

    // Method to get the current size (number of elements in the stack)
    public int size() {
        return top;
    }

    // Method to resize the stack array
    private void resize(int newSize) {
        int[] newItems = new int[newSize]; // Create a new array of the specified new size
        for (int i = 0; i < top; i++) {
            newItems[i] = items[i]; // Copy all elements to the new array
        }
        items = newItems; // Replace the old array with the new one
        size = newSize; // Update the size of the stack
    }
}

// Custom exception class for stack underflow
class StackUnderflowException extends RuntimeException {
    public StackUnderflowException(String message) {
        super(message);
    }
}
