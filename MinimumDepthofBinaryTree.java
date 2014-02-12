package leetCode2012;

import java.util.Scanner;

/**************
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.
 * 
 * @author Frog
 *
 */

public class MinimumDepthofBinaryTree {
	
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
		int minDepth = minimumDepth(root);
		
		System.out.println("The minimum depth of the tree is " + minDepth +". ");
			
		
		
	} // end main();

	private static int minimumDepth(TreeNode root) {
		// TODO to get the minimum depth of a tree;
		if(root == null){
			return 0;
		}
		
		if(root.left!=null && root.right!=null){
			return 1 + Math.max(minimumDepth(root.left), minimumDepth(root.right));
			
		} else if(root.left==null && root.right!=null){
			return 1 + minimumDepth(root.right);
			
		} else if(root.left!=null && root.right==null){
			return 1 + minimumDepth(root.left);
			
		} 
		
		return 1;
	}


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
