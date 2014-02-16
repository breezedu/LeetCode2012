package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/********************
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 *  @author Frog
 *
 */

public class ValidateBinarySearchTree {
	
	public static void main(String[] args){
		
		System.out.println("This is Validate Binary Search Tree program.");
		
		//1st, build an array of num elements;
		System.out.println("Please input how many nodes in the tree:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		int[] array = buildArray(num);
		System.out.println("\n The original array has been built.");
		printArray(array);
		
		//2nd, put the array into a tree
		TreeNode root = buildTree(array);
		System.out.println("The tree has been built:");
		System.out.println("root: " + root.val +", left: "+root.left +", right: "+root.right);
		
		//3rd, check if the tree is a BST or not
		boolean BST = isValidBST(root);
		
		if(BST){
			System.out.println("\nThe tree is a balanced binary tree.");
			
		} else {
			System.out.println("\nThe tree is not a balanced binary tree.");
			
		}
		
	}//end main();

	private static boolean isValidBST(TreeNode root) {
		// TODO check BST
		if(root == null || (root.left==null && root.right==null)){
			return true;
			
		} 
		
		ArrayList<Integer> treeList = new ArrayList<Integer>();
		
		addTreetoAL(root, treeList);
		
		System.out.println();
		printArrayList(treeList);
		
		int Len = treeList.size();
		for(int i=1; i<Len; i++){
			if(treeList.get(i-1) >= treeList.get(i)){
				return false;
			}
		} //end for i<Len loop;
				
		return true;
	}// end isValidBST() method;

	
	private static void addTreetoAL(TreeNode root, ArrayList<Integer> treeList) {
		// TODO add every tree node into an arrayList
		if(root == null){
			return;
			
		} else {
			addTreetoAL(root.left, treeList);
			treeList.add(root.val);
			addTreetoAL(root.right, treeList);
			
		}
		
	} //end addTreetoAL() method;
	
	private static void printArrayList(ArrayList<Integer> treeList) {
		// TODO Auto-generated method stub
		int Len = treeList.size();
		
		for(int i=0; i<Len; i++){
			System.out.print(" " + treeList.get(i));
		}
		System.out.println();
		
	}//end printArrayList() method;

	private static TreeNode buildTree(int[] array) {
		// TODO put an array into a tree
		if(array==null){
			return null;
		}
		
		TreeNode root = new TreeNode(array[0]);
		for(int i=1; i<array.length; i++){
			addNode(root, array[i]);
		}
		
		return root;
	}// end buildTree() method;

	private static void addNode(TreeNode root, int m) {
		// TODO add a integer into a tree;
		if(root == null){
			root = new TreeNode(m);
			
		} else if(m < root.val && root.left==null){
			root.left = new TreeNode(m);
			
		} else if(m >= root.val && root.right==null){
			root.right = new TreeNode(m);
			
		} else if(m < root.val && root.left!=null){
			addNode(root.left, m);
			
		} else if(m >= root.val && root.right!=null){
			
			addNode(root.right, m);
		}
		
	}//end addNode() method;

	private static void printArray(int[] array) {
		// TODO printout an array
		if(array==null || array.length==0){
			System.out.println("There's nothing in the array.");
			return;
		}
		
		for(int i=0; i<array.length; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
	}// end printArray() method;

	private static int[] buildArray(int num) {
		// TODO build an array of random integers
		if(num == 0){
			return null;
		}
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			
			array[i] = (int)(Math.random()*100);
		}
		return array;
	}//end buildArray() method;

}// end of everything in ValidateBinarySearchTree class;
