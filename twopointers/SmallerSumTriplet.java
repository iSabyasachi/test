package test.twopointers;

import java.util.*;

/**
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. 
Write a function to return the count of such triplets.

Input: [-1, 0, 2, 3], target=3 
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

Input: [-1, 4, 2, 1, 3], target=5 
Output: 4
Explanation: There are four triplets whose sum is less than the target: 
[-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]


Algo :

1. Find triplet using twosum method and then check if the sum is lesser than the target.
If yes, increase the finalCount.

Time Complexity : N LogN + N^3 (For fetching the list, for getting the count, N LogN + N^2)
Space Complexity : N (For Sorting)
 */

public class SmallerSumTriplet{

    public static void main(String[] args){
        System.out.println("Hello SmallerSumTriplet!!!");
        //int[] input = new int[]{-1, 0, 2, 3};
        //int target = 3;
        int[] input = new int[]{-1, 4, 2, 1, 3};
        int target = 5;
        //-1, 1, 2, 3, 4
        System.out.println(tripletSum(input, target));
        
    }

    public static List<List<Integer>> tripletSum(int[] input, int target){
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
        System.out.println("Target "+target);
        List<List<Integer>> resultList = new ArrayList<>();
        int finalCount = 0;
        for(int i = 0 ; i < input.length ; i++){
            resultList = findTwoSum(input, i, target - input[i], finalCount, resultList);
        }
        System.out.println(resultList);
        return resultList;
    }

    public static List<List<Integer>> findTwoSum(int[] arr, int index, int complement, int finalCount, List<List<Integer>> resultList){
        
        if(index >= arr.length - 2)
            return resultList;
        
        int left = index + 1;
        int right = arr.length - 1;
        
        while(left < right){
                        
            if(arr[left] + arr[right] < complement){ 
                //finalCount += right - left;
                for(int i = right ; i > left ; i--){
                    List<Integer> results = new ArrayList<>();
                    results.add(arr[index]);
                    results.add(arr[left]);
                    results.add(arr[i]);
                    resultList.add(results);
                }
                left++;              
            }else{                
                right--;
            }
        }
        return resultList;
    }

}