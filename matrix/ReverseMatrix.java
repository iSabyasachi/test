package test.matrix;

import java.util.*;


public class ReverseMatrix{  

    public static void main(String[] args) {
       int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
       for(int[] arr : matrix){
        System.out.println(Arrays.toString(arr));
       }
        System.out.println("------");
       reverseMatrix(matrix);

       for(int[] arr : matrix){
        System.out.println(Arrays.toString(arr));
       }

    }

    public static void reverseMatrix(int[][] matrix){
        int start = 0, end = matrix[start].length-1;

        while(start < end){
            for(int i = 0 ; i < matrix.length ; i++){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
            }
            start++;
            end--;
        }
    }
   
}

