package lab5;
class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class LL{
    Node head;

    public void add(int data) {
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

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void printReverse(Node node) {
        if (node == null) {
            return;
        }
        printReverse(node.next); 
        System.out.print(node.data + " -> ");
    }

    public void printReverse() {
        printReverse(head);
        System.out.println("NULL"); 
    }
}

public class task {
    public static void main(String[] args){
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("Original Linked List:");
        list.printList();

        System.out.println("Original Linked List in Reverse Order:");
        list.printReverse();

        System.out.println("Original Linked List:");
        list.printList();
    }
}
