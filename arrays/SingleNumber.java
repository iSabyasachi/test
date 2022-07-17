package test.arrays;

import java.util.*;
import java.util.stream.*;
/**
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 */
public class SingleNumber{  

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        //int[] arr = new int[]{1,1,2};
        //int[] arr = new int[]{-1};
        Integer result = singleNumber(arr);
        System.out.println(result);
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N)
     */
    public static Integer singleNumber(int[] nums){
        Map<Integer,Integer> table = new HashMap<>();
        for(int num : nums){
            table.put(num, table.getOrDefault(num, 0)+1);
        }
        for(int num : nums){
            if(table.get(num) == 1){
                return num;
            }
        }    
        return 0;
    }
    /**
    Time Complexity : O(N^2)
    Space Complexity : O(N)
     */
    public static Integer singleNumberNotOptimized(int[] nums){
        List<Integer> no_duplicate_list = new ArrayList<>();
        for(int num : nums){
            if(no_duplicate_list.contains(num)){
                no_duplicate_list.remove(new Integer(num));
            }else{
                no_duplicate_list.add(num);
            }
        }        
        return no_duplicate_list.get(0);
    }
    
    
}

