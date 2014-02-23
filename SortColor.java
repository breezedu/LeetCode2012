package leetCode2012;

import java.util.Scanner;

/*********
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color 
 * red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * @author Frog
 *
 */
public class SortColor {
	
	public static void main(String[] args){
		
		System.out.println("This is Sort Color program.");
		
		//1st, create an array of 0, 1 and 2s;
		int[] array = createArray();
		//int[] array = {2, 1, 1, 0};
		printArray(array);
		
		//2nd, sort the array (take 0, 1 and 2 as colors instead of integers
		sortColors(array);
		System.out.println("After sorting: ");
		printArray(array);
		
		
	}//end main();

	private static void sortColors(int[] array) {
		// TODO sort an array of colors
		if(array==null || array.length==1){
			return;
		}
		
		int Len = array.length;
		int pRed = 0; 
		int pBlue = Len-1;
		
		while(array[pRed]==0){
			pRed++;
			if(pRed==Len-1) return;
		}
		
		while(array[pBlue]==2){
			pBlue--;
			if(pBlue==0) return;
		}
		
		if(array[pRed]<array[pBlue]){
			swap(array, pRed, pBlue);
		}
		
		int p = pRed;
		while(p <= pBlue){
			System.out.print(" (" + p +", " +pRed +", " +pBlue+")");
			printArray(array);
			
			if(array[p] == 1){
			    p++;
			    
			} else if(array[p] == 0){
				
				swap(array, p, pRed);
				pRed++;
				
			} else if(array[p] == 2){
				
				swap(array, p, pBlue);
				pBlue--;
			}
			
			if(p<pRed) p = pRed;
			if(pRed>=pBlue) return;
									
		}//end while p<pBlue loop;
	}

	private static void swap(int[] array, int p, int q) {
		// TODO swap two elements in an array
		int temp = array[p];
		array[p] = array[q];
		array[q] = temp;
		
	}//end swap() method;

	private static void printArray(int[] array) {
		// TODO Printout an array
		
		if(array==null){
			System.out.println("It's an empty array, nothing to print.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		System.out.println();
		
	}//end printArray() method;

	private static int[] createArray() {
		// TODO create an array of 0, 1 and 2s
		
		System.out.println("Please input the length of array:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		if(num==0){
			System.out.println("That is an empty array.");
			return null;
		}
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*3);
		}
				
		return array;
	}//end createArray() method;
}//end of everything in SortColor class
