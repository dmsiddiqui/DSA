package lab4;

class Queue { 
    private int arr[]; 
    private int front; 
    private int rear; 
    private int capacity; 
    private int count; 

    public Queue(int size) { 
        arr = new int[size]; 
        capacity = size; 
        front = 0; 
        rear = 0; 
        count = 0; 
    }

    public boolean isFull(){
        return count == capacity;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full");
        }else{
            arr[rear]=data;
            rear= (rear+1) % capacity;
            count++;
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return-1;
        }else{
            count --;
            int data = arr[front];
            front = (front + 1)%capacity;
            return data;
        }
    }

    public int peek(){
        if(!isEmpty()){
            return arr[front];
        }else{
            return-1;
        }
    }
    
    public int size(){
        return count;
    }

}
public class task3 {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        System.out.println("Inserting 1 :");
        q.enqueue(1); 

        System.out.println("Inserting 2 :");
        q.enqueue(2); 

        System.out.println("Inserting 3 :");
        q.enqueue(3); 

        System.out.println("Front element is: " + q.peek()); 

        System.out.println("Removing 1 :");
        q.dequeue(); 

        System.out.println("Front element is: " + q.peek()); 
        System.out.println("Queue size is " + q.size());

        System.out.println("Removing 2 :");
        q.dequeue();

        System.out.println("Removing 3 :");
        q.dequeue();

        if (q.isEmpty()) 
        System.out.println("Queue Is Empty"); 
        else System.out.println("Queue Is Not Empty");
    }
}
