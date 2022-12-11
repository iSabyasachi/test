package test.treedfs;

import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

public class SumOfPathNumbers{
    
    public int findSumOfPathNumbers(TreeNode root) {
        int pathSum = 0;
        pathSum = findSumOfPathNumbersRec(root, pathSum);        
        return pathSum;
    }

    public int findSumOfPathNumbersRec(TreeNode currNode, int pathSum) {
        if(currNode == null) return 0;

        pathSum = pathSum * 10 + currNode.val;

        if(currNode.left == null && currNode.right == null){
            return pathSum;
        }
        
        return findSumOfPathNumbersRec(currNode.left, pathSum) +
                    findSumOfPathNumbersRec(currNode.right, pathSum);
    }
    
    /*
    int currPathSum = 0;
    int totalSum = 0;
    public int findSumOfPathNumbers(TreeNode root) {

        findSumOfPathNumbersRec(root);
        
        return totalSum;
    }

    public void findSumOfPathNumbersRec(TreeNode currNode) {
        if(currNode == null) return;

        currPathSum = currPathSum * 10 + currNode.val;

        if(currNode.left == null && currNode.right == null){
            totalSum += currPathSum;
        }
        //Traverse Left
        findSumOfPathNumbersRec(currNode.left);

        //Traverse Right
        findSumOfPathNumbersRec(currNode.right);

        currPathSum = (currPathSum - currNode.val) / 10;
    }*/
    /*
    public static int findSumOfPathNumbers(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();

        findSumOfPathNumbersRec(root, currPath, allPaths);
        int sum = 0;
        for(List<Integer> path : allPaths){
            sum += path.stream().reduce((x,y) -> x * 10 + y).get();
        }
        return sum;
    }

    public static void findSumOfPathNumbersRec(TreeNode currNode, List<Integer> currPath, List<List<Integer>> allPaths) {
        if(currNode == null) return;

        currPath.add(currNode.val);

        if(currNode.left == null && currNode.right == null){
            allPaths.add(new ArrayList<Integer>(currPath));
        }
        //Traverse Left
        findSumOfPathNumbersRec(currNode.left, currPath, allPaths);

        //Traverse Right
        findSumOfPathNumbersRec(currNode.right, currPath, allPaths);

        currPath.remove(currPath.size() - 1);
    }
    */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        SumOfPathNumbers obj = new SumOfPathNumbers();
        System.out.println("Total Sum of Path Numbers: " + obj.findSumOfPathNumbers(root));
    }
}