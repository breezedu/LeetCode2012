package leetCode2012;

import java.util.Scanner;

/**************
 * Given a sorted linked list, 
 * delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author Frog
 *
 */

public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args){
		
		System.out.println("This is a Remove Duplicates from Sorted List program.");
		System.out.println("Please indicate how many nodes in the list:");
		//1st, build a sorted linked list of #num nodes;
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		ListNode Head = buildList(num);
		
		//2nd, printout the original list
		System.out.println("The linked list has been built:");
		printList(Head);
		
		//3rd, remove the duplicated nodes
		ListNode newHead = deleteDuplicates(Head);
		System.out.println("\nThe duplicated nodes have been removed:");
		printList(newHead);
		
	} //end main()

	/*******
	 * build a new list with newHead.val = head.val;
	 * create two pointers, p=head.next; np=newHead;
	 * let the p move one be one along the original list;
	 * if p.vla!=np.val add a new node to the new list, np=np.next;
	 * 
	 * @param head
	 * @return newhead
	 */
	private static ListNode deleteDuplicates(ListNode head) {
		// TODO Remove duplicated nodes in the lst;
		if(head == null){
			return head;
		}
		ListNode newhead = new ListNode(head.val);
		ListNode p = head.next;
		ListNode np = newhead;
		
		while(p!=null){
			
			if(p.val!=np.val){
				np.next = new ListNode(p.val);
				np = np.next;
			}
			p = p.next;
			
		} // end while loop;
		
		return newhead;
	} //end deleteDuplicates() method;

	private static void printList(ListNode head) {
		// TODO Printout the linked list
		
		if(head == null){
			System.out.println("There's no node in the list.");
			return;
		}
		System.out.print(head.val);		
		ListNode p = head.next;

		while(p!=null){
			System.out.print(" -> " + p.val);
			p = p.next;
		}
		System.out.println();
		
	} //end printList() method;

	
	private static ListNode buildList(int num) {
		// TODO Build a linked list of #num nodes
		if(num==0){
			return null;
		}
		
		ListNode head = new ListNode((int)(Math.random()*10));
		ListNode p = head;
		for(int i=1; i<num; i++){
			p.next = new ListNode(p.val + (int)(Math.random()*5));
			p = p.next;
		}
		
		return head;
	} //end buildList() method;
	
} //end everything in RemoveDuplicatesfromSortedList class
