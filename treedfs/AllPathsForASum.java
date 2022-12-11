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

public class AllPathsForASum{
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        AllPathsForASum obj = new AllPathsForASum();
        List<List<Integer>> allPaths = new ArrayList<>();
        //Check if the current node value is equals to the sum and if the node is a leaf node, then add the node to the list
        // Continue searching till you check all nodes in the tree
        //Node : Required Sum in child node
        List<Integer> currentPath = new ArrayList<>();
        findPathRecursively(root, sum, currentPath, allPaths);
        return allPaths;
    }
    public static void findPathRecursively(TreeNode currentNode, int sum, List<Integer> currentPath, List<List<Integer>> allPaths){
        if(currentNode == null) return;

        currentPath.add(currentNode.val);

        if(currentNode.val == sum && currentNode.left == null && currentNode.right == null){
            allPaths.add(new ArrayList<Integer>(currentPath));
        }else{
            //traverse left
            findPathRecursively(currentNode.left, sum - currentNode.val, currentPath, allPaths);

            //traverse right
            findPathRecursively(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }

        
        currentPath.remove(currentPath.size() - 1);
    }

    public static List<List<Integer>> findAllPaths(TreeNode root){
        List<List<Integer>> allPaths = new ArrayList<>();

        List<Integer> currentPath = new ArrayList<>();
        findAllPathsRecursively(root, currentPath, allPaths);
        return allPaths;
    }
    public static void findAllPathsRecursively(TreeNode currentNode, List<Integer> currentPath, List<List<Integer>> allPaths){
        if(currentNode == null) return;

        currentPath.add(currentNode.val);
        if(currentNode.left == null && currentNode.right == null){
            allPaths.add(new ArrayList<Integer>(currentPath));
        }
        //Traverse Left
        findAllPathsRecursively(currentNode.left, currentPath, allPaths);

        //Traverse Right
        findAllPathsRecursively(currentNode.right, currentPath, allPaths);

        currentPath.remove(currentPath.size() - 1);        
    }
    int currPathSum = 0;
    int allPathSum = 0;
    public int maxSum(TreeNode root){        
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        maxSumRecursively(root);

        /*
        int max = 0;
        for(List<Integer> path : allPaths){
            int currSum = path.stream().reduce((x,y) -> x + y).get();
            max = Math.max(currSum, max);
        }*/
        return allPathSum;
    }
    
    public void maxSumRecursively(TreeNode currentNode){
        if(currentNode == null) return;

        currPathSum += currentNode.val;

        if(currentNode.left == null && currentNode.right == null){
            allPathSum = Math.max(allPathSum, currPathSum);
        }

        //Traverse Left
        maxSumRecursively(currentNode.left);

        //Traverse Right
        maxSumRecursively(currentNode.right);

        currPathSum -= currentNode.val;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        //List<List<Integer>> result = AllPathsForASum.findPaths(root, sum);
        //System.out.println("Tree paths with sum " + sum + ": " + result);
        AllPathsForASum obj = new AllPathsForASum();
        List<List<Integer>> result = AllPathsForASum.findAllPaths(root);
        System.out.println("All Tree paths"+ result);
        int maxSum = obj.maxSum(root);
        System.out.println("Max Sum "+ maxSum);
    }
}