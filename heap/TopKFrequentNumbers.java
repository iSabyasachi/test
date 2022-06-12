package test.heap;
import java.util.*;
import java.util.stream.Collectors;

/**
Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
Ex 1:
Input: [1, 3, 5, 12, 11, 12, 11], K = 2
Output: [12, 11]
Explanation: Both '11' and '12' apeared twice.

Ex 2:
Input: [5, 12, 11, 3, 11], K = 2
Output: [11, 5] or [11, 12] or [11, 3]
Explanation: Only '11' appeared twice, all other numbers appeared once.


Time Complexity : O(N + N Log K)
Space Complexity : O(N)
 */

class TopKFrequentNumbers {

  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
    List<Integer> topNumbers = new ArrayList<>(k);
    Map<Integer, Integer> numMap = new HashMap<>();
    for(int num : nums)
        numMap.put(num, numMap.getOrDefault(num,0) + 1);
    
    PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<Map.Entry<Integer, Integer>>(
        (e1, e2) -> e1.getValue() - e2.getValue());
    
    for(Map.Entry<Integer, Integer> me : numMap.entrySet()){
        heap.add(me);
        if(heap.size() > k){
            heap.poll();
        }
    }
    
    while(!heap.isEmpty()){
        topNumbers.add(heap.poll().getKey());
    }
    return topNumbers;
  }

  public static void main(String[] args) {
    List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);
    
    result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);
  }
}