package BST;

import BinaryTree.TreeNode;

public class SizeOfLargestBSTinBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Info {
	    int maxi, mini, size;
	    boolean isBST;
	    public Info( int mini, int maxi, boolean isBST, int size){
	        this.mini = mini;
	        this.maxi = maxi;
	        this.isBST = isBST;
	        this.size = size;
	    }
	     public Info(){
	        
	    }
	}
	
	static int maxSize;
    public static int largestBST(TreeNode root) {
        // Write your code here.
        maxSize = 0;
        Info ans = solve(root);
        return maxSize;
    }
    private static Info solve(TreeNode root){
        if(root == null)   return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        
        Info left = solve(root.left);
        Info right = solve(root.right);
        
        Info curr = new Info();
        curr.size = left.size + right.size + 1;
       
        curr.maxi = Math.max(root.val, right.maxi);
        curr.mini = Math.min(root.val, left.mini);
        if(left.isBST && right.isBST && left.maxi < root.val && root.val < right.mini){
            curr.isBST = true;
        }
        else 
            curr.isBST = false;
        if(curr.isBST == true){
            maxSize = Math.max(maxSize, curr.size);

        }
        return curr;
    }

}
