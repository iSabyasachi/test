package test.tree;
import java.util.Objects;
/*Definition for a binary tree node.*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

	static int size;

    TreeNode() {}
    TreeNode(int val) { 
        this(val, null, null);
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
		size++;
    }
    @Override
	public int hashCode() {
		return Objects.hash(left, right, val);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		return Objects.equals(left, other.left) && Objects.equals(right, other.right) && val == other.val;
	}
    
}