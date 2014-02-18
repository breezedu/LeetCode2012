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
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		
		ListNode Head = buildList(num);
		System.out.println("The linked list has been built:");
		printList(Head);
		
		System.out.println("Please input the two indices of reverse nodes:");
		int m = input.nextInt();
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
		if(head==null || head.next==null ||m==n) return head;
		
		
		ListNode retHead = new ListNode(0);
		retHead.next = head; 				//the head of 1st list;
		
		int count = n-m;
		
		ListNode oriP = retHead;
		for(int i=0; i<m-1; i++){
			oriP = oriP.next;
		}
		ListNode tempHead = oriP.next;		//the head of 2nd list;
		
		ListNode p1 = tempHead;
		ListNode tempOri = null;
			
		while(p1.next!=null && count>0){
			
			ListNode p2 = p1.next; //remember the next node of p1;
			
			//break p1 and it's following nodes; 
			//let p1 point to the head of reversed list;			
			p1.next = tempOri; 			
			//the let tempOri point to the head of newly built list;
			tempOri = p1;
			
			p1 = p2;
			p2 = p2.next;
			
			count--;
			
		}//end while loop, after this loop, p1.next is the head of 3rd list;
		
		tempHead.next = p1.next;
		p1.next = tempOri; //the nodes between indices m and n were reversed;
		
		//let the last node in the 1st list point to the head of newly 2nd list;
		oriP.next = p1;
		
		return retHead.next;
	}

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
