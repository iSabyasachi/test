package test.tree;
import java.util.*;


/*Definition for a binary tree node.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumDepthofBinaryTree{
    public static void main(String[] args){
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);       
        root.right.right = new TreeNode(5);

        int result = maxDepth(root);
        System.out.println(result);
        
    }
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<Integer> depths = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        int depth = 0, currDepth = 0;
        stack.push(root);
        depths.add(1);     
        while(!stack.isEmpty()){            
            TreeNode curr = stack.pop();                    
            currDepth = depths.pollLast();
            if(curr != null){ 
                depth = Math.max(depth, currDepth);
                
                stack.push(curr.left);
                stack.push(curr.right);

                depths.add(currDepth + 1);
                depths.add(currDepth + 1);
            }            
        }        
        return depth;
    }
    
}

