package test.tree;
import java.util.*;
import java.util.stream.*;

public class PostorderTraversal {
    int index = 0;  
    public static void main(String[] args){        
        Integer[] arr = {1,null,2,3};
        PostorderTraversal obj = new PostorderTraversal();
        TreeNode root = obj.buildTree(arr, 0);

        List<Integer> result = obj.postorderTraversal(root);
        System.out.println(result);

    }
    public TreeNode buildTree(Integer[] arr, int left, int right){
        
    }
    public TreeNode buildTreeOld(Integer[] arr, int i){
        if(i > arr.length - 1) return null;
        if(arr[i] == null) return null;          
        return new TreeNode(arr[i], buildTree(arr, i * 2 + 1), buildTree(arr, i * 2 + 2));
    }
  
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversal(root, new ArrayList<>());
    }

    public List<Integer> postorderTraversal(TreeNode root, List<Integer> result) {        
        if(root != null){
            postorderTraversal(root.left, result);
            postorderTraversal(root.right, result);
            result.add(root.val);
        }
        return result; 
    }

}