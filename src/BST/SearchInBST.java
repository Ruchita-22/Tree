package BST;

import TreeNode.TreeNode;

public class SearchInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static boolean search(TreeNode root, int k) {

		TreeNode curr = root;

		while (curr != null) {
			if (curr.val == k)			return true;
			else if (curr.val > k)		curr = curr.left;
			else					curr = curr.right;
		}
		return false;
	}
	//TC=O(h) SC=O(1) / if skew TC=O(n)
	// O(log n ) < O(h) < O(n)
	// balance BST < BST < skew

}
