package leetCode2012;

import java.util.Scanner;

/*************
 * Given an array of non-negative integers, 
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * @author Frog
 *
 */

public class JumpGame {
	
	public static void main(String[] args){
		
		System.out.println("This is a Jump Game program.");
		
		//1st, create an array of random integers.
		int[] array = createArray();
		printArray(array);
		
		//2nd, check if we can jump through the array till the end
		boolean jump = canJump(array);
		
		//3rd, printout the result:
		if(jump){
			System.out.println("We can jump till the end of the array.");
			
		} else {
			System.out.println("No, we cannot jump till the end.");
			
		}
	}//end of main();
	

	private static boolean canJump(int[] array) {
		// TODO check if we can 'jump' through the array till the end
		
		if(array == null) return false;
		if(array.length == 1) return true;
		
		int Len = array.length;
		int next = 0;
		
		for(int i=0; i<Len; ){
			
			if(array[i] == 0) return false; //the jump will just stay there;
			
			next += array[i]; //this is the index of next array[] element;
			if(next >= Len-1) return true;
			
			i = next;
		} //end for i<Len loop;
		
		return false;
	}


	private static int[] createArray() {
		// TODO create an array of random integers
		
		System.out.println("Please input the length of the array:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random() * 5);
		}
		
		return array;
	}//end of createArray() method;


	private static void printArray(int[] array) {
		// TODO Printout an array
		
		if(array == null){
			System.out.println("This is an empty array.");
			return;
		}
		int Len = array.length;
		
		for(int i=0; i<Len; i++){
			System.out.print(" " +array[i]);
		}
		System.out.println();
	}//end of printArray() metho;

}//end of everything in JumpGame class


