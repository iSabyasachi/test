package test.twopointers;

import java.util.*;
/**
1. Given an array of unsorted numbers and a target number, 
2. find a triplet in the array whose sum is as close to the target number as possible, 
3. return the sum of the triplet
4. If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Ex 1 : 
Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

Ex 2 : 
Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.

Ex 3 :
Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.

Algo :
1. Initiate a variable V to store nearest value to target.
2. Find the triplet and check if the sum is greater than the variable V and lesser than or equal to the target.
3. iterate till the end of array and then return V.

TimeComplexity :
    getSum() -> O(1)    
    findTriplet() -> O(N)
    twoSum() -> O(N * N)
    Sort -> O(N * log N)
    Total = O(N * log N) + O(N * N) = O(N * N)
Space Complexity : 
    Sort -> O(N)
 */
public class TripletSumTarget{

    public static void main(String[] args){
        System.out.println("Hello TripletSumTarget!!!");
        //Integer[] input = new Integer[]{-2, 0, 1, 2};
        //Integer target = 2;
        //Integer[] input = new Integer[]{-3, -1, 1, 2};
        //Integer target = 1;
        Integer[] input = new Integer[]{1, 0, 1, 1};
        Integer target = 100;
        System.out.println(findTriplet(input, target));
        
    }
    public static int findTriplet(Integer[] input, Integer target){
        Arrays.sort(input);
        int closestNum = Integer.MIN_VALUE;
        for(int i = 0 ; i < input.length ; i++){
            closestNum = twoSum(input, i , target , closestNum); 
        }
        return closestNum;
    }
    public static int twoSum(Integer[] input, int index, int target, int closestNum){
        if(index >= input.length - 2)
            return closestNum;
        
        List<Integer[]>  findTripletList = new ArrayList<>();

        int left = index + 1;
        int right = input.length - 1;

        while(left < right){
            //Find triplet sum
            int tripletSumVal = getSum(new Integer[]{input[index] , input[left] , input[right]});
            if(tripletSumVal == target){
                closestNum = target;
                left++;
                right--;
            }else if(tripletSumVal > target){
                if(tripletSumVal >  closestNum && tripletSumVal < target){
                    //Find triplet sum and check if it is closest to the target
                     closestNum = tripletSumVal;
                }                
                right--;
            }else{
                if(tripletSumVal >  closestNum && tripletSumVal < target){
                    //Find triplet sum and check if it is closest to the target
                     closestNum = tripletSumVal;
                }
                left++;
            }
        }
        return closestNum;
    }
    public static int getSum(Integer[] arr){
        int sum = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
        }
        return sum;
    }

}