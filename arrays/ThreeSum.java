package test.arrays;
import java.util.*;

public class ThreeSum{
    public static void main(String[] args){        
        ThreeSum obj = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        //int[] nums = {0,0,0};
        //int[] nums = {-2,0,0,2,2};
        List<List<Integer>> res = obj.threeSum(nums);
        System.out.println(res);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            List<List<Integer>> currRes = twoSum(nums, i, -nums[i]);
            if(currRes != null && currRes.size() > 0){
                result.addAll(currRes);
            } 
            while(i + 1 < nums.length && nums[i] == nums[i+1]){
                i++;
            }                                 
        }
        return result;
    }
    public List<List<Integer>> twoSum(int[] nums, int i, int complement){
        List<List<Integer>> result = new ArrayList<>();          
        int low = i + 1, high = nums.length-1;
        while(low < high){                   
            if(nums[low] + nums[high] == complement){
                result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                while(low + 1 < high && nums[low] == nums[low+1]){
                    low++;
                }
                low++;
                while(high - 1 > low && nums[high] == nums[high-1]){
                    high--;
                } 
                high--;
            }else if(nums[low] + nums[high] > complement){
                high--;                               
            }else{
                low++;                
            }
        }       
        return result;
    }
}
