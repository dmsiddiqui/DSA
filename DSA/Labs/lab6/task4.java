import java.util.Arrays;

public class task4 {
    public static boolean twoSum(int[] arr, int K) {
        
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int sum = arr[left] + arr[right];

            if (sum == K) {
                
                if (left != right || (left == right && arr[left] + arr[right] == K)) {
                    return true;
                }
            }

            if (sum < K) {
                left++;
            } 
            else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 6};
        int K = 10;

        if (twoSum(arr, K)) {
            System.out.println("Yes, there are two numbers whose sum equals " + K);
        } else {
            System.out.println("No, there are no two numbers whose sum equals " + K);
        }
    }
}

