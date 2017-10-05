

/**************************************
 * 
 * @author Jeff
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 
 */
public class No173_BinarySearchTreeIterator {
	
	public static void main(String[] args){
		
		//step 1 create a BST tree
		int n = 10;
		TreeNode tree = createTree(n);
		System.out.print(tree.val + " left: ");
		
		//step 2 get the min value from the tree, with BSTIterator class
		BSTIterator Ite = new BSTIterator(tree);
		
		
		
		for(int i=0; i<n; i++){
			
			if(Ite.hasNext()){
				System.out.println("min: " + Ite.next());
			} else {
				System.out.println("i = " + i + ", there's no min value.");
			}
		}
	}

	
	//create a tree with n nodes;
	private static TreeNode createTree(int n) {
		// TODO Auto-generated method stub
		
		//1st, create a array of integers; 
		int[] nums = new int[n];
		
		for(int i=0; i<n; i++){
			nums[i] = (int)(Math.random() * n);
		}
		
		printArray(nums);
		
		TreeNode node = new TreeNode(nums[0]);
		
		for(int i=1; i<nums.length; i++){
			putNewNode2Tree(node, nums[i]);

		} //end for i<nums.length loop; 
		
		return node;
	}



	private static void printArray(int[] nums) {
		// TODO Auto-generated method stub
		
		System.out.println("Printout an array: " );
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		
	}//end printArray() method; 


	private static void putNewNode2Tree(TreeNode root, int m) {
		// TODO Auto-generated method stub
		
		if(root == null){
			root = new TreeNode(m);
			
		} else if(m < root.val && root.left==null){
			root.left = new TreeNode(m);
			
		} else if(m <root.val && root.left!=null){
			putNewNode2Tree(root.left, m);
			
		} else if(m >= root.val && root.right==null){
			root.right = new TreeNode(m);
			
		} else if(m >= root.val && root.right!=null){
			putNewNode2Tree(root.right, m);
			
		}
		
	}//end putNewNode2Tree() method; 



	
	
}
