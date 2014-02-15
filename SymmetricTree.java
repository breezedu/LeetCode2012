package leetCode2012;

import java.util.Scanner;

/******************
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 
 * @author Frog
 *
 */
public class SymmetricTree {
	
	public static void main(String[] args){
		 
		System.out.println("This is a SymmetricTree program.");
		
		//1st, build a binary tree;
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		int[] array = buildArray(num);
		System.out.println("The original array has been built.");
		printArray(array);
		
		//2nd, put the array into a tree;
		TreeNode root = buildTree(array);
		System.out.println("The binary tree has been build:");
		printTree(root);
		
		
		//3rd, check if the tree is symmetric or not
		boolean symTree = isSymmetric(root);
		if(symTree){
			System.out.println("The tree is symmetric.");
		
		} else {
			System.out.println("The tree is Not symmetric.");
		}
		
	} //end main();

	private static boolean isSymmetric(TreeNode root) {
		// TODO check if a tree is symmetric or not
		if(root == null || (root.left==null&&root.right==null)){
			return true;
		}
		
		//create two pointers point to root.left and root.right;
		//Stack<TreeNode> leftSt = new Stack<TreeNode>();
		//Stack<TreeNode> rightSt = new Stack<TreeNode>();
		
		//boolean symSt = checkSymmtricStack(leftSt, rightSt, root.left, root.right);		
		boolean symNodes = checkSymmtricNodes(root.left, root.right);		
		
		return symNodes;
	} //end isSymmetric() method;
	
	private static boolean checkSymmtricNodes(TreeNode left, TreeNode right) {
		// TODO Check if two nodes are symmtric
		boolean leftA;
		boolean rightA;
		
		 if((left==null && right!=null) || (left!=null && right==null)){
			 return false;
			 
		} else if(left==null && right==null) {
			return true;
			
		} else if(left.val != right.val){
			return false;
			
		} //end if-else conditions
		
		leftA = checkSymmtricNodes(left.left, right.right);
		rightA = checkSymmtricNodes(left.right, right.left);
				
		return (leftA && rightA);
	} //end checkSymmtricNode() method;

	private static void printTree(TreeNode root) {
		// TODO Printout a tree
		if(root == null){
			return;
		}
		System.out.print(" (" + root.val);
		
		if(root.left==null){
			System.out.print(" *");
			
		} else if(root.left!=null){
			System.out.print(" " +root.left.val);
			
		}
		
		if(root.right == null){
			System.out.print(" *)");
			
		} else if(root.right != null){
			System.out.print(" " + root.right.val +")");
			
		}
		
		printTree(root.left);
		printTree(root.right);
		
	}//end printTree() method

	private static TreeNode buildTree(int[] array) {
		// TODO Auto-generated method stub
		if(array==null || array.length==0){
			return null;
		}
		TreeNode root = new TreeNode(array[0]);
		for(int i=1; i<array.length; i++){
			addNode(root, array[i]);
		}
		
		
		return root;
	}//end buildTree() method;

	private static void addNode(TreeNode root, int m) {
		// TODO add one more node to a tree root
		
		if(root==null){
			root = new TreeNode(m);
		
		} else if(m < root.val && root.left==null){
			root.left = new TreeNode(m);
			
		} else if(m <root.val && root.left!=null){
			addNode(root.left, m);
						
		} else if(m >= root.val && root.right==null){
			root.right = new TreeNode(m);
			
		} else if(m >= root.val && root.right!=null){
			addNode(root.right, m);
			
		} //end if-else conditions;
		
	
	} // end addNode() method;

	private static void printArray(int[] array) {
		// TODO Printout each elementry of an array
		int len = array.length;
		for(int i=0; i<len; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
	} //end printArray() method;

	private static int[] buildArray(int num) {
		// TODO create an array[] of num elements
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random() * 10);
		}
		
		return array;
	} // end buildArray() method;

} //end of everything in SymmetricTree class;
