package lab2;
interface List {
    boolean isEmpty();
    int size();
    void add(Object item);
    void add(int index, Object item);
    void remove(int index);
    void remove(Object item);
    List duplicate();
    List duplicateReversed();
}

public class LinkedList implements List {
    private Node head;
    private int size;

    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = new Node(null);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Object item) {
        Node newNode = new Node(item);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public void add(int index, Object item) {
        if (index < 1 || index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(item);
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public void remove(Object item) {
        Node current = head;
        while (current.next != null && !current.next.data.equals(item)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    public List duplicate() {
        LinkedList copy = new LinkedList();
        Node current = head.next;
        while (current != null) {
            copy.add(current.data);
            current = current.next;
        }
        return copy;
    }

    public List duplicateReversed() {
        LinkedList copy = new LinkedList();
        Node current = head.next;
        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = copy.head.next;
            copy.head.next = newNode;
            current = current.next;
        }
        copy.size = size;
        return copy;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ size: ").append(size).append(" - ");
        Node current = head.next; 
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(2, "D");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.remove("B");
        System.out.println(list); 
        LinkedList copy = (LinkedList) list.duplicate();
        System.out.println(copy); 
        LinkedList reversedCopy = (LinkedList) list.duplicateReversed();
        System.out.println(reversedCopy); 
    }
}
