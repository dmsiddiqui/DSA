package lab7;
import java.util.Random;
import java.util.Scanner;

public class SearchInArray {
    // Method to search iteratively
    public static int iterativeSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return 1; // value found
            }
        }
        return 0; // value not found
    }

    // Method to search recursively
    public static int recursiveSearch(int[] arr, int value, int index) {
        if (index >= arr.length) {
            return 0; // value not found
        }
        if (arr[index] == value) {
            return 1; // value found
        }
        return recursiveSearch(arr, value, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.print("Enter a value to search for: ");
        int value = sc.nextInt();

        long startTimeIterative = System.nanoTime();
        int resultIterative = iterativeSearch(arr, value);
        long endTimeIterative = System.nanoTime();
        long durationIterative = endTimeIterative - startTimeIterative;

        long startTimeRecursive = System.nanoTime();
        int resultRecursive = recursiveSearch(arr, value, 0);
        long endTimeRecursive = System.nanoTime();
        long durationRecursive = endTimeRecursive - startTimeRecursive;

        System.out.println("Iterative Search Result: " + resultIterative);
        System.out.println("Recursive Search Result: " + resultRecursive);

        System.out.println("Iterative Search Time: " + durationIterative + " nanoseconds");
        System.out.println("Recursive Search Time: " + durationRecursive + " nanoseconds");

        if (durationIterative < durationRecursive) {
            System.out.println("Iterative search is faster.");
        } else if (durationRecursive < durationIterative) {
            System.out.println("Recursive search is faster.");
        } else {
            System.out.println("Both searches took the same time.");
        }

        sc.close();
    }
}

