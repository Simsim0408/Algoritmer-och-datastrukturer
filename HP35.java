import java.io.*;

public class HP35 {
    public static void main(String[] args) throws IOException {
        DynamicStack stack = new DynamicStack();
        System.out.println("HP-35 pocket calculator");
        boolean run = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (run) {
            System.out.print(" > ");
            String input = br.readLine();

            switch (input) {
                case "+":
                    if (stack.size() < 2) {
                        System.out.println("Error: inte tillräckligt många operander för addition");
                        break;
                    }
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                    break;

                case "-":
                    if (stack.size() < 2) {
                        System.out.println("Error: inte tillräckligt många operander för subtraktion");
                        break;
                    }
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;

                case "*":
                    if (stack.size() < 2) {
                        System.out.println("Error: inte tillräckligt många operander för multiplikation");
                        break;
                    }
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;

                case "/":
                    if (stack.size() < 2) {
                        System.out.println("Error: inte tillräckligt många operander för division");
                        break;
                    }
                    b = stack.pop();
                    a = stack.pop();
                    if (b == 0) {
                        System.out.println("Error: aja baja dela inte med 0!");
                        stack.push(a); // pusha tillbaka tal då divition inte hände
                        stack.push(b);
                        break;
                    }
                    stack.push(a / b);
                    break;

                case "":
                    run = false;
                    break;

                default:
                    try {
                        Integer nr = Integer.parseInt(input);
                        stack.push(nr);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: otillåten input. Endast nummer och operationer tack!.");
                    }
                    break;
            }
        }

        if (stack.size() > 0) {
            System.out.printf("The result is: %d\n\n", stack.pop());
        } else {
            System.out.println("No result available.");
        }
        System.out.println("I love reversed polish notation, don't you?");
    }
}
