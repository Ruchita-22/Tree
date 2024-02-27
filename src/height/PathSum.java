package height;

import TreeNode.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//112. Path Sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum);
    }
    private static boolean pathSum(TreeNode root, int targetSum){
        if(root == null)    return false;
        if(root.left == null && root.right == null && targetSum == root.val) return true;
        
        boolean l = pathSum(root.left, targetSum - root.val);
        boolean r = pathSum(root.right, targetSum - root.val);
        return l || r;
        
    }
}
