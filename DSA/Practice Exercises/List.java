public class List {
    Node head; 

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public int nthFromLast(int n) {
        int length = 0;
        Node temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (n > length || head == null) {
            return -1; 
        }

        temp = head;
        for (int i = 1; i < length - n + 1; i++) {
            temp = temp.next;
        }

        return temp.data;
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

    public static void main(String[] args) {
        List list = new List();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        int n = 2;
        int result = list.nthFromLast(n);

        if (result != -1) {
            System.out.println("The " + n + "th node from the end is: " + result);
        } else {
            System.out.println("List is empty or n is greater than the number of nodes in the list.");
        }
    }
}
