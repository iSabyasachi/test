package test.sort;

import java.util.*;
import java.util.stream.*;
/**
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
 */
public class SortColors{

    public static void main(String[] args){
        SortColors obj = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        //int[] nums = {0,1};
        //int[] nums = {0,1,0};
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, i = 0;
        while(i < high){
            if(nums[i] == 0) swap(nums, low++, i++);
            else if(nums[i] == 2) swap(nums, i, high--);
            else if(nums[i] == 1) i++;
        }
    } 
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }    
}