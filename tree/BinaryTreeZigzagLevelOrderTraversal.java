package test.tree;
import java.util.*;


/*Definition for a binary tree node.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/**
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
 */
public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result);         
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for(int i = 0 ; i < size; i++){
                TreeNode curr = queue.poll();
                if(reverse){
                    levelList.add(0, curr.val);
                }else{
                    levelList.add(curr.val);
                }         
                
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }                                
            }
            reverse = !reverse;
            result.add(levelList);
        }
        return result;
    }
}