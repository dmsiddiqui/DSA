package lab7;
public class PrintCharArray {

    public static void printForward(char[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        System.out.print(arr[index] + " ");
        printForward(arr, index + 1);
    }

    public static void printReverse(char[] arr, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(arr[index] + " ");
        printReverse(arr, index - 1);
    }
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'd', 'e'};

        System.out.println("Array in forward direction:");
        printForward(charArray, 0);

        System.out.println("\nArray in reverse direction:");
        printReverse(charArray, charArray.length - 1);
    }
}

