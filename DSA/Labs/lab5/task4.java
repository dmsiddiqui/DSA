package lab5;
import java.util.Stack;
class InfixToPostfix {

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String convertToPostfix(String exp) {
        
        StringBuilder result = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
           
            else if (c == '(') {
                stack.push(c);
            }
            
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
public class task4 {
    public static void main(String[] args) {
        String infix = "A+B*C+D";
        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + InfixToPostfix.convertToPostfix(infix));
    }
}
