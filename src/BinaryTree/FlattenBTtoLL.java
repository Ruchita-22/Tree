package BinaryTree;

public class FlattenBTtoLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Application for Morris inorder traversal
	//114. Flatten Binary Tree to Linked List
	//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
	public void flatten(TreeNode root) {
        if(root == null)    return;
        
        TreeNode curr = root;
        while(curr != null) {
			if(curr.left == null) {
				curr = curr.right;
			}
			else {
				TreeNode temp = curr.left;
				while(temp.right != null) {		// keep going right
					temp = temp.right;
				}
				if(temp.right ==  null) {		// make connection from right most node to root
					temp.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
				}
			}
		}   
    }

}
