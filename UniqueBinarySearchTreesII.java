package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

public class UniqueBinarySearchTreesII {
	
	public static void main(String[] args){
		
		System.out.println("This is a Unique Binary Search Trees II program.");
		
		//1st, ask user to input how many nodes are there in each tree;
		System.out.println("Please input the total nodes in each tree.");
		Scanner input = new Scanner(System.in);
		System.out.print(" num = ");
		int num = input.nextInt();
		input.close();
		
		
		//2nd, create an arrayList<TreeNode> to store all trees with num nodes;
		ArrayList<TreeNode> numTree = numNodesTrees(num);
		
		//printout arrayList of TreeNodes
		printArrayListofTrees(numTree);
		
	}//end main()

	private static ArrayList<TreeNode> numNodesTrees(int num) {
		// TODO create arrayList<TreeNode> for each set of trees with i=0...num nodes;
		ArrayList<ArrayList<TreeNode>> treeSets = new ArrayList<ArrayList<TreeNode>>();
		
		//with 0 nodes, the tree is null
		ArrayList<TreeNode> treeZero = new ArrayList<TreeNode>();
		treeZero.add(null);
		treeSets.add(treeZero);
		
		//with 1 nodes, the tree is simply root(1)
		ArrayList<TreeNode> one = new ArrayList<TreeNode>();
		TreeNode treeOne = new TreeNode(1);
		one.add(treeOne);
		treeSets.add(one);
		
		//DP create all trees with i nodes;
		//very like the UniqueBinarySearch.java class;
		//BUT, we have to add a completely new tree to the ArrayList each time;
		//and, we have to update right branch of each tree :)
		for(int i=2; i<=num; i++){
			
			ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
			for(int j=0; j<i; j++){
				
				//TreeNode currNode = new TreeNode(j+1);
				//currNode.left = ArrayList<TreeNode> j nodes;
				//currNode.right = ArrayList<TreeNode> i-1-j nodes;
				for(int left=0; left<treeSets.get(j).size(); left++){
					
					for(int right = 0; right <treeSets.get(i-1-j).size(); right++){
						
						TreeNode currNode = new TreeNode(j+1); //create a new root node;
						//copy a new left branch from treeSets.get(j).get(left) tree;
						currNode.left = copyTree(treeSets.get(j).get(left));
						//copy a new right branch from treeSets.get(i-1-j).get(right) tree;
						currNode.right = copyTree(treeSets.get(i-1-j).get(right));
						//update right branch of current tree; 
						updateRightBranch(currNode.right, currNode.val);
						
						temp.add(currNode);
						
					} //end for left loop;
				}//end for right loop;				
				
			}//end for j<i loop;
			
			treeSets.add(temp);
			
		}//end for i<=num loop;
	
		/***
		ArrayList<TreeNode> retAL = new ArrayList<TreeNode>();
		for(TreeNode tree:treeSets.get(num)){

			//now we have to update right branch of the tree :)
			//add root.val to every node's val to the right branch;
			
			TreeNode tempTree = copyTree(tree);
			
			updateRightBranch(tempTree.right, tempTree.val);
			retAL.add(tempTree);
		}
		*/
		
		return treeSets.get(num);
	}

	private static TreeNode copyTree(TreeNode tree) {
		// TODO create a new tree, each node in the new tree has the same val of old tree;
		if(tree == null) return null;
		
		TreeNode retTree = new TreeNode(tree.val);
		retTree.left = copyTree(tree.left);
		retTree.right = copyTree(tree.right);
		
		return retTree;
	}

	private static void updateRightBranch(TreeNode root, int n) {
		// TODO traversal the whole right branch, add root.val to every node's val;
		if(root==null) return;
		root.val = root.val+n;
		updateRightBranch(root.left, n);
		updateRightBranch(root.right, n);
		
	}//end updateRightBranch() method;

	private static void printArrayListofTrees(ArrayList<TreeNode> numTree) {
		// TODO printout every tree in the arrayList
		for(TreeNode tree:numTree){
			printTreeNode(tree);
			System.out.println();
		}
		
		System.out.println();
	}//end of printArrayListofTrees() method;

	private static void printTreeNode(TreeNode root) {
		// TODO printout every nodes and it's left and right child in a parentheses;
		if(root == null) return;
		
		System.out.print(" (" + root.val);
		if( root.left==null) {
			System.out.print(": *");
		
		} else {
			System.out.print(": " + root.left.val);
		}
		
		if(root.right==null){
			System.out.print(", *)");
			
		} else {
			System.out.print(", " + root.right.val +")");			
			
		}
		
		printTreeNode(root.left);
		printTreeNode(root.right);
		
	}//end printTreeNode() method;
	

}//end of everything in UniqueBinarySearchTreesII class;
