package test.tree;
import java.util.*;

public class ValidateBinaryTree {
    int index = 0;

    Integer prevValue = null;
    public static void main(String[] args){       
        ValidateBinaryTree cbt = new ValidateBinaryTree();
        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);*/
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        //System.out.println(root.size);
        //System.out.println(cbt.isValidBST(root));
        System.out.println(cbt.isValidBSTMax(root, null, null));
    }
    public void copyBST(TreeNode root, int[] array){
        if(root == null) return;
        copyBST(root.left, array);
        array[index++] = root.val;
        copyBST(root.right, array);
    }
    public boolean isValidBSTMax(TreeNode n, Integer min, Integer max) {
        if(n == null) return true;

        if((min != null && n.val <= min) || (max != null &&  n.val > max)) return false;

        return isValidBSTMax(n.left, min, n.val) && isValidBSTMax(n.right, n.val, max);        
    }
    public boolean isValidBST(TreeNode n) {
        if(n == null) return true;

        if(!isValidBST(n.left)) return false;

        if(prevValue != null && prevValue >= n.val){
            return false;
        }
        prevValue = n.val;

        if(!isValidBST(n.right)) return false;

        return true;
    }
    public boolean isValidBSTTemp(TreeNode root) {
        int[] array = new int[root.size];

        copyBST(root, array);
        //System.out.println(Arrays.toString(array));
        
        for(int i = 1 ; i < array.length ; i++){
            if(array[i] <= array[i - 1]) return false;
        }
        return true;
    }
}