package lab4;

class Node{
    int data;
    Node next;

    Node (int data){
        this.data=data;
        this.next=null;
    }
}

public class StackusingLinkedList {
    
    private Node top;
    public StackusingLinkedList(){
        this.top= null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(int x){
        Node n = new Node(x);
        if (isEmpty()) {
            top=n;
        }
        else{
            n.next=top;
            top=n;
        }
    }
    
    public int pop(){
        if(isEmpty()){
            return-1;
        }
        else{
            int data=top.data;
            top= top.next;
            return data;
        }
    }

    public int top(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        else{
            return top.data;
        }
    }
    public static void main(String[] args) {
        StackusingLinkedList stack = new StackusingLinkedList();
        System.out.println("Inserting 1 :");
        stack.push(1);

        System.out.println("Inserting 2 :");
        stack.push(2);

        System.out.println("Inserting 3 :");
        stack.push(3);

        System.out.println("Top Element is " + stack.top()) ;


        System.out.println("Removing the top 3 :");
        System.out.println("Poped : "+stack.pop());

        System.out.println("Removing the top 2 :");
        System.out.println("Poped : "+stack.pop());
        
        System.out.println("Removing the top 1 :");
        System.out.println("Poped : "+stack.pop());


        if(stack.isEmpty()){
            System.out.println("Stack is Empty");
        }else{
            System.out.println("Stack is Not Empty");
        }
    }
}
