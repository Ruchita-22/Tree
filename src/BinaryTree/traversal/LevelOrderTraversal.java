package BinaryTree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import TreeNode.TreeNode;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static ArrayList<Integer> levelOrderTravesal(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();
		ArrayList<Integer> list = new ArrayList<>();
		q.add(root);
		while (q.size() > 0) {
			TreeNode x = q.poll();
			list.add(x.val);
			if (x.left != null)		q.add(x.left);
			if (x.right != null)	q.add(x.right);
		}
		return list;
	}
	//TC - O(n), SC-O(w) queue space
}
