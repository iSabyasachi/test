package test.heap;

import java.util.*;
import java.util.stream.*;

class Entry {
  int key;
  int value;

  public Entry(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
/*
Time Complexity : O(K Log K)
Space Complexity  O(K)
 */
class KClosestElements {
  /**Using Binary Search and two pointer */
  public static List<Integer> findClosestElementsBS(int[] arr, int K, Integer X) {
    List<Integer> result = new ArrayList<>();    

    int index = Arrays.binarySearch(arr, X);    
    if(index < 0){
      int size = arr.length;
      arr = X > arr[size - 1] 
      ? Arrays.copyOfRange(arr, size - K, size) 
      : Arrays.copyOfRange(arr, 0, K);
      //result = Arrays.asList(arr);
      Integer[] arrs = IntStream.of(arr).boxed().toArray(Integer[]::new);
      Collections.addAll(result, arrs);        
    }else{
      int low = index - 1, high = index + 1;
      result.add(arr[index]);
      while(result.size() < K && low >= 0 && high <= arr.length - 1){
        int lowDiff = Math.abs(arr[index] - arr[low]);
        int highDiff = Math.abs(arr[high] - arr[index]);
        if(lowDiff < highDiff){
          result.add(arr[low]);
          low--;
        }else{
          result.add(arr[high]);
          high++;
        }
      }
    }    
    Collections.sort(result);
    return result; 
  }
  public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
    List<Integer> result = new ArrayList<>();    
    PriorityQueue<Entry> maxHeap = new PriorityQueue<Entry>((e1, e2) -> e2.value - e1.value);
    // TODO: Write your code here
    
    for(int i = 0 ; i < arr.length ; i++){
        maxHeap.add(new Entry(arr[i],Math.abs(X - arr[i])));
        if(i > K - 1){
            maxHeap.poll();
        }
    }
    while(!maxHeap.isEmpty()){
        result.add(maxHeap.poll().key);
    }  
    Collections.sort(result);
    return result;
  }

  public static void main(String[] args) {
     /*List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
    System.out.println("'K' closest numbers to 'X' are: " + result);
   
    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
    System.out.println("'K' closest numbers to 'X' are: " + result);*/

    List<Integer> result = KClosestElements.findClosestElementsBS(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
    System.out.println("'K' closest numbers to 'X' are: " + result);
   
    result = KClosestElements.findClosestElementsBS(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = KClosestElements.findClosestElementsBS(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
    System.out.println("'K' closest numbers to 'X' are: " + result);
  }
}