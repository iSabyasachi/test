package test.tree;
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    public TreeNode(int val){
        this.val = val;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
        TreeNode current = nextLevelRoot;
        nextLevelRoot = null;
        while (current != null) {
            System.out.print(current.val + " ");
            if (nextLevelRoot == null) {
            if (current.left != null)
                nextLevelRoot = current.left;
            else if (current.right != null)
                nextLevelRoot = current.right;
            }
            current = current.next;
        }
        System.out.println();
        }
    }
}
public class ConnectLevelOrderSiblings{
    public static void connect(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode prevNode = null;            
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode currNode = queue.poll();                
                if(prevNode != null)
                    prevNode.next = currNode;
                prevNode = currNode;
                
                if(currNode.left != null)
                    queue.offer(currNode.left);
                if(currNode.right != null)
                    queue.offer(currNode.right);
            }

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}