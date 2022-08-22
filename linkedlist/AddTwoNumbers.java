package test.linkedlist;
import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
    ListNode(){        
    }
}

public class AddTwoNumbers{
    public static void main(String[] args){
        AddTwoNumbers obj = new AddTwoNumbers();

        ListNode list1 = new ListNode(2);
        list1.next= new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next= new ListNode(6);
        list2.next.next = new ListNode(4);

        ListNode res = obj.addTwoNumbers(list1, list2);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
           
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            
            if(sum >= 10){
                sum = sum % 10;
                carry = 1;
            }else{                
                carry = 0;
            }             

            curr.next = new ListNode(sum);
            curr = curr.next;
                             
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }     
        return head.next;
    }
}