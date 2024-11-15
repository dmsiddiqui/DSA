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
    Node head;
    void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else {
            Node currentNode = head;
            while(currentNode.next!=null){
                currentNode = currentNode.next;
            }
            currentNode.next=newNode;
        }
    }

    void addfirst(int data){
        Node newnNode = new Node(data);
        Node currentNode = head;
        head = newnNode;
        head.next=currentNode;
    }
    public boolean search(int key) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == key) {
                return true;  
            }
            currentNode = currentNode.next;
        }
        return false;  
    }
    void display(){
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode =currentNode.next;
        }
        System.out.println("null");
    }
}
public class task {
    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        list.addNode(5);
        list.addNode(11);
        list.addNode(30);
        list.addNode(88);
        list.display();
        list.addfirst(22);
        list.display();
        int searchKey = 22;
        if (list.search(searchKey)) {
            System.out.println("Element " + searchKey + " found in the list.");
        } else {
            System.out.println("Element " + searchKey + " not found in the list.");
        }
    }
}
