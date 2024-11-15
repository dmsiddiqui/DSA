package lab4;

class Stack{

    private int arr[];
    private int top;
    private int cap;

    Stack(int size){
        
        arr = new int[size];
        cap = size;
        top = -1; 
    }

    public boolean isFull(){
        return top== cap-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int x){
        if(isFull()){
            System.out.println("OverFlow");
        }
        else{
            cap++;
            arr[++top]=x;
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        cap--;
        return arr[top--];
    }
    public int top(){
        return arr[top];
    }
    public int size(){
        return cap;
    }

}
public class task {
    public static void main(String[] args) {
        Stack stack = new Stack(3);

        System.out.println("Inserting 1 :");
        stack.push(1);

        System.out.println("Inserting 2 :");
        stack.push(2);

        System.out.println("Removing the top 2 :");
        System.out.println("Poped : "+stack.pop());

        System.out.println("Removing the top 1 :");
        System.out.println("Poped : "+stack.pop());

        System.out.println("Inserting 3 :");
        stack.push(3);

        System.out.println("Top element is: " + stack.top()); 
        System.out.println("Stack size is " + stack.size());

        System.out.println("Removing the top 3 :");
        System.out.println("Poped : "+stack.pop());

        if (stack.isEmpty())
            System.err.println("Stack is Empty");
        else
        System.out.println("Stack is Not Empty");
    }
}
