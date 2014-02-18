package leetCode2012;

import java.util.Scanner;

/*******************
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author Frog
 *
 */
public class MergeTwoSortedLists {

	
	public static void main(String[] args){
		
		System.out.println("This is a Merge Two Sorted Lists program.");
		
		//1st, build two sorted lists
		System.out.println("Please input the number of nodes each list has:");
		System.out.println("num1= ");
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		
		System.out.println("num2= ");
		int num2 = input.nextInt();
		input.close();
		
		ListNode head1 = buildSortedList(num1);
		ListNode head2 = buildSortedList(num2);
		
		//2nd, print out the two linked lists:
		System.out.print("List1: ");
		printList(head1);
		
		System.out.print("List2: ");
		printList(head2);
		
		//3rd, merge two lists:
		ListNode head = mergeTwoLists(head1, head2);
		
		//4th, printout the new list after merging;
		printList(head);
		
	}//end main();

	private static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		// TODO merge two sorted list into one
		if(head1==null && head2==null){
			return null;
		
		} else if(head1==null && head2!=null){
			return head2;
			
		} else if(head1!=null && head2==null){
			return head1;
			
		} //end direct return if-else conditions;
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		ListNode p1 = head1;
		ListNode p2 = head2;
		
		while(p1!=null && p2!=null){
						
			if(p1.val > p2.val){
				p.next = p2;
				p2 = p2.next;
				p = p.next;
				
			} else {
				p.next = p1;
				p1 = p1.next;
				p = p.next;
				
			}
			
		} //end while loop, at least one of the pointers reached end;
	
			while(p2!=null){
				p.next = p2;
				p2 = p2.next;
				p = p.next;
			}
		
			while(p1!=null){
				p.next = p1;
				p1 = p1.next;
				p = p.next;
			}

		return head.next;
	}//end mergeTwoList() method;

	private static void printList(ListNode head) {
		// TODO print out a linked list
		if(head==null){
			System.out.println("Nothing in the list.");
			return;
		}
		
		System.out.print(" " +head.val);
		ListNode p = head.next;
		while(p!=null){
			
			System.out.print("->"+p.val);
			p = p.next;
		}
		
		System.out.println("==>NULL");
	}//end printList() method;

	private static ListNode buildSortedList(int num) {
		// TODO build a sorted linked list;
		
		if(num==0){
			return null;
		}
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		int val = head.val;
		for(int i=0; i<num; i++){
			val += (int)(Math.random()*10);
			p.next = new ListNode(val);
			p = p.next;
		}
		
		return head.next;
		
	}//end buildSortedList() method;
}//end everything in MergeTwoSortedLists class
