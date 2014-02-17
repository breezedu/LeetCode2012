package leetCode2012;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/********************
 * Given a inOrder and a preOrder traversals of a tree;
 * re-construct the binary tree
 * 
 * @author Frog
 *
 */
public class ConstructBinaryTreeonInPreOrdershash {

	public static void main(String[] args){
		
		System.out.println("This is a Binary Tree Inorder Traversal program.");
		
		//1st, build an array;
		int[] array = buildArray();
		System.out.println("The original array has been built:");
		printArray(array);
		
		//2nd, put the array into a tree
		TreeNode root = buildTree(array);
		System.out.println("Every element in the array has been put into the tree.");
		printTree(root);
		System.out.println();
		
		//3rd, In-Order-Traversal
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		inOrder = inorderTraversal(root);
		System.out.println("after the inOrderTraversal:");
		printArrayList(inOrder);
		
		int numIN = inOrder.size();
		int[] inArray = new int[numIN];
		for(int i=0; i<numIN; i++){
			inArray[i] = inOrder.get(i);
		}
		//3.5 check inArray[] 
		System.out.println("Printout the inOrder Array[]:");
		printArray(inArray);
			
		
		
		//4th, pre-Order-Traversal;
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		preOrder = preorderTraversal(root);	
	
		System.out.println("after the preOrderTraversal:");
		printArrayList(preOrder);
		
		int numPre = preOrder.size();
		int[] preArray = new int[numPre];
		for(int i=0; i<numPre; i++){
			preArray[i] = preOrder.get(i);
			
		}
		System.out.println("Printout the preOrder Array[]:");
		printArray(preArray);
		
		//5th, re-construct the original binary tree
		TreeNode oriRoot = buildOriginalTree(inArray, preArray);
		printTree(oriRoot);
		
	}//end main();

	private static TreeNode buildOriginalTree(int[] inArray, int[] preArray) {
		// TODO re-construct a tree base on preOrder and inOrder traversals
		if(inArray==null ||preArray==null){
			return null;
		}
		Hashtable<Integer, Integer> preTable = new Hashtable<Integer, Integer>();
		Hashtable<Integer, Integer> inTable = new Hashtable<Integer, Integer>();
		for(int i=0; i<preArray.length; i++){
			preTable.put(preArray[i], i);
			inTable.put(inArray[i], i);
		}
		
		
		TreeNode root = new TreeNode(preArray[0]);
		int index = inTable.get(preArray[0]); //hashCode()getIndex(preArray[0], inArray);
		
		root.left = buildBranch(root.left, inArray, 0, index-1, preTable, inTable);
		root.right = buildBranch(root.right, inArray, index+1, inArray.length-1, preTable, inTable);
		
		return root;
	}//end buildOriginalTree() method;
	
	private static TreeNode buildBranch(TreeNode node, int[] inArray, int indexFront, int indexEnd, Hashtable<Integer, Integer> preTable, Hashtable<Integer, Integer> inTable) {
		// TODO Auto-generated method stub
		if(indexEnd < indexFront){
			return null;
		}
		
		int indexOfinOrder = inArray.length;//this is the worst condition;
		int newIndex = 0;
		for(int i=indexFront; i<=indexEnd; i++){
			if(preTable.get(inArray[i]) < indexOfinOrder){
				indexOfinOrder = preTable.get(inArray[i]);
				newIndex = i;
			}
		}
		
		node = new TreeNode(inArray[newIndex]);
		
		node.left = buildBranch(node.left, inArray, indexFront, newIndex-1, preTable, inTable);
		node.right = buildBranch(node.right, inArray, newIndex+1, indexEnd, preTable, inTable);
		
		return node;
	}

	private static ArrayList<Integer> preorderTraversal(TreeNode root) {
		// TODO preOrder traversal of a tree
		if(root == null){
			return null;
		}
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		
		preOrderTraversal(preOrder, root);
		
		return preOrder;
	}//end preorderTraversal() method;
	
	private static void preOrderTraversal(ArrayList<Integer> preOrder, TreeNode root) {
		// TODO preOrder traversal, put every val into an AL
		
		if(root == null){
			return;
		}
		preOrder.add(root.val);
		
		preOrderTraversal(preOrder, root.left);
		preOrderTraversal(preOrder, root.right);
		
	}//end preOrderTraversal() method;

	

	private static void printTree(TreeNode root) {
		// TODO printout a tree
		if(root==null){
			return;
		}
		System.out.print(" (" +root.val);
		
		if(root.left == null){
			System.out.print(" *");
			
		} else if(root.left != null){
			System.out.print(" "+root.left.val);
			
			
		} 
		
		if(root.right == null){
			System.out.print(" *)");
			
		} else if(root.right != null){
			System.out.print(" " + root.right.val +")");
			
		}
		
		printTree(root.left);
		printTree(root.right);
		
	}//end printTree() method;

	private static ArrayList<Integer> inorderTraversal(TreeNode root) {
		// TODO In Order Traversal, install every val into an arrayList
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		
		inOrderTraversal(inOrder, root);
		
		return inOrder;
	}

	private static void inOrderTraversal(ArrayList<Integer> inOrder, TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null){
			return;
		}
		
		inOrderTraversal(inOrder, root.left);
				
		inOrder.add(root.val);
		
		inOrderTraversal(inOrder, root.right);
		
	}//end inOrderTraversal() method;

	private static void printArrayList(ArrayList<Integer> inOrder) {
		// TODO Printout an ArrayList;
		if(inOrder==null){
			System.out.println("Nothing in the ArrayList.");
			return;
		}
		
		for(int e:inOrder){
			System.out.print(" " + e);
		}
		
		System.out.println();
		
	}// end printArrayList() method;

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
	}//end buidTree() method;
	

	private static void addNode(TreeNode root, int m) {
		// TODO add an integer into a tree;
		if(root == null){
			root = new TreeNode(m);
			
		} else if(m>=root.val && root.right==null){
			root.right = new TreeNode(m);
			
		} else if(m>=root.val && root.right!=null){
			addNode(root.right, m);
			
		} else if(m<root.val && root.left==null){
			root.left = new TreeNode(m);
			
		} else if(m<root.val && root.left!=null){
			addNode(root.left, m);
			
		}
		
	}//end addNode() method;

	private static void printArray(int[] array) {
		// TODO printout an array
		if(array==null){
			System.out.println("There's nothing in the array.");
			return;
		}
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
		
	}//end printArray() method;

	private static int[] buildArray() {
		// TODO build an array;
		System.out.println("To build an array, please indicate the length:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		if(num==0) return null;
		
		int [] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*100+1);
		}
		
		return array;
	}//end buildArray() method;
	
}//end everything in BinaryTreeInorderTraversal class
