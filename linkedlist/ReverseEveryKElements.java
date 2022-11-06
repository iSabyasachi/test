package test.linkedlist;
import java.util.*;
/**
Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}
/**
Time Complexity : O(N)
Space Complexity : O(1)
 */
class ReverseEveryKElements {

  public static ListNode reverse(ListNode head, int k) {
    int p = 1, q = k;
    ListNode curr = head;
    int size = 0;
    while(curr != null){
        size++;
        curr = curr.next;
    }
    
    while(p < size){
        head = reverseSubList(head, p, q);
        p += k;
        q += k;
    }
    return head;
  }

public static ListNode reverseSubList(ListNode head, int p, int q) {
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
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = ReverseEveryKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}