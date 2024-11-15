package lab3;

class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
        this.next = null;
    }
}

public class task3 {

    public boolean detectCycle(Node head) {
        
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;      
            fast = fast.next.next;  

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        task3 list = new task3();

        Node head = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        boolean hasCycle = list.detectCycle(head);
        System.out.println("Cycle detected: " + hasCycle);

        node4.next = null; 
        hasCycle = list.detectCycle(head);
        System.out.println("Cycle detected: " + hasCycle);
    }
}

