package BST;

import TreeNode.TreeNode;

public class RecoverBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//99. Recover Binary Search Tree
	public void recoverTree(TreeNode root) {
		prev = null;
		first = null;
		second = null;
		
		findCulprit(root);
		
		//swap
		int temp = first.val;
		first.val = second.val;
		second.val = temp;

	}

	static TreeNode prev = null, first = null, second = null;

	private static void findCulprit(TreeNode curr) {

		if (curr == null)		return;

		findCulprit(curr.left);
		if (prev != null && prev.val > curr.val) {
			if (first == null)
				first = prev;
			second = curr;
		}
		prev = curr;

		findCulprit(curr.right);
	}

}
