package leetCode2012;

import java.util.Scanner;

/**************
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * @author Frog
 *
 */

public class BalancedBinaryTree {
	
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public static void main(String[] args){
		
		System.out.println("This is a BalancedBinaryTree program.");
		System.out.println("Please indicate how many nodes in the tree:");
		
		//1st, generate an array[];
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		int[] array = buildArray(num);
		System.out.println("Printout the original array:");
		printArray(array);
		
		//2nd put the array into a tree;
		TreeNode root = buildTree(array);
		System.out.println("The tree has been built, root=" + root.val +", " +root.left +", " + root.right);
		
		//3rd, check if the tree is balanced in height
		boolean bal = isBalanced(root);
		
		if(bal){
			System.out.println("The tree is balanced.");
			
		} else {
			System.out.println("The tree is NOT balanced.");
			
		} // end if-else balanced conditon;
		
	} // end main();

	private static boolean isBalanced(TreeNode root) {
		// TODO To check if a tree is Balanced or Not
		if(root == null){
			return true;
		} // if the tree is empty, return true;
		
		if(!isBalanced(root.left)){
			return false;
		} // check left branch;
		
		if(!isBalanced(root.right)){
			return false;
		} // check right branch;
		
		// check root itself;		
		int heightL = getHeight(root.left);
		int heightR = getHeight(root.right);
		
		System.out.println("The total height is: " + Math.max(heightL+1, heightR+1));
		
		if(heightL-heightR > 1 || heightR-heightL >1){
			return false;
		}
		
		return true;
	} // end isBalanced() method;

	/********
	 * get the height of a tree;
	 * @param node
	 * @return
	 */
	private static int getHeight(TreeNode node) {
		// TODO get the height of a tree/branch
		if(node == null){
			return 0;
			
		} 
				
		return Math.max(getHeight(node.left)+1, getHeight(node.right)+1);
		
	} // end getHeight() method;

	private static TreeNode buildTree(int[] array) {
		// TODO put an array into a tree
		if(array == null){
			return null;
		}
		
		TreeNode root = new TreeNode(array[0]);
		int Len = array.length;
		
		for(int i=1; i<Len; i++){
			root = addNode(root, array[i]);
		}
		
		return root;
	} // end buildTree() method;

	private static TreeNode addNode(TreeNode root, int m) {
		// TODO Add an integer to a tree
		if(m >= root.val && root.right==null){
			root.right = new TreeNode(m);
		
		} else if(m >= root.val && root.right!=null){
			addNode(root.right, m);
			
		} else if(m < root.val && root.left==null){
			root.left = new TreeNode(m);
		
		} else if(m <root.val && root.left!=null){
			addNode(root.left, m);
			
		}
		
		return root;
		
	}// end addNode() method;

	private static void printArray(int[] array) {
		// TODO printout an array
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		System.out.println();
	} // end of printArray() method;

	private static int[] buildArray(int num) {
		// TODO build an array with random integers
		int[] array = new int[num];
		
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*100);
		}
		
		return array;
	} // end buildArray() method;

} // end of everything in Balanced BinaryTree class;
