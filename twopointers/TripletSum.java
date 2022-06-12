package test.twopointers;

import java.util.*;

/**
Problem Statement #
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Ex 1 : 
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.

Ex 2 : 
Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.

Algo :

1. Iterate each index and find the two sum of the complement of the element for that index
2. If found, check if all the three elements are already present.
3. If yes, ignore, continue searhing

Time Complexity : For Sorting : O(N log N) & for findling triplets : O(N * N) : So O(N  * N)
 */
public class TripletSum{

    public static void main(String[] args){
        System.out.println("Hello TripletSum!!!");

        //Integer[] arr = new Integer[]{-3, 0, 1, 2, -1, 1, -2};
        Integer[] arr = new Integer[]{-5, 2, -1, -2, 3};
        List<Integer[]> finalRes = triplets(arr, 0);
        for(Integer[] arrs : finalRes){
            System.out.println(Arrays.toString(arrs));
        }        
    }

    public static List<Integer[]> triplets(Integer[] arr, int K){
        List<Integer[]> res = new ArrayList<>();

        Arrays.sort(arr);

        System.out.println("1. arr"+Arrays.toString(arr));

        for(int i = 0 ; i < arr.length ; i++){
            List<Integer[]> resList = findTwoSum(arr, i, K - arr[i]);
            if(resList != null && resList.size() > 0)
                res.addAll(resList);
        }
        return res;
    }
    public static List<Integer[]> findTwoSum(Integer[] arr, int index, int complement){
        List<Integer[]> currRes = new ArrayList<>();
        if(index >= arr.length - 2)
            return null;
        
        int left = index + 1;
        int right = arr.length - 1;

        while(left < right){                  
            if(arr[left] + arr[right] == complement){
                currRes.add(new Integer[]{arr[index], arr[left], arr[right]}); 
                left++;
                right--;               
            }else if(arr[left] + arr[right] > complement){
                right--;
            }else{
                left++;
            }
        }
        return currRes;
    }

}