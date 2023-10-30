package BST;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.TreeNode;

public class PredecessorSuccessorinBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        int pre = -1, succ = -1;
        // predecessor = floor
        TreeNode curr = root;
        while(curr != null){
            if(key > curr.val){
                pre = curr.val;
                curr = curr.right;
            }
            else curr = curr.left;
        }
        //Successor = ceil
        curr = root;
        while(curr != null){
            if(key < curr.val){
                succ = curr.val;
                curr = curr.left;
            }
            else curr = curr.right;
        }
        List<Integer> list = new ArrayList<>();
        list.add(pre);
        list.add(succ);
        return list;
    }

}
