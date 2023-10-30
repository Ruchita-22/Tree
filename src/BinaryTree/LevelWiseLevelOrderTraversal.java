package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	
	//Q1. Left View of Binary tree
	public ArrayList<Integer> leftView(TreeNode root) {

		ArrayList<Integer> list = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);
		q.add(null);

		boolean flag = true;
		// here we use L-R level order traversal
		while (q.size() > 1) {
			TreeNode x = q.poll();
			if (x != null) {
				if (flag == true) {
					list.add(x.val);
					flag = false;
				}
				if (x.left != null)		q.add(x.left);
				if (x.right != null)	q.add(x.right);

			} else {
				flag = true;
				q.add(null);
			}

		}
		return list;
	}
	//Q1. Right View of Binary tree
	// this code is giving TLE
	public ArrayList<Integer> rightView(TreeNode root) {

		ArrayList<Integer> list = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		// here we use R-L level order traversal
		boolean flag = true;
		while (q.size() > 1) {
			TreeNode x = q.poll();
			if (x != null) {
				if (flag == true) {
					list.add(x.val);
					flag = false;
				}
				if (x.right != null)
					q.add(x.right);
				if (x.left != null)
					q.add(x.left);
			} else {
				q.add(null);
				flag = true;
			}
		}
		return list;
	}
	public List<Integer> rightSideView1(TreeNode root) {
        //    Write your code here.
        if(root == null)    return new ArrayList<Integer>(0);
        List<Integer> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
        
		q.add(root);
		q.add(null);
        

	
		while (q.size() > 0) {
			TreeNode x = q.poll();
			if (x != null) {
				
				temp.add(x.val);	
				if (x.right != null)    q.add(x.right);
				if (x.left != null)     q.add(x.left);
			} 
            else {
                list.add(temp.get(0));
                temp = new ArrayList<>();
				if(q.size()>0)  q.add(null);
				
			}
		}
		return list;
    
    }
	// recursive approach
	public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        rightView(root, list, 0);
        return list;
    }
   private static void rightView(TreeNode root, List<Integer> list, int level){
        if(root == null)    return;

        if(list.size() == level) list.add(root.val);
        
        rightView(root.right, list, level+1);
        rightView(root.left, list, level+1);
        
    }

}
