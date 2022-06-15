package test.linkedlist;
import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}
/**
Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.

Time Complexity : O(N)
Space Complexity : O(1)

 */
class ReverseSubList {
    //1 -> 2 -> (3) -> 4 -> (5) -> 6
    //Result : 1 -> 2 -> 5 -> 4 -> 3 ->6
  public static ListNode reverse(ListNode head, int p, int q) {
    if(p == q){
        return head;
    } 
    ListNode lastNodeOfFirstPart;
    ListNode firstNodeOfSubList;
    ListNode prev = null;
    ListNode curr = head;
    for(int i = 0 ; curr != null && i < p - 1  ; i++){
        prev = curr;
        curr = curr.next;
    }
    lastNodeOfFirstPart = prev;
    firstNodeOfSubList = curr;

    ListNode next = null;
    for(int i = 0 ; curr != null && i < q - p + 1; i++){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    if(lastNodeOfFirstPart != null){
        lastNodeOfFirstPart.next = prev;
    }else{
        head = prev;
    }
    
    firstNodeOfSubList.next = curr;
    return head;
  }
  

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    //head.next.next.next.next.next = new ListNode(6);

    ListNode result = ReverseSubList.reverse(head, 2, 4);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}