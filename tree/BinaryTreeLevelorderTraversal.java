package test.tree;
import java.util.*;
public class BinaryTreeLevelorderTraversal{
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = levelOrder(root);
        System.out.println(result); 
        
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);        
        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int levelSize = queue.size();            
            for(int i = 0 ; i < levelSize ; i++){
                TreeNode curr = queue.poll();                
                levelList.add(curr.val);

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }
    
    
}

