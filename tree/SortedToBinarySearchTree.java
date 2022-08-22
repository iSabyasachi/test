package test.tree;
import java.util.*;
/**
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

Time Complexity : O(N)
Space Complexity : O(Log N)
 */
public class SortedToBinarySearchTree{
    public static void main(String[] args){
        SortedToBinarySearchTree obj = new SortedToBinarySearchTree();
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = obj.sortedArrayToBST(nums);
        List<Integer> result = obj.preOrderTraversal(root, new ArrayList<>());
        System.out.println(result);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int left, int right){
        if(left > right) return null;

        int mid = left + (right - left) / 2;

        return new TreeNode(nums[mid], helper(nums, left, mid -1), helper(nums, mid + 1, right));
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