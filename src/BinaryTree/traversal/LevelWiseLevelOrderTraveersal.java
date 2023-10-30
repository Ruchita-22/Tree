package BinaryTree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.TreeNode;

public class LevelWiseLevelOrderTraveersal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static ArrayList<ArrayList<Integer>> levelWiseLevelOrderTravesal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		q.add(root);
		q.add(null);
		while (q.size() > 1) {
			TreeNode x = q.poll();
			if (x != null) {
				temp.add(x.val);
				if (x.left != null)		q.add(x.left);
				if (x.right != null)	q.add(x.right);
			} 
			else {
				list.add(temp);
				temp = new ArrayList<>();
				if(q.size()>0)	q.add(null);
			}
		}
		return list;
	}
	// another way of writing it
	private static ArrayList<ArrayList<Integer>> levelWiseLevelOrderTravesal1(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		q.add(root);
		
		while (q.size() > 0) {
			int size = q.size();
			ArrayList<Integer> temp = new ArrayList<>();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				temp.add(node.val);
				if(node.left != null)	q.add(node.left);
				if(node.right != null)	q.add(node.right);	
			}
			list.add(temp);
		}
		return list;
	}
	
	//TC - O(n), SC-O(n) queue space
	

}
