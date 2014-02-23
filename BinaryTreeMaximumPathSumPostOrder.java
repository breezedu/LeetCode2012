package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/*******************
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 *      
 *      Return 6.
 *      
 * @author Frog
 *
 */
public class BinaryTreeMaximumPathSumPostOrder {

		public static void main(String[] args){
			
			System.out.println("This is Longest Path in a Binary Tree program.");
			
			//1st, create an array then put the array into a tree:
			int[] array = createArray();
			System.out.println("The array has been created:");
			printArray(array);
			
			//2nd, put the array into a tree;
			TreeNode root = buildTreeFromArray(array);
			System.out.println("The tree has been built:");
			printTree(root);
			System.out.println();
			
			//3rd, find out the maximum path in the tree:
			int maxPath = findMaxPath(root);
			
			System.out.println("The maximum path in the tree is: " + maxPath);
			
		}//end main();

		/************
		 * Find out the longest path through the root; root.val + root.left.longestpath + root.right.longestpah;
		 * Then calculate the same longest path through root.left, when taking root.left as the 'root' of a new tree;
		 * the calculate the longest path through root.right. .......
		 * every time, compare the longest path with the max, if bigger, assign it the max.
		 * 
		 * @param root
		 * @return
		 */
		private static int findMaxPath(TreeNode root) {
			// TODO find out the maximum path is the tree
			if(root==null) return 0;
			int max = -10000;
			int soloPath = 0; //recored the longest solo path from node to leaf;
			
			ArrayList<Integer> maxPair = new ArrayList<Integer>();
			maxPair.add(max);
			maxPair.add(soloPath);
			
			maxPair = findMaxPaththroughRoot(root, maxPair);
					
			return maxPair.get(0);
		}

		private static ArrayList<Integer> findMaxPaththroughRoot(TreeNode root, ArrayList<Integer> maxPair) {
			// TODO Auto-generated method stub
			if(root==null){
				ArrayList<Integer> emptyPair = new ArrayList<Integer>();
				emptyPair.add(0);
				emptyPair.add(0);
				
				return maxPair;
			}
			
			ArrayList<Integer> maxPairLeft = findMaxPaththroughRoot(root.left, maxPair);
			ArrayList<Integer> maxPairRight = findMaxPaththroughRoot(root.right, maxPair);
			
			
			int LeftPath = Math.max(0, maxPairLeft.get(1)); //if the child if the node is negative, just choose 0;
			int RightPath = Math.max(0, maxPairRight.get(1));
			
			int max = Math.max(maxPairLeft.get(0), maxPairRight.get(0));
			
			int depthPath = root.val + Math.max(0, Math.max(maxPairLeft.get(1), maxPairRight.get(1)));
			
			int sum = root.val + LeftPath + RightPath;
			System.out.println("At node " +root.val + ", sum= " + sum);
			
			if(sum > max){
				max = sum;
			}
			ArrayList<Integer> retPair = new ArrayList<Integer>();
			retPair.add(max);
			retPair.add(depthPath);
			
			return retPair;
		}//end of findMaxPaththroughRoot() method;

		private static void printTree(TreeNode root) {
			// TODO print out a tree
			
			if(root == null) return;
			
			System.out.print(" (" + root.val);
			if(root.left==null){
				System.out.print(" *");
				
			} else if(root.left!=null){
				System.out.print(" " + root.left.val);
				
			}
			
			if(root.right==null){
				System.out.print(" *)");
				
			} else if(root.right!=null){
				System.out.print(" " + root.right.val +")");
				
			}
			
			printTree(root.left);
			printTree(root.right);
			
		}//end printTree() method;

		private static TreeNode buildTreeFromArray(int[] array) {
			// TODO build a tree from an array
			if(array==null) return null;
			
			int Len = array.length;
			TreeNode root = new TreeNode(array[0]);
			
			for(int i=1; i<Len; i++){
				addNode(root, array[i]);
			}
			
			return root;
		}//end buildTreeFromArray() method;

		private static void addNode(TreeNode root, int m) {
			// TODO Add an integer to a tree
			if(root==null){
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
			
		}//end of printArray() method;

		private static int[] createArray() {
			// TODO create an array
			System.out.println("Please input the number of nodes in the tree.");
			Scanner input = new Scanner(System.in);
			System.out.print("num= ");
			int num = input.nextInt();
			input.close();
			
			if(num==0){
				System.out.println("That's an empty array, and ofcourse an empty tree.");
				return null;
			}
			
			int[] array = new int[num];
			
			for(int i=0; i<num; i++){
				array[i] = (int)(Math.random() * 100 -50);
			}
			
			/***
			array[num-1] = 900;
			array[num-2] = 700;
			array[num-3] = 800;
			*/
			return array;
		}//end of crateArray() method;
			
	
}// end everything of BinaryTreeMaximumPathsum class;
