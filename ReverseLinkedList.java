package leetCode2012;

import java.util.Scanner;

/**************
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL,
 * return 5->4->3->2->1->NULL;
 * 
 * @author Frog
 *
 */
public class ReverseLinkedList {
	
	public static void main(String[] args){
		
		System.out.println("This is a Reverse Linked List program.");
		
		//1st, build a linked list;
		System.out.println("Please input how many nodes in the list:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		ListNode Head = buildList(num);
		System.out.println("The linked list has been built:");
		printList(Head);
		
		//2nd, reverse the list;
		Head = reverseList(Head);
		System.out.println("After reverse:");
		printList(Head);
		
	}//end main();

	/***************
	 * use a pair of pointers: p1=head and p2=p1.next;
	 * create an empty list newList=null;
	 * at the very beginning, break p1 from original list, let p1.next link to the new list;
	 * thus, we got a newList with only 1 node of head and head.next = null;
	 * 
	 * let p1 point to p2, and the p2=p1.next;
	 * break p1 from the original list; 
	 * let p1.next point to the head of the new list: p1.next p1->head;
	 * and let p1 point to p2, and p2=p2.next;
	 * 
	 * as the traversal goes on, the p1 will reach the last node of original list;
	 * let p1.next point to the head of the new list; END of traversal :)
	 * return p1 as the head of new list;
	 * 
	 * @param head
	 * @return
	 */
	private static ListNode reverseList(ListNode head) {
		// TODO reverse the list
		if(head==null || head.next==null) return head;
		
		ListNode p1 = head;
		ListNode tempOri = null;
			
		while(p1.next!=null){
			
			ListNode p2 = p1.next; //remember the next node of p1;
			
			//break p1 and it's following nodes; 
			//let p1 point to the head of reversed list;			
			p1.next = tempOri; 			
			//the let tempOri point to the head of newly built list;
			tempOri = p1;
			
			p1 = p2;
			p2 = p2.next;
			
		}//end while loop;
		
		p1.next = tempOri; //let the last node in the original list point to the head of newly built list; 
						
		return p1;
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
