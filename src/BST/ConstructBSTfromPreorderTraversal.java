package BST;

import BinaryTree.TreeNode;

public class ConstructBSTfromPreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1008. Construct Binary Search Tree from Preorder Traversal
	public TreeNode bstFromPreorder(int[] preorder) {
		TreeNode root = new TreeNode(preorder[0]);
		for (int i = 1; i < preorder.length; i++) {
			insert(root, preorder[i]);
		}
		return root;

	}

	private static void insert(TreeNode root, int val) {
		TreeNode p = root, parent = null;

		while (p != null) {
			parent = p;
			if (val <= p.val)	p = p.left;
			else				p = p.right;
		}

		if (val <= parent.val)		parent.left = new TreeNode(val);
		else						parent.right = new TreeNode(val);
	}

}
