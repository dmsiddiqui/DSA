package lab11;
import java.util.ArrayList;
class PriorityQueueUsingArray {
    private ArrayList<Integer> array;

    public PriorityQueueUsingArray() {
        array = new ArrayList<>();
    }

    public void insert(int data) {
        try {
            array.add(data);
        } catch (Exception e) {
            System.out.println("Error while inserting data: " + e.getMessage());
        }
    }

    public int extractMax() {
        try {
            if (array.isEmpty()) {
                throw new IllegalStateException("Priority Queue is empty.");
            }
            int maxIndex = 0;
            for (int i = 1; i < array.size(); i++) {
                if (array.get(i) > array.get(maxIndex)) {
                    maxIndex = i;
                }
            }
            int maxValue = array.get(maxIndex);
            array.remove(maxIndex);
            return maxValue;
        } catch (Exception e) {
            System.out.println("Error while extracting max: " + e.getMessage());
            return -1;
        }
    }

    public int getMax() {
        try {
            if (array.isEmpty()) {
                throw new IllegalStateException("Priority Queue is empty.");
            }
            int maxValue = array.get(0);
            for (int value : array) {
                if (value > maxValue) {
                    maxValue = value;
                }
            }
            return maxValue;
        } catch (Exception e) {
            System.out.println("Error while getting max: " + e.getMessage());
            return -1;
        }
    }

    public boolean searchData(int data) {
        try {
            return array.contains(data);
        } catch (Exception e) {
            System.out.println("Error while searching data: " + e.getMessage());
            return false;
        }
    }
}

public class task {
    public static void main(String[] args) {
        PriorityQueueUsingArray pq = new PriorityQueueUsingArray();
        pq.insert(10);
        pq.insert(30);
        pq.insert(20);

        System.out.println("Maximum value: " + pq.getMax());
        System.out.println("Extracted max: " + pq.extractMax());
        System.out.println("Maximum value after extraction: " + pq.getMax());

        System.out.println("Search 20: " + pq.searchData(20));
        System.out.println("Search 30: " + pq.searchData(30));
    }
}

