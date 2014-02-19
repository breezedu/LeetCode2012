package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/***************
 * If two nodes of a BST were swapped by mistake, how to recovery the tree?
 * do not use O(n) method, that's too straight forward
 * 
 * @author Frog
 *
 */
public class RecoveryBanlancedSearchTree {

	public static void main(String[] args){
		
		System.out.println("This is Recovery Balanced Search Tree program.");
		
		//1st, build an array of ascending order;
		System.out.println("Please input how many elements in the array?");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		System.out.println("Please pick two elements to swap:");
		System.out.println("Index1= ");
		int index1 = input.nextInt();
		System.out.println("Index2= ");
		int index2 = input.nextInt();
		input.close();
		
		int[] array = buildArray(num);
		System.out.println("The original array has been built:");
		printArray(array);
		
		//2nd, swap two elements
		swapArray(array, index1, index2);
		System.out.println("Two elements have been swapped:");
		printArray(array);
		
		//3rd, put the array into a tree
		TreeNode root = buildTree(array);
		System.out.println("The tree has been built.");
		printTree(root);
		System.out.println();
		
		//4th, recovery the BST
		recoveryBST(root);
		
		System.out.println("the two nodes have been swapped:");
		printTree(root);
		
	}//end main();

	private static void recoveryBST(TreeNode root) {
		// TODO recovery a BST with two nodes swapped by mistake
		
		TreeNode node1 = null;
		TreeNode node2 = null;
		//	int count = 0;
		ArrayList<TreeNode> swapNodes = new ArrayList<TreeNode>();
		Stack<TreeNode> preNodeSt = new Stack<TreeNode>();
		
		TreeNode min = root;
		while(min.left!=null){
			min = min.left;
		}
		
		preNodeSt.push(min);
		
		checkInvalidNodes(root, preNodeSt, swapNodes);
		
		//there are two possibilities: the two node might be neighbors or not
		//if the two nodes are neighbors, we would get only two nodes in the AL
		//if they are not neighbors, we will get four nodes;
		System.out.println("\nsize of arraylist: " + swapNodes.size());
		if(swapNodes.size() == 4){
			node1 = swapNodes.get(0);
			node2 = swapNodes.get(3);
		
		} else if(swapNodes.size() ==2){
			node1 = swapNodes.get(0);
			node2 = swapNodes.get(1);
			
		}
		
		swapNodes(node1, node2);
		
	}//end recoveryBST() method;

	private static void checkInvalidNodes(TreeNode root, Stack<TreeNode> preStc, ArrayList<TreeNode> swapNodes) {
		// TODO figure out which two nodes are invalid
		
		if(root == null){
			return;
		}
		
		checkInvalidNodes(root.left, preStc, swapNodes);
		
		TreeNode nodePre = preStc.pop();
		System.out.print(" (" + nodePre.val +", " + root.val +") ");
				
		if(nodePre.val > root.val){
			
			swapNodes.add(nodePre);
			swapNodes.add(root);
			
		}//end outer if condition;
		
		preStc.push(root);
		
		checkInvalidNodes(root.right, preStc, swapNodes);
		
	} //end checkInvalidNodes() method;


	private static void swapNodes(TreeNode node1, TreeNode node2) {
		// TODO swap two nodes' vals
		
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
		
	}//end swapNode() method;
	
	
	private static void printTree(TreeNode root) {
		// TODO Printout a tree with most naive method
		if(root == null){
			//System.out.println("There's nothing in the tree.");
			return;
		}
		
		System.out.print(" (" + root.val);
		
		if(root.left != null){
			System.out.print(" " + root.left.val);
			
		} else {
			System.out.print(" *");
		}
		
		if(root.right!=null){
			System.out.print(" " +root.right.val +")");
			
		} else {
			System.out.print(" *)");
			
		}
		
		printTree(root.left);
		printTree(root.right);
		
	}//end printTree() method;

	private static TreeNode buildTree(int[] array) {
		// TODO build a tree from an array
		if(array == null){
			return null;
		}
		
		int Len = array.length; //index from 0 to Len-1;
		TreeNode root = new TreeNode(array[Len/2]); //choose the middle element as the root;
		
		if(Len>1){
			root.left = addMid2Tree(array, 0, Len/2-1, root.left);
		}
		
		if(Len>2){
			root.right = addMid2Tree(array, Len/2+1, Len-1, root.right);
		}
		
		return root;
	} //end buildTree() method;
	
	

	private static TreeNode addMid2Tree(int[] array, int frontIndex, int endIndex, TreeNode node) {
		// TODO add the middle element to a node
		if(frontIndex == endIndex){
			node = new TreeNode(array[endIndex]);
			return node;
		}
		
		int mid = (frontIndex + endIndex +1)/2;
		
		node = new TreeNode( array[mid]);
		
		if(mid > frontIndex){
			node.left = addMid2Tree(array, frontIndex, mid-1, node.left);
		}
		
		if(mid < endIndex){
			node.right = addMid2Tree(array, mid+1, endIndex, node.right);
		}
		
		return node;
	}//end addMid2Tree() method;

	private static void swapArray(int[] array, int index1, int index2) {
		// TODO swap two elements of an array;
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
	} //end swapArray() method;

	private static void printArray(int[] array) {
		// TODO Printout an array;
		if(array==null){
			System.out.println("There's nothing in the array.");
			return;
		}
		
		int Len=array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println(); 
				
	}//end printArray() method;

	private static int[] buildArray(int num) {
		// TODO Build an array with num elements
		
		if(num==0){
			return null;
		}
		int[] array = new int[num];
		array[0] = (int)(Math.random() *10);
		for(int i=1; i<num; i++){
			array[i] = array[i-1] + (int)(Math.random()*10 + 1);
		}
		
		return array;
	}// end buildArray() method;
	
}//end of everything in RecoveryBalancedSearchTree class
