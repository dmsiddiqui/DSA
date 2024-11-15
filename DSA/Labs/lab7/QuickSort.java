package lab7;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);  // Get pivot index
            quickSort(arr, low, pi - 1);  // Sort left of pivot
            quickSort(arr, pi + 1, high);  // Sort right of pivot
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Pivot is the last element
        int i = (low - 1);  // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] with the pivot (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;  // Return the partition index
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted list");
        for (int num : arr) System.out.print(num + " ");
    }
}

