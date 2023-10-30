package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	//116. Populating Next Right Pointers in Each Node
	//117. Populating Next Right Pointers in Each Node II
	public Node connect(Node root) {
        if(root == null)    return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                if(i == size-1)     node.next = null;
                else                node.next = q.peek();
                
                if(node.left != null)   q.add(node.left);
                if(node.right != null)   q.add(node.right);   
            }
                
        }
        return root;
        
	}
}
