import java.util.Arrays;

public class task2 {
    public void mergeSort(int[] array) {
        int n = array.length;
        int[] tempArray = new int[n];

        // Iterate over subarray sizes: 1, 2, 4, 8, etc.
        for (int size = 1; size < n; size *= 2) {
            // Iterate over the array in blocks of size `size`
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * size) {
                // Find the end points for the left and right subarrays
                int mid = Math.min(leftStart + size - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);

                // Merge the two subarrays
                merge(array, tempArray, leftStart, mid, rightEnd);
            }
        }
    }

    private void merge(int[] array, int[] tempArray, int leftStart, int mid, int rightEnd) {
        int left = leftStart;
        int right = mid + 1;
        int index = leftStart;

        // Merge the two subarrays into tempArray
        while (left <= mid && right <= rightEnd) {
            if (array[left] <= array[right]) {
                tempArray[index++] = array[left++];
            } else {
                tempArray[index++] = array[right++];
            }
        }

        // Copy any remaining elements from the left subarray
        while (left <= mid) {
            tempArray[index++] = array[left++];
        }

        // Copy any remaining elements from the right subarray
        while (right <= rightEnd) {
            tempArray[index++] = array[right++];
        }

        // Copy the merged subarray back into the original array
        for (int i = leftStart; i <= rightEnd; i++) {
            array[i] = tempArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        task2 sorter = new task2();
        sorter.mergeSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

