package other;

import java.util.*;

import TreeNode.TreeNode;

public class Advance {



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //993. Cousins in Binary Tree
    public boolean isCousins(TreeNode root, int x, int y) {
    	if(root == null)	return false;
    	
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	while(q.size()>0) {
    		boolean isXexist = false, isYexist = false;
    		int n = q.size();
    		for (int i = 0; i < n; i++) {
				TreeNode curr = q.poll();
				if(curr.val == x)	isXexist = true;
				if(curr.val == y)	isYexist = true;
				if(curr.left != null && curr.right != null) {
					if( (curr.left.val == x && curr.right.val == y) || 
							(curr.left.val == y && curr.right.val == x))
						return false;
					if(curr.left != null)	q.add(curr.left);
					if(curr.right != null)	q.add(curr.right);
				}
				
			}
    		if(isXexist && isYexist)	return true;
    		
    	}
    			
		return false;
    	
        
    }
    // 1302. Deepest Leaves Sum
    // new way of level wise level order traversal
    
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)    return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int sum = 0;
        while(q.size()>0) {
        	sum = 0;
        	int n = q.size();
        	for (int i = 0; i < n; i++) {
				TreeNode node = q.poll();
				sum += node.val;
				if(node.left != null)	q.add(node.left);
				if(node.right != null)	q.add(node.right);
			}
        }
        return sum;
    }
    //1123. Lowest Common Ancestor of Deepest Leaves
    int Hmax;
    TreeNode A,B;
    TreeNode ans;
    public int lca(TreeNode node){
        if(node==null)
            return 0;
        
        int sum=lca(node.left)+lca(node.right);
   
        int matched=0;
        if(node.val==A.val)
            matched++;
        if(node.val==B.val)
            matched++;
        
        if(sum+matched==2 && ans==null){
            ans=node;
        }
        
        return sum+matched;
    }
    public void dfs(TreeNode node,int height){
        if(node==null)
            return;
        
        if(height>Hmax){
            Hmax=height;
            A=node;
            B=node;
        }
        else if(height==Hmax){
            B=node;
        }
        
        dfs(node.left,height+1);
        dfs(node.right,height+1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        A=null;
        B=null;
        Hmax=-1;
        
        ans=null;
        dfs(root,0);

        lca(root);
        return ans;
        
    }
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    //////////////////////////////////////////////////////////
  
    // sum of longest path
    // k path sum = https://practice.geeksforgeeks.org/problems/k-sum-paths/1
    // count the path whose sum is k
    static int count = 0;
    private static int kSum (TreeNode root, int targetSum) {
    	ArrayList<Integer> path = new ArrayList<>();
    	count = 0;
    	kSumHelper(root, targetSum, path);
    	return count;
    }

	private static void kSumHelper(TreeNode root, int targetSum, ArrayList<Integer> path) {
		// TODO Auto-generated method stub
		if(root ==  null) return;
		
		path.add(root.val);		
			
		kSumHelper(root.left, targetSum, path);
		kSumHelper(root.right, targetSum, path);
		
		int sum = 0;
		for(int e : path) {
			sum += e;
			if(sum == targetSum)
				count++;
		}
		path.remove(path.size()-1);
	}

    
	//1038. Binary Search Tree to Greater Sum Tree
	public TreeNode bstToGst(TreeNode root) {
        solve(root, 0);
        return root;
    }
    private static int solve(TreeNode root, int sum){
        if(root == null)    return 0;
        if(root.right != null)  sum = solve(root.right, sum);
        
        int a = root.val;  
        root.val += sum;
        sum += a;
        
        if(root.left != null) sum = solve(root.left, sum);
        
        return sum;
    }
 // max sum of non adj node = https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1
	
	
 	// max width of BT
    
}
