package test.linkedlist;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}
/**
Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of the reversed LinkedList.
Head -> 2 -> 4 -> 6 -> 8 -> 10 -> Null

Result :
Head -> 10 -> 8 -> 6 -> 4 -> 2 -> Null

Time Complexity : O(N)
Space Complexity : O(1)
 */
class ReverseLinkedList {

  public static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;
    while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);

    ListNode result = ReverseLinkedList.reverse(head);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}