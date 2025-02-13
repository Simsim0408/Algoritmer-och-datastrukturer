public class StaticStack {
    int[] stack; 
    int top; 

    
    public StaticStack(int size) {
        stack = new int[size]; // Initializera stackens array med given storlek
        top = -1; // Initializera "Top" till -1, stacken är tom!
    }

    
    public void push(int val) {
        if (top == stack.length - 1) { // Checka stack overflow.
            System.out.println("Stack overflow. gick inte pusha " + val);
        } else {
            stack[++top] = val; // Inkrementera push och pop
        }
    }
   
    public int pop() {
        if (top == -1) { // Checka för stack underflow
            System.out.println("Stack underflow. Inget element att poppa.");
            return -1; // Returnera värde (bevisa att stacken är tom)
        } else {
            return stack[top--]; // Returnera elementet högst upp och dekrementera en gång
        }
    }

    // Main method to test the stack
    public static void main(String[] args) {
        StaticStack s = new StaticStack(16); // Create a stack with a capacity of 16 elements
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("pop : " + s.pop()); // Should print 34
        System.out.println("pop : " + s.pop()); // Should print 33
        System.out.println("pop : " + s.pop()); // Should print 32
    }
}
