package test.sliding;
import java.util.*;


public class MaximumSubArray{
    
    public static void main(String[] args) {
       MaximumSubArray obj = new MaximumSubArray();
       int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
       
       int results = obj.maxSubArray(nums);
       System.out.println(results);
    }
    /**
    Time Complexity : O(N^2)
    Space Complexity : O(1)
     */
    public int maxSubArray(int[] nums) {        
        int largestSubArray = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length ; i++){
            int currentSubArray = 0;
            for(int j = i; j < nums.length ; j++){
                currentSubArray += nums[j];
                largestSubArray = Math.max(currentSubArray, largestSubArray);
            }   
        }       
        return largestSubArray;
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public int maxSubArrayOpt(int[] nums) {        
        int largestSubArray = nums[0];
        int currentSubArray = nums[0];
        for(int i = 1; i < nums.length ; i++){
            int num = nums[i];
            currentSubArray = Math.max(num, num + currentSubArray);
            largestSubArray = Math.max(currentSubArray, largestSubArray);
        }
        return largestSubArray;
    }
    
}