package leetCode2012;

import java.util.Scanner;

/*******************
 * Given an array and a value, 
 * remove all instances of that value in place and return the new length.
 * 
 * The order of elements can be changed. 
 * It doesn't matter what you leave beyond the new length.
 * 
 * @author Frog
 *
 */

public class RemoveElement {

	public static void main(String[] args){
		
		System.out.println("This is a Remove Element program.");
		
		//1st, build an array with num elements;
		System.out.println("Please input how many elements in the array:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		int[] array = buildArray(num);
		System.out.println("The array has been built:");
		printArray(array);
		
		//2nd, input the value of elements to remove
		System.out.println("Please input the value of elements to remove from the array:");
		int element = input.nextInt();
		input.close();
		
		//3rd, remove elements equal to the inputed value;
		int newLength = removeElement(array, element);
		
		System.out.print("There are " +newLength +" elements left in the array.");
		
	}//end main();

	private static int removeElement(int[] array, int elem) {
		// TODO remove all elements equal to elem, return the length of array left;
		if(array == null ||array.length==0) return 0;
		
		int Len = array.length;
		int indexEnd = Len-1;
		
		//to make sure the last element does not equal to elem;
		while(array[indexEnd] == elem){
			indexEnd--;
			if(indexEnd<0) return 0;
		}
		if(indexEnd<0) return 0; //if all elements are equal to elem, just return 0;
		
		for(int i=0; i<indexEnd; i++){
			
			if(array[i] == elem){
				array[i] = array[indexEnd]; 
				indexEnd--;
				//not necessary to swap, because we do not need the last element anymore;
				
				while(array[indexEnd] == elem){
					indexEnd--;
					if(indexEnd<0) return 0;
					
				} //end while loop
			}//end if condition;
			
		}//end for i<indexEnd loop;
		
		return indexEnd+1;
	}

	private static void printArray(int[] array) {
		// TODO printout an array
		if(array==null){
			System.out.println("Nothing in the array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
	}//end of printArray() method;

	private static int[] buildArray(int num) {
		// TODO build an array with num elements
		if(num ==0) return null;
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			
			array[i] = (int)(Math.random()*15);
		}
		
		return array;
	}//end buildArray() method;
	
}//end everything in RemoveElement class;
