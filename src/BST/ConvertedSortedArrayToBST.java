package BST;

import java.util.ArrayList;
import java.util.List;

import TreeNode.ListNode;
import TreeNode.TreeNode;

public class ConvertedSortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 108. Convert Sorted Array to Binary Search Tree
	public TreeNode sortedArrayToBST(int[] arr) {
		return build(0, arr.length - 1, arr);

	}

	private static TreeNode build(int s, int e, int arr[]) {
		if (s > e)	return null;

		int m = s + (e - s) / 2;
		TreeNode root = new TreeNode(arr[m]);
		root.left = build(s, m - 1, arr);
		root.right = build(m + 1, e, arr);

		return root;

	}
	//109. Convert Sorted List to Binary Search Tree
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return build(head, null);
    }
    
    public TreeNode build(ListNode head, ListNode tail) {
        
        ListNode mid = getMiddle(head, tail);
        if(mid == null) return null;
        TreeNode root = new TreeNode(mid.val);
        
        root.left = build(head, mid);
        root.right = build(mid.next, tail); 
               
        return root;
    }
    
    public ListNode getMiddle(ListNode head, ListNode tail) { 
        if(head == tail) return null;
        
        ListNode slow = head, fast = head;
        while(fast != tail && fast.next != tail) {
            slow = slow.next; 
            fast = fast.next.next;
        }
        return slow;
        
    }
    //1382. Balance a Binary Search Tree
    List<Integer> list = new ArrayList();
    
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(list, 0, list.size()-1);
    }
    public TreeNode build(List<Integer> list, int s, int e) {
        if(e < s) return null;
        
        int m = s + (e-s)/2;
        TreeNode root = new TreeNode(list.get(m));
        root.left = build(list, s, m-1);
        root.right = build(list, m+1, e);
        return root;
                
    }
    public void inorder(TreeNode root) {
        if(root == null)    return;
        
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

}
