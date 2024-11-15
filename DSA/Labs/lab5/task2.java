package lab5;
import java.util.Scanner;
import java.util.Stack;

class BalancedBrackets {
    
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string with brackets:");
        String input = scanner.nextLine();

        if (BalancedBrackets.isBalanced(input)) {
            System.out.println("The string has balanced brackets.");
        } else {
            System.out.println("The string does not have balanced brackets.");
        }
        scanner.close();
    }
}
