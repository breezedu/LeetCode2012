package leetCode2012;

import java.util.Scanner;

/**************
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, 
 * return 1->4->3->2->5->NULL.
 * 
 * @author Frog
 *
 */
public class ReverseLinkedListII {
	
	public static void main(String[] args){
		
		System.out.println("This is a Reverse Linked List program.");
		
		//1st, build a linked list;
		System.out.println("Please input how many nodes in the list:");
		System.out.print("total nodes = ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		
		ListNode Head = buildList(num);
		System.out.println("The linked list has been built:");
		printList(Head);
		
		System.out.println("Please input the two indices of reverse nodes:");
		System.out.print(" m = ");
		int m = input.nextInt();
		System.out.print(" n = ");
		int n = input.nextInt();
		input.close();
		
		//2nd, reverse the list;
		Head = reverseListBetween(Head, m, n);
		
		System.out.println("After reverse:");
		printList(Head);
		
	}//end main();

	/***************
	 * break the original list into 3 lists;
	 * the 1st list are nodes before m, the 3rd list are nodes after m;
	 * just reverse the 2nd list with the same method as ReverseLinkList.java;
	 * then link all three lists together;
	 * 
	 * ONE trick here is, if m==1, then the 1st list should be null. 
	 * but we can not add an empty list before the 2nd list; so we add another node 
	 * to the original list, thus we will have at least one node in the new 1st list;
	 * if the 3rd list is empty, then it is OK to let the end of 2nd list point to another null
	 * so, we do not have to add another node to the very end of the original list;
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	private static ListNode reverseListBetween(ListNode head, int m, int n) {
		
		// TODO reverse the list between m and n indices; 
		if(head==null || head.next==null ||m>=n) return head;		
		
		ListNode retHead = new ListNode(0);
		retHead.next = head; 				//the head of 1st list;
		
		int count = n-m;
		
		ListNode oriP = retHead;
		for(int i=1; i<m; i++){
			oriP = oriP.next;
			if(oriP==null) return head;
		}
		
		ListNode revHead = oriP.next;		//the head of 2nd list;
		
		ListNode pCurr = revHead; 	//this is the head of the 2nd list;
		ListNode revList = null;
			
		while(pCurr.next!=null && count>0){
			
			ListNode pNext = pCurr.next; 	//remember the next node of pCurrent;
			
			//break pCurr and it's following nodes; 
			//right now the reversed List is just a null;
			//let pCurr point to the head of reversed list: tempList2;			
			pCurr.next = revList; 			
			//then let tempList2 point to the head node of the reversed 2nd list;
			revList = pCurr;
			
			pCurr = pNext;
			pNext = pCurr.next;
			
			count--; 	//this is the number of nodes left to the 2nd list.
			
		}//end while loop, after this loop, pCurr.next is the head of 3rd list;
		
		
		//link the reversed list's end to the head of the 3rd list;
		revHead.next = pCurr.next;
		
		//make pCurr the head of the reversed list;
		//the nodes between indices m and n were reversed;
		pCurr.next = revList; 

		
		//link the 1st list's end to the head of reversed list;
		oriP.next = pCurr;
		
		return retHead.next;
	}//end of reverseListBetween() method;

	private static void printList(ListNode head) {
		// TODO printout a linked list
		
		if(head==null){
			System.out.println("There's nothing in the list.");
		}
		
		System.out.print("LIST: " + head.val);
		ListNode p = head.next;
		while(p!=null){
			System.out.print("->" + p.val);
			p = p.next;
		}
		System.out.println("=>END");
		
	}//end printList() method;

	private static ListNode buildList(int num) {
		// TODO build a linked list with num nodes;
		if(num==0)
		   return null;
		ListNode head = new ListNode(0);
		ListNode p = head;
		for(int i=0; i<num; i++){
			p.next = new ListNode( (int)(Math.random()*10) );
			p = p.next;
		}
		
		return head.next;
		
	}//end buildList() method;

}//end of everything in ReverseLinkedList class
