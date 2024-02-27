package height;

import java.util.Deque;
import java.util.LinkedList;

import TreeNode.TreeNode;

public class MaxWidth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//662. Maximum Width of Binary Tree
	public int widthOfBinaryTree(TreeNode root) {
        
        Deque<TreeNode> dq = new LinkedList<>();
        root.val = 0;
        dq.add(root);
        
        int maxWidth = 1;
        
        while(dq.size() > 0){
            int currWidth = dq.peekLast().val - dq.peekFirst().val + 1;
            maxWidth = Math.max(maxWidth, currWidth);
            
            int size = dq.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = dq.pollFirst();
                if(node.left != null){
                    node.left.val = 2 * node.val + 1;
                    dq.add(node.left);
                }
                if(node.right != null){
                    node.right.val = 2 * node.val + 2;
                    dq.add(node.right);
                }
            }
        }
        return maxWidth;
    }

}
