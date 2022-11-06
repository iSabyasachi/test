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
  public static boolean isCycle(Node head){
    // 1 -> 2 -> 3 -> 4 -> 5 -> 2
    Node fast = head;
    Node slow = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) return true;
    }
    return false;
  }
  public static int cycleLength(Node head){
    int length = 0;
    Node fast = head;
    Node slow = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) return calculateLength(slow);
    }
    return 0;
  }
  public static int calculateLength(Node slow){
    int length = 0;
    Node curr = slow;
    while(curr != null){
      length++;
      curr = curr.next;
      if(curr == slow) break;
    }
    return length;
  }
  public static Node cycleFirstNode(Node head){
    int cycleLength = cycleLength(head);
    if(cycleLength == 0) return null;

    Node first = head;
    Node second = head;
    System.out.println("Length "+cycleLength);
    while(cycleLength > 0){
      second = second.next;
      cycleLength--;
    }
    while(first != null && second != null){
      if(first == second) return first;
      first = first.next;
      second = second.next;
    }
    return null;
  }
  public static Node cycleLastNode(Node head){
    int cycleLength = cycleLength(head);
    if(cycleLength == 0) return null;

    Node first = head;
    Node second = head;
    while(cycleLength > 0){
      second = second.next;
      cycleLength--;
    }
    while(first.next != second.next){
      first = first.next;
      second = second.next;
    }
    return second;
  }
  public static void removeLoop(Node head){
    Node lastNode = cycleLastNode(head);
    if(lastNode != null) lastNode.next = null;
  }

  public static void main(String[] args){  
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = head.next;

    //System.out.println("Is Cycle "+isCycle(head));
    //System.out.println("Cycle Length"+cycleLength(head));
   // System.out.println("First Node of the cycle "+cycleFirstNode(head) != null ? cycleFirstNode(head).data : null);
    //System.out.println("Last Node of the cycle "+cycleLastNode(head).data);
    removeLoop(head);
    System.out.println("Is Cycle "+isCycle(head));
  }
}

