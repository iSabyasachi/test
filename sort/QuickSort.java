package test.sort;

import java.util.*;

public class QuickSort{
    
    public static void main(String[] args){
        int[] arr = new int[]{10, 16, 8, 12, 15, 6, 3, 9 , 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int low, int high){        
        if(low < high){
            int partition = findPartition(arr, low , high);
            //System.out.println(partition);
            //System.out.println("Arrays : "+Arrays.toString(arr));
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }  
    }
    public static int findPartition(int[] arr, int low, int high){
        int pivot = arr[low];

        int i = low, j = high;
        while(i < j){
            while(arr[i] <= pivot)
                i++;
            
            while(arr[j] > pivot)
                j--;
            
            if(i < j)
                swap(arr, i , j);                
            
        }
        swap(arr, low , j);
        return j;
    }
    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}