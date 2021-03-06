/**********************************************
 * 
 * @author Jeff
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * 	Example
 * 	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6	
 * 	Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 */


public class No203_RemoveNodeinaLinkedListElements {
	
	
	public static void main(String[] args){
		
		//1st, crate a linked list;
		int num = 1;
		ListNode head = createList(num);
		
		System.out.println("Print out the original linked list: ");
		printListNodes(head); 
		
		//2nd, select a random ListNode in the linked list; 
		int pivot = (int)(Math.random()*5);
		System.out.println("remove va = " + pivot );
				
		
		//3rd, remove the target ListNode;
		head = removeElements(head, pivot);
		
		printListNodes(head); 
		
		
	}//end main();

	private static ListNode createList(int num) {
		// TODO Auto-generated method stub
		if(num == 0)	return null; 
		
		ListNode head = new ListNode(0); 
		
		ListNode p = head;
		
		//create another 8 list nodes in the linked list;
		for(int i=0; i<num-1; i++){
			p.next = new ListNode( (int)(Math.random()*5) );
			p = p.next;
		}
		return head;
	}

	private static ListNode removeElements(ListNode head, int val) {
		// TODO Auto-generated method stub
		if(head == null) return head;
		
		while(head.val == val && head.next!=null){
			head = head.next; 
		}
		
		if(head.val == val) return null;
		
		ListNode p = head; 
		ListNode p_next = p.next;
		
		while(p_next!= null){
			if(p_next.val == val){
				
				p_next = p_next.next;
				p.next = p_next;
			
			} else {
				
				p = p_next;
				p_next = p_next.next; 
			}
		} //end while
		
		//the last item
		if(p.val == val){
			p = null;
		}
		
		return head;
	}//end removeElements() method; 

	private static void printListNodes(ListNode head) {
		// TODO Auto-generated method stub
		if(head == null) {
			System.out.println("It's a NULL list");
			return;
		}
		ListNode p = head;
		
		while(p.next!=null){
			
			System.out.print(p.val + "->");
			p = p.next;
		}
		
		System.out.println(p.val);
	}
		
}




/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */