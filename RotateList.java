package leetCode2012;

import java.util.Scanner;

/*******************
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * @author Frog
 *
 */


public class RotateList {

	public static void main(String[] args){
		
		System.out.println("This is a Rotate List program.");
		
		//1st, build an linked list with num nodes;
		System.out.println("Please indicate how many nodes in the list:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		ListNode head = buildList(num);
		System.out.println("The linked list has been built:");
		printList(head);
		
		//2nd, input the index of rotate point;
		System.out.println("Now please input the rotate point:");
		int rotatePoint = input.nextInt();
		input.close();
		
		//3rd, rotate the linked list;
		head = rotateRight(head, rotatePoint);
		
		//4th, after rotation, check out the output:
		printList(head);
		
	}//end of main();

	private static ListNode rotateRight(ListNode head, int rotate) {
		// TODO rotate the right part of Node at rotate to the left side
		if(head==null || rotate==0 || head.next ==null){
			return head;
		}
		
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode p1 = newHead;
		ListNode p2 = p1;
		for(int i=0; i<rotate; i++){
			
			p2 = p2.next;
			
			if(p2 == null){
				p2 = newHead.next;
			} //in case rotate > list.length, let p2 point to the head again.
			
		}//end for i<rotate loop;
		
		while(p2.next!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		ListNode retHead = p1.next;
		p1.next = null;
		p2.next = newHead.next;
		
		
		return retHead;
	}//end rotateRight() method;

	private static void printList(ListNode head) {
		// TODO printout a linked list;
		if(head==null){
			System.out.println("Nothing in the list.");
			return;
		}
		
		System.out.print("List: " +head.val);
		
		ListNode p = head.next;
		while(p!=null){
			System.out.print("->" +p.val);
			p = p.next;
		}
		
		System.out.println("=>>End");
		
	}//end of printList() method;

	private static ListNode buildList(int num) {
		// TODO build a linked list of num nodes
		if(num==0){
			return null;
		}
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		for(int i=0; i<num; i++){
			
			p.next = new ListNode((int)(Math.random()*15));
			p = p.next;
		}
		
		return head.next;
	}//end buildList() method;
	
}//end of everything in RotateList class
