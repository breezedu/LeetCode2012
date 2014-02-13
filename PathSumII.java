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
 * return:
 *    [5,4,11,2]
 *    [5,8,4,5]
 * 
 * @author Frog
 *
 */

public class PathSumII {
	
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
		
		//3rd, check out all path-sums equal to sum
		ArrayList<ArrayList<Integer>> sumList =pathSum(root, sum);
		
		if(sumList.size() == 0){
			System.out.println("\nThere's no such path sum equal to sum.");
			
		} else {
			System.out.println("\nWe got " + sumList.size() +" path-sums.");
			printALofAL(sumList);
			
		}
		
		
	} // end main();

	/***********
	 * Printout the arrayLists by calling printArrayList() method;
	 * @param sumList
	 */
	private static void printALofAL(ArrayList<ArrayList<Integer>> sumList) {
		// TODO printout ArrayList of ArrayList
		if(sumList == null || sumList.size()==0){
			System.out.println("\nThe arrayList is empty.");
			return;
		}
		
		for(ArrayList<Integer> L:sumList){
			printArrayList(L);
		} // all arrayLists in sumList have been printed;
		
	}// end printALofAL() method;

	private static void printArrayList(ArrayList<Integer> arrayList) {
		// TODO printout an arrayList of integers
		for(int a:arrayList){
			System.out.print(" " +a);
		}
		System.out.println();
		
	}// end printArrayList() method;

	/*****************
	 * create an arrayList to store all path-sums equal to sum;
	 * @param root
	 * @param sum
	 * @return
	 */
	private static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// TODO check if there's any path-sum equal to sum, if so add the whold path to an arrayList
		ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
		if(root == null){
			return retList;
		}
		
		ArrayList<Integer> pathList = new ArrayList<Integer>();
		int pathSum = 0;
		
		//call checkPathSum() method to check if a path's total is equal to sum
		//if so, add that path to the retList;
		checkPathSum(root,sum, pathSum, pathList, retList);
		
		return retList;
	}

	/**********************
	 * pathSum to store the path total from root to node n;
	 * pathList to store all nodes from root to node n;
	 * 
	 * if node n has no leaf, this is one end, 
	 * if pathSum equals to sum, add pathList to retList; 
	 * @param root
	 * @param sum
	 * @param pathSum
	 * @param pathList
	 * @param retList
	 */
	private static void checkPathSum(TreeNode root, int sum, int pathSum, ArrayList<Integer> pathList, ArrayList<ArrayList<Integer>> retList) {
		// TODO Check if there's any path-sum equal to sum
		if(root.left==null && root.right==null){
			pathSum += root.val;
			pathList.add(root.val);
			System.out.println("one pathSum: " + pathSum);
			
			if(pathSum == sum){
				retList.add(pathList);
			}
		} // end if root has no leaf;
		
		if(root.left!=null && root.right==null){
			int pathSumLeft = pathSum + root.val;
			pathList.add(root.val);
			checkPathSum(root.left, sum, pathSumLeft, pathList, retList);
			
		} else if(root.left==null && root.right!=null){
			int pathSumRight = pathSum + root.val;
			pathList.add(root.val);
			checkPathSum(root.right, sum, pathSumRight, pathList, retList);
						
		} else if(root.left!=null && root.right!=null){
			int pathSumLeft = pathSum + root.val;
			int pathSumRight = pathSum + root.val;
			pathList.add(root.val);
			
			ArrayList<Integer> leftList = new ArrayList<Integer>(pathList);
			ArrayList<Integer> rightList = new ArrayList<Integer>(pathList);
			
			checkPathSum(root.left, sum, pathSumLeft, leftList, retList);
			checkPathSum(root.right, sum, pathSumRight, rightList, retList);
			
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
			array[i] = (int)(Math.random()*4 +1);
		}
		
		return array;
	} // end buildArray() method;

} // end of everything in Balanced BinaryTree class;
