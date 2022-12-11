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

class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        return findPathRec(root, sequence, 0);
    }

    public static boolean findPathRec(TreeNode currNode, int[] sequence, int sequenceNum) {
        if(currNode == null) return false;

        if(sequenceNum > sequence.length - 1 || sequence[sequenceNum] != currNode.val) return false;

        if(currNode.left == null && currNode.right == null && sequenceNum == sequence.length - 1 && sequence[sequenceNum] == currNode.val) return true;

        return findPathRec(currNode.left, sequence, sequenceNum + 1) || findPathRec(currNode.right, sequence, sequenceNum + 1);
    }

    /*
  public static boolean findPath(TreeNode root, int[] sequence) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();

    findAllPaths(root, currentPath, allPaths);

    boolean finalSeqCheck = false;
    for(List<Integer> path : allPaths){
        boolean seqFound = true;
        if(path.size() != sequence.length){
            seqFound = false;
        }else{
            int i = 0;        
            while(i < sequence.length){
                if(sequence[i] != path.get(i)){
                    seqFound = false;
                }
                i++;
            }
        }        
        if(seqFound) 
            finalSeqCheck = true;
    }
    return finalSeqCheck;
  }

  public static void findAllPaths(TreeNode currentNode, List<Integer> currentPath, List<List<Integer>> allPaths) {
    if(currentNode == null) return;

    currentPath.add(currentNode.val);

    if(currentNode.left == null || currentNode.right == null){
        allPaths.add(new ArrayList<Integer>(currentPath));
    }

    findAllPaths(currentNode.left, currentPath, allPaths);

    findAllPaths(currentNode.right, currentPath, allPaths);

    currentPath.remove(currentPath.size() - 1);
  }
  */
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}