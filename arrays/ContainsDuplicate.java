package test.arrays;

import java.util.*;
import java.util.stream.*;
/**
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Input: nums = [1,2,3,1]
Output: true
 */
public class ContainsDuplicate{  

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        boolean result = containsDuplicate(arr);
        System.out.println(result);
    }
    /**
    Time Complexity : O(NLogN)
    Space Complexity :O(1)
     */
    public static boolean containsDuplicate(int[] nums){        
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 1 ; i++){
            if(nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
    /**
    Time Complexity : O(N*N)
    Space Complexity : O(1)
     */
    public static boolean containsDuplicateNotOptimized(int[] nums){        
        for(int i = 0; i < nums.length ; i++){
            for(int j = i + 1; j < nums.length ; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N)
     */
    public static boolean containsDuplicateUsingHS(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
    
    
}

