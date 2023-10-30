package BinaryTree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

import BinaryTree.TreeNode;

public class VerticalTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Pair {
		TreeNode node;
		int level;			// vertical level

		public Pair(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap();
		Queue<Pair> q = new ArrayDeque();
		
		q.add(new Pair(root, 0));
		int minL = 0, maxL = 0;

		while (q.size() > 0) {

			Pair x = q.poll();
			int level = x.level;
			TreeNode node = x.node;

			map.putIfAbsent(level, new ArrayList());
			ArrayList temp = map.get(level);
			temp.add(node.val);

			minL = Math.min(minL, level);
			maxL = Math.max(maxL, level);

			if (node.left != null)		q.add(new Pair(node.left, level - 1));
			if (node.right != null)		q.add(new Pair(node.right, level + 1));
		}
		// store level wise
		ArrayList<ArrayList<Integer>> res = new ArrayList();
		for (int i = minL; i <= maxL; i++) {
			ArrayList<Integer> temp = map.get(i);
			res.add(temp);
		}
		return res;
	}
	
	// top view
	public ArrayList<Integer> solve(TreeNode root) {
		ArrayList<ArrayList<Integer>> list = verticalOrderTraversal(root);
		
		ArrayList<Integer> res = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> temp = list.get(i);
			res.add(temp.get(0));
		}
		return res;
	}

}
