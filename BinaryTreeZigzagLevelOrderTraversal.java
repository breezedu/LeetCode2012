package leetCode2012;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*********************
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *    
 * return its zigzag level order traversal as:
 *    [
 *      [3],
 *      [20,9],
 *      [15,7]
 *      ]
 * 
 * @author Frog
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	
	public static void main(String[] args){
		
		System.out.println("This is Binary Tree Level Order Traversal program.");
		
		//1st, build an array of random numbers;
		System.out.println("Please input how many elements in the Tree:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		int[] array = buildArray(num);
		System.out.println("The original array has been built.");
		printArray(array);
		
		//2nd, put the array into a Balanced Binary Tree
		TreeNode root = buildTree(array);
		System.out.println("\nThe tree has been built:");
		System.out.println("Root:" + root.val +", left:" + root.left +", right:" + root.right);
		
		//3rd, In Level Traversal of the Tree
		ArrayList<ArrayList<Integer>> zigZagLevel = zigZagLevelOrder(root);
		
		//4th, the ArrayList of ArrayList has been build
		System.out.println("\nThe Zigzag Lever Order ALofAL has been built:");
		printALofAL(zigZagLevel);
		
	}// end main();

	private static ArrayList<ArrayList<Integer>> zigZagLevelOrder(TreeNode root) {
		// TODO in Level Order Traversal of a tree
		ArrayList<ArrayList<Integer>> retALofAL = new ArrayList<ArrayList<Integer>>();
		if(root==null){
			return retALofAL;
		}
		
		Queue<TreeNode> levelQ = new LinkedList<TreeNode>();
		levelQ.add(root);
		
		zigZagLevelTraversal(retALofAL, levelQ);
		
		return retALofAL;
	}

	/*********
	 * operate two levels at one time;
	 * with two stacks and two ArrayLists;
	 * 
	 * @param retALofAL
	 * @param levelQ
	 */
	private static void zigZagLevelTraversal(ArrayList<ArrayList<Integer>> retALofAL, Queue<TreeNode> levelQ) {
		// TODO inLevelTraversal of a tree
		//	if(levelQ==null) return; this condition is not necessary here;
		
		ArrayList<Integer> levelAL = new ArrayList<Integer>(); //create an AL to store all nodes' vals in levelQ
		ArrayList<Integer> levelAL2 = new ArrayList<Integer>();
		
		Stack<TreeNode> levelSt = new Stack<TreeNode>(); //create a Stack to store all children nodes of those in the Queue
		Stack<TreeNode> levelSt2 = new Stack<TreeNode>();
		
		//zigzag
		while(!levelQ.isEmpty()){
			
			TreeNode tempNode = levelQ.poll();
			
			levelAL.add(tempNode.val);
			
			if(tempNode.left!=null){
				levelSt.push(tempNode.left);
			}
			if(tempNode.right!=null){
				levelSt.push(tempNode.right);
			}
			
		}//end while loop;
				
		retALofAL.add(levelAL);
		
		while(!levelSt.isEmpty()){
			
			TreeNode tempNode = levelSt.pop();
			levelAL2.add(tempNode.val);
			
			if(tempNode.right!=null){
				levelSt2.push(tempNode.right);
			}
			if(tempNode.left!=null){
				levelSt2.push(tempNode.left);
			}
			
		} //end while loop;
		
		if(!levelAL2.isEmpty())
			retALofAL.add(levelAL2);
		
		while(!levelSt2.isEmpty()){
			levelQ.add(levelSt2.pop());
		}
		
		if(!levelQ.isEmpty()){
			zigZagLevelTraversal(retALofAL, levelQ);
		}
		
	}//end zigZagLevelTraversal() method;

	private static void printALofAL(ArrayList<ArrayList<Integer>> inLevel) {
		// TODO Printout the ALofAL
		if(inLevel == null){
			System.out.println("There's noting in the ALofAL.");
			return;
		}
		
		for(ArrayList<Integer> al:inLevel){
			printArrayList(al);
		}
		
	}// end printALofAL() method;
	

	private static void printArrayList(ArrayList<Integer> al) {
		// TODO Printout every element in a ArrayList
		if(al == null){
			return;
		}
		
		for(int e:al){
			System.out.print(" " + e);
		}
		System.out.println();
		
	}// end printArrayList() method;

	private static TreeNode buildTree(int[] array) {
		// TODO Put every element in the array into a tree
		
		if(array==null){
			return null;
		}
		
		TreeNode root = new TreeNode(array[0]);
		int Len = array.length;
		for(int i=1; i<Len; i++){
			addNode(root, array[i]);
		}
		
		return root;
	}// end bildTree() method;

	private static void addNode(TreeNode root, int m) {
		// TODO add one number into a tree
		if(root == null){
			root = new TreeNode(m);
			
		} else if(m < root.val && root.left==null){
			root.left = new TreeNode(m);
			
		} else if(m <root.val && root.left!=null){
			addNode(root.left, m);
			
		} else if(m >= root.val && root.right==null){
			root.right = new TreeNode(m);
			
		} else if(m >= root.val && root.right!=null){
			addNode(root.right, m);
			
		}
		
	}//end addNode() method;

	private static void printArray(int[] array) {
		// TODO print out an array;
		if(array==null){
			System.out.println("There's nothing in the array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		
	}//end printArray() method;

	private static int[] buildArray(int num) {
		// TODO build an array of num elements
		if(num==0){
			return null;
		}
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*100);
		}
		
		return array;
	} //end buildArray() method;
	

}//end of everything in BinaryTreeLevelOrderTraversal class
