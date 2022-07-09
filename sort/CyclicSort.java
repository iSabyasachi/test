package test.sort;
import java.util.*;
/**
We are given an array containing n objects. Each object, when created, was assigned a unique number from the 
range 1 to n based on their creation sequence. This means that the object with sequence number 3 was created 
just before the object with sequence number 4.

Write a function to sort the objects in-place on their creation sequence number in O(n)
O(n)
 and without using any extra space. For simplicity, let’s assume we are passed an integer array containing 
 only the sequence numbers, though each number is actually an object.

Example 1:
Input: [3, 1, 5, 4, 2]
Output: [1, 2, 3, 4, 5]

Example 2:
Input: [2, 6, 4, 3, 1, 5]
Output: [1, 2, 3, 4, 5, 6]

Time Complexity : O(N)
Space Complexity : O(1)
 */
class CyclicSort {

    public static void sort(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int j = nums[i] - 1;
            if(nums[i] != nums[j]){                
                swap(nums, i , j);
            }
            i++;
        }
    }

    public static void swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        //int[] nums = new int[]{1,2,3,4,5,6};
        int[] nums = new int[]{3,2,1,4,6,5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    };
}