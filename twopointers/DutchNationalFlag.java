package test.twopointers;

import java.util.*;
import java.util.stream.IntStream;
public class DutchNationalFlag{
    /**
    Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
    Example 1:
    Input: [1, 0, 2, 1, 0]
    Output: [0, 0, 1, 1, 2]

    Example 2:
    Input: [2, 2, 0, 1, 2, 0]
    Output: [0, 0, 1, 2, 2, 2,]    
     */
    public static void main(String[] args){
        System.out.println("Hello DutchNationalFlag!!!");
        //int[] arr = new int[]{1, 0, 2, 1, 0};
        int[] arr = new int[]{2, 2, 0, 1, 2, 0};
        sortOpt(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public static void sortOpt(int[] arr) {
        int low = 0, high = arr.length - 1;
        for(int i = 0 ; i <= high;){
            if(arr[i] == 0){
                swap(arr, i, low);
                i++;
                low++;
            }else if(arr[i] == 1){
                i++;
            }else{
                swap(arr, i, high);
                high--;
            }
        } 
    }
    /**
    Time Complexity : O(N^2) 
    Space Complexity : O(1)
     */
    public static void sort(int[] arr) {
        //Create two pointer left and right
        //Left points to 0th position and right points to left + 1 position
        //iterate right pointer till it finds number less than the number left pointer points, if found , swap two elements
        // if not present , incement left pointer and continue the iteration

        int left = 0;
        for(int right = left + 1 ; right < arr.length ; right++){
            int i = right;
            while(i < arr.length){
                if(arr[i] < arr[left]){
                    swap(arr, left, i);
                }
                i++;
            }
            left++;
        }
     }

     public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
     }

}