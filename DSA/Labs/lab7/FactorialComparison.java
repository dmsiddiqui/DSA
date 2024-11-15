package lab7;
import java.util.Scanner;

public class FactorialComparison {

    // Iterative method to calculate factorial
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Recursive method to calculate factorial
    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to calculate its factorial: ");
        int n = scanner.nextInt();

        // Calculate factorial using iterative approach and measure time
        long startIterative = System.nanoTime();
        long resultIterative = factorialIterative(n);
        long endIterative = System.nanoTime();
        long timeIterative = endIterative - startIterative;

        // Calculate factorial using recursive approach and measure time
        long startRecursive = System.nanoTime();
        long resultRecursive = factorialRecursive(n);
        long endRecursive = System.nanoTime();
        long timeRecursive = endRecursive - startRecursive;

        // Display results
        System.out.println("\nFactorial of " + n + " (Iterative): " + resultIterative);
        System.out.println("Time taken by Iterative method: " + timeIterative + " nanoseconds");

        System.out.println("\nFactorial of " + n + " (Recursive): " + resultRecursive);
        System.out.println("Time taken by Recursive method: " + timeRecursive + " nanoseconds");

        // Compare which approach is faster
        if (timeIterative < timeRecursive) {
            System.out.println("\nIterative method is faster.");
        } else if (timeRecursive < timeIterative) {
            System.out.println("\nRecursive method is faster.");
        } else {
            System.out.println("\nBoth methods took the same time.");
        }

        scanner.close();
    }
}

