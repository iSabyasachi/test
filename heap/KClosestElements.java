package test.heap;

import java.util.*;

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
    List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
    System.out.println("'K' closest numbers to 'X' are: " + result);
    
    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
    System.out.println("'K' closest numbers to 'X' are: " + result);
  }
}