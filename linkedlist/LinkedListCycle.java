package test.linkedlist;
import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        next = null;
    }
}
public class LinkedListCycle{
    public static void main(String[] args){
        LinkedListCycle obj = new LinkedListCycle();

        /*ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;*/
        ListNode head = new ListNode(1);
        System.out.println(obj.hasCycle(head));
    }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){            
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return true;
        }
        return false;
    }
    public boolean hasCycleOld(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;
        do{
            if(fast == null || fast.next == null || slow == null)
                return false;
            
            fast = fast.next.next;
            slow = slow.next;
        }while(fast != slow);

        return fast == slow;
    }
}