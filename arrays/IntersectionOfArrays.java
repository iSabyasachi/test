package test.arrays;

import java.util.*;
import java.util.stream.*;
/**
Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
 */

public class IntersectionOfArrays{  

    public static void main(String[] args) {       
       int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
       System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0 ; i < nums1.length ; i++){
            for(int j = 0 ; j < nums2.length ; j++){
                if(nums1[i] == nums2[j]){
                    resultList.add(nums1[i]);
                    nums2[j] = -1;
                    break;
                }
            }
        }
        return resultList.stream().mapToInt(x->x).toArray();
    }    
   
}

