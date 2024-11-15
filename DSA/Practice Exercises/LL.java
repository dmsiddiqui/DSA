public class LL {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void reverse() {
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;  
            current.next = prev;  
            prev = current;       
            current = next;
        }
        head = prev;  
    }

    public void append(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new_node;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.append(50);
        list.append(40);
        list.append(30);
        list.append(20);
        list.append(10);

        System.out.println("Original list:");
        list.printList();

        list.reverse();

        System.out.println("Reversed list:");
        list.printList();
    }
    
}
