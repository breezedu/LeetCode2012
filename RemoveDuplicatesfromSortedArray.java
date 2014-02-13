package leetCode2012;

import java.util.Scanner;

/*********
 * Given a sorted array, 
 * remove the duplicates in place such that each element appear only once 
 * and return the new length.
 * 
 * Do not allocate extra space for another array, 
 * you must do this in place with constant memory. 
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 *  
 * @author Frog
 *
 */
public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args){
		
		System.out.println("This is a Remove Duplicates from Sorted Array program.");
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

	private static int removeDuplicates(int[] array) {
		// TODO Remove duplicated elements
		int Len = array.length;
		if(Len < 2){
			return Len;
		}
		
		int oriIndex =1;
		int newIndex =0;
		int newLen = 1;
		
		while(oriIndex<Len){
			
			if(array[oriIndex] == array[newIndex]){
				oriIndex++;
			
			} else {
				
				newIndex++;
				array[newIndex] = array[oriIndex];
				oriIndex++;
				newLen ++;
			}
					
		}
		System.out.println("There are " + newLen +" nodes left.");
		return newLen;
	}

	private static void printArray(int[] array) {
		// TODO Printout the array
		
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
			array[i] = array[i-1] + (int)(Math.random()*5);
		}
		
		return array;
	}
	
	
} // end everything in RemoveDuplicatesfromSortedArray;
