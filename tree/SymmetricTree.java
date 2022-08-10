package test.tree;
import java.util.*;
import java.util.stream.*;

public class SymmetricTree {    
    public static void main(String[] args){
        SymmetricTree obj = new SymmetricTree();        

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = null;
        root.left.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(3);

        System.out.println(obj.isSymmetric(root));
        
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N), as recursive call on stack will be O(N).
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root , root);
    }

    public boolean isMirror(TreeNode t1 , TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return (t1.val == t2.val 
                && isMirror(t1.left, t2.right) 
                && isMirror(t1.right, t2.left));
    }
    
}