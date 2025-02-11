public class ArrayStack {
    private int[] stack; // Array to hold stack elements
    private int top; // Index of the top element
    private int capacity; // Capacity of the stack

    // Constructor to initialize the stack
    public ArrayStack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1; // Stack is initially empty
    }

    // Push operation to add an item to the stack
    public void push(int item) {
        if (top == capacity - 1) {
            System.out.println("Stack overflow. Unable to push " + item);
            return; // Optionally, you could resize the stack here
        }
        stack[++top] = item; // Increment top and add item
        System.out.println("Pushed " + item + " to stack");
    }

    // Pop operation to remove the top item from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Unable to pop.");
            return -1; // Indicate an error
        }
        return stack[top--]; // Return the top item and decrement top
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Peek operation to view the top item without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Unable to peek.");
            return -1; // Indicate an error
        }
        return stack[top];
    }

    // Main method to demonstrate stack operations
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5); // Create a stack of size 5

        stack.push(10); // Push 10
        stack.push(20); // Push 20
        stack.push(30); // Push 30
        System.out.println("Top item is: " + stack.peek()); // Peek at the top item

        System.out.println("Popped item: " + stack.pop()); // Pop the top item
        System.out.println("Popped item: " + stack.pop()); // Pop another item

        stack.push(40); // Push 40
        stack.push(50); // Push 50
        stack.push(60); // Push 60
        stack.push(70); // Try to push 70 (will show overflow)

        while (!stack.isEmpty()) { // Pop all items
            System.out.println("Popped item: " + stack.pop());
        }
    }
}
