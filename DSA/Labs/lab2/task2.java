package lab2;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class linkedlist{
    Node head,tail;
    int size;

    void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            size++;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    void addfirstNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            size++;
        }
        else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }
    void removenode(){
        if(head == null){
            System.out.println("Empty");
        }
        else{
            head = head.next;
            size--;
        }
    }
    public int getsize(){
        return size;
    }
}
public class task2 {
    public static void main(String[] args) {
        linkedlist list = new linkedlist();

        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        System.out.println("Size -> " + list.getsize() );

    }
}
