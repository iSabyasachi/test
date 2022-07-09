package test.treedfs;

import java.util.*;

/**
Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such 
that the sum of all the node values of that path equals ‘S’.

Time Complexity : O(N) ,where N is the total number of nodes.
Space Complexity : O(N)

 */

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class TreePathSum {
  public static boolean hasPathOpt(TreeNode root, int sum) {
    if(root == null){
        return false;
    }
    if(sum == root.val && root.left == null && root.right == null){
        return true;
    }

    return hasPath(root.left , sum - root.val) || hasPath(root.right , sum - root.val);

  }

public static boolean hasPath(TreeNode root, int sum) {
    if(root == null){
        return false;
    }
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while(!stack.isEmpty()){
        TreeNode curr = stack.pop();
        sum -= curr.val;
        if(sum == curr.val && curr.left == null && curr.right == null){
            return true;
        }else if(sum != curr.val && curr.left == null && curr.right == null){
            sum +=curr.val;
        }else{            
            if(curr.left != null){
                stack.push(curr.left);            
            }
            if(curr.right != null){
                stack.push(curr.right);           
            }
        }        
    }
    return false;
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
  }
}