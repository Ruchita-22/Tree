package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinTimeToBurnEntireBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//https://practice.geeksforgeeks.org/problems/burning-tree/1
	public static int minTime(TreeNode root, int k) {	
		
		
		// create parent mapping and return target node
		
		HashMap<TreeNode, TreeNode> nodeToParentMapping = new HashMap<>();
		TreeNode res = null;
		
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(root);
		nodeToParentMapping.put(root, null);
		
		while(q.size()>0) {
		    
			TreeNode node = q.poll();
			
			if(node.val == k)	res = node;
			
			if(node.left != null) {
				nodeToParentMapping.put(node.left, node);
				q.add(node.left);
			}
			
			if(node.right != null) {
				nodeToParentMapping.put(node.right, node);
				q.add(node.right);
			}
		}
		// burn tree
		
		int time = 0;
		HashSet<TreeNode> visited = new HashSet<>();
		q.clear();
		
		q.add(res);
		visited.add(res);
		
		while(q.size() > 0) {
			boolean flag = false;
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
			    TreeNode node = q.poll();
				if(node.left != null && !visited.contains(node.left)) {
					flag = true;
					q.add(node.left);
					visited.add(node.left);
				}
				
				if(node.right != null && !visited.contains(node.right)) {
					flag = true;
					q.add(node.right);
					visited.add(node.right);
				}
				
				TreeNode parent = nodeToParentMapping.get(node);
				if(parent != null && !visited.contains(parent)) {
					flag = true;
					q.add(parent);
					visited.add(parent);
				}
			}
			if(flag == true)	time++;
		}
		return time;
        
    }

}
