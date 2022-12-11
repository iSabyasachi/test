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

class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        List<Integer> currentNode = new ArrayList<>();
        return countPathsRec(root, S, currentNode);
    }

    public static int countPathsRec(TreeNode currNode, int S, List<Integer> currentPath) {
        if(currNode == null) return 0;

        currentPath.add(currNode.val);
        int countPath = 0, sum = 0;
        ListIterator<Integer> iter = currentPath.listIterator(currentPath.size());
        while(iter.hasPrevious()){
            sum += iter.previous();
            if(sum == S)
                countPath++;
        }
        //Traverse Left
        countPath += countPathsRec(currNode.left, S, currentPath);

        //Traverse Right
        countPath += countPathsRec(currNode.right, S, currentPath);

        currentPath.remove(currentPath.size() - 1);
        
        return countPath;
    }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 23));
  }
}