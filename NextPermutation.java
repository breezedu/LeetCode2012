package leetCode2012;

import java.util.Arrays;
import java.util.Scanner;

/******************
 * Implement next permutation, which rearranges numbers 
 * into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order 
 * (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and 
 * its corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 ¡ú 1,3,2
 * 3,2,1 ¡ú 1,2,3
 * 1,1,5 ¡ú 1,5,1
 * 
 * @author Frog
 *
 */

public class NextPermutation {

	public static void main(String[] args){
		
		System.out.println("This is Next Permutation program.");
		
		//1st, create an array of num elements;
		int[] array = createArray();
		//int[] array = {4,2,0,2,3,2,0};
		//int[] array = {2, 3, 1};
		printArray(array);
		
		
		//2nd, take the array as an permutation arrange; calculate the next permutation;
		nextPermutation(array);
		System.out.println("After the NextPermutation operation.");
		printArray(array);
		
		
	}//end main();

	/***********
	 * from the end index i to the front index j, find out the first pair
	 * array[j] < array[i], check the right part of index i, if any element at k
	 * array[k] > array[j]: swap array[j] and array[k]; and sort the right part of k;
	 * 
	 * if no such pair exist, swap the whole array back forward;
	 * @param array
	 */
	private static void nextPermutation(int[] array) {
		// TODO get the 'next' permutation of the original array
		if(array == null || array.length==1) return;
		
		int Len = array.length;
		int sortIndex = 0; //at this point the array needs reverse;
		
		for(int i=Len-1; i>0; i--){			
			int j = i-1;
			if(array[i] > array[j]){
					
				for(int k=array.length-1; k>j; k--){
						
					if(array[k] > array[j]){
						swap(array, k, j);
						sortIndex = i;
						k=j=i=0; //jump out of both for loop;
					}
				}//end for k>j loop;				
					
			}//end if array[i]>array[j] condition;

		}//end outer for i>0 loop;
		
		//last step, sort the array from index[k] to the end;
		Arrays.sort(array, sortIndex, array.length);
		
	}//end nextPermutation() method;

	private static void swap(int[] array, int i, int j) {
		// TODO swap two elements in an array
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}//end swap() method;


	private static int[] createArray(){
		// TODO create an array
		System.out.println("PLease input the num of elements in the array.");
		Scanner input = new Scanner(System.in);
		System.out.print(" num = ");
		int num = input.nextInt();
		input.close();
		
		if(num == 0) return null;
		
		int[] array = new int[num];
		
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*10);
		}
		
		return array;
	}//end createArray() method;
	
	
	private static void printArray(int[] array) {
		// TODO Printout an array
		if(array == null){
			System.out.println("It's an empty array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
	}//end of printArray() method;
	
	
}//end of everything in NextPermutation class
