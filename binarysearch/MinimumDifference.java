package test.binarysearch;

import java.util.*;

/**
Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.
 */

class MinimumDifference {
    /**
    Time Complexity : O(Log N)
    Space Complexity : O(1)
     */
  public static int searchMinDiffElement(int[] arr, int key) {
      if(key < arr[0]){
          return arr[0];
      }else if(key > arr[arr.length - 1]){
          return arr[arr.length - 1];
      }
      int start = 0, end = arr.length - 1;
      while(start <= end){
          int mid = start + (end - start)/2;
          /*if(mid < arr.length - 1 && key > arr[mid] && key < arr[mid+1]){
              if(Math.min(arr[mid] - key, arr[mid+1] - key) == (arr[mid] - key)){
                  return arr[mid];
              }else{
                  return arr[mid+1];
              }
          }else */
          if(key > arr[mid]){
              start = mid + 1;
          }else if(key < arr[mid]){
              end = mid - 1;
          }else{
              return arr[mid];
          }
      }
      if((arr[start] - key) < key - arr[end]){
          return arr[start];
      }else{
          return arr[end];
      }
  }

  public static void main(String[] args) {
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
  }
}