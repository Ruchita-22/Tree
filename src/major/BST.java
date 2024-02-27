package major;

import TreeNode.TreeNode;

public class BST {
	// Binary Search Tree
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    

    

	///////////////////////////////////////////////////////////////////////////////////
	// Q1. Check for BST with One Child
	public String solve(int[] A) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		TreeNode root = null, node = null;
		
		for (int i = 0; i < A.length; i++) {
			if (root == null) {
				root = new TreeNode(A[i]);
				node = root;
			} else if (A[i] > node.val && A[i] < max && A[i] > min) {// right
				node.right = new TreeNode(A[i]);
				min = node.val;// [min, max] successive nodes should be in this range
				node = node.right;
			} else if (A[i] <= node.val && A[i] > min && A[i] < max) {
				node.left = new TreeNode(A[i]);
				max = node.val;
				node = node.left;
			} else {
				return "NO";
			}
		}
		return "YES";
	}

	// Q2. Largest BST Subtree
	public int solve(TreeNode root) {
		if (root == null) 	return 0;
		
		int l = solve(root.left);
		int r = solve(root.right);
		
		if (isBST(root.left) && isBST(root.right)) {
			if (root.left != null && root.left.val >= root.val)		return Math.max(l,r);
			if (root.right != null && root.right.val <= root.val)	return Math.max(l,r);
			return 1 + l + r;
		}
		
		return Math.max(l,r);
	}

	boolean isBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean isLeftBST = isBST(root.left);
		boolean isrightBST = isBST(root.right);
		
		if (root.right != null && root.val >= root.right.val) 	return false;
		if (root.left != null && root.val <= root.left.val) 	return false;
	
		return isLeftBST && isrightBST;

	}
	/////////////////////////////////BST Basic operation///////////////////////////////////////////////////////////
	


	private static TreeNode min(TreeNode root) {
		TreeNode min = root;
		while (min.left != null)
			min = min.left;
		return min;
	}

	private static TreeNode max(TreeNode root) {
		TreeNode max = root;
		while (max.right != null)
			max = max.right;
		return max;
	}



}
