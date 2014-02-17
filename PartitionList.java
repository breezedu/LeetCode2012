package leetCode2012;

import java.util.Scanner;

/*******************
 * Given a linked list and a value x, partition it such that 
 * all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes 
 * in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * @author Frog
 *
 */
public class PartitionList {
	
	public static void main(String[] args){
		
		System.out.println("This is a Partition List program.");
		
		//1st, build a linked list of num nodes;
		System.out.println("Please indicate the # of nodes in the list:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		ListNode Head = createList(num);
		System.out.println("The list has been created.");
		printList(Head);
		
		//2nd, input the pivot to partition the original list
		System.out.println("\nPlease input the value to partition the list:");
		int pivot = input.nextInt();
		input.close();
		
		//3rd, partition the list
		Head = partition(Head, pivot);
		printList(Head);
		
	}//end main()

	private static ListNode partition(ListNode head, int pivot) {
		// TODO to partition a linked list
		
		if(head == null){
			return null;
		}
		
		ListNode fHead = new ListNode(0);
		ListNode fp = fHead;
		ListNode aHead = new ListNode(0);
		ListNode ap = aHead;
		
		ListNode p = head;
		while(p!=null){
		//	System.out.println("p=" +p.val);
			if(p.val < pivot){
				fp.next = p;
				fp = fp.next;
					
			} 
			
			if(p.val >= pivot){
				ap.next = p;
				ap = ap.next;
		
			}
			
			p = p.next;
			
		}//end while() loop;
	//	if(aHead.next!=null)
		ap.next=null;
		fp.next = aHead.next;
		
		return fHead.next;
	}//end partition() method;

	private static void printList(ListNode head) {
		// TODO printout a list
		
		if(head==null){
			System.out.println("It's an empty list.");
			return;
		}
		System.out.print("List: " +head.val);
		
		ListNode p = head.next;
		while(p!=null){
			System.out.print("->" + p.val);
			p = p.next;
		}//end while loop;
		
		System.out.println();
	}//end printList() method;

	private static ListNode createList(int num) {
		// TODO Creat a linked list with num nodes
		if(num==0){
			return null;
		}
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		for(int i=0; i<num; i++){
			
			p.next = new ListNode((int)(Math.random()*10));
			p = p.next;
		}
		return head.next;
	}//end createList() method;

}//end everything in PartitionList class
