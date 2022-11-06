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
    public static boolean hasPath(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.val == sum) return true;

        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }
    public static boolean hasPathOld(TreeNode root, int sum) {
        // I will check if the node value is equals to any of the child node, if it is a leaf node, then success
        //Otherwise, update the sum by substracting the curr value from sum and keep validating the step 1 in the child nodes
        Map<TreeNode, Integer> table = new HashMap<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); 
        table.put(root, 10);

        while(!stack.isEmpty()){
            TreeNode currNode = stack.pop();
            if(currNode.val == table.get(currNode) && currNode.left == null && currNode.right == null) return true;

            if(currNode.left != null){
                stack.push(currNode.left);
                table.put(currNode.left, sum - currNode.val);
            }

            if(currNode.right != null){
                stack.push(currNode.right);
                table.put(currNode.right, sum - currNode.val);
            }
        }

        return false;
    }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 10));
   
  }
}