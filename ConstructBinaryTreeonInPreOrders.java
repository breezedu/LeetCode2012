package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/********************
 * Given a inOrder and a preOrder traversals of a tree;
 * re-construct the binary tree
 * 
 * @author Frog
 *
 */
public class ConstructBinaryTreeonInPreOrders {

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
	//	System.out.println("Printout the inOrder Array[]:");
	//	printArray(inArray);
			
				
		//4th, pre-Order-Traversal;
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		preOrder = preorderTraversal(root);	
	
		System.out.println("after the preOrderTraversal:");
	//	printArrayList(preOrder);
		
		int numPre = preOrder.size();
		int[] preArray = new int[numPre];
		for(int i=0; i<numPre; i++){
			preArray[i] = preOrder.get(i);
			
		}
	//	System.out.println("Printout the preOrder Array[]:");
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
		
		int Len = inArray.length;
		
		//buildNodes(preArray, inArray, startofPreArray, endofpreArray, startofinArray, endofinArray);
		TreeNode root = buildNode(preArray, inArray, 0, Len-1, 0, Len-1);
		
		return root;
	}//end buildOriginalTree() method;b
	
	private static TreeNode buildNode(int[] preArray, int[] inArray, int preStart, int preEnd, int inStart, int inEnd) {
		// TODO Auto-generated method stub
		if(preStart>preEnd || inStart>inEnd){
			return null;
		}
		
	//	System.out.println("start= " + preStart +", end= "+preEnd +" preArray[]" + preArray[preStart]);
		
		TreeNode root = new TreeNode(preArray[preStart]);
		
		int step = 0; //to find the index of preArray[0] in inArray[]
			//this is also the endIndex of new preArray first half;
		for(int i= inStart; i<=inEnd; i++){
			if(inArray[i] == preArray[preStart]){
				break;
			}
			
			step++;
		}//end for i<=inEnd loop;
		
		root.left = buildNode(preArray, inArray, preStart+1, preStart+step, inStart, inStart+step-1);
		root.right = buildNode(preArray, inArray, preStart+step+1, preEnd, inStart+step+1, inEnd);
		
		return root;
	}// end buildNode() method;

	private static ArrayList<Integer> preorderTraversal(TreeNode root) {
		// TODO preOrder traversal of a tree add each node to an AL;
		
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		
		preOrder(preOrder, root); //call preOrder() to build the AL;
		
		return preOrder;
	}//end preorderTraversal() method;
	
	private static void preOrder(ArrayList<Integer> preOrder, TreeNode root) {
		// TODO preOrder traversal, put every val into an AL
		if(root == null){
			return;
		}
		
		//the order here is very important!
		preOrder.add(root.val); 		//1st, add root.val;
		
		preOrder(preOrder, root.left);	//2nd, traversal to left branch;
		
		preOrder(preOrder, root.right);	//3rd, traversal to the right branch;
		
	}//end preOrder() method;

	

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
		
		inOrder(inOrder, root);
		
		return inOrder;
	}//end inorderTraversal() method;

	private static void inOrder(ArrayList<Integer> inOrder, TreeNode root) {
		// TODO inorder traversal the tree, add each node to an AL
		if(root == null){
			return;
		}
		
		//the order here is very important;
		inOrder(inOrder, root.left);	//1st, traversal to the left branch;
				
		inOrder.add(root.val);			//2nd, add the root.val to the AL;
		
		inOrder(inOrder, root.right);	//3rd, traversal to the right branch;
		
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
