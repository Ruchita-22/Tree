# Tree


##### Tree Traversal
	
##### Recursive Approach
	
	static ArrayList<Integer> list = new ArrayList<>();
	public int[] inorderTraversal(TreeNode root) {
		list.clear();
		inorder(root);
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	private static void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);

	}
	//TC - O(n), SC-O(h) stack space
	
	
##### Iterative Approach

	private static void inorder1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		
		while (curr != null || stack.size() > 0) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				TreeNode t = stack.pop();
				System.out.println(t.val);
				curr = t.right;
			}
		}
	}
	//TC - O(n), SC-O(h) stack space
	
#####  Morris Inorder Traversal = no extra space is required
	
	public ArrayList<Integer> inorder2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null) {
			if(curr.left == null) {
				list.add(curr.val);
				curr = curr.right;
			}
			else {
				TreeNode temp = curr.left;
				while(temp.right != null && temp.right != curr) {		// keep going right
					temp = temp.right;
				}
				if(temp.right ==  null) {		// make connection from right most node to root
					temp.right = curr;
					curr = curr.left;
				}
				else {
					temp.right = null;
					list.add(curr.val);
					curr = curr.right;
				}
			}
		}
        return list;
	}
	
#####  LevelOrderTraversal	

	private static ArrayList<Integer> levelOrderTravesal(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();
		ArrayList<Integer> list = new ArrayList<>();
		q.add(root);
		while (q.size() > 0) {
			TreeNode x = q.poll();
			list.add(x.val);
			if (x.left != null)	q.add(x.left);
			if (x.right != null)	q.add(x.right);
		}
		return list;
	}
	//TC - O(n), SC-O(width) queue space
	
	
##### LevelWiseLevelOrderTraveersal	

	private static ArrayList<ArrayList<Integer>> levelWiseLevelOrderTravesal1(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		q.add(root);
		
		while (q.size() > 0) {
			int size = q.size();
			ArrayList<Integer> temp = new ArrayList<>();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				temp.add(node.val);
				if(node.left != null)	q.add(node.left);
				if(node.right != null)	q.add(node.right);	
			}
			list.add(temp);
		}
		return list;
	}
	
	//TC - O(n), SC-O(w) queue space
	
##### ZigZagTraversal

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<>();
		
		if (root == null)
			return list;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		while (q.size() > 0) {
			int size = q.size();
			List<Integer> temp = new ArrayList<>();
			
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null)		q.add(node.left);
				if (node.right != null)		q.add(node.right);
				
				if (level % 2 == 0)			temp.add(node.val);  	// add at the end 
				else						temp.add(0, node.val);	// add at the front
			}
			list.add(temp);
			level++;
		}
		return list;

	}
	//TC - O(n), SC-O(w) queue space

##### VerticalTraversal

	class Pair {
		TreeNode node;
		int level;			// vertical level

		public Pair(int level, TreeNode node) {
			this.node = node;
			this.level = level;
		}
	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap();
		//vertical level, elements
		
		Queue<Pair> q = new ArrayDeque();
		
		q.add(new Pair(0, root));
		int minL = 0, maxL = 0;

		while (q.size() > 0) {

			Pair x = q.poll();
			int level = x.level;
			TreeNode node = x.node;

			map.putIfAbsent(level, new ArrayList());
			ArrayList temp = map.get(level);
			temp.add(node.val);

			minL = Math.min(minL, level);
			maxL = Math.max(maxL, level);

			if (node.left != null)		q.add(new Pair(level - 1, node.left));
			if (node.right != null)		q.add(new Pairlevel + 1, node.right));
		}
		// store level wise
		ArrayList<ArrayList<Integer>> res = new ArrayList();
		for (int i = minL; i <= maxL; i++) {
			res.add(map.get(i));
		}
		return res;
	}		
	
##### searlize and desearlize - application of level order traversal

	public ArrayList<Integer> searlize(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
		while (q.size() > 0){
            TreeNode node = q.poll();     
       
            if(node != null) {
            	list.add(node.val);
            	q.add(node.left != null ? node.left : null);
				q.add(node.right != null ? node.right : null);
            }
            else list.add(-1);
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

			TreeNode left = arr.get(i + 1) == -1 ? null : new TreeNode(arr.get(i + 1));
			TreeNode right = arr.get(i + 2) == -1 ? null : new TreeNode(arr.get(i + 2));
            node.left = left;
            node.right = right;
			if (left != null)  q.add(left);
            if(right != null) q.add(right);
            i=i+2;
        }
        return root;  
    }

