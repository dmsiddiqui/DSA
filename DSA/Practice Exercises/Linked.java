public class Linked{
    Node head; 
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public void sort() {
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return;
        }

        Node current = head;
        Node index = null;
        Node temp;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.data > index.data) {
                   
                    temp = new Node(current.data);
                    current.data = index.data;
                    index.data = temp.data;
                }
                index = index.next;
            }
            current = current.next;
        }
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
        Linked list = new Linked();
        list.append(50);
        list.append(40);
        list.append(30);
        list.append(20);
        list.append(10);

        System.out.println("Original list:");
        list.printList();

        list.sort();

        System.out.println("Sorted list:");
        list.printList();
    }
}
