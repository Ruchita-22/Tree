package height;

import TreeNode.TreeNode;

public class NodeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Count in range
    static int count;
	public int countInRange(TreeNode root, int a, int b) {
		count = 0;
		count(root, a, b);
		return count;
	}

	public int count(TreeNode root, int a, int b) { // preorder
		if (root == null)	return 0;
		if (a <= root.val && root.val <= b) {
			count++;
		}
		count(root.left, a, b);
		count(root.right, a, b);
		return 0;
	}
	
    // Count no of node at distance k from the root
    private static int count(TreeNode root, int k) {
    	if(root == null)	return 0;
    	if(k == 0)	return 1;
    	
    	int leftCount = count(root.left, k-1);
    	int rightCount = count(root.right, k-1);
    	
		return leftCount + rightCount;
    	
    }
}
