package test;
import java.util.*;
class Node{
  int data;
  Node next;
  public Node(int data){
    this.data = data;
  }
}
public class HelloWorld{
  public static void main(String[] args){  
    //0, 0, 1, 1, 1, 2, 2
    int[] arr = new int[]{1,0,2,1,0,1,2};
    int low = 0, high = arr.length - 1;
    for(int i = 0 ; i <= high ;){
      if(arr[i] == 0) swap(arr, i++ , low++);
      else if(arr[i] == 2) swap(arr, high--, i);
      else if(arr[i] == 1) i++;
    }
    System.out.println(Arrays.toString(arr));
  }
  public static void swap(int[] arr, int i , int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}

