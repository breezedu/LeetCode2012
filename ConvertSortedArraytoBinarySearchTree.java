package leetCode2012;

import java.util.Scanner;

/**********
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * @author Frog
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConvertSortedArraytoBinarySearchTree {
	
	public static void main(String[] args){
		
		System.out.println("This is a convert Sorted Array to Binary Search Tree program.");
		System.out.println("Please input the number of elements in the array:");
		
		//1st, build an array
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		int [] array = buildSortedArray(num);
		System.out.println("The original array has been built:");
		printArray(array);
		
		//2nd, put the array into a BST
		TreeNode root = sortedArrayToBST(array);
		System.out.println("The tree has been built.");
		System.out.println("The root is: "+root.val);
		
	} //end main();

	/***********
	 * put an sorted array into a BST
	 * 1st, pick the middle element of the array, array[Len/2];
	 * break the original array into leftPart and rightPart;
	 * pick the middle element of leftPart as the root.left node;
	 * pick the middle element of rightPart as the root.right node;
	 * do the iteration, until reached the end of the array;
	 * when the sub-array.length == 0; return null;
	 * 
	 * @param array
	 * @return
	 */
	private static TreeNode sortedArrayToBST(int[] array) {
		// TODO Auto-generated method stub
		if(array.length == 0){
			return null;
		}
		
		int Len = array.length;
		TreeNode root = new TreeNode(array[Len/2]); //pick the middle element as the root of the BST
		
		//break the original array into left and right part;
		int[] leftArray = new int[Len/2];
		int[] rightArray = new int[Len - Len/2-1];
		
		for(int i=0; i<Len/2; i++){
			leftArray[i] = array[i];
		}
		for(int j=Len/2+1; j<Len; j++){
			rightArray[j-Len/2-1] = array[j];
		}
		
		//build the left branch and right branch seperately;
		root.left = sortedArrayToBST(leftArray);
		root.right = sortedArrayToBST(rightArray);
		
		return root;
		
	}//end sortedArrayToBST() method;

	private static void printArray(int[] array) {
		// TODO printout the array
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
	} // end printArray() method;

	private static int[] buildSortedArray(int num) {
		// TODO build a sorted array
		
		int[] array = new int[num];
		array[0] = (int)(Math.random()*10);
		
		for(int i=1; i<num; i++){
			array[i] = array[i-1] + (int)(Math.random()*5);
		}
		
		return array;
	} //end buildSortedArray() method;

} // end of everything in ConvertSortedArraytoBinarySearchTree class
