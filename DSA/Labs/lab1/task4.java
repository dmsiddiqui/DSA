package lab1;

import java.util.Scanner;
public class task4 {
    public static void main(String[] args) {
        int rows, cols;
        Scanner SC = new Scanner(System.in);
        System.out.println("Enter no of Rows");
        rows = SC.nextInt();
        System.out.println("Enter no of Cols");
        cols = SC.nextInt();
        int arr[][]= new int[rows][cols];
        System.out.println("Enter elements of the Array");

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr[i][j]= SC.nextInt();
            }
            System.out.println();
        }
        System.out.println("Print Boundaries");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0 || j==0 || i==(rows-1) || j==(cols-1)){
                    System.out.println(" ");
                }else{
                    System.out.println(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
