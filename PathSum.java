package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/**************
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \      \
 *      7    2      1
 *
 * @author Frog
 *
 */

public class PathSum {
	
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
		
		System.out.println("This is a Path Sum program.");
		System.out.println("Please indicate how many nodes in the tree:");
		
		//1st, generate an array[];
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		System.out.println("Please input the sum to be checked: sum=");
		int sum = input.nextInt(); // to check if there's a sum equal to m;
		input.close();
		
		int[] array = buildArray(num);
		System.out.println("Printout the original array:");
		printArray(array);
		
		//2nd put the array into a tree;
		TreeNode root = buildTree(array);
		System.out.println("The tree has been built, root=" + root.val +", " +root.left +", " + root.right);
		
		//3rd, check if the tree is balanced in height
		boolean sumM =hasPathSum(root, sum);
		
		if(sumM){
			System.out.println("There's one sum-path in the tree up to "+sum);
			
		} else {
			System.out.println("There's NO such sum-path in the tree.");
			
		}
		
		
	} // end main();

	/**********
	 * check if there's a root to leaf path in the tree with a total value equal to sum;
	 * create an arrayList to store all path-sums;
	 * at the end check each integer in the arrayList, to see is there's anyone match the sum;
	 * @param root
	 * @param sum
	 * @return
	 */
	private static boolean hasPathSum(TreeNode root, int sum) {
		// TODO To check if there's a path with total values == sum
		if(root == null){
			return false;
		}
		
		ArrayList<Integer> pathList = new ArrayList<Integer>();
		int pathSum = 0;
		checkPathSum(root, pathList, pathSum); //call checkPathSum() method to add path-sums to arrayList
		
		for(int e:pathList){
			System.out.print(" " + e+".");
			if(e==sum) return true;
		}
		
		return false;
	} // end hasPathSum() method;

	/***********
	 * add path-sums to an arrayList
	 * return condition:
	 * when the root passed to the method is a leaf (node.left==null && node.right==null);
	 * sum the passed pathSum and the last node.val together, then add the result to arrayList;
	 * 
	 * otherwise, pathSum=pathSum+node.val; pass the new pathSum with node.left/node.right 
	 * to a new checkPathsum() call;
	 * 
	 * @param root
	 * @param pathList
	 * @param pathSum
	 */
	private static void checkPathSum(TreeNode root, ArrayList<Integer> pathList, int pathSum) {
		// TODO Add all path values to an arrayList
		if(root.left==null && root.right==null){
			pathSum += root.val;
			pathList.add(pathSum);
		}
		
		if(root.left!=null && root.right!=null){
			int pathSumLeft = pathSum + root.val;
			int pathSumRight = pathSum + root.val;
			checkPathSum(root.left, pathList, pathSumLeft);
			checkPathSum(root.right, pathList, pathSumRight);
			
		} else if(root.left!=null && root.right==null){
			int pathSumLeft = pathSum + root.val;
			checkPathSum(root.left, pathList, pathSumLeft);
			
		} else if(root.left==null && root.right!=null){
			int pathSumRight = pathSum + root.val;
			checkPathSum(root.right, pathList, pathSumRight);
			
		}
		
	} // end checkPathSum() method;

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

	/*************
	 * add one more node to the tree;
	 * get the value from Math.random()*XX, pass the value and root to the addNode() method;
	 * compare m with root.val, if m>=root.val, check the right side;
	 * if m<root.val, check the left side;
	 * if the checking side is null, just create a new node here, else pass the non-null node 
	 * and the m to addNode() method again, iteration till reach an empty node; 
	 * @param root
	 * @param m
	 * @return
	 */
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
			array[i] = (int)(Math.random()*10);
		}
		
		return array;
	} // end buildArray() method;

} // end of everything in Balanced BinaryTree class;
