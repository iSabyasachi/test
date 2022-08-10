package test.tree;
import java.util.*;
/**
Given two integer arrays preorder and inorder where preorder is the preorder traversal 
of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class ConstructBinaryTree{
    Map<Integer, Integer> inorderIndexMap;
    int preorderIndex;

    public static void main(String[] args){
        //int[] preorder = {3, 9, 1, 2, 20, 15, 7};
        //int[] inorder = {1, 9, 2, 3, 15, 20, 7};

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        ConstructBinaryTree cbt = new ConstructBinaryTree();
        TreeNode root = cbt.buildTree(preorder, inorder);

        System.out.println(cbt.preOrderTraversal(root, new ArrayList<>()));
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {    
        preorderIndex = 0;    

        inorderIndexMap = new HashMap<>();
        /**
        Map : value - Index
         */
        for(int i = 0 ; i < inorder.length ; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        //System.out.println(inorderIndexMap);
        
        return arrayToTree(preorder, 0, preorder.length-1);
    }
    public TreeNode arrayToTree(int[] preorder, int left, int right){
        if(left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        //build left and right subtree
        //exclude inorderIndexMap[rootValue] as it is the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue)-1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue)+1, right);
        
        return root;
    }

    public List<Integer> preOrderTraversal(TreeNode root, List<Integer> result){
        if(root != null){
            result.add(root.val);
            preOrderTraversal(root.left, result);
            preOrderTraversal(root.right, result);
        }

        return result;
    }
}
