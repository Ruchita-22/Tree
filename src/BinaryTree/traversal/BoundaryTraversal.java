package BinaryTree.traversal;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.TreeNode;

public class BoundaryTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static ArrayList<Integer> list = new ArrayList<>();
	private static List<Integer> traverseBoundary(TreeNode root){
		
        // Write your code here.
		if(root == null)
			return list;
		
		list.add(root.val);
		
		leftPart(root.left);
		leafTraversal(root.left);
		leafTraversal(root.right);
		rightPart(root.right);
		return list;
    }
	private static void leftPart(TreeNode root) {
		if(root == null)	return;
		
		if(root.left == null && root.right == null)	return;			// leaf node
		
		list.add(root.val);				// first take the move forward
		
		if(root.left != null)		leftPart(root.left);
		else						leftPart(root.right);
				
	}
	//TC - O(n), SC-O(h) stack
	private static void leafTraversal(TreeNode root) {		// same as inorder
		if(root == null)	return;
		if(root.left == null && root.right == null)	{
			list.add(root.val);
			return;
		}
		leafTraversal(root.left);
		leafTraversal(root.right);		
	}
	//TC - O(n), SC-O(h) stack
	private static void rightPart(TreeNode root) {
		if(root == null)	return;
		if(root.left == null && root.right == null)	return;
		
		if(root.right != null)		rightPart(root.right);
		else						rightPart(root.left);
		
		list.add(root.val);			// take node while returing back
				
	}
	//TC - O(n), SC-O(h) stack
	

}
