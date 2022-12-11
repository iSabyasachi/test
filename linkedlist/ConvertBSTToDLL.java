
package test.linkedlist;
import java.util.*;
/**
Convert a given Binary Tree to Doubly Linked List
 */

/* Structure for tree and Linked List */
class Node {
    int data;
    Node left, right;
 
    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class ConvertBSTToDLL{
  Node prev;
  Node head;
  public void buildBST(Node root){    
    inOrderTraversal(root);
    print(head);
  }
  public void inOrderTraversal(Node curr){
    if(curr == null) return;
    inOrderTraversal(curr.left);   
    if(head == null){
      head = curr;
    }else{
      prev.right = curr;
      curr.left = prev;
    }
    prev = curr;    
    inOrderTraversal(curr.right);
  }
  public void print(Node head){
    Node curr = head;
    while(curr != null){
      System.out.print(curr.data+" ");
      curr = curr.right;
    }
  }
  public static void main(String[] args){    
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.right = new Node(4);
        root.left.left = new Node(1);
        root.right.right = new Node(8);
        root.left.left.right = new Node(2);
        root.left.left.left = new Node(0);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(9);
        ConvertBSTToDLL obj = new ConvertBSTToDLL();
        obj.buildBST(root);
  }
}

