package test.tree;
import java.util.*;

public class SmallestElementInBST{
    public static void main(String[] args){
        SmallestElementInBST obj = new SmallestElementInBST();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);        
        int result = obj.kthSmallest(root, 2);
        System.out.println(result); 
        
    }
    public int kthSmallest(TreeNode root, int k) {
        int position = 0;
        TreeNode node = kthSmallestRec(root, k , position);
        return node.val;
    }
    public TreeNode kthSmallestRec(TreeNode node, int k, int position) {
        if(node == null) return node;

        TreeNode left = kthSmallestRec(node.left, k , position);
        if(left != null){
            return left;
        }
        position++;
        if(position == k){
            return node;
        }
        return kthSmallestRec(node.right, k , position);
    }
    public int kthSmallest2(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        inOrderTraversal(root, maxHeap, k);           
        return maxHeap.peek();
    }
    public void inOrderTraversal(TreeNode root, PriorityQueue<Integer> result, int k){
        if(result.size() > k) {
        	result.poll();
        }

        if(root != null){
            inOrderTraversal(root.left, result, k);            
            result.add(root.val);                        
            inOrderTraversal(root.right, result, k);
        }
        
        return;
    }
    /*
    public int kthSmallestOld(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        maxHeap = inOrderTraversalOld(root, maxHeap);
        
        int i = 1;
        while(i < k){
            maxHeap.poll();
            i++;
        }
        return maxHeap.peek();
    }
    public PriorityQueue<Integer> inOrderTraversalOld(TreeNode root, PriorityQueue<Integer> result){
        if(root != null){
            inOrderTraversalOld(root.left, result);
            result.add(root.val);
            inOrderTraversalOld(root.right, result);
        }
        return result;        
    }
    */
}