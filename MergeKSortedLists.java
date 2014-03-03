package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeKSortedLists {
	
	public static void main(String[] args){
		
		System.out.println("This is Merge K Sorted Lists program.");
		
		//1st, build k sorted lists;
		ArrayList<ListNode> listAL = createALLinkedList();
		printALofLists(listAL);
		
		
		//2nd, merge all sorted lists
		ListNode mergedList = mergeKLists(listAL);
		printListNode(mergedList);
		
		
	}//end main()
	

	private static ListNode mergeKLists(ArrayList<ListNode> listAL) {
		// TODO merge k lists
		if(listAL == null || listAL.size()==0){
			return null;
		}
		
		if(listAL.size()==1) return listAL.get(0);
		//end directly return conditions;
		
		ListNode retHead = new ListNode(0);
		ListNode retP = retHead;
		
		int Size = listAL.size();
		ListNode[] p = new ListNode[Size];
		
		//declare an array of listNodes p[i], each pointing to an listNode inthe AL;
		for(int i=0; i<Size; i++){
			p[i] = listAL.get(i);
		}
		
		boolean empty = false;
		while(!empty){
			
			//get the small node from the lists available:
			int index = 0;
			ListNode pMin = null;
			for(int i=0; i<Size; i++){
				//if the pMin==null, get the 1st non-null listNode assigned to pMin;
				if(p[i]!= null && pMin==null){
					pMin = p[i];
					index = i;
				
				} else if(p[i]!=null && p[i].val<pMin.val){
					
					//if the pMin is non-null, only assign listNode with smaller val to pMin;
					pMin = p[i];
					index = i;
				}
				
			}//end for i<Size loop;
			
			retP.next = pMin; 
			
			//in case every list in the AL is null, here p[index] == null.
			if(p[index] == null) return null;
			p[index] = p[index].next;
			
			empty = true;
			for(int i=0; i<Size; i++){
				if(p[i] != null) empty=false;
			}
			
			retP = retP.next;
		//	printListNode(retHead);
		}//end while() loop;
		
		return retHead.next;
	}


	private static void printALofLists(ArrayList<ListNode> listAL) {
		// TODO printout all sorted lists in the ArrayList
		System.out.println("The size of the listAL is " + listAL.size());
		if(listAL.size() == 0) return;
		
		for(ListNode list:listAL){
			printListNode(list);
		}
		
		System.out.println();
	}//end printALofLists() method;
	

	private static void printListNode(ListNode list) {
		// TODO printout a linked list		
		System.out.print("List: ");
		if(list == null){
			System.out.println(" No Nodes. ");
			return;
		}
		
		System.out.print(" " + list.val);		
		ListNode p = list.next;		
		int count = 1;
		while(p!=null){
			
			System.out.print("->" + p.val);
			p = p.next;
			count++;
		}
		
		System.out.println("    (" +count + " nodes)");
	}//end printListNode() method;

	private static ArrayList<ListNode> createALLinkedList() {
		// TODO create an arrayList of linked lists
		System.out.println("Please input the num of lists:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		ArrayList<ListNode> retAL = new ArrayList<ListNode>();
		if(num == 0) {
			return retAL;
		}
		
		for(int i=0; i<num; i++){
			ListNode head = createList();
			retAL.add(head);
		}
		
		return retAL;
	}//end createLinkedList() method;

	private static ListNode createList() {
		// TODO create an sorted linked list of random length (10-20);
		int Len = (int)(Math.random()*10);
		ListNode head = new ListNode(0);
		ListNode p = head;
		int val = 0;
		
		for(int i=0; i<Len; i++){
			val += (int)(Math.random()*10+1);
			p.next = new ListNode(val);
			p = p.next;
		}
		return head.next;
	}//end createList() method;

	
}//end of everything in MergeKSortedList class
