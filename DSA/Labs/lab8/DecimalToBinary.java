package lab8;
public class DecimalToBinary {
    
    // Recursive function to convert decimal to binary
    public static String decToBinary(int num) {
        if (num == 0) {
            return "0"; // Base case when num is 0
        } 
        if (num == 1) {
            return "1"; // Base case when num is 1
        }
        // Recursive call: Divide by 2 and concatenate the remainder
        return decToBinary(num / 2) + (num % 2);
    }

    public static void main(String[] args) {
        int num = 13;
        String binaryRepresentation = decToBinary(num);
        System.out.println("Binary equivalent of " + num + " is: " + binaryRepresentation);
    }
}
