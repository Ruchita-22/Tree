package BST;

import TreeNode.TreeNode;

public class ValidBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Q1. Valid Binary Search Tree
	private static boolean isBST(TreeNode root, int low, int high) {
		if (root == null) return true;

		if (low <= root.val && root.val <= high) {
			boolean l = isBST(root.left, low, root.val - 1);
			boolean r = isBST(root.right, root.val + 1, high);
			return l && r;
		}
		return false;
	}

}
