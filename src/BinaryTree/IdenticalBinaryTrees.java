package BinaryTree;

public class IdenticalBinaryTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Q1. Identical Binary Trees
	public int isSameTree(TreeNode A, TreeNode B) {
		if (solve(A, B))
			return 1;
		else
			return 0;

	}

	private static boolean solve(TreeNode A, TreeNode B) {
		if (A == null && B == null)		return true;
		if (A == null || B == null)		return false;
		if (A.val != B.val)				return false;
		return solve(A.left, B.left) && solve(A.right, B.right);

	}
	///////////////////////////////////////////////////////////////
	public int isSymmetric(TreeNode A) {
		if (isMirror(A.left, A.right))
			return 1;
		else
			return 0;

	}

	private static boolean isMirror(TreeNode A, TreeNode B) {
		if (A == null && B == null)		return true;
		if (A == null || B == null)		return false;
		if (A.val != B.val)				return false;
		return isMirror(A.left, B.right) && isMirror(A.right, B.left);
	}
	///////////////////////////////////////
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

}
