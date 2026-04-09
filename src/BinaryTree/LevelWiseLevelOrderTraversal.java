package BinaryTree;

import java.util.*;


import TreeNode.TreeNode;

public class LevelWiseLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static ArrayList<ArrayList<Integer>> levelWiseLevelOrderTravesal(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		q.add(root);
		q.add(null);
		while (q.size() > 1) {
			TreeNode x = q.poll();
			if (x != null) {
				temp.add(x.val);
				if (x.left != null)		q.add(x.left);
				if (x.right != null)	q.add(x.right);
			} 
			else {
				list.add(temp);
				temp = new ArrayList<>();
				if(q.size()>0)	q.add(null);
			}
		}
		return list;
	}
	// new way
	private static ArrayList<ArrayList<Integer>> levelWiseLevelOrderTravesal1(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		q.add(root);
		
		while (q.size() > 0) {
			int size = q.size();
			ArrayList<Integer> temp = new ArrayList<>();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				temp.add(node.val);
				if(node.left != null)	q.add(node.left);
				if(node.right != null)	q.add(node.right);	
			}
			list.add(temp);
		}
		return list;
	}
	
	//application
	//Q1. Next Pointer Binary Tree
	class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
	}
	public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size()>0){
            TreeLinkNode node = q.poll();
            if(node!=null){
                if(q.peek()!=null){
                    node.next = q.peek();
                }
                else{
                    node.next = null;
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            else{
                if(q.size()>0)  q.add(null);
            }
        }
    }
	//Q3. Odd and Even Levels
	public int solve(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = levelWiseLevelOrderTravesal(root);
        long odd=0,even=0;
        for(int i=0;i<res.size();i++){
            ArrayList<Integer> temp = res.get(i);
            //as level start from 1
            if(i%2!=0){
                for(int e : temp)   even += e;
            }
            else{
                 for(int e : temp)   odd += e;
            }
        }
        return (int)(odd-even);
    }

}
