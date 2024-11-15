package lab8;
class Node {
    int data;
    Node next;

    // Constructor to create a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortedLists {

    // Function to merge two sorted linked lists
    public static Node mergeSortedLists(Node head1, Node head2) {
        // If one of the lists is empty, return the other list
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // Create a new head pointer for the merged list
        Node mergedHead;
        if (head1.data <= head2.data) {
            mergedHead = head1;
            mergedHead.next = mergeSortedLists(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = mergeSortedLists(head1, head2.next);
        }
        return mergedHead;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating first sorted linked list: 1 -> 3 -> 5
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        // Creating second sorted linked list: 2 -> 4 -> 6
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);

        // Merging both lists
        Node mergedHead = mergeSortedLists(head1, head2);

        // Printing the merged linked list
        System.out.print("Merged List: ");
        printList(mergedHead);
    }
}
