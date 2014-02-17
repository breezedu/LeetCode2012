package leetCode2012;

import java.util.Scanner;

/***********
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * @author Frog
 *
 */
public class RemoveNthNodeFromEndofList2Pointers {

	public static void main(String[] args){
		
		System.out.println("This is a Remove Nth Node From End of List program.");
		
		//1st, build a linked list
		System.out.println("Please input the #number of nodes in the list:");
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		ListNode Head = buildList(num);
		System.out.println("The original list has been build:");
		printList(Head);
		
		//2nd, input the Nth index from End 
		System.out.println("Please input the Nth index of the node you want to delete:");
		int N = input.nextInt();
		input.close();
		
		//3rd, remove the Nth node from End
		Head = removeNthFromEnd(Head, N);
		
		//4th, printout the new List
		System.out.println("The Nth node from the end has been removed.");
		printList(Head);
		
		
	}//end main()

	private static ListNode removeNthFromEnd(ListNode head, int n) {
		// TODO remove the Nth node from the End
		if(head==null){
			return null;
		}
		ListNode p = head;
		ListNode q = head;
		for(int i=0; i<n; i++){
			q = q.next;
		}
		
		if(q==null){
			return head.next;
		} //if N = length of the List; return the list without original head;
		
		while(q.next!=null){
			p=p.next;
			q=q.next;
		}
		p.next = p.next.next;
						
		return head;
	}//end removeNthFromEnd() method;

	private static void printList(ListNode head) {
		// TODO printout every node in a linked list
		
		if(head == null){
			System.out.println("There's nothing in the list.");
		}
		
		ListNode p = head;
		while(p!=null){
			System.out.print(" " +p.val);
			p = p.next;
		}
		
		System.out.println();
		
	}//end printList() method;

	private static ListNode buildList(int num) {
		// TODO build a linked list
		if(num == 0){
			return null;
		}
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		for(int i=0; i<num; i++){
			p.next = new ListNode((int)(Math.random()*10));
			p = p.next;
		}//end for i<num loop;
		
		return head.next;
	}//end buildList() method;
	
}//end everything in RemoveNthNodeFromEndofList class
