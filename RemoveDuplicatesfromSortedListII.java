package leetCode2012;

import java.util.Scanner;

/**************
 * Given a sorted linked list, 
 * delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @author Frog
 *
 */

public class RemoveDuplicatesfromSortedListII {

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
		Head = deleteDuplicates(Head);
		System.out.println("\nThe duplicated nodes have been removed:");
		printList(Head);
		
	} //end main()

	/*******
	 * build a new list with newHead=new ListNode(0);
	 * create two pointers, newP=newHead.next; oriP=head;
	 * check how many duplicates oriP has after itself in the original list;
	 * if there's no duplicate, let newP.next point to oriP, then move oriP to oriP.next 
	 * otherwise, if there are M duplicates, left oriP move M steps; 
	 * then check duplicates at the new position;
	 * 
	 * if the last few nodes are duplicates, we have to cut the original list before those nodes
	 * @param head
	 * @return newhead.next
	 */
	private static ListNode deleteDuplicates(ListNode head) {
		// TODO Remove duplicated nodes in the lst;
		if(head == null ||head.next==null){
			return head;
		}
		
		ListNode newHead = new ListNode(0);
		ListNode newP = newHead;
		ListNode oriP = head;
		
		while(oriP!=null){
			int duplicate = checkDuplicate(oriP);
			System.out.print(" " + duplicate);
			
			if(duplicate == 0){
				newP.next = oriP;
				oriP = oriP.next;
				newP = newP.next;
				
			} else {
				for(int i=0; i<duplicate+1; i++){
					oriP = oriP.next;
					
					if(oriP == null){
						newP.next = null;
					} //if the last few nodes are duplicates, 
					//we have to cut off the new list before these duplicated nodes;
					
				}//end for i<duplicate+1 loop;
				
			} //end if-else conditions;

		}//end while loop;
		
		return newHead.next;
		
	} //end deleteDuplicates() method;

	private static int checkDuplicate(ListNode oriP) {
		// TODO check out how many duplicates a node has after itself;
		if(oriP.next == null){
			return 0;
		} 
		
		int duplicate = 0;
		ListNode checkP = oriP.next;
		while(checkP != null){
			if(checkP.val != oriP.val){
				break;
				
			} else {
				duplicate++;
				checkP = checkP.next;
				
			}
			
		}// end while loop;
		
		return duplicate;
	} //end checkDuplicate() method;

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
			p.next = new ListNode(p.val + (int)(Math.random()*3));
			p = p.next;
		}
		
		return head;
	} //end buildList() method;
	
} //end everything in RemoveDuplicatesfromSortedList class
