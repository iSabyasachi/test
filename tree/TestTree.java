package test.tree;
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
public class TestTree{   
    public static boolean hasPath(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.val == sum && root.left == null && root.right == null) return true;

        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val) ;
    }
    public static boolean hasPathOld(TreeNode root, int sum) {
        //Node Val : parent node
        Map<Integer, Integer> table = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        table.put(root.val, 0);
        while(!stack.isEmpty()){
            TreeNode currNode = stack.pop();
            int currSum = currNode.val + table.get(currNode.val);
            if(currSum == sum) return true;

            if(currNode.left != null){
                stack.push(currNode.left);
                table.put(currNode.left.val, currSum);
            }
            if(currNode.right != null){
                stack.push(currNode.right);
                table.put(currNode.right.val, currSum);
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
    boolean result = TestTree.hasPath(root, 10);
    System.out.println("Level order traversal: " + result);
  }
}