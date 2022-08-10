package test.tree;
import java.util.*;



public class BinaryTreeInorderTraversal{
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = inorderTraversal(root);
        System.out.println(result); 
        //root = [1,null,2,3]
        //output : 1, 3 ,2
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
    public static void inorderTraversal(TreeNode curr, List<Integer> result) {
        if(curr != null){
            inorderTraversal(curr.left, result);
            result.add(curr.val);
            inorderTraversal(curr.right, result);
        }
    }
    public static List<Integer> inorderTraversalOld(TreeNode root) {
        //InorderTraversal
        // store the root val in result , then traverse to left, then travrese to right of the root,
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();       
        TreeNode curr = root;        
        while(curr != null || !stack.isEmpty()){                  
            while(curr != null){                
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
    
}

