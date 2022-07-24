package test.matrix;

import java.util.*;

public class SpiralMatrixII{  
    public static void main(String[] args) {       
       int n = 3;
      
       int[][] resMatrix = spiralOrder(n);
       for(int[] val : resMatrix){
        System.out.println(Arrays.toString(val));
       }
    }
    
    public static int[][] spiralOrder(int n) {       
        int[][] matrix = new int[n][n];
        int curr = 1, row = 0, col = 0, rowLength = n, colLength = n, max = n * n;
        
        while(curr <= max){
            //move right: (row, col + 1)            
            while(row < rowLength && col < colLength && matrix[row][col] == 0){
                matrix[row][col] = curr++;                
                col++;
            }
            col--;

            //move downwards: (row + 1, col)
            row++;            
            while(row < rowLength && col < colLength && matrix[row][col] == 0){
                matrix[row][col] = curr++;      
                row++;
            }
            row--; 

            //move left: (row, col - 1)
            col--; 
            while(row < rowLength && col >= 0 && matrix[row][col] == 0){
                matrix[row][col] = curr++;      
                col--;
            }
            col++;
           
            //move upwards: (row - 1, col)
            row--;
            while(row >= 0 && col < colLength && matrix[row][col] == 0){
                matrix[row][col] = curr++;      
                row--;
            }
            row++;
            col++;
        }
        
        return matrix;
    }
   
}

