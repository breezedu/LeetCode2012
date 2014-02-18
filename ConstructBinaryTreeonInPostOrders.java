package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/*******************
 * Given a inOrder and a postOrder traversals of a tree;
 * re-construct the binary tree
 * 
 * @author Yan
 *
 */
public class ConstructBinaryTreeonInPostOrders {

	public static void main(String[] args){
		
		System.out.println("This is a Construct Binary Tree on Inorder and Postorder program.");
		
		//1st, create an array
		int[] arrayOri = createArray();
		System.out.println("Printout the original array:");
		printArray(arrayOri);
		
		
		//2nd, put array to a tree
		TreeNode root = buildTreefromArray(arrayOri);
		System.out.println("Printout the tree:");
		printTree(root);
		System.out.println();
		
		
		//3rd, in-order traversal;
		int[] inOrder = inOrderTraversal(root);
		System.out.print("In-Order: ");
		printArray(inOrder);
		
		//4th, post-order traversal;
		int[]  postOrder = postOrderTraversal(root);
		System.out.print("Po-Order: ");
		printArray(postOrder);
		
		
		//5th, rebuild the tree from in-order and post-order arrays;
		TreeNode rebuildTree = buildOriginalTree(inOrder, postOrder);
		System.out.println("Printout the re-buit tree:");
		printTree(rebuildTree);
		
		
	}//end main();

	private static TreeNode buildOriginalTree(int[] inOrder, int[] postOrder) {
		// TODO rebuild the original tree base on in-order and post-order arrays;
		if(inOrder == null || postOrder==null){
			return null;
		}
		
		int Len = inOrder.length;
		//send the two arrays and begin-end indices to the buildNode() method;
		TreeNode root = buildNode(inOrder, 0, Len-1, postOrder, 0, Len-1);
		
		return root;
	}//end buildOriginalTree() method;

	private static TreeNode buildNode(int[] inOrder, int inBegin, int inEnd, int[] postOrder, int postBegin, int postEnd) {
		// TODO build a node, base on two arrays and their begin-end indices
		if(inBegin>inEnd){
			return null;
		}
		
		TreeNode root = new TreeNode(postOrder[postEnd]);
		
		int step = 0;
		for(int i=inBegin; i<=inEnd; i++){
			if(inOrder[i] == postOrder[postEnd]){
				break;
			}
			
			step++;
		}
		
		root.left = buildNode(inOrder, inBegin, inBegin+step-1, postOrder, postBegin, postBegin+step-1);
		root.right = buildNode(inOrder, inBegin+step+1, inEnd, postOrder, postBegin+step, postEnd-1);
		
		return root;
	}//end buildNode() method;
	

	private static int[] postOrderTraversal(TreeNode root) {
		// TODO post-order traversal a tree, put every node in an arrayList
		if(root == null){
			return null;
		}
		
		ArrayList<Integer> postOrderAL = new ArrayList<Integer>();
		postOrder(postOrderAL, root);
		
		int[] postArray = arrayfromAL(postOrderAL);
		
		return postArray;
	}//end postOrderTraversal() method;

	private static void postOrder(ArrayList<Integer> postOrderAL,	TreeNode root) {
		// TODO post-order traversal a tree, put every node in an arrayList
		if(root == null){
			return;
		}
		
		postOrder(postOrderAL, root.left);
		postOrder(postOrderAL, root.right);
		postOrderAL.add(root.val);
		
	}//end postOrder() method;

	private static int[] inOrderTraversal(TreeNode root) {
		// TODO in-order traversal a tree, return an array of each node
		if(root == null){
			return null;
		}
		
		//create an arrayList to store all nodes' val in in-order traversal
		ArrayList<Integer> inOrderAL = new ArrayList<Integer>();
		inOrder(inOrderAL, root);
		
		int[] arrayIn = arrayfromAL(inOrderAL);
		
		return arrayIn;
	}//end inOrderTraversal() method
	

	private static int[] arrayfromAL(ArrayList<Integer> AL) {
		// TODO Transform an arrayList to an array
		if(AL == null){
			return null;
		}
		
		int Len = AL.size();
		int[] array = new int[Len];
		
		for(int i=0; i<Len; i++){
			array[i] = AL.get(i);
		}
		
		return array;
	}//end arrayfromAL() method;

	private static void inOrder(ArrayList<Integer> inOrderAL, TreeNode root) {
		// TODO inOrder traversal and put every node to an ArrayList
		if(root == null){
			return;
		}
		
		inOrder(inOrderAL, root.left);
		inOrderAL.add(root.val);
		inOrder(inOrderAL, root.right);
		
	}//end inOrder() method;

	private static void printTree(TreeNode root) {
		// TODO print each node in a ()
		if(root == null){
			return;
		}
		
		System.out.print(" ("+root.val);
		
		if(root.left == null){
			System.out.print(" *");
		
		} else if(root.left!=null){
			System.out.print(" " + root.left.val);
			
		}
		
		if(root.right == null){
			System.out.print(" *)");
			
		} else if(root.right!=null){
			System.out.print(" "+root.right.val +")");
			
		}
		
		printTree(root.left);
		printTree(root.right);
		
	}//end printTree() method;

	private static TreeNode buildTreefromArray(int[] array) {
		// TODO build a tree from an array
		if(array == null){
			return null;
		}
		
		int Len = array.length;
		TreeNode root = new TreeNode(array[0]);
		
		for(int i=1; i<Len; i++){
			
			addNodetoTree(root, array[i]);
		}//end for i<Len loop;
		
		return root;
	}//end buildTreefromArray() method;

	private static void addNodetoTree(TreeNode root, int m) {
		// TODO add an integer m to a tree
		if(root == null){
			root = new TreeNode(m);
		
		} else if(m < root.val && root.left==null){
			root.left = new TreeNode(m);
			
		} else if(m < root.val && root.left!=null){
			addNodetoTree(root.left, m);
			
		} else if(m>= root.val && root.right==null){
			root.right = new TreeNode(m);
			
		} else if(m>= root.val && root.right!=null){
			addNodetoTree(root.right, m);
			
		}		
		
	}//end addNodetoTree() method;

	private static void printArray(int[] array) {
		// TODO printout an array
		
		if(array==null){
			System.out.println("Nothing in the array.");
			return;
		}
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
	}//end printArray() method;

	private static int[] createArray() {
		// TODO create an array
		System.out.println("Please input num of elements in the array:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		if(num==0){
			input.close();
			return null;
		}
		input.close();
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			
			array[i] = (int)(Math.random()*100);
		}
		return array;
	}//end creatArray() method;
	
	
}//end everything is ConstructBinaryTreeonInPostOrders class
