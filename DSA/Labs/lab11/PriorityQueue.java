package lab11;
import java.util.ArrayList;

public class PriorityQueue {
    
    private ArrayList<Integer> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    public void insert(int element) {
        int i = 0;
        
        while (i < queue.size() && queue.get(i) < element) {
            i++;
        }
        queue.add(i, element);
    }

    public int getMax() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty.");
        }
        return queue.get(queue.size() - 1);
    }

    public int extractMax() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty.");
        }
        return queue.remove(queue.size() - 1);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void display() {
        System.out.println(queue);
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        pq.insert(10);
        pq.insert(20);
        pq.insert(15);
        pq.insert(5);

        System.out.println("Priority Queue after insertions:");
        pq.display();

        System.out.println("Maximum element: " + pq.getMax());

        System.out.println("Extracted maximum: " + pq.extractMax());
        System.out.println("Priority Queue after extraction:");
        pq.display();
    }
}

