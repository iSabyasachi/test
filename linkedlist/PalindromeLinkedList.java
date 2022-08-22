package test.linkedlist;
import java.util.*;
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}
public class PalindromeLinkedList{
    public static int size(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        PalindromeLinkedList obj = new PalindromeLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        
        boolean result = obj.isPalindrome(head);
        System.out.println(result);
        /*
        ListNode result = PalindromeLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }*/
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            list.add(curr.value);
            curr = curr.next;
        }        
        int low = 0, high = list.size()-1;
        while(low <= high){
            if(list.get(low++) != list.get(high--))
                return false;                      
        }
        return true;
    }
    public void print(ListNode curr){
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println("");
    }
    public boolean isPalindromeOld(ListNode head) {
        if(head == null) return true;        
        ListNode firstHalfEnd = findMiddleNode(head);
        ListNode secondHalfStart = reverse(firstHalfEnd.next);
        
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while(result && p1 != null && p2 != null){
            if(p1.value != p2.value){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverse(secondHalfStart);       
        return result;
    }
    public ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}


  