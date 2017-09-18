/**********************************************
 * 
 * @author Jeff
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * 
 */


public class No237_DeleteNodeinaLinkedList {
	
	
	public static void main(String[] args){
		
		//1st, crate a linked list;
		ListNode first = new ListNode(0); 
		
		ListNode p = first;
		
		//create another 8 list nodes in the linked list;
		for(int i=0; i<9; i++){
			p.next = new ListNode( (int)(Math.random()*100) );
			p = p.next;
		}
		
		System.out.println("Print out the original linked list: ");
		printListNodes(first); 
		
		//2nd, select a random ListNode in the linked list; 
		int pivot = (int)(Math.random()*10);
		
		ListNode removeNode = first;
		for(int i = 1; i<pivot; i++){
			removeNode = removeNode.next; 
		}
		System.out.println("\n To be removed ListNode: " + removeNode.val);
		
		
		//3rd, remove the target ListNode;
		deleteNode(removeNode);
		
		printListNodes(first); 
		
		
	}//end main();

	private static void deleteNode(ListNode removeNode) {
		// TODO Auto-generated method stub
		
		removeNode.val = removeNode.next.val;
		removeNode.next = removeNode.next.next; 
		
	} //end of deleteNode() method; 

	private static void printListNodes(ListNode head) {
		// TODO Auto-generated method stub
		
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