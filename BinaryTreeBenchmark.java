public class BinaryTreeBenchmark {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Exempel på data att lägga till och söka efter
        int[] testData = generateTestData(10); // Generera 1000 slumpmässiga tal

        // Benchmark för både add() och lookup()
        long startTime = System.nanoTime();
        
        for (int value : testData) {
            tree.add(value);      // Lägg till elementet i trädet
            tree.lookup(value);   // Sök efter elementet direkt efter tillägg
        }

        long endTime = System.nanoTime();
        long durationTotal = endTime - startTime;

        System.out.println("Tiden för att lägga till och söka efter 1000 element: " + durationTotal + " nanosekunder");
    }

    // Funktion för att generera en array med slumpmässiga data
    public static int[] generateTestData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = (int) (Math.random() * 10000); // Generera slumpmässiga tal mellan 0 och 9999
        }
        return data;
    }
}

class BinaryTree {
    private class Node {
        private Integer value;
        private Node left, right;

        private Node(Integer value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    // Rekursiv add()-metod
    public void add(Integer value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, Integer value) {
        if (current == null) {
            return new Node(value); // Skapa ny nod om vi når en tom plats
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value); // Lägg till i vänstra grenen
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value); // Lägg till i högra grenen
        }

        return current; // Om värdet redan finns, gör ingenting
    }

    // Rekursiv lookup()-metod
    public boolean lookup(Integer key) {
        return lookupRecursive(root, key);
    }

    private boolean lookupRecursive(Node current, Integer key) {
        if (current == null) {
            return false; // Om vi når en null, finns inte värdet i trädet
        }
        if (key.equals(current.value)) {
            return true; // Om värdet matchar, returnera sant
        }

        return key < current.value
                ? lookupRecursive(current.left, key)
                : lookupRecursive(current.right, key); // Sök vidare i vänster eller höger gren
    }
}
