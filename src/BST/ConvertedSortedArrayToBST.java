package BST;

import BinaryTree.TreeNode;

public class ConvertedSortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 108. Convert Sorted Array to Binary Search Tree
	public TreeNode sortedArrayToBST(int[] arr) {
		return build(0, arr.length - 1, arr);

	}

	private static TreeNode build(int s, int e, int arr[]) {
		if (s > e)
			return null;

		int m = s + (e - s) / 2;
		TreeNode root = new TreeNode(arr[m]);
		root.left = build(s, m - 1, arr);
		root.right = build(m + 1, e, arr);

		return root;

	}

}
