package test.heap;

import java.util.*;

class KthSmallestNumber {
    /**
    Time Complexity : O(K ∗ logK + (N−K) ∗ logK) , which is asymptotically equal to O(N * logK)
    Space Complexity : O(K)
    */
  public static int findKthSmallestNumber(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for(int i = 0 ; i < nums.length ; i++){
        if(i < (nums.length - k + 1)){
            heap.add(nums[i]);
        }else{
            if(nums[i] > heap.peek()){
                heap.poll();
                heap.add(nums[i]);
            }
        }
    }    
    return heap.peek();
  }

  public static void main(String[] args) {
    int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
    System.out.println("Kth smallest number is: " + result);

    // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
    result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
    System.out.println("Kth smallest number is: " + result);

    result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
    System.out.println("Kth smallest number is: " + result);
  }
}