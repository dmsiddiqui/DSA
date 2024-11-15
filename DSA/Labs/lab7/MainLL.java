package lab7;

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    Node head;
    
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Iterative method to print all nodes
    public void printIterative() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Recursive method to print all nodes
    public void printRecursive(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printRecursive(node.next);
    }

    // Helper function for recursive method
    public void printRecursive() {
        printRecursive(head);
        System.out.println();
    }
}
public class MainLL {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Adding some nodes to the linked list
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        
        // Measuring time for the iterative approach
        long startTimeIterative = System.nanoTime();
        System.out.print("Iterative: ");
        list.printIterative();
        long endTimeIterative = System.nanoTime();
        long timeIterative = endTimeIterative - startTimeIterative;

        // Measuring time for the recursive approach
        long startTimeRecursive = System.nanoTime();
        System.out.print("Recursive: ");
        list.printRecursive();
        long endTimeRecursive = System.nanoTime();
        long timeRecursive = endTimeRecursive - startTimeRecursive;

        // Comparing times
        System.out.println("Time taken by Iterative: " + timeIterative + " ns");
        System.out.println("Time taken by Recursive: " + timeRecursive + " ns");
    }
}

