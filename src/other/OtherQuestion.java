package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import TreeNode.TreeNode;

public class OtherQuestion {
	
	//257. Binary Tree Paths
	public static List<String> res = null;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList();
        preorder( root, "");
        return res;
        
    }
    public void preorder(TreeNode root, String s) { 
        if(root == null) return;
        
        s += root.val;
        if(root.left == null && root.right == null){
            res.add(new String(s));
        }
        else {
            s += "->";
            preorder(root.left, s);
            preorder(root.right, s);
        }
    }
    // Note : always use string in recursion not StringBuilder
    
	//129. Sum Root to Leaf Numbers
	static int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        sum = 0;
        preorder1(root, "");
        return sum;
    }
    public void preorder1(TreeNode root, String str) {
        if(root == null)    return;
        str += root.val;
        if(root.left == null && root.right == null) {
            sum += Integer.parseInt(str);
        } else {
            preorder(root.left, str);
            preorder(root.right, str);
        }
    }
    
    //2415. Reverse Odd Levels of Binary Tree
    public TreeNode reverseOddLevels(TreeNode root) {
        invert(root.left, root.right, 1);
        return root;
    }
    public void invert(TreeNode root1, TreeNode root2, int level){
        if(root1 == null && root2 == null)    return;
        
       
        if(level % 2 == 1) {
            int temp = root1.val;
            root1.val = root2.val ;
            root2.val = temp;
        } 
        invert(root1.left, root2.right, level+1);
        invert(root1.right, root2.left, level+1);
       
    }
    //1104. Path In Zigzag Labelled Binary Tree
    public List<Integer> pathInZigZagTree(int n) {
        List<Integer> ans = new ArrayList<>();
        
        ans.add(n);
        while(n > 1) {
            int level = (int) (Math.log(n)/Math.log(2));
            int llv = (int) Math.pow(2, level);
            int parent = (int)((3 * llv - n-1)/2);
            ans.add(0,parent);
            n = parent;
        }
        return ans;
    }

    /* in normal case parent(n) = n/2*/
    //501. Find Mode in Binary Search Tree

    static HashMap<Integer,Integer> map;
    static int maxf = 0;
    
    public int[] findMode(TreeNode root) {
        map = new HashMap();
        maxf = 0;
        preorder(root);
        
        List<Integer> list = new ArrayList();
        
        for(Integer key : map.keySet()){
            if(map.get(key) == maxf) list.add(key);
        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
        
    }
    public void preorder(TreeNode root) {
        if(root == null)    return;
        
        int x = root.val;
        map.put(x, map.getOrDefault(x,0)+1);
        maxf = Math.max(maxf, map.get(x));
        
        preorder(root.left);
        preorder(root.right);
    }
    
    //1026. Maximum Difference Between Node and Ancestor
    public int maxAncestorDiff(TreeNode root) {
		if (root == null)   return 0;
		int min = root.val, max = root.val;
         
		preorder(root, min, max);
		return diff;
	}

	public int diff = 0;

	public void preorder(TreeNode root, int min, int max) {
		if (root == null)   return;
        
		diff = Math.max(diff, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
		min = Math.min(min, root.val);
		max = Math.max(max, root.val);
        
		preorder(root.left, min, max);
		preorder(root.right, min, max);
	}
}
