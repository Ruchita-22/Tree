package BinaryTree;

public class Construction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Either you are given two order or one order and one property*/
	//Binary Tree From Inorder And Postorder
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder,inorder,0,postorder.length-1, 0, inorder.length-1);
    }

    private static TreeNode build(int[] postorder, int[] inorder, int ps, int pe, int is, int ie){
        if(ps>pe||is>ie)   return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int index = -1;
        // search in inorder
		for (int i = is; i <= ie; i++) {
			if (inorder[i] == postorder[pe]) {
				index = i;
                break;
            }
        }
		int len = index - 1 - is + 1;

		root.left = build(postorder, inorder, ps, ps + len - 1, is, index - 1);
		root.right = build(postorder, inorder, ps + len, pe - 1, index + 1, ie);
        return root;
    }
    //Binary Tree From Inorder And Preorder
    
    public TreeNode buildTree1(int[] preorder, int[] inorder) {

        return build1(preorder,inorder,0,preorder.length-1,0, inorder.length-1);
    }

    private static TreeNode build1(int[] preorder, int[] inorder,int ps,int pe,int is,int ie) {
        if(ps>pe)   return null;

        int val = preorder[ps];
        TreeNode p = new TreeNode(val);
        int index=-1;
        //linear searching- for this we can use hash map also then TC-O(n)
		for (int i = is; i <= ie; i++) {
			if (inorder[i] == val) {
				index = i;
				break;
			}
		}

		int len = index - 1 - is + 1;
		p.left = build(preorder, inorder, ps + 1, ps + len, is, index - 1);
		p.right = build(preorder, inorder, ps + len + 1, pe, index + 1, ie);
    
        return p;
    }
    //TC - O(n), SC-O(n) stack space
    // 654. Maximum Binary Tree
    private static TreeNode constructMaximumBinaryTree(int[] arr) {
        if(arr.length == 0)  return null;
        return constructMaximumBinaryTreeHelper(arr, 0, arr.length-1);
     }
     private static TreeNode constructMaximumBinaryTreeHelper(int[] arr, int s, int e) {
         int idx = getMax(arr, s, e);
         if(idx == -1)   return null;
         TreeNode root = new TreeNode(arr[idx]);
         
         root.left = constructMaximumBinaryTreeHelper(arr, s, idx-1);
         root.right = constructMaximumBinaryTreeHelper(arr, idx+1,e);
         
         return root;   
     }
     private static int getMax(int arr[], int s, int e){
         int max = Integer.MIN_VALUE;
         int idx = -1;
         for(int i = s; i <= e; i++){
             if(arr[i] > max){
                 max = arr[i];
                 idx = i;
             }
         }
         return idx;
     }
     
     //998. Maximum Binary Tree II
     private static TreeNode insertIntoMaxTree(TreeNode root, int val) {
         TreeNode node = new TreeNode(val);
         
         if(root.val < val){
             node.left = root;
             return node;
         }
         else{
             TreeNode curr = root;
             TreeNode prev = root;
             while(curr != null && curr.val > val){
                 prev = curr;
                 curr = curr.right;
             } 
         
             
             if(curr != null){
                 node.left = curr;
             }
             
              prev.right = node;  
             
             return root;
         }
     }
}
