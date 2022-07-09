package test.treebfs;

import java.util.*;
/**
Time Complexity : O(N)
Space Complexity : O(1)
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class ReverseLevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    //Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        List<Integer> levelList = new ArrayList<>();
        int levelSize = queue.size();        
        for(int i = 0 ; i < levelSize ; i++){            
            TreeNode currNode = queue.poll();
            levelList.add(currNode.val);  

            if(currNode.left != null){
                queue.add(currNode.left);
            } 
            if(currNode.right != null){
                queue.add(currNode.right);
            }         
        }
        result.add(0, levelList);        
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
    System.out.println("Reverse level order traversal: " + result);
  }
}