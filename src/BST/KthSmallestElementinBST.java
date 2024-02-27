package BST;

import java.util.ArrayList;

import TreeNode.TreeNode;

public class KthSmallestElementinBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//230. Kth Smallest Element in a BST
	// brute force 
	static ArrayList<Integer> list = new ArrayList<>();
    public int kthsmallest(TreeNode root, int k) {
        list.clear();
        inorder(root);
        return list.get(k-1);
    }
    private static void inorder(TreeNode root){
        if(root==null)  return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    // TC = n SC = n
    
    // approach 2
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
    // TC=N SC=1
   //approach three
    //Morris inorder traversal
	public int kthsmallest1(TreeNode root, int k) {
		int count = 0;
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left == null) {
				count++;
				if (count == k)		return curr.val;
				curr = curr.right;
			} 
			else {
				TreeNode temp = curr.left;
				while (temp.right != null && temp.right != curr) {
					temp = temp.right;
				}
				if (temp.right == null) {
					temp.right = curr;
					curr = curr.left;
				} 
				else if (temp.right == curr) {
					count++;
					if (count == k)		return curr.val;
					curr = curr.right;
					temp.right = null;
				}
			}
		}
		return -1;
	}

}
