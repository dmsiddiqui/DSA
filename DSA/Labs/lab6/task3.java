import java.util.Arrays;

public class task3 {
    public static void SortingFour(int[] arr) {

        if (arr[0] > arr[1]) {
            swap(arr, 0, 1);
        }
        if (arr[2] > arr[3]) {
            swap(arr, 2, 3);
        }
        if (arr[0] > arr[2]) {
            swap(arr, 0, 2);
            swap(arr, 1, 3);
        }
        if (arr[1] > arr[2]) {
            swap(arr, 1, 2);
        }
        if (arr[1] > arr[3]) {
            swap(arr, 1, 3);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};
        SortingFour(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

