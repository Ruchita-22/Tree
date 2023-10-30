package BinaryTree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import BinaryTree.TreeNode;

public class TreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static ArrayList<Integer> list = new ArrayList<>();
    ////////////////////////////////////////////////////////////////////////////////////////
	private static void preorder(TreeNode root) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preorder(root.left);
		preorder(root.right);

	}

	private static void postorder(TreeNode root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		list.add(root.val);

	}
	////////////////////////////
	//TC - O(n), SC-O(h) stack space 
	/*if question is asking to output result as list so it will not be counted in SC
	 * becz ye to must hai or ise optimise nahi kiya ja sakta
	 * 
	 * But stack space complexity me add hoga
	 * 
	 * 
	 * */
	
}
