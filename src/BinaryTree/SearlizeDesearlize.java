package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SearlizeDesearlize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static ArrayList<Integer> levelOrderTravesal(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();
		ArrayList<Integer> list = new ArrayList<>();
		q.add(root);
		while (q.size() > 0) {
			TreeNode x = q.poll();
			list.add(x.val);
			if (x.left != null)		q.add(x.left);
			if (x.right != null)	q.add(x.right);
		}
		return list;
	}
	
	
	//application
	//searlize and desearlize
	
	public ArrayList<Integer> searlize(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
		while (q.size() > 0){
            TreeNode node = q.poll();
            
            list.add(node != null ?  node.val : -1);
            if(node != null){
				q.add(node.left != null ? node.left : null);
				q.add(node.right != null ? node.right : null);
            }
        }
        return list;
    }
	
	public TreeNode desearlize(ArrayList<Integer> arr) {
		Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr.get(0));
        q.add(root);
		int i = 0;
		while (q.size() > 0){
            TreeNode node = q.poll();
            
            TreeNode left = arr.get(i+1)==-1 ? null : new TreeNode(arr.get(i+1));
            TreeNode right = arr.get(i+2)==-1 ? null : new TreeNode(arr.get(i+2));
            node.left = left;
            node.right = right;
			if (left != null)  q.add(left);
            if(right != null) q.add(right);
            i=i+2;
        }
        return root;  
    }


}
