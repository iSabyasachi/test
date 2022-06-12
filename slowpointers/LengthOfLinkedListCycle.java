package test.slowpointers;
import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}
class LengthOfLinkedListCycle {
/**
Time Complexity : O(N)
Space Complexity : O(1)
 */
  public static int lengthOfCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;    
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;       
        if(slow == fast){
            return countLength(slow);
        }
    }
    return 0;
  }

  public static int countLength(ListNode slow){
        ListNode curr = slow;
        int countLength = 0;
        do{
            curr = curr.next;
            countLength++;
        }while(curr != slow);
        return countLength;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);    
    
    head.next.next.next.next.next.next = head.next.next;
    System.out.println("Length of LinkedList cycle: " + LengthOfLinkedListCycle.lengthOfCycle(head));

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("Length of LinkedList cycle: " + LengthOfLinkedListCycle.lengthOfCycle(head));
  }
}