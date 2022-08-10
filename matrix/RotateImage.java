package test.matrix;
import java.util.*;


public class RotateImage{
    public static void main(String[] args) {
       int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
       rotate(matrix);

       for(int i = 0 ; i < matrix.length ; i++){
        for(int j = 0 ; j < matrix[i].length ; j++){
            System.out.print(matrix[i][j]);
        }
        System.out.println("");
       }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix[0].length;

        for(int i = 0 ; i < n / 2 + n % 2 ; i++){
            for(int j = 0 ; j < n / 2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }


    }
    
}

