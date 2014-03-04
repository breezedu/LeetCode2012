package leetCode2012;

import java.util.Scanner;

/*******************
 * Given a linked list, reverse the nodes of a linked list k at a time
 * and return its modified list.
 * If the number of nodes is not a multiple of k 
 * then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author Frog
 *
 */
public class ReverseNodesinkGroup {
	
	public static void main(String[] args){
		
		System.out.println("This is Reverse Nodes in K Group program.");
		
		//1st, create a linked list with num nodes;
		System.out.println("Please input the num of nodes in the list:");
		Scanner input = new Scanner(System.in);
		System.out.print(" num = ");
		int num = input.nextInt();
		
		ListNode head = createList(num);
		printList(head);
		
		
		//2nd, ask user to input k, then reverse k-nodes
		System.out.println("Please input k, the num of nodes to reverse.");
		System.out.print(" k = ");
		int k = input.nextInt();
		input.close();
		
		ListNode revHead = reverseKGroup(head, k);
		printList(revHead);
		
	}//end main();

	/***************
	 * cut the original list into two section, 1-node(k) and node(k+1)-end;
	 * reverse the first section; then recursion the same operation to the second section;
	 * link two parts together;
	 * @param head
	 * @param k
	 * @return
	 */
	private static ListNode reverseKGroup(ListNode head, int k) {
		// TODO Auto-generated method stub
		if(k==1 || head==null) return head;
		
		ListNode newHead = new ListNode(0); //the newHead to be returned;
		ListNode p = newHead;
		
		//declare three pointers;
		ListNode startP = head;
		ListNode endP = head;
		ListNode nextP = head;
		
		//get the a section of list with length k;
		for(int i=1; i<k; i++){
			endP = endP.next;
			if(endP == null) return head;
		}
		nextP = endP.next;
		endP.next = null;
				
		//reverse the whole startP-->endP list;
		ListNode revP = reverseList(startP);
		p.next = revP;
		
		//recursion, if the left parts is not null;
		if(nextP!=null){
			
			while(p.next!=null){
				p = p.next;
			}
			
			p.next = reverseKGroup(nextP, k);
		}
		
		//return the new list;
		return newHead.next;
	}

	/*************
	 * dismiss the first node from original list; and put the dismissed node
	 * as the head of the newly built list;
	 * @param head
	 * @return
	 */
	private static ListNode reverseList(ListNode head) {
	//	System.out.println("reverse list" + head.val);
		// TODO reverse a list
		ListNode p1 = head;		
		ListNode newHead = null;
		
		while(p1.next!=null){
			ListNode p2 = p1.next;			
			p1.next = newHead;
			newHead = p1;
			
			p1 = p2;
			p2 = p1.next;
		}//p1 pointing to the original last node while newHead pointing to the newly formed
		
		p1.next = newHead;	//finally let p1 pointing to the new head of the list;
		
		return p1; 
	}//end reverse a whole partial linked list;

	private static void printList(ListNode head) {
		// TODO printout a linked list
		
		if(head == null){
			System.out.println(" the list is a null.");
			return;
		}
		System.out.print("List: " +head.val);
		ListNode p = head.next;
		
		while(p!=null){
			System.out.print("->" + p.val);
			p = p.next;
		}
		
		System.out.println();
	}//end printList() method;

	private static ListNode createList(int num) {
		// TODO create a linked list, with num nodes;		
		if(num == 0) return null;
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		for(int i=0; i<num; i++){
			p.next = new ListNode((int)(Math.random() * 25));
			p = p.next;
		}
		
		return head.next;
	}//end createList() method;

}//end of everything in ReverseNodesinKGroup class
