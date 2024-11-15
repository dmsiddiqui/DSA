package lab3;
class Node {
    String name;
    Node prev, next;

    Node(String name) {
        this.prev = null;
        this.next = null;
        this.name = name;
    }
}

public class task1 {
    Node head;

    public void insertAtBeginning(String name) {
        Node newNode = new Node(name);
        insertAtBeginning(newNode);
    }

    public void insertAtBeginning(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void insertAtEnd(String name) {
        Node newNode = new Node(name);
        insertAtEnd(newNode);
    }

    public void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }

    public void insertAfterName(String name, Node node) {
        Node temp = head;
        while (temp != null && !temp.name.equals(name)) {
            temp = temp.next;
        }
        if (temp == null) {
            throw new IllegalArgumentException("Node with name " + name + " not found.");
        }
        node.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = node;
        }
        node.prev = temp;
        temp.next = node;
    }

    public void insertBeforeName(String name, Node node) {
        Node temp = head;
        while (temp != null && !temp.name.equals(name)) {
            temp = temp.next;
        }
        if (temp == null) {
            throw new IllegalArgumentException("Node with name " + name + " not found.");
        }
        node.prev = temp.prev;
        node.next = temp;
        if (temp.prev != null) {
            temp.prev.next = node;
        } else {
            head = node; 
        }
        temp.prev = node;
    }

    public void makeCircular() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head; 
        head.prev = temp; 
    }

    public void printAll() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.name + " ");
            temp = temp.next;
        } while (temp != null && temp != head);
        System.out.println();
    }
    public static void main(String[] args) {
        task1 list = new task1();

        list.insertAtBeginning("Alice");
        list.insertAtBeginning("Bob");

        list.insertAtEnd("Eve");

        Node nodeDavid = new Node("David");
        list.insertAtBeginning(nodeDavid);

        Node nodeChris = new Node("Chris");
        list.insertAfterName("Alice", nodeChris);

        Node nodeZack = new Node("Zack");
        list.insertBeforeName("Alice", nodeZack);

        list.makeCircular();

        list.printAll();
    }
}
