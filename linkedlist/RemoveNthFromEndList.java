package test.linkedlist;
import java.util.*;
/**
Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list.

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
public class RemoveNthFromEndList{
    public static void main(String[] args) {
        /*ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);*/
        ListNode node = new ListNode(1);
        node = removeNthFromEnd(node, 1);

        while(node != null){
            System.out.print("-> "+node.val);
            node = node.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {       
        int length = 0;
        ListNode curr = head;
        while(curr != null){
            length++;
            curr = curr.next;
        }           
        int i = 1;
        curr = head;
        while(i < (length - n)){
            curr = curr.next;
            i++;
        }
        
        if(length - n == 0){            
            head = head.next;            
        }else{
            curr.next = curr.next.next;
        }        
        return head;
    }
}

