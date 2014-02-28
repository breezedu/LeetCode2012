package leetCode2012;

import java.util.Arrays;
import java.util.Scanner;

/***************
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Frog
 *
 */

public class FirstMissingPositive {
	
	public static void main(String[] args){
		
		System.out.println("This is a First Miss Positive program.");
		
		//1st, create an array of random integers both positive and negative;
		int[] array = createArray();
		printArray(array);
		
		
		//2nd, check the first missing positive integer missing in the array
		int firstPositive = firstMissingPositive(array);
		System.out.println("The first positive integer missing in the array is: " + firstPositive);
		
	}//end main()

	private static int firstMissingPositive(int[] array) {
		// TODO find out the first positive integer missing in the array.
		
		if(array==null || array.length ==0) return 1;
        
        Arrays.sort(array);
        int index = 0; 
        while(array[index]<=0) {
            index++;
            if(index == array.length) return 1;
        }
        
        if(array[index] != 1) return 1;
        for(int i= index+1; i<array.length; i++){
            
            if(array[i] - array[i-1] > 1) return array[i-1]+1;
        }
        
        return array[array.length-1] +1;
	}

	private static int[] createArray() {
		// TODO create an array of random integers
		
		System.out.println("Please input the num of elements in the array.");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		if(num==0){
			System.out.println("Length == 0, there's nothing to do.");
			return null;
		}
		int[] array = new int[num];
		
		for(int i=0; i<num; i++){
			
			array[i] = (int)(Math.random() * 50 - 25);
		}
		
		return array;
	}//end createArray() method;

	private static void printArray(int[] array) {
		// TODO print out an array
		
		if(array==null || array.length==0) {
			System.out.println("This is an empty array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		System.out.println();
		
	}//end printArray() method;

}//end of everything in FirstMissingPositive class
