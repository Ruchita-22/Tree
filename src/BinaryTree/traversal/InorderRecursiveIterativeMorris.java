package BinaryTree.traversal;

import java.util.ArrayList;
import java.util.Stack;

import BinaryTree.TreeNode;

public class InorderRecursiveIterativeMorris {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static ArrayList<Integer> list = new ArrayList<>();
	public int[] inorderTraversal(TreeNode root) {
		list.clear();
		inorder(root);
		return list.stream().mapToInt(Integer::intValue).toArray();

	}

	private static void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);

	}
	//TC - O(n), SC-O(h) stack space
	// Iterative Approach
	private static void inorder1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		
		while (curr != null || stack.size() > 0) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				TreeNode t = stack.pop();
				System.out.println(t.val);
				curr = t.right;
			}
		}
	}
	//TC - O(n), SC-O(h) stack space
	// Morris Inorder Traversal = no extra space is required
	public ArrayList<Integer> inorder2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null) {
			if(curr.left == null) {
				list.add(curr.val);
				curr = curr.right;
			}
			else {
				TreeNode temp = curr.left;
				while(temp.right != null && temp.right != curr) {		// keep going right
					temp = temp.right;
				}
				if(temp.right ==  null) {		// make connection from right most node to root
					temp.right = curr;
					curr = curr.left;
				}
				else {
					temp.right = null;
					list.add(curr.val);
					curr = curr.right;
				}
			}
		}
        return list;
	}
	//TC - O(n), SC-O(1)

}
