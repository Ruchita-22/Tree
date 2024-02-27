package BinaryTree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

public class ZigZagTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<>();
		
		if (root == null)
			return list;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		while (q.size() > 0) {
			int size = q.size();
			List<Integer> temp = new ArrayList<>();
			
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null)		q.add(node.left);
				if (node.right != null)		q.add(node.right);
				
				if (level % 2 == 0)			temp.add(node.val);  	// add at the end 
				else						temp.add(0, node.val);	// add at the front
			}
			list.add(temp);
			level++;
		}
		return list;

	}
	//TC - O(n), SC-O(w) queue space

}
