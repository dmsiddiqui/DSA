package lab5;
class FirstSingleLetter {

    public static char firstSingleLetter(String text) {
        int n = text.length();
        
        for (int i = 0; i < n; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            
            for (int j = 0; j < n; j++) {
                if (i != j && currentChar == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            
            if (isUnique) {
                return currentChar;
            }
        }
        
        return '\0';
    }
}
public class task3 {
    public static void main(String[] args) {
        String text = "ALGORITHM";
        char result = FirstSingleLetter.firstSingleLetter(text);
        System.out.println("The text is : "+text);
        if (result != '\0') {
            System.out.println("First single letter: " + result);
        } else {
            System.out.println("No unique character found.");
        }
    }
}
