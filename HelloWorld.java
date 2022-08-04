package test;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
public class HelloWorld{
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);        
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return preOrderTraverse(root);        
    }

    public static boolean preOrderTraverse(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    
    
}

