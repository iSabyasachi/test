package test.slowpointers;
import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}
/**
Time Complexity : O(N)
Space Complexity ; O(1)
 */
class LinkedListCycle {

  public static boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast){
        return true;
      }
    }

    return false;
  }

  public static boolean hasCycleOld(ListNode head) {
    
    Set<Integer> dataSet = new HashSet<>();
    ListNode currNode = head;
    while(currNode.next != null){
      if(dataSet.contains(currNode.next.value)){
        return true;       
      }else{
        dataSet.add(currNode.next.value);
      }
      currNode = currNode.next;
    }
    return false;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
  }
}