package leetCode2012;

import java.util.Scanner;

/******************
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 * 
 * @author Frog
 *
 */
public class SwapNodesinPairs {

	public static void main(String[] args){
		
		System.out.println("This is a SwapNodesinPairs program.");
		
		//1st, create a linked list;
		ListNode head = creatList();
		printList(head);
		
		//2nd, swap node-pairs:
		ListNode newHead = swapPairs(head);
		System.out.println("After swap pairs: ");
		printList(newHead);
		
		
	}//end main();

	private static ListNode swapPairs(ListNode head) {
		// TODO swap pairs
		if(head == null || head.next==null) return head;
		
		ListNode newHead = new ListNode(0);
		ListNode pNew = newHead;
		
		ListNode p = head;
		
		
		while(p.next!=null && p.next.next!=null){
			ListNode q = p.next;
			
			pNew.next = q;
			p.next = q.next;
			q.next = p;
			
			pNew = pNew.next.next;
			p = p.next;
			
		}
		
		if(p.next!=null){
			pNew.next = p.next;
			p.next = null;
			pNew = pNew.next;
			pNew.next = p;
		}
		System.out.print("p.val=" + p.val +".. ");
		
		return newHead.next;
		
	}//end swapPairs() method;

	private static void printList(ListNode head) {
		// TODO Printout a linked list
		
		if(head == null){
			System.out.println("It's an empty list.");
			return;
		}
		
		System.out.print("List: " + head.val);
		ListNode p = head;
		
		while(p.next!=null){
			p = p.next;
			System.out.print("->" + p.val);
		}
		
		System.out.println();
		
	}//end printList() method;

	private static ListNode creatList() {
		// TODO creat a linked list of num nodes
		
		System.out.println("Please indicate how many nodes are there in the list:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		for(int i=0; i<num; i++){
			p.next = new ListNode((int)(Math.random()*25));
			p = p.next;
		}
		
		return head.next;
	}// end creatList() method;
	
	
}//end of everything in SwapNodesinPairs class
