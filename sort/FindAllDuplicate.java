package test.sort;
import java.util.*;

/**
We are given an unsorted array containing n numbers taken from the range 1 to n. 
The array has some numbers appearing twice, find all these duplicate numbers using constant space.

Ex 1 :
Input: [3, 4, 4, 5, 5]
Output: [4, 5]

Ex 2:
Input: [5, 4, 7, 2, 3, 5, 3]
Output: [3, 5]

Time Complexity : O(N)
Space Complexity : O(1)
 */

class FindAllDuplicate {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0;        
        while(i < nums.length){
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i , nums[i] - 1);
            }else{
                i++;
            }
        }  
        //System.out.println(Arrays.toString(nums));   
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] != j + 1){
                duplicateNumbers.add(nums[j]);
            }
        } 
        return duplicateNumbers;
    }
  
    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1, 4, 4, 3, 3};
        //int[] nums = new int[]{2, 1, 3, 3, 5, 4};
        List<Integer> result = findNumbers(nums);
        System.out.println(result);
    }
}