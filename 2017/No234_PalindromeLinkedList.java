/***********
 * 
 * @author Jeff
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * 	Could you do it in O(n) time and O(1) space?
 * 
 */

public class No234_PalindromeLinkedList {
	
	
	public static void main(String[] args){
		
		//1st, create a linked list; 
		int num = 5;
		ListNode Head = createList(num);
		
		printList(Head); 
		
		boolean palindrome = isPalindrome(Head);

		if(palindrome) {
			System.out.println("The linked list is a Palindrome.");
		
		} else {
			
			System.out.println("The list is NOT a Palindrome.");
		}
		
	}//end main();

	
	
	private static boolean isPalindrome(ListNode head) {
		// TODO Auto-generated method stub

		//2nd, get the middle node in the linked list;
		ListNode mid = getMidNode(head);
		
		//System.out.println("The mid node: " + mid.val);
		//printList(mid);
		
		//3rd, reverse the second half of the linked list
		ListNode revMid = reverseList(mid);
		//printList(revMid);
		
		while(revMid != null){
			if(revMid.val == head.val){
				head = head.next;
				revMid = revMid.next; 
			
			} else {
				return false;
			}
			
		}
		
		return true;
	} 



	/****************
	 * reverse a linked list
	 * @param mid
	 * @return
	 */
	private static ListNode reverseList(ListNode mid) {
		// TODO Auto-generated method stub
		
		ListNode p0 = null; 		//Node pre
		ListNode p1 = mid;			//Node current
		
		while(p1 != null){
			
			ListNode p2 = p1.next; 	//node next
			
			p1.next = p0; 
			p0 = p1;
			
			p1 = p2;		
			}
		
		return p0;
	}




	/*********
	 * If the total number of nodes in the list is even (10), return the n/2th + 1 (6th) node
	 * if the total number of nodes in the list is odd (9), return the (n+1)/2th + 1 (6th) node
	 * 
	 * @param head
	 * @return
	 */
	private static ListNode getMidNode(ListNode head) {
		// TODO Auto-generated method stub
		
		ListNode fast = head; 
		ListNode slow = head; 
		
		if(slow == null) return slow; 
		
		while(fast.next!=null && fast.next.next != null){
			fast = fast.next.next; 
			slow = slow.next; 
		}
		
		return slow.next;
	}





	private static void printList(ListNode head) {
		// TODO Auto-generated method stub
		
		ListNode p = head;
		while(p.next != null){
			System.out.print(p.val + "->");
			p = p.next; 
		}
		
		System.out.println(p.val);
	}




	private static ListNode createList(int num2) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode((int) (Math.random() * 5));
		ListNode p = head; 
		
		for(int i =1; i<num2; i++){
			
			p.next = new ListNode((int) (Math.random()*5));
			
			p = p.next; 
			
		}
		
		return head;
	}
	
	
}//ee
