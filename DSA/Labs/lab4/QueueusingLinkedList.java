package lab4;
class Node {
    int data;  
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class Queue {
    private static Node rear = null, front = null;

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int data = front.data;
        front = front.next; 
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

public class QueueusingLinkedList {
    public static void main(String[] args) {
        Queue qu = new Queue();
        qu.enqueue(1);
        qu.enqueue(2);
        qu.enqueue(3);
        qu.enqueue(4);

        System.out.println("Front element is: " + qu.peek());

        qu.dequeue();
        qu.dequeue();
        qu.dequeue();
        qu.dequeue();

        if (qu.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue is not empty");
        }
    }
}
