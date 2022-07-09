package test;

import java.util.*;
import java.util.stream.*;

public class HappyMatrics{  

    public static void main(String[] args) {
        int[] A = new int[]{-1,2,2,1,2};
        int[] B = new int[]{1,1,1,1,2};

        int totalSumA = 0;
        int totalSumB = 0;
        for(int num : A){
            totalSumA +=num;
        }
        for(int num : A){
            totalSumB +=num;
        }         
        int totalCount = 0;
        int sumA = 0;
        int sumB = 0;
        for(int i = 0 ; i < A.length ; i++){
            sumA += A[i];
            sumB += B[i];
            if(isHappyMatric(A, totalSumA, sumA, i) && isHappyMatric(B, totalSumA, sumA, i)){
                totalCount++;
            }
        }
        System.out.println(totalCount);
    }
    public static boolean isHappyMatric(int[] inputArr, int totalSum, int sum, int i){ 
        if(sum == i + 1 && sum == (totalSum - sum)){
            return true;
        }
        return false;
    }
}
