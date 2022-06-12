package test.sliding;

import java.util.*;

/**
Given an array with positive numbers and a positive target number, 
find all of its contiguous subarrays whose product is less than the target number.

Ex 1:
Input: [2, 5, 3, 10], target=30 
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.

Ex 2:
Input: [8, 2, 6, 5], target=50 
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5] 
Explanation: There are seven contiguous subarrays whose product is less than the target.

ALgo : 
Implemnt sliding window technique to check if the product of all elements is less then the target,
once calculated, move the slider till it reaches at the end of array.

TimeComplexity : O(N^3) ; Space Complexity : O(N^3)
 */
public class SubArraysWithProduct{

    public static void main(String[] args){
        System.out.println("Hello SubArraysWithProduct!!!");
        int[] input = new int[]{2, 5, 3, 10};
        //Integer[] input = new Integer[]{2, 5, 1, 2};
        //Integer[] input = new Integer[]{2, 5, 3};
        int target = 30;
        System.out.println(findSubarrays(input, target));
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        double product = 1;
        int left = 0;

        for(int right = 0 ; right < arr.length ; right++){
            product *= arr[right];

            while(product >= target && left <= right){
                product /= arr[left++];
            }
            List<Integer> subArrays = new LinkedList<>();
            for(int i = right ; i >= left ; i--){                
                subArrays.add(0, arr[i]);
                result.add(new ArrayList<>(subArrays));
            }
        }
        return result;
    }

}