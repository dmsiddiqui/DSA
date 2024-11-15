class SortingAlgorithms {
    
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

public class task {
    public static void main(String[] args) {
        int[] array1 = {64, 25, 12, 22, 11};
        int[] array2 = {96, 32, 14, 22, 1};

        System.out.println("Original array:");
        SortingAlgorithms.printArray(array1);
        SortingAlgorithms.selectionSort(array1);
        System.out.println("Array after Selection Sort:");
        SortingAlgorithms.printArray(array1);
        SortingAlgorithms.insertionSort(array2);
        System.out.println("Array after Insertion Sort:");
        SortingAlgorithms.printArray(array2);
    
    }
}
