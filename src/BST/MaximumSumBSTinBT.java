package BST;

import BinaryTree.TreeNode;

public class MaximumSumBSTinBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Info {
	    int maxi, mini, sum;
	    boolean isBST;
	    Info( int mini, int maxi, int sum){
	        this.mini = mini;
	        this.maxi = maxi;
	        this.sum = sum;
	    }
	     Info(){
	        
	    }
	}
	static int maxSum;
    
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        Info temp = solve(root);
        return maxSum > 0 ? maxSum : 0;
    }
    private static Info solve(TreeNode root){
        if(root == null)    return new Info( Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        
        Info left = solve(root.left);
        Info right = solve(root.right);
        
        Info curr = new Info();
        
        if(left.maxi < root.val && root.val  < right.mini){
            
            curr.maxi = Math.max(root.val, Math.max(left.maxi, right.maxi));
            curr.mini = Math.min(root.val, Math.min(left.mini, right.mini));
            curr.sum = left.sum + right.sum + root.val;
        }
        else {
            curr.sum = Math.max(left.sum, right.sum);
            curr.mini = Integer.MIN_VALUE;
            curr.maxi = Integer.MAX_VALUE;
        }
        maxSum = Math.max(maxSum, curr.sum);
        return curr;
    }

}
