package BST;

import BinaryTree.TreeNode;

public class SearchInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static boolean search(TreeNode root, int k) {

		TreeNode p = root;

		while (p != null) {
			if (p.val == k)			return true;
			else if (p.val > k)		p = p.left;
			else					p = p.right;
		}
		return false;
	}
	//TC=O(h) SC=O(1) / if skew TC=O(n)
	// O(log n ) < O(h) < O(n)
	// balance BST < BST < skew

}
