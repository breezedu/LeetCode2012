package leetCode2012;

import java.util.Scanner;

/*****************
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *    
 * @author Frog
 *
 */

public class UniqueBinarySearchTrees {
	
	public static void main(String[] args){
		
		System.out.println("This is Unique Bianry Trees program.");
		
		//1st, ask user to input the num of nodes in each trees;
		System.out.println("Pleaes input the num of nodes in each tree.");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		
		//2nd, calculate the total # of unique BSTs
		int Trees = numOfTrees(num);
		
		//printout the total # of unique BSTs
		System.out.println("There are " + Trees + " unique trees with " + num +" nodes.");
		
		
	}//end of main()

	/*****************
	 * Pretty much like a DP method;
	 * for a set of trees with num nodes;
	 * 1st, we can pick 1 as root, then there's null to the left branch, and num-1 nodes to the right branch;
	 * 2nd, we can pick 2 as root, then there's 1 node to the left, and num-2 nodes to the right;
	 * 3rd, pick 3 as root, then there are 2 nodes to the left, and num-3 nodes to the right branch;
	 * ... ... ...
	 * finally, pick num as the root, then there are num-1 nodes to the left, and null to the right branch;
	 * 
	 * following this pattern, we get equation: trees[num] = SUM(trees[i]*trees[num-i-1];
	 * works good :)
	 * @param num
	 * @return
	 */
	private static int numOfTrees(int num) {
		// TODO calculate the total # of unique BSTs with num nodes
		if(num<2) return 1;
		
		int[] trees = new int[num+1];
		trees[0] = 1; //empty tree;
		trees[1] = 1; //only one node;
	//	trees[2] = 2; //two nodes, 1-2 or 2-1;
		
		for(int i=2; i<num+1; i++){			
			for(int j=0; j<i; j++){				
				trees[i] += trees[j] * trees[i-j-1];
				
			}//end for j<i loop;
		}//end for i<num+1 loop;
		
		return trees[num];
	}

}//end of everything in UniqueBinarySearchTrees class
