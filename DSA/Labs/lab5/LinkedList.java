package lab5;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void reverse() {
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

    
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Original Linked List:");
        list.printList();

        
        list.reverse();

        System.out.println("Reversed Linked List:");
        list.printList();
    }


    public void addfirst(int data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addfirst'");
    }
}

