package test.sort;
import java.util.*;
/**
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside 
the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

public class MergeSortedArray{
    public static void main(String[] args){
        MergeSortedArray obj = new MergeSortedArray();
        //int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        //int[] nums1 = {4,5,6,0,0,0}, nums2 = {1,2,3};
        //int m = 3, n = 3;
        int[] nums1 = {0}, nums2 = {1};
        int m = 0, n = 1;
        obj.mergeOptimized(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void mergeOptimized(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(j >= 0){
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--]; 
            }else{
                nums1[k--] = nums2[j--]; 
            }
        }
    }

    
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length == 0) return;
        mergeSort(arr, 0, arr.length - 1);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length != m + n) return;
        int p = 0;
        while(m < nums1.length){
            nums1[m++] = nums2[p++];            
        }
        mergeSort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
    public static void mergeSort(int[] arr, int start, int end){        
        if(start < end){
            int mid = start + (end - start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            mergeArray(arr, start, end, mid);
        }
    }
    public static void mergeArray(int[] arr, int start, int end, int mid){
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }        

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= end){
            temp[k++] = arr[j++];
        }

        i = start;
        while(i <= end){
            arr[i] = temp[i - start];
            i++;
        }        
    }
    public void mergeOld(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        while(i < m){
            minHeap.add(nums1[i++]);            
        }
        int j = 0;
        while(j < n){
            minHeap.add(nums2[j++]);            
        }

        int k = 0;
        while(k < nums1.length){
            nums1[k++] = minHeap.poll();            
        }        
    }
}