package leetCode2012;

import java.util.Scanner;

public class TEST0216 {
	
	public static void main(String[] args){
		
		System.out.println("This is a test program of recover a sorted array with 2 elements missplaced.");
		//1st, build an array
		Scanner input = new Scanner(System.in);
		System.out.println("Please input how many elements in the array:");
		
		int num = input.nextInt();
		int[] array = buildArray(num);
		printArray(array);
		
		//2nd swap two elements at index m and n;
		System.out.println("Please input two indices to swap. \n m= ");
		int m = input.nextInt();
		
		System.out.println("n= ");
		int n = input.nextInt();
		input.close();
		
		swapArray(array, m, n);
		System.out.println("After swap two elements at "+ m +" and " + n +". ");
		printArray(array);
		
		//3rd, check invalid points, then swap them back;
		System.out.println();
		checkInvalidPoints(array);
		
		//4th, printout the final array;
		printArray(array);
		
	} // end main();

	private static void checkInvalidPoints(int[] array) {
		// TODO Auto-generated method stub
		int index1 = 0, index2 = 0;
		int count=0;
		
		int Len = array.length;
		for(int i=1; i<Len; i++){
			if(array[i] <= array[i-1]){
				count++;
				if(count==1) index1 =i-1;
				if(count==2) index2 =i;
			}
		}
		
		System.out.println("We get two invalid points: " + index1 +", " +index2);
		System.out.println("Now swap them back: ");
		swapArray(array, index1, index2);
		
	}

	private static void swapArray(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}

	private static void printArray(int[] array) {
		// TODO Auto-generated method stub
		if(array==null) return;
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " +array[i]);
		}
		
		System.out.println();
	}//end printArray() method;

	private static int[] buildArray(int num) {
		// TODO Auto-generated method stub
		int[] array = new int[num];
		
		array[0] = (int)(Math.random() *10);
		for(int i=1; i<num; i++){
			array[i] = array[i-1] + (int)(Math.random()*10+1);
		}
		return array;
	}

}
