package leetCode2012;

import java.util.Scanner;

/****************
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author Frog
 *
 */
public class TrappingRainWater {
	
	public static void main(String[] args){
		
		System.out.println("This is Trapping Rain Water program.");
		
		//1st, create an array of non-negative integers
		int[] array = createArray();
		printArray(array);
		
		
		//2nd, calculate the capability of trapping water
		int trapWater = trap(array);
		System.out.println("The capability of the array to trap water is: " + trapWater);
		
	}//end main();

	private static int trap(int[] array) {
		// TODO calculate the trapping capability of an array:
		if(array.length<3) return 0;
		int Len = array.length;
		
		int area = checkPeaks(array, 0, Len-1);
		
		return area;
	}

	private static int checkPeaks(int[] array, int start, int end) {
		
		// TODO Auto-generated method stub
		if(start >= end) return 0;
		
		while(array[start] < array[start+1]){
			start++;
			if(start >= end) return 0;
		}
		
		int pivot = start;
		while(array[pivot] > array[pivot+1]){
			pivot++;
			if(pivot >=end) return 0;
			
		}
		
		int volum = 0;
		
		int stop = pivot +1; if(stop >end) return 0;
		int maxHigh = array[stop];
		
		for(int i=stop; i<=end; i++){
			if(array[i] > array[start]){
				stop = i;
				break;
			}
			if(array[i] > maxHigh){
				maxHigh = array[i];
				stop = i;
			}
		}
		System.out.println("start " + start +", end " +end);
		
		volum = calculateArea(array, start, stop);
		
		volum += checkPeaks(array, stop, end);
		
		return volum;

	}

	private static int calculateArea(int[] array, int start, int end) {
		// TODO calculate area between two peaks
		int area = 0;
		System.out.println("array[" + start +"], array[" +end +"] ");
		
		if(array[end] >= array[start]){
			for(int i= start+1; i<end; i++){
				area += array[start] -array[i];
			}
		}
		
		if(array[end] < array[start]){
			int temp = start;
			while(array[temp] > array[end]){
				temp++;
			}
			
			for(int i=temp; i<end; i++){
				area += array[end] - array[i];
			}
		}
		
		return area;
	}//end calculateArea() method;

	private static int[] createArray() {
		// TODO create an array of non-negative integers
		System.out.println("Please input the num of elements in the array.");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		if(num == 0){
			return null;
		}
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*25);
		}
		return array;
	}//end createArray() method;

	private static void printArray(int[] array) {
		// TODO printout an array
		
		if(array == null || array.length==0){
			System.out.println("This is an empty array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " +array[i]);
		}
		
		System.out.println();
	}//end printArray() method;

}//end of everything in TrappingRainWater class
