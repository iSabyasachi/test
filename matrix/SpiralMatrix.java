package test.matrix;

import java.util.*;

public class SpiralMatrix{  
    public static void main(String[] args) {
       int m = 3;
       int n = 3;
       int[][] matrix = createMatrix(m, n);
       for(int[] val : matrix){
        System.out.println(Arrays.toString(val));
       }

       int[][] matrixs = new int[][]{{23,18,20,26,25},{24,22,3,4,4},{15,22,2,24,29},{18,15,23,28,28}};
       List<Integer> res = spiralOrder(matrixs);
       System.out.println(res);
    }
    public static boolean searchMatrixList(List<Integer[]> result, int x, int y){
        for(Integer[] input : result){
            if(input[0] == x && input[1] == y){
                return true;
            }
        }
        return false;
    }
    
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        List<Integer[]> matrixIndex = new ArrayList<>();    
        int row = 0, col = 0, rowLength = matrix.length, colLength = matrix[0].length, length = rowLength * colLength;
        
        while(result.size() < length){
            //move right: (row, col + 1)            
            while(row < rowLength && col < colLength && !searchMatrixList(matrixIndex, row, col)){
                matrixIndex.add(new Integer[]{row,col});
                result.add(matrix[row][col]);
                col++;
            }
            col--;

            //move downwards: (row + 1, col)
            row++;            
            while(row < rowLength && col < colLength && !searchMatrixList(matrixIndex, row, col)){
                matrixIndex.add(new Integer[]{row,col});
                result.add(matrix[row][col]);
                row++;
            }
            row--; 

            //move left: (row, col - 1)
            col--; 
            while(row < rowLength && col >= 0 && !searchMatrixList(matrixIndex, row, col)){
                matrixIndex.add(new Integer[]{row,col});
                result.add(matrix[row][col]);
                col--;
            }
            col++;
           
            //move upwards: (row - 1, col)
            row--;
            while(row >= 0 && col < colLength && !searchMatrixList(matrixIndex, row, col)){
                matrixIndex.add(new Integer[]{row,col});
                result.add(matrix[row][col]);
                row--;
            }
            row++;
            col++;
        }
        return result;

    } 
    public static List<Integer> spiralOrderOpt(int[][] matrix) {
        List<Integer> result = new ArrayList<>();        
        int row = 0, col = 0, rowLength = matrix.length, colLength = matrix[0].length, length = rowLength * colLength;
        
        while(result.size() < length){
            //move right: (row, col + 1)            
            while(row < rowLength && col < colLength && !result.contains(matrix[row][col])){
                result.add(matrix[row][col]);
                col++;
            }
            col--;

            //move downwards: (row + 1, col)
            row++;            
            while(row < rowLength && col < colLength && !result.contains(matrix[row][col])){
                result.add(matrix[row][col]);
                row++;
            }
            row--; 

            //move left: (row, col - 1)
            col--; 
            while(row < rowLength && col >= 0 && !result.contains(matrix[row][col])){
                result.add(matrix[row][col]);
                col--;
            }
            col++;
           
            //move upwards: (row - 1, col)
            row--;
            while(row >= 0 && col < colLength && !result.contains(matrix[row][col])){
                result.add(matrix[row][col]);
                row--;
            }
            row++;
            col++;
        }
        return result;
    }
    
    public static int[][] createMatrix(int m, int n){
        int val = 1;
        int[][] result = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                result[i][j] = val;
                val++;
            }
        }
        return result;
    }
   
}

