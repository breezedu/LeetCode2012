package leetCode2012;

import java.util.Scanner;

public class FlattenBinaryTreetoLinkedListNoAL {

	public static void main(String[] args){
		
		System.out.println("This is a Flatten Binary Tree to Linked List like tree program.");
		
		//1st, create an array
		int[] array = creatArray();
		printArray(array);
		
		
		//2nd, put array into a tree;
		TreeNode root = arrayToTree(array);
		System.out.println("The tree has been built:");
		printTree(root);
		System.out.println();
		
		
		//3rd, flatten the original tree;
		flattenNode(root);
		System.out.println("\nAfter flatten:");
		printTree(root);
		
		
		
	}//end main();
	
	private static void flatten(TreeNode root) {
		
	     if(root == null){
	        	return;
	        }
	     
	     root = flattenNode(root); //
	    
	}

	/************
	 * if the current node is null or leaf, just return;
	 * otherwise divide the node into three part: root, left and right;
	 * let the root be a solo node without any child;
	 * then merge the left branch to root.right if left!=null
	 * then merge the right branch to root.right;
	 * Recurison flattern left and right node :)
	 * 
	 * @param node
	 * @return
	 */
	private static TreeNode flattenNode(TreeNode node) {
		// TODO to flatten the current node;
		if(node == null){
			return node;
		}
		
		//divide the node into 3 parts
		TreeNode left = node.left;
		TreeNode right = node.right;
		
		node.left = null;
		node.right = null; //not quite necessary;
		
		//merge left branch to node.right;
		if(left!=null){
			node.right = left;
			node = flattenNode(left);
		}
		
		//merge right branch to node.right;
		if(right!=null){
		
			node.right = right;
			node = flattenNode(right);
		}
		
		//return new node; node.right==null;
		return node;
		
	}//end of flattenTree() method;
		

	private static void printTree(TreeNode root) {
		// TODO printout a tree
		
		if(root==null){
			return;
		}
		
		System.out.print(" (" + root.val);
		
		if(root.left!=null){
			System.out.print(" " + root.left.val);
			
		} else if(root.left==null){
			System.out.print(" *");
			
		}
		
		if(root.right!=null){
			System.out.print(" " + root.right.val +")");
			
		} else if(root.right == null){
			System.out.print(" *)");
			
		}
		
		printTree(root.left);
		printTree(root.right);
		
	}//end printTree method;

	private static TreeNode arrayToTree(int[] array) {
		// TODO put an array into a tree
		if(array==null){
			return null;
		}
		TreeNode root = new TreeNode(array[0]);
		
		int Len = array.length;
		for(int i=1; i<Len; i++){
			
			addNode(root, array[i]);
		}
		
		return root;
	}//end arrayToTree() method;
	

	private static void addNode(TreeNode root, int m) {
		// TODO add an integer into a BST
		
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
			System.out.println("Nothing in the array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " + array[i]);
		}
		System.out.println();
		
	}//end printArray() method;

	private static int[] creatArray() {
		// TODO create an array
		System.out.println("Please input the length of array:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			
			array[i] = (int)(Math.random()*25);
		}
		
		return array;
	}//end creatArray() method;

	
}//end of everything in Flatten Binary Tree to Linked List  class
