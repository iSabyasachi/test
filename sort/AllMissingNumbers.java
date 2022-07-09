package test.sort;
import java.util.*;

/**
We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, 
which means some numbers will be missing. Find all those missing numbers.

Ex 1:
Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.

Ex 2: 
Input: [2, 4, 1, 2]
Output: 3

Ex 3:
Input: [2, 3, 2, 1]
Output: 4

Time Complexity : O(N)
Space Complexity : O(1)
 */

 
class AllMissingNumbers {

  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> missingNumbers = new ArrayList<>();
    int i = 0;
    while(i < nums.length){
        int j = nums[i] - 1;
        if(j < nums.length && nums[i] != nums[j]){
            swap(nums, i , j);
        }else{
            i++;
        }
    }
    for(int k = 0 ; k < nums.length ; k++){
        if(k != nums[k] - 1){
            missingNumbers.add(k+1);
        }        
    }
    System.out.println(Arrays.toString(nums));
    return missingNumbers;
  }

  public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        //int[] nums = new int[]{2, 4, 1, 2};
        int[] nums = new int[]{2, 3, 1, 8, 2, 3, 5, 1};
        List<Integer> result = findNumbers(nums);
        System.out.println(result);
    }
}