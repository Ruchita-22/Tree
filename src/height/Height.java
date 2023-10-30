package height;

import BinaryTree.TreeNode;

public class Height {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int height(TreeNode root) {
		if(root == null)	return 0;
		
		int l = height(root.left);
		int r = height(root.right);
		
		return 1+ Math.max(l, r);
	}
	//104. Maximum Depth of Binary Tree
	private static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int l = maxDepth(root.left);
		int r = maxDepth(root.right);

		return Math.max(l, r) + 1;
	}

}
