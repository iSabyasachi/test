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
Space Complexity : O(1)
 */
class StartOfLinkedListCycle {
    public static ListNode findCycleStart(ListNode head) {
        int lengthOfCycle = findLengthOfCycle(head);
        System.out.println("lengthOfCycle "+lengthOfCycle);
        
        if(lengthOfCycle > 0){
            ListNode slow = head;
            ListNode fast = head;
            while(lengthOfCycle > 0){
                fast = fast.next;
                lengthOfCycle--;
            }

            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return head;
    }
    public static int findLengthOfCycle(ListNode head){
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
        int count = 0;
        do{
            curr = curr.next;
            count++;
        }while(curr != slow);
        return count;
    }
  public static ListNode findCycleStartOld(ListNode head) {
        
        ListNode curr = head;

        Set<Integer> valSet = new HashSet<>();
        while(curr != null & curr.next != null){
            if(valSet.contains(curr.value)){
                return curr;
            }
            valSet.add(curr.value);
            curr = curr.next;
        }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start: " + StartOfLinkedListCycle.findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start: " + StartOfLinkedListCycle.findCycleStart(head).value);

    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start: " + StartOfLinkedListCycle.findCycleStart(head).value);
  }
}