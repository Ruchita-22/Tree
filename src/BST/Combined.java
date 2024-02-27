package BST;

import java.util.ArrayList;
import java.util.List;

import TreeNode.TreeNode;

public class Combined {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static boolean search(TreeNode root, int k) {

		TreeNode p = root;

		while (p != null) {
			if (p.val == k)
				return true;
			else if (p.val > k)
				p = p.left;
			else
				p = p.right;
		}
		return false;
	}
	//TC=O(h) SC=O(1) / if skew TC=O(n)
	// O(log n ) < O(h) < O(n)
	// balance BST < BST < skew
	
	// Q1. Valid Binary Search Tree
	private static boolean isBST(TreeNode root, int low, int high) {
		if (root == null)
			return true;

		if (low <= root.val && root.val <= high) {
			boolean l = isBST(root.left, low, root.val - 1);
			boolean r = isBST(root.right, root.val + 1, high);
			return l && r;
		}
		return false;
	}
	
	private static TreeNode lca(TreeNode root, int a, int b) {
		TreeNode p = root;
		while(p != null) {
			if(p.val > a && p.val > b)	p = p.left;
			else if(p.val < a && p.val < b)	p = p.right;
			else return p;
		}
		return null;
	}
	
	//230. Kth Smallest Element in a BST
	static int ans, i;
    
    private static int kthSmallest(TreeNode root, int k) {
        ans = -500;
        i = 0;
        inorder(root, k);
        return ans;
    }
    private static void inorder(TreeNode root, int k){
       if(root == null) return;
        
        inorder(root.left, k);
        
        i++;
        if(i == k)  {
            ans = root.val;;
            return;
        } 
        
        inorder(root.right, k);
       
    }
 // 108. Convert Sorted Array to Binary Search Tree
 	public TreeNode sortedArrayToBST(int[] arr) {
 		return build(0, arr.length - 1, arr);
 	}

 	private static TreeNode build(int s, int e, int arr[]) {
 		if (s > e)	
 			return null;

 		int m = s + (e - s) / 2;
 		TreeNode root = new TreeNode(arr[m]);
 		root.left = build(s, m - 1, arr);
 		root.right = build(m + 1, e, arr);

 		return root;

 	}
 // 1008. Construct Binary Search Tree from Preorder Traversal
 	public TreeNode bstFromPreorder(int[] preorder) {
 		TreeNode root = new TreeNode(preorder[0]);
 		for (int i = 1; i < preorder.length; i++) {
 			insert(root, preorder[i]);
 		}
 		return root;

 	}

 	private static void insert(TreeNode root, int val) {
 		TreeNode p = root, parent = null;

 		while (p != null) {
 			parent = p;
 			if (val <= p.val)	p = p.left;
 			else				p = p.right;
 		}

 		if (val <= parent.val)
 			parent.left = new TreeNode(val);
 		else
 			parent.right = new TreeNode(val);
 	}
 	
 // 897. Increasing Order Search Tree
 	//approach1 one find inorder using extra space and then convert
 	// approach 2 without extra space
 	
 	 static TreeNode newHead;
     static TreeNode curr;
     public TreeNode increasingBST(TreeNode root) {
         
    	 newHead = new TreeNode(0);
         curr = newHead;
         inorder(root);
         return newHead.right;
     }
     private static void  inorder(TreeNode root){
         if(root == null) return;
         
         inorder(root.left);
         
         TreeNode node = new TreeNode(root.val);
         curr.right = node;
         curr = curr.right;
         
         inorder(root.right);
     }
     
     
     public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
         // Write your code here.
         int pre = -1, succ = -1;
         // predecessor = floor
         TreeNode curr = root;
         while(curr != null){
             if(key > curr.val){
                 pre = curr.val;
                 curr = curr.right;
             }
             else curr = curr.left;
         }
         //Successor = ceil
         curr = root;
         while(curr != null){
             if(key < curr.val){
                 succ = curr.val;
                 curr = curr.left;
             }
             else curr = curr.right;
         }
         List<Integer> list = new ArrayList<>();
         list.add(pre);
         list.add(succ);
         return list;
     }
     // 99. Recover Binary Search Tree
     public void recoverTree(TreeNode root) {
 		prev = null;
 		first = null;
 		second = null;
 		
 		findCulprit(root);
 		
 		//swap
 		int temp = first.val;
 		first.val = second.val;
 		second.val = temp;

 	}

 	static TreeNode prev = null, first = null, second = null;

 	private static void findCulprit(TreeNode curr) {

 		if (curr == null)	return;

 		findCulprit(curr.left);
 		
 		if (prev != null && prev.val > curr.val) {
 			if (first == null)
 				first = prev;
 			second = curr;
 		}
 		prev = curr;

 		findCulprit(curr.right);
 	}


}
