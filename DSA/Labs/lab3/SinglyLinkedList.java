package lab3;

class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head, tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtBeginning(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void insertAtEnd(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeFromBeginning() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    public void removeFromEnd() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.name + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBeginning("Alice");
        list.insertAtBeginning("Bob");
        list.insertAtEnd("Eve");

        list.removeFromBeginning();
        list.removeFromEnd();

        list.printAll();
    }
}


