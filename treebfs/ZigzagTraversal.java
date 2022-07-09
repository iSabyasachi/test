package test.treebfs;
import java.util.*;

/**
Given a binary tree, populate an array to represent its zigzag level order traversal. 
You should populate the values of all nodes of the first level from left to right, 
then right to left for the next level and keep alternating in the same manner for the following levels.

Time Complexity : O(N)
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

class ZigzagTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean leftToRight = true;
    while(!queue.isEmpty()){
        int levelSize = queue.size();
        List<Integer> levelList = new LinkedList<>();        
        for(int i = 0; i < levelSize ; i++){
            TreeNode currNode = queue.poll();

            if(leftToRight){
                levelList.add(currNode.val);
            }else{
                levelList.add(0,currNode.val);
            }            

            if(currNode.left != null){
                queue.add(currNode.left);
            }
            if(currNode.right != null){
                queue.add(currNode.right);
            }
        }
        result.add(levelList);
        leftToRight = !leftToRight;
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
    root.right.left.left = new TreeNode(20);
    root.right.left.right = new TreeNode(17);
    List<List<Integer>> result = ZigzagTraversal.traverse(root);
    System.out.println("Zigzag traversal: " + result);
  }
}