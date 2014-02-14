package leetCode2012;

import java.util.Scanner;

/*********
 * Given a sorted array, 
 * remove the duplicates in place such that leave only elements appear only once 
 * and return the new length.
 * 
 * Do not allocate extra space for another array, 
 * you must do this in place with constant memory. 
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [2].
 *  
 * @author Frog
 *
 */
public class RemoveDuplicatesfromSortedArrayII2 {

	public static void main(String[] args){
		
		System.out.println("This is a Remove 3+ Duplicates from Sorted Array program.");
		System.out.println("Please input how many elements in the original array:");
		
		//1st, build an array of ascending order
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		int[] oriArray = buildArray(num);
		System.out.println("The original array has been built:");
		printArray(oriArray);
		
		//2nd, remove duplicates with using extra memory space
		int newLen = removeDuplicates(oriArray);
		
		System.out.println("After removing duplicated elements:");
		for(int i=0; i<newLen; i++){
			System.out.print(" " + oriArray[i]);
		}
		
	}//end main();

	/*******************
	 * traverse the array, when original Index points to array[m] call checkDuplicates 
	 * to check how many (x) duplicated nodes in the array, because the array is sorted
	 * the index pointer could just x nodes directly to a 'fresh' node
	 * if there's no duplicate of array[m], then add the array[m] to the new array, count++
	 * if there are x (x>2) duplicates of array[m], just add two of them to the new array, 
	 * then 'jump' x steps for original Index;
	 * 
	 * @param array
	 * @return
	 */
	private static int removeDuplicates(int[] array) {
		// TODO Remove duplicated elements
		if(array==null){
			return 0;
		}
		
		int Len = array.length;
		if(Len < 2){
			return Len;
		}
		
		int newIndex =0;
		int oriIndex =0;
		//int newLen = 0;
		while(oriIndex<Len){
			System.out.print(" (" + oriIndex +")");
			int duplicate = checkDuplicate(array, oriIndex);
			
			if(duplicate > 1){
				array[newIndex] = array[oriIndex];
				array[newIndex+1] = array[oriIndex+1];
				newIndex += 2;
				
				oriIndex += duplicate+1;
				
			} else {
				array[newIndex] = array[oriIndex];
				newIndex++;	
				oriIndex++;
				
			} 
			
		} //end for oriIndex<Len loop;
		
		System.out.println("\nThere are " + newIndex +" nodes left.");
		return newIndex;
		
	}//end removeDuplicates() method

	private static int checkDuplicate(int[] array, int m) {
		// TODO check how many elements after array[m] are the same;
		if(m == array.length-1){
			return 0;
		}
		
		int duplicate =0;
		for(int i=m+1; i<array.length; i++){
			if(array[i]!=array[m]){
				break;
			
			} else {
				duplicate++;
				
			}
		}
		return duplicate;
	} //end checkDuplicate() method;

	private static void printArray(int[] array) {
		// TODO Printout the array
		if(array==null){
		//	System.out.println("There's nothing in the array.");
			return;
		}
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		System.out.println();
		
	} // end printArray() method;

	private static int[] buildArray(int num) {
		// TODO Build an array of ascending order;
		if(num == 0){
			return null;
		}
		int[] array = new int[num];
		array[0] = (int)(Math.random()*10);
		
		for(int i=1; i<num; i++){
			array[i] = array[i-1] + (int)(Math.random()*2);
		}
		
		return array;
	}
	
	
} // end everything in RemoveDuplicatesfromSortedArray;
