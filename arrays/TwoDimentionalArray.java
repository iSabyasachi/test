package test.arrays;
import java.util.Arrays;
import java.util.*;
public class TwoDimentionalArray{
    public static void main(String[] args){
        int[][] arrays = {{1,2,3},{4,5,6},{7,8,9}};

        for(int i = 0; i < arrays.length ; i++){
            for(int j = 0; j < arrays[i].length ; j++){
                System.out.print(arrays[i][j]+" ");
            }
            System.out.println("");
        }
        reverseArray(arrays);
        System.out.println("");
        for(int i = 0; i < arrays.length ; i++){
            for(int j = 0; j < arrays[i].length ; j++){
                System.out.print(arrays[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void reverseArray(int[][] arrays){
        for(int i = 0; i < arrays.length ; i++){
            int j = 0, k = arrays[i].length - 1;

            while(j < k){
                int temp = arrays[i][j];
                arrays[i][j] = arrays[i][k];
                arrays[i][k] = temp;
                j++;
                k--;
            }
        }
    }

}