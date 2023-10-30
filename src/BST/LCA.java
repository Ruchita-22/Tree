package BST;

import BinaryTree.TreeNode;

public class LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static TreeNode lca(TreeNode root, int a, int b) {
		TreeNode p = root;
		while(p != null) {
			if(p.val > a && p.val > b)	p = p.left;
			else if(p.val < a && p.val < b)	p = p.right;
			else return p;
		}
		return null;
	}

}
