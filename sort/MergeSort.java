package test.sort;

import java.util.*;

public class MergeSort{
    public static void main(String[] args){
        int[] arr = new int[]{5,2,1,6,4,7,3,8,9,10};        
        mergeSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start < end){            
            int mid = start + (end - start) / 2;            
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);   
            merge(arr, start, end, mid);         
        }  
    }

    public static void merge(int[] arr, int start, int end, int mid){
        
        int[] tempArr = new int[end - start + 1];
        int i = start, j = mid+1, k = 0;       
        while(i <= mid && j <= end){
            if(arr[i] < arr[j]){
                tempArr[k++] = arr[i++];
            }else{
                tempArr[k++] = arr[j++];
            }
        }
        while(i <= mid){
            tempArr[k++] = arr[i++]; 
        }
        while(j <= end){
            tempArr[k++] = arr[j++]; 
        }

        for(k = start ; k <= end ; k++){
            arr[k] = tempArr[k - start];
        }        
    }
}