package test.binarysearch;

import java.util.*;

/**
Given a sorted array of numbers, find if a given number ‘key’ is present in the array. Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have duplicates.

Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.

Ex 1 : Input: [4, 6, 10], key = 10
Output: 2

Ex 2: Input: [1, 2, 3, 4, 5, 6, 7], key = 5
Output: 4

Ex 3: Input: [10, 6, 4], key = 10
Output: 0

Ex 4 : 
Input: [10, 6, 4], key = 4
Output: 2
 */
/**
Time Complexity : O(Log N)
Space Complexity : O(1)
 */
 class BinarySearch {

  public static int search(int[] arr, int key) {
      boolean asc = arr.length > 0 && arr[0] <= arr[arr.length - 1] ? true : false;
      int low = 0, high = arr.length;
      while(low <= high){
          int mid = low + (high - low) / 2;
          if(key == arr[mid]){
              return mid;
          }else if(key > arr[mid]){
              if(asc){
                  low = mid + 1;
              }else{
                  high = mid - 1;
              }
          }else{              
              if(asc){
                  high = mid - 1;                  
              }else{
                  low = mid + 1;                 
              }
          }
      }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
    System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
  }
}