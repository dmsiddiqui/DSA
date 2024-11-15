package lab3;

class DNode {
    String name;
    DNode next, prev;

    DNode(String name) {
        this.name = name;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    DNode head, tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtBeginning(String name) {
        
        DNode newNode = new DNode(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(String name) {
        DNode newNode = new DNode(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void removeFromBeginning() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeFromEnd() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void printAll() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.name + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtBeginning("Alice");
        list.insertAtBeginning("Bob");
        list.insertAtEnd("Eve");

        list.removeFromBeginning();
        list.removeFromEnd();

        list.printAll();
    }
}
