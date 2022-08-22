package test.subsets;
import java.util.*;
/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber{
    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
       int[] nums = {1,2,3,1}; 
       int results = obj.rob(nums);
       System.out.println(results);
    }
    public int rob(int[] nums) {
        int maxAmount = 0;        
        for(int i = 0 ; i < nums.length ; i++){
            int currAmount = nums[i];
            for(int j = i + 2 ; j < nums.length ; j++){
                for(int k = j ; k < nums.length ; k++){
                    currAmount += nums[k];
                    maxAmount = Math.max(currAmount, maxAmount);
                    k++;
                }
            }           
        }
        return maxAmount;
    }
}