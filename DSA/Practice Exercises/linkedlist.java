class Node {
    int data ;
    Node next ;

    Node (int data){
        this.data = data;
        this.next = null;
    }
}
class linked{
    Node head;
    
    void insert(int data){
        
        Node newNode = new Node(data);
        if(head == null ){
            head = newNode;
        }
        else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next= newNode;
        }
    }

    void display(){
        Node current = head;
        while(current != null){
            System.out.println(current.data + " -> ");
            current =current.next;
        }
        System.out.println("null");
    }
}
public class linkedlist {
    public static void main(String[] args) {
        linked list = new linked();

        list.insert(5);
        list.insert(8);
        list.insert(10);

        list.display();
    }    
}
