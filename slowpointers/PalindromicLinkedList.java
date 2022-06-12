package test.slowpointers;
import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class PalindromicLinkedList {
  /**
  Time Complexity : O(N)
  Space Complexity : O(1)
  
   */
  public static boolean isPalindrome(ListNode head) {
    
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode secondHalfReverse = reverse(slow);
    ListNode copyOfSecondHalfReverse = secondHalfReverse;

    while(head != null && secondHalfReverse != null){
      if(head.value != secondHalfReverse.value){
        break;
      }
      head = head.next;
      secondHalfReverse = secondHalfReverse.next;
    }
    reverse(copyOfSecondHalfReverse);
    if(head == null || secondHalfReverse == null){
      return true;
    }
    return false;
  }

  public static ListNode reverse(ListNode head){
    ListNode prev = null;

    while(head != null){
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
  public static void print(ListNode head){
    while(head != null){
      System.out.print(head.value+" ");
      head = head.next;
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    print(head);
    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    print(head);
  }
}