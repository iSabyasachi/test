package test.arrays;
import java.util.*;


public class TwoSum{
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(hMap.containsKey(target - nums[i])){
                return new int[]{hMap.get(target - nums[i]) , i};
            }else{
                hMap.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSumOld(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }



    
}

