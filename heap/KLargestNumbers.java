package test.heap;

import java.util.*;

class KLargestNumbers {
/**
Time Complexity : O(K ∗ logK + (N−K) ∗ logK) , which is asymptotically equal to O(N * logK)
Space Complexity : O(K)
 */
  public static List<Integer> findKLargestNumbers(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for(int i = 0; i < nums.length ; i++){
        heap.add(nums[i]);
        if(i > k - 1){
          heap.poll();
        }
    }
    return new ArrayList<Integer>(heap);
  }

  public static void main(String[] args) {
    List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
    System.out.println("Here are the top K numbers: " + result);

    result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
    System.out.println("Here are the top K numbers: " + result);
  }
}