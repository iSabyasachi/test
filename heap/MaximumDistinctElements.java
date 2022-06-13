package test.heap;

import java.util.*;

/**
Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.

Ex 1 :
Input: [7, 3, 5, 8, 5, 3, 3], and K=2
Output: 3
Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have to skip 5 because it is not distinct and appeared twice. 

Another solution could be to remove one instance of '5' and '3' each to be left with three distinct numbers [7, 5, 8], in this case, we have to skip 3 because it appeared twice.

Example 2:
Input: [3, 5, 12, 11, 12], and K=3
Output: 2
Explanation: We can remove one occurrence of 12, after which all numbers will become distinct. Then we can delete any two numbers which will leave us 2 distinct numbers in the result.

Example 3:
Input: [1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5], and K=2
Output: 3
Explanation: We can remove one occurrence of '4' to get three distinct numbers.

Algorithm
1. Create a Max Heap of HashMap<Integer, Integer> as number and number of occurance of the number
2. Remove the first element till k is 0
3. Find all unique number

Time Complexity : O(N) + O(K Log K)
Space Complexity : O(N) + O(K)
 */
class MaximumDistinctElements {

  public static int findMaximumDistinctElements(int[] nums, int k) {
    int result = 0;
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
    HashMap<Integer, Integer> hMap = new HashMap<>();
    for(int i = 0 ; i < nums.length ; i++){
        hMap.put(nums[i], hMap.getOrDefault(nums[i], 0) + 1);
    }
    //System.out.println(hMap);
    
    for(Map.Entry<Integer,Integer> me : hMap.entrySet()){
        if(me.getValue() == 1){
            result++;
        }else{
            minHeap.add(me);
        }
    }
    //System.out.println(minHeap);
    
    while(k > 0){
        if(minHeap.size() == 0){
            result--;
        }else{
            Map.Entry<Integer,Integer> entry = minHeap.poll();
            int currValue = entry.getValue();
            
            entry.setValue(currValue - 1); 
            if(entry.getValue() == 1){
                result++;
            }else{
                minHeap.add(entry);
            } 
        }               
        k--;
    }
    //System.out.println(minHeap);    
    return result;
  }

  public static void main(String[] args) {
    int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);

    
    result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);

    result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);
  }
}