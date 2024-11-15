package lab8;

public class PalindromeCheck {
    
    public static boolean isPalindrome(String str, int start, int end) {
        // Base case: if the string has only one character or no characters, it's a palindrome
        if (start >= end) {
            return true;
        }
        // Check if the characters at start and end are the same
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        // Recursively check the next pair of characters
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "racecar";
        boolean result = isPalindrome(input, 0, input.length() - 1);
        System.out.println("Is \"" + input + "\" a palindrome? " + result);
    }
}
