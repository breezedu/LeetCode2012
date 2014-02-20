package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/*****************
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? 
 * Would your previous solution still work?
 * Note:
 * 
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *         /  \
 *        2    3
 *       / \    \
 *      4   5    7
 *      
 * After calling your function, the tree should look like:
 *       1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \    \
 *   4-> 5 -> 7 -> NULL
 *   
 * @author Frog
 *
 */

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}


public class PopulatingNextRightPointersinEachNodeII {
	
	public static void main(String[] args){
		
		System.out.println("This is Populating Next Right Pointers in Each Node II program.");
		
		//1st, create an array;		
		int[] array = buildArray();
		System.out.println("The array has been created:");
		printArray(array);
		
		//2nd, put array into a tree
		TreeLinkNode root = arrayToTree(array);
		printTree(root);
		System.out.println();
		
		//3rd, connect each node in the same level
		connect(root);
		System.out.println("printout the connected tree");
		printTree(root);
		
	}//end main();
	
	private static void printTree(TreeLinkNode root) {
		// TODO printout a tree
		
		if(root==null) return;
		
		System.out.print(" (" + root.val);
		
		if(root.left==null){
			System.out.print(" *");
		} else if(root.left!=null){
			System.out.print(" " +root.left.val);
		}
		
		if(root.right==null){
			System.out.print(" *");
		} else if(root.right!=null){
			System.out.print(" " +root.right.val);
		}
		
		if(root.next==null){
			System.out.print(" *)");
		} else if(root.next!=null){
			System.out.print(" " +root.next.val +")");
		}
		
		printTree(root.left);
		printTree(root.right);
		
	}//end printTree() method;

	private static TreeLinkNode arrayToTree(int[] array) {
		// TODO Auto-generated method stub
		if(array == null) return null;
		
		int Len = array.length; //index from 0 to Len-1;
		TreeLinkNode root = new TreeLinkNode(array[Len/2]); //choose the middle element as the root;
		
		if(Len>1){
			root.left = addMid2Tree(array, 0, Len/2-1, root.left);
		}
		
		if(Len>2){
			root.right = addMid2Tree(array, Len/2+1, Len-1, root.right);
		}
		
		return root;
		
	}

	private static TreeLinkNode addMid2Tree(int[] array, int frontIndex, int endIndex, TreeLinkNode node) {
		// TODO Auto-generated method stub
		
		if(frontIndex == endIndex){
			node = new TreeLinkNode(array[endIndex]);
			return node;
		}
		
		int mid = (frontIndex + endIndex +1)/2;
		
		node = new TreeLinkNode( array[mid]);
		
		if(mid > frontIndex){
			node.left = addMid2Tree(array, frontIndex, mid-1, node.left);
		}
		
		if(mid < endIndex){
			node.right = addMid2Tree(array, mid+1, endIndex, node.right);
		}
		
		return node;
		
	}

	private static void printArray(int[] array) {
		// TODO printout array
		if(array==null){
			System.out.println("Nothing in the array!");
			return;
		}
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
		
	}//end printArray() method;

	private static int[] buildArray() {
		// TODO create an array
		System.out.println("Please input the length of array:");
		Scanner input = new Scanner(System.in);
			
		int num = input.nextInt();
		input.close();
		
		if(num==0) return null;
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*25);
		}
		
		return array;
	}//end buildArray() method;

	public static void connect(TreeLinkNode root) {
        
        if(root == null){
            return;
        }
        
        ArrayList<TreeLinkNode> AL1 = new ArrayList<TreeLinkNode>();
        AL1.add(root);
        
        connectNodesinAL(AL1);
        
    }
    
    
    private static void connectNodesinAL(ArrayList<TreeLinkNode> AL){
        
        if(AL.isEmpty()) return;
        
        ArrayList<TreeLinkNode> nextAL = new ArrayList<TreeLinkNode>();
        int Len = AL.size();
        
        if(Len==1){
            
            if(AL.get(0).left!=null)
                nextAL.add(AL.get(0).left);
            if(AL.get(0).right!=null)
                nextAL.add(AL.get(0).right);
                
        } else {
        
        	for(int i=0; i<Len-1; i++){
            
        		AL.get(i).next = AL.get(i+1);
            
        		if(AL.get(i).left!=null)
        			nextAL.add(AL.get(i).left);
        		if(AL.get(i).right!=null)
        			nextAL.add(AL.get(i).right);
            
        	}//end for i<len-1 loop;
        	
        	if(AL.get(Len-1).left!=null)
        		nextAL.add(AL.get(Len-1).left);
            
        	if(AL.get(Len-1).right!=null)
        		nextAL.add(AL.get(Len-1).right);
            
        }
        
        AL.clear();
        connectNodesinAL(nextAL);
        
    }

}
