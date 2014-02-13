package leetCode2012;

import java.util.Scanner;

import leetCode.Stopwatch;

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

public class SortedArraytoBinarySearchTree {
	
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
		
		Stopwatch timmer = new Stopwatch();
		
		//2nd, put the array into a BST
		TreeNode root = sortedArrayToBST(array);
		System.out.println("The tree has been built.");
		System.out.println("The root is: "+root.val);
		
		System.out.println("The time cost was: " + timmer.elapsedTime() +" seconds");
		
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
		// the front element is array[0], the end element is array[Len-1];
		
		
		TreeNode root = putMidtoTree(array, 0, Len-1);
				
		return root;
		
	}//end sortedArrayToBST() method;

	private static TreeNode putMidtoTree(int[] array, int frontIndex, int endIndex) {
		// TODO pick out the middle element between front and endIndex
		if(frontIndex == endIndex){
			TreeNode nodeLeaf = new TreeNode(array[frontIndex]);
			return nodeLeaf;
		}
		
		int midIndex = (endIndex+frontIndex+1)/2;
		TreeNode root = new TreeNode(array[midIndex]);
		
		if(frontIndex <= midIndex-1)
			root.left = putMidtoTree(array, frontIndex, midIndex-1);
		
		if(midIndex+1 <= endIndex)
			root.right = putMidtoTree(array, midIndex+1, endIndex);
		
		return root;
		
	} // end putMidtoTree() method;

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
