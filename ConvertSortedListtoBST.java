package leetCode2012;

import java.util.Scanner;

/***************
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * @author Frog
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConvertSortedListtoBST {
	
	public static void main(String[] args){
		
		System.out.println("This is Convert Sorted List to Binary Search Tree program.");
		
		//1st, build a linked list with ascending order;
		System.out.println("Please input how many nodes in the linked list:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		ListNode Head = createList(num);
		
		//2nd, printout the list;
		System.out.println("The linked list has been created:");
		printList(Head);
		
		//3rd, put the linked list to BST
		TreeNode root = sortedListToBST(Head);
		printRoot(root);
		
	} //end main()

	private static void printRoot(TreeNode root) {
		// TODO printout partial of the tree
		if(root==null){
			return;
		}
		System.out.print(" (" + root.val);
		
		if(root.left!=null){
			System.out.print(" " +root.left.val);
		
		} else if(root.left==null){
			System.out.print(" *");
			
		}
		
		if(root.right!=null){
			System.out.print(" " +root.right.val+")");
			
		} else if(root.right==null){
			System.out.print(" *)");
			
		}
		
		printRoot(root.left);
		printRoot(root.right);
		
	}// end printRoot() method;

	/*************
	 * use two pointers Pslow and Pfast;
	 * Pfast move two nodes everytime, while Pslow move only one;
	 * when Pfast.next||Pfast.next.next reach null, the Pslow should be in the middle;
	 * pick that Pslow as the root node of the Binary Tree;
	 * break the original linked list into two lists: one before Pslow and the other after Pslow;
	 * build root.left according to the leftPart, build the root.right according to the rightPart;
	 * 
	 * @param head
	 * @return
	 */
	private static TreeNode sortedListToBST(ListNode head) {
		// TODO put a sorted List to BST with 2 pointers
		if(head == null){
			return null;
		}
		/*
		if(head.next == null){
			TreeNode root = new TreeNode(head.val);
			return root;
		}
		
		if(head.next.next == null){
			TreeNode root = new TreeNode(head.next.val);
			root.left = new TreeNode(head.val);
		}
		*/
		ListNode Pslow = head;
		ListNode Pfast = head;
		while(Pfast.next!=null && Pfast.next.next!=null){
			
			Pfast = Pfast.next.next;
			Pslow = Pslow.next;
		}
		TreeNode root = new TreeNode(Pslow.val);

		if(Pslow.next!=null){
			ListNode rightHead = Pslow.next;
			Pslow.next = null;
			root.right = sortedListToBST(rightHead);
		}
		
		
		if(Pslow!=head){
			//remove the Pslow from the left part of the original list;
			ListNode brP = head;
			while(brP.next.next!=null){
				brP = brP.next;
			}
			brP.next = null;
			
			root.left = sortedListToBST(head);
			
		}
		
		return root;
	}

	private static void printList(ListNode head) {
		// TODO Printout every node in the list
		if(head==null){
			System.out.println("There's no node in the list.");
			return;
		}
		
		int count = 1;
		System.out.print(head.val);
		ListNode p = head.next;
		while(p!=null){
			System.out.print(" -> " + p.val);
			p = p.next;
			count++;
		}
		System.out.println("\n There are " + count +" nodes in the list.");
		
	} // end printList() method;

	private static ListNode createList(int num) {
		// TODO create a linked list with num nodes in ascending order
		if(num==0){
			return null;
		} // end if num==0 condition; 
		
		ListNode head = new ListNode((int)(Math.random()*10));
		ListNode p = head;
		
		for(int i=0; i<num-1; i++){
			p.next = new ListNode(p.val + (int)(Math.random()*5));
			p = p.next;
		} //end fori<num-1 loop; all nodes created;
		
		return head;
		
	} // end createList() method;

} // end everything in ConvertSortedListtoBST class
