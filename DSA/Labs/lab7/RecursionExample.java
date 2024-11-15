package lab7;
import java.util.Scanner;
public class RecursionExample {
    
    public static void printAscending(int n) {
        if (n == 0) {
            return; // Base case
        }
        printAscending(n - 1);
        System.out.print(n + " ");
    }

    public static void printDescending(int n) {
        if (n == 0) {
            return; // Base case
        }
        System.out.print(n + " ");
        printDescending(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number N: ");
        int N = sc.nextInt();
        
        System.out.println("Numbers in ascending order:");
        printAscending(N);
        
        System.out.println("\nNumbers in descending order:");
        printDescending(N);
        
        sc.close();
    }
}

