package lab1;

import java.util.Arrays;

public class task1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 2, 2, 7, 8, 9};
        int i=0;
        for(int j=0 ; j<arr.length;j++){
            if (arr[j]%2!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }
        System.out.println(Arrays.toString(arr)); 
    }
}
