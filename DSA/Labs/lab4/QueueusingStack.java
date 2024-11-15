package lab4;
import java.util.Stack;

class Queue {
    private Stack<Integer> s1, s2;

    Queue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(int data) {
        
        s1.push(data);
    }

    public int dequeue() {
        
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }
}

public class QueueusingStack{

    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5 };
        Queue Q = new Queue();

        for (int key : keys) {
            Q.enqueue(key);
        }

        System.out.println(Q.dequeue()); // print 1
        System.out.println(Q.dequeue()); // print 2
    }
}

