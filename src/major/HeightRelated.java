package major;

import java.util.ArrayList;

import BinaryTree.TreeNode;

public class HeightRelated {

//height, path, diameter,pathsum etc
    
    
    static int ans = 0;
    private static int diameter(TreeNode root) {
		if(root==null)	return -1;
		int l = diameter(root.left);
		int r = diameter(root.right);
		ans = Math.max(ans, l+r+2);
		return Math.max(l, r)+1;
	}
    public int isBalanced(TreeNode root) {
        if(checkBalanced(root)==0)  return 0;
        else return 1;
    }
    private static int checkBalanced(TreeNode root){
        if(root == null)    return 1;
       
        int left = checkBalanced(root.left);
        int right = checkBalanced(root.right);
       
        if(left==0 ||right==0) return 0;
        if(Math.abs(left-right)>1) return 0;
        return Math.max(left,right)+1;
    }


    static ArrayList<Integer> list = new ArrayList<>();
	static int count = 0;

	

	

	public int solve(TreeNode root) {
		count = 0; // whenever using static variable always clear or re initialize
		count(root, Integer.MIN_VALUE);
		return count;
	}

	// for backtracking pass the variable with fn
	static void count(TreeNode root, int max) {
		// Base case
		if (root == null)
			return;

		if (root.val > max) {
			count++;
			max = root.val;
		}
		count(root.left, max);
		count(root.right, max);

	}
    

	// static ArrayList<Integer> list = new ArrayList<Integer>();

	public int[] solve(TreeNode root, int B) {
		list.clear();
		path(root, B);

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	private boolean path(TreeNode root, int B) {
		// Base condition
		if (root == null) {
			return false;
		}
		list.add(root.val);
		if (root.val == B)
			return true;
		
		boolean l = path(root.left, B);
		boolean r = path(root.right, B);
		if (l == true || r == true) {
			return true;
		}
		list.remove(list.size() - 1);
		return false;
	}

	
    
}
