package BST;

import TreeNode.TreeNode;

public class BasicOperationINBST {
	private static boolean search(TreeNode root, int k) {

		TreeNode p = root;

		while (p != null) {
			if (p.val == k)			return true;
			else if (p.val > k)		p = p.left;
			else					p = p.right;
		}
		return false;
	}
	//TC=O(h) SC=O(1) / if skew TC=O(n)
	// O(log n ) < O(h) < O(n)
	// balance BST < BST < skew

	
	//701. Insert into a Binary Search Tree
	public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)    return new TreeNode(val);
        
        TreeNode parent = null, curr = root;
        
        while(curr != null){
            parent = curr;
            if(curr.val < val)  curr = curr.right;
            else curr = curr.left;
        }
        if(val < parent.val) parent.left = new TreeNode(val);
        else parent.right = new TreeNode(val);
        
        return root;
    }
	// 450. Delete Node in a BST
	public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(root.val == key) {
           if(root.left == null) return root.right; 
           else if(root.right == null) return root.left;
           else {
              TreeNode temp = root.right;
              while(temp.left != null) {
                  temp = temp.left;
              }
              temp.left = root.left;
              return root.right;
           } 
        }
        if(root.val > key) {
          root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
       return root; 
    }
}
