public class LinkedLinst {
    private Cell first;

    // Inner class Cell to represent each node in the list
    private class Cell {
        int head;
        Cell tail;

        // Constructor for the Cell class
        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }

    // Constructor to create a linked list of length n
    public LinkedLinst(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {
            last = new Cell(i, last);
        }
        first = last;
    }

    // Method to append another list to this list
    public void append(LinkedLinst other) {
        if (first == null) {
            first = other.first;
            return;
        }

        // Find the last cell of this list
        Cell current = first;
        while (current.tail != null) {
            current = current.tail;
        }
        // Append the other list to the last cell
        current.tail = other.first;
    }

    // Utility method to measure the length of the list
    public int length() {
        int len = 0;
        Cell current = first;
        while (current != null) {
            len++;
            current = current.tail;
        }
        return len;
    }
}
