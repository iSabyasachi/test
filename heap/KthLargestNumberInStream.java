package test.heap;

import java.util.*;
/*
Design a class to efficiently find the Kth largest element in a stream of numbers.

The class should have the following two things:

The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
The class should expose a function add(int num) which will store the given number and return the Kth largest number.

Ex 1 : 
Input: [3, 1, 5, 12, 2, 11], K = 4
1. Calling add(6) should return '5'.
2. Calling add(13) should return '6'.
2. Calling add(4) should still return '6'.

Time Complexity : Add Function : O(Log K)
Space Complexity ; Add Function : O(K)
*/ 

class KthLargestNumberInStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((h1, h2) -> h1 - h2);
    final int k;
    public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;
        for(int i = 0 ; i < nums.length; i++){
            add(nums[i]);
        }
    }
    public int add(int num) {
        minHeap.add(num);
        if(minHeap.size() > this.k)
            minHeap.poll();
        
        return minHeap.peek();
    }


  public static void main(String[] args) {
    int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
    KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
    //System.out.println(kthLargestNumber.minHeap);
    System.out.println("4th largest number is: " + kthLargestNumber.add(6));
    System.out.println("4th largest number is: " + kthLargestNumber.add(13));
    System.out.println("4th largest number is: " + kthLargestNumber.add(4));
  }
}