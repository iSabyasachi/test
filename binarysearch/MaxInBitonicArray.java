package test.binarysearch;

import java.util.*;
/**
Find the maximum value in a given Bitonic array. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing. 
Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

Ex : 1 
Input: [1, 3, 8, 12, 4, 2]
Output: 12
Explanation: The maximum number in the input bitonic array is '12'.

Ex : 2
Input: [3, 8, 3, 1]
Output: 8

Ex : 3
Input: [1, 3, 8, 12]
Output: 12

Ex : 4
Input: [10, 9, 8]
Output: 10
 */
 /**
 Time Complexity : O(Log N)
 Space Complexity : O(1)
  */
class MaxInBitonicArray {

  public static int findMax(int[] arr) {
    int start = 0 , end = arr.length -1;    
    while(start < end){
        int mid = start + (end - start)/2; 
        System.out.println("start "+start);       
        System.out.println("end "+end);   
        System.out.println("mid "+mid);   
        if(arr[mid] > arr[mid + 1]){
            end = mid;
        }else{
            start = mid + 1;
        }
    }

    return arr[start];
  }

  public static void main(String[] args) {
    //System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
    //System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
    //System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
    //System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 13, 4}));
  }
}