package test.sort;
import java.util.*;
/**
We are given an array containing n distinct numbers taken from the range 0 to n. Since the array has only n 
numbers out of the total n+1 numbers, find the missing number.
Ex 1:
Input: [4, 0, 3, 1]
Output: 2

Ex 2:
Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7

Time Complexity : O(N)
Space Complexity : O(1)
 */
class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){                      
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }else{
                i++;
            }
        }
        for(int j = 0 ; j < nums.length ; j++){
            if(j != nums[j]){
                return nums[j];
            }
        }
        return -1;
    }
    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        int[] nums = new int[]{4, 0, 3, 1};
        int result = findMissingNumber(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }
}