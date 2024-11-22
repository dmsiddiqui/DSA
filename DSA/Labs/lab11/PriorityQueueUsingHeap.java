package lab11;
import java.util.Arrays;

public class PriorityQueueUsingHeap {
    private int[] heap;
    private int size; 
    private int capacity; 

    public PriorityQueueUsingHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public int removeMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty.");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    public int peekMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty.");
        }
        return heap[0];
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[getParentIndex(index)] < heap[index]) {
            
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(int index) {
        int largest = index;
        int leftChild = getLeftChildIndex(index);
        int rightChild = getRightChildIndex(index);

        if (leftChild < size && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }
        if (rightChild < size && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
    }

    public static void main(String[] args) {
        PriorityQueueUsingHeap pq = new PriorityQueueUsingHeap(10);

        pq.insert(15);
        pq.insert(20);
        pq.insert(10);
        pq.insert(30);

        System.out.println("Heap after insertions:");
        pq.printHeap();

        System.out.println("Max element: " + pq.peekMax());
        System.out.println("Removed max: " + pq.removeMax());

        System.out.println("Heap after removing max:");
        pq.printHeap();
    }
}
