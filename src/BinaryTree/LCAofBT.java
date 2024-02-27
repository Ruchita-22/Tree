package BinaryTree;

import TreeNode.TreeNode;

public class LCAofBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//longest common ancestor 
    //TC-n, SC-h
	/*
	  4 cases
	  1) curr node is == a or b
	  2) a is on left and b on right
	  3) a and b in any one sub tree
	  4) a and b in nor of the sub tree 
	 */
    private static TreeNode lca(TreeNode root, int a, int b) {
    	if(root == null)	return null;
    	if(root.val == a || root.val == b)	return root;		// curr element is a or b
    	
    	TreeNode left = lca(root.left, a, b);
    	TreeNode right = lca(root.right, a, b);
    	
    	if(left == null)	return right;
    	else if(right == null)	return left;
    	else	return root;
	}
    
    TreeNode res = null;
    public int lca1(TreeNode node, int A, int B){
        if(node == null)
            return 0;
        
        int sum = lca1(node.left, A, B) + lca1(node.right, A, B);
   
        int matched = 0;
        if(node.val == A)		matched++;
        if(node.val == B)		matched++;

		if (sum + matched == 2 && res == null) {
			res = node;
        }
        
        return sum+matched;
    }
    
    
    // kth ancestor = https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
 	/*approach 1 :  find path to that node 
 	 * make path vector
 	 * check from back and give kth ancestor
 	 * ans.val == node // edge case
 	 * approach 2
 	 * ---------
 	 * find node
 	 * if(left != null && right == null)	k-- / if k==0 so curr node is ans /  else return node 
 	 * 
 	 * 
 	 * */
    static int k = 0;
    public int kthAncestor(TreeNode root, int kth, int node)
    {
        //Write your code here
        k = kth;
        TreeNode ans =  kthAncestorHelper(root, node);
     	return (ans == null || ans.val == node) ? -1 : ans.val;
    }
    
    private static TreeNode kthAncestorHelper(TreeNode root, int node) {
 		// TODO Auto-generated method stub
 		if(root == null)	return  null;
 		if(root.val == node)	return root;
 		
 		TreeNode left = kthAncestorHelper(root.left, node);		// first we are searching that node
 		TreeNode right = kthAncestorHelper(root.right, node);	// first we are searching that node
 		
 		// wapas aarahe hai
 		if(left == null && right == null)   return null;
		
		k--;
 		if(k == 0){
 		    k = Integer.MAX_VALUE;
 			return root;
 	    }
 		else {
			return left != null ? left : right;
 		}
 	}

}
