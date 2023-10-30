package BST;

import BinaryTree.TreeNode;

public class IncreasingOrderSearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 897. Increasing Order Search Tree
	//approach1 one find inorder using extra space and then convert
	// approach 2 without extra space
	
	static TreeNode ans;
    static TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        
        ans = new TreeNode(0);
        curr = ans;
        inorder(root);
        return ans.right;
    }
    private static void  inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        
        TreeNode node = new TreeNode(root.val);
        curr.right = node;
        curr = curr.right;
        
        inorder(root.right);
    }

}
