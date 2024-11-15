package lab7;
import java.util.Scanner;

public class FibonacciComparison {

    // Iterative method to generate Fibonacci series
    public static void fibonacciIterative(int N) {
        int a = 0, b = 1, c;
        System.out.print("Fibonacci Series (Iterative): " + a + " " + b + " ");
        for (int i = 2; i < N; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println();
    }

    // Recursive method to calculate Fibonacci number
    public static int fibonacciRecursive(int N) {
        if (N <= 1) return N;
        return fibonacciRecursive(N - 1) + fibonacciRecursive(N - 2);
    }

    // Wrapper function to print Fibonacci series using recursion
    public static void fibonacciRecursiveSeries(int N) {
        System.out.print("Fibonacci Series (Recursive): ");
        for (int i = 0; i < N; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();

        long startIterative = System.nanoTime();
        fibonacciIterative(N);
        long endIterative = System.nanoTime();
        long timeIterative = endIterative - startIterative;
        System.out.println("Time taken by Iterative approach: " + timeIterative + " nanoseconds");

        long startRecursive = System.nanoTime();
        fibonacciRecursiveSeries(N);
        long endRecursive = System.nanoTime();
        long timeRecursive = endRecursive - startRecursive;
        System.out.println("Time taken by Recursive approach: " + timeRecursive + " nanoseconds");

        if (timeIterative < timeRecursive) {
            System.out.println("Iterative approach is faster.");
        } else {
            System.out.println("Recursive approach is faster.");
        }
    }
}

