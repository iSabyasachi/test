package test.binarysearch;
import java.util.*;
/**
Given an array of numbers sorted in ascending order, find the range of a given number ‘key’. 
The range of the ‘key’ will be the first and last position of the ‘key’ in the array.

Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].

Example 1:
Input: [4, 6, 6, 6, 9], key = 6
Output: [1, 3]

Example 2:
Input: [1, 3, 8, 10, 15], key = 10
Output: [3, 3]

Input: [1, 3, 8, 10, 15], key = 12
Output: [-1, -1]
 */
class FindRange {
    /**
    Time Complexity : O(Log N)
    Space Complexity : O(1)
     */
  public static int[] findRange(int[] arr, int key) {
    int[] result = new int[] { -1, -1 };
    result[0] = search(arr, key, false);
    if(result[0] != -1){
        result[1] = search(arr, key, true);
    }    
    return result;
  }
  public static int search(int[] arr, int key, boolean findMaxIndex) {
    int start = 0, end = arr.length - 1;
    int keyIndex = -1;
    while(start <= end){
        int mid = start + (end - start)/2;
        if(key < arr[mid]){
            end = mid - 1;
        }else if(key > arr[mid]){
            start = mid + 1;
        }else{
            keyIndex = mid;
            if(findMaxIndex){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
    }
    return keyIndex;
  }

  public static void main(String[] args) {
    int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
  }
}
