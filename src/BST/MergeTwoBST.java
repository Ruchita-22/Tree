package BST;

import java.util.ArrayList;

import TreeNode.TreeNode;

public class MergeTwoBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static TreeNode mergeTwoBST(TreeNode root1, TreeNode root2) {
		
		if(root1 == null && root2 == null)	return null;
		if(root1 == null)	return root2;
		if(root2 == null)	return root1;
		
		ArrayList<Integer> list1 = inorder(root1, new ArrayList<>());
		ArrayList<Integer> list2 = inorder(root2, new ArrayList<>());
		
		ArrayList<Integer> list = merge(list1, list2);
		
		TreeNode root = inorderToBST(list, 0, list.size()-1);
		return root;
	}
	
	private static TreeNode inorderToBST(ArrayList<Integer> list, int s, int e) {
		// TODO Auto-generated method stub
		
		
		int m = s+(e-s)/2;
		TreeNode root = new TreeNode(list.get(m));
		root.left = inorderToBST(list, s, m-1);
		root.right = inorderToBST(list, m+1, e);
		
		
		return root;
	}
	private static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		// TODO Auto-generated method stub
		if(list1.size() == 0 && list2.size() == 0)	return new ArrayList<>(0);
		if(list1.size() == 0)	return list2;
		if(list2.size() == 0)	return list1;
		
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0,j = 0, k = 0;
		while(i < list1.size()  && j < list2.size()){
			if(list1.get(i) <= list2.get(j)) {
				list.add(list1.get(i));
				i++; k++;
			}
			else {
				list.add(list2.get(j));
				j++; k++;
			}
		}
		while (i < list1.size()) {
			list.add(list1.get(i));
			i++; k++;
		}
		while(j < list2.size()) {
			list.add(list2.get(j));
			j++; k++;
		}
		return list;
	}
	private static ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> list){
		if(root == null)	return list;
		
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
		
		return list;
	}

}