##### FlattenBTtoLL - Application for Morris inorder traversal

	public void flatten(TreeNode root) {
        if(root == null)    return;
        
        TreeNode curr = root;
        while(curr != null) {
			if(curr.left == null) {
				curr = curr.right;
			}
			else {
				TreeNode temp = curr.left;
				while(temp.right != null) {		// keep going right
					temp = temp.right;
				}
				if(temp.right ==  null) {		// make connection from right most node to root
					temp.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
				}
			}
		}   
    }
##### Populating Next Right Pointers in Each Node - Application of Level Order Traversal

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

##### MinTimeToBurnEntireBT
	
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
    	    
##### LCA of BT

	private static TreeNode lca(TreeNode root, int a, int b) {
    	if(root == null)	return null;
    	if(root.val == a || root.val == b)	return root;		// curr element is a or b
    	
    	TreeNode left = lca(root.left, a, b);
    	TreeNode right = lca(root.right, a, b);
    	
    	if(left == null)	return right;
    	else if(right == null)	return left;
    	else	return root;
	}
    
##### kthAncestor
    
    static int k = 0;
    public int kthAncestor(TreeNode root, int kth, int node)
    {
        //Write your code here
        k = kth;
        TreeNode ans =  kthAncestorHelper(root, node);
     	return (ans == null || ans.val == node) ? -1 : ans.val;
    }
    
    private static TreeNode kthAncestorHelper(TreeNode root, int node) {
    	if(root == null)	return  null;
		if(root.val == node)	return root;
		TreeNode left = kthAncestorHelper(root.left, node);		// first we are searching that node
		TreeNode right = kthAncestorHelper(root.right, node);	// first we are searching that node
		// wapas aarahe hai
		if(left == null && right == null)   return null;
		
		k--;
		if(k == 0){
		    k = Integer.MAX_VALUE;
		   	return root;
		} else {
			return left != null ? left : right;
		}
	}
	 		
 	
### BST

##### Search in BST

	private static boolean search(TreeNode root, int k) {

		TreeNode p = root;

		while (p != null) {
			if (p.val == k)			return true;
			else if (p.val > k)		p = p.left;
			else					p = p.right;
		}
		return false;
	}
##### Valid BST
	
	private static boolean isBST(TreeNode root, int low, int high) {
		if (root == null) return true;

		if (low <= root.val && root.val <= high) {
			boolean l = isBST(root.left, low, root.val - 1);
			boolean r = isBST(root.right, root.val + 1, high);
			return l && r;
		}
		return false;
	}
	 	 	
##### LCA in BST	

	private static TreeNode lca(TreeNode root, int a, int b) {
		TreeNode p = root;
		while(p != null) {
			if(p.val > a && p.val > b)	p = p.left;
			else if(p.val < a && p.val < b)	p = p.right;
			else return p;
		}
		return null;
	}
	
### Height Related
	
	private static int height(TreeNode root) {
		if(root == null)	return 0;
		
		int l = height(root.left);
		int r = height(root.right);
		
		return 1+ Math.max(l, r);
	}
	
##### countInRange

	static int count;
	public int countInRange(TreeNode root, int a, int b) {
		count = 0;
		count(root, a, b);
		return count;
	}

	public int count(TreeNode root, int a, int b) { // preorder
		if (root == null)	return 0;
		if (a <= root.val && root.val <= b) {
			count++;
		}
		count(root.left, a, b);
		count(root.right, a, b);
		return 0;
	}
##### Count no of node at distance k from the root

    private static int count(TreeNode root, int k) {
    	if(root == null)	return 0;
    	if(k == 0)	return 1;
    	
    	int leftCount = count(root.left, k-1);
    	int rightCount = count(root.right, k-1);
    	
		return leftCount + rightCount;
    	
    }	

##### hasPathSum

	public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum);
    }
    private static boolean pathSum(TreeNode root, int targetSum){
        if(root == null)    return false;
        if(root.left == null && root.right == null && targetSum == root.val) return true;
        
        boolean l = pathSum(root.left, targetSum - root.val);
        boolean r = pathSum(root.right, targetSum - root.val);
        return l || r;
        
    }    
    
##### 662. Maximum Width of Binary Tree

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
    