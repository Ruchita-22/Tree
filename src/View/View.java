package View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import TreeNode.TreeNode;

public class View {
	private static ArrayList<Integer> leftView (TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		q.add(root);
		
		while (q.size() > 0) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				
				if(i == 0) {
					list.add(node.val);
				}
				if(node.left != null)	q.add(node.left);
				if(node.right != null)	q.add(node.right);	
			}
		}
		return list;
	}
	private static ArrayList<Integer> rightView (TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		q.add(root);
		
		while (q.size() > 0) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				
				if(i == size-1) {
					list.add(node.val);
				}
				if(node.left != null)	q.add(node.left);
				if(node.right != null)	q.add(node.right);	
			}
		}
		return list;
	}
	class Pair {
		TreeNode node;
		int level;			// vertical level

		public Pair(int level, TreeNode node) {
			this.node = node;
			this.level = level;
		}
	}
	public ArrayList<Integer> topView(TreeNode root) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap();
		//vertical level, elements
		
		Queue<Pair> q = new ArrayDeque();
		
		q.add(new Pair(0, root));
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

			if (node.left != null)		q.add(new Pair( level - 1, node.left));
			if (node.right != null)		q.add(new Pair( level + 1, node.right));
		}
		// store level wise
		ArrayList<Integer> res = new ArrayList();
		for (int i = minL; i <= maxL; i++) {
			res.add(map.get(i).get(0));
		}
		return res;
	}
	public ArrayList<Integer> bottomView(TreeNode root) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap();
		//vertical level, elements
		
		Queue<Pair> q = new ArrayDeque();
		
		q.add(new Pair(0, root));
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

			if (node.left != null)		q.add(new Pair( level - 1, node.left));
			if (node.right != null)		q.add(new Pair( level + 1, node.right));
		}
		// store level wise
		ArrayList<Integer> res = new ArrayList();
		for (int i = minL; i <= maxL; i++) {
			res.add(map.get(i).get(map.get(i).size()-1));
		}
		return res;
	}
}
