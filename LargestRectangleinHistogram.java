package leetCode2012;

import java.util.Scanner;
import java.util.Stack;

/******************
 * Given n non-negative integers representing the histogram's bar height 
 * where the width of each bar is 1,  * find the area of largest rectangle in the histogram.
 * 
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * @author Frog
 *
 *This program works ok except for extreme input data like 0,1,2,3,.....30000; 
 */
public class LargestRectangleinHistogram {

	public static void main(String[] args){
		
		System.out.println("This is Largest Rectangle in Histogram program.");
		
		//1st, create an array of heights
		int[] height = createArray();
		printArray(height);
		
		
		//2nd, calculate the maximum rectangle in the area;
		Stopwatch timmer = new Stopwatch();
		int maxRec = largestRectangleArea(height);
		System.out.println("The largest rectangle's area is: " + maxRec +", time uses: " + timmer.elapsedTime());
		
	}//end main()

	private static int largestRectangleArea(int[] height) {
		// TODO Calculate the largest rectangle in the area;
		if(height == null || height.length==0) return 0;
		if(height.length == 1) return height[0];
		
		Stack<Integer> areaStc = new Stack<Integer>();
		areaStc.push(0);
		
		divideCalculate(height, 0, height.length-1, areaStc);
	
		return areaStc.pop();
	}

	private static void divideCalculate(int[] height, int start, int end, Stack<Integer> areaStc) {
		// TODO Auto-generated method stub
	//	System.out.println("start " + start +" end " + end);
		
		if(start > end || start>=height.length-1) {
			return;
		}
		if(start == end){
			areaStc.push( Math.max(areaStc.pop(), height[start]) );
		}
		
		int minH = height[start];
		int minP = start;
		for(int i= start; i<=end; i++){
			if(height[i] < minH){
				minH = height[i];
				minP = i;
			}
			
		}
		
		int tempArea = minH * (end-start+1);
	//	System.out.println("tempA " + tempArea);
		
		areaStc.push(Math.max(areaStc.pop(), tempArea));
		
		if(minP == start){
			divideCalculate(height, minP+1, end, areaStc);
			
		} else if (minP == end){
			divideCalculate(height, start, minP-1, areaStc);
			
		} else {
				
			divideCalculate(height, minP+1, end, areaStc);
			divideCalculate(height, start, minP-1, areaStc);
		}
		
		//return area;
	}//end of divideCalculate() method;

	private static void printArray(int[] array) {
		// TODO printout an array
		if(array == null){
			System.out.println("It's an empty array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}//end printArray() method;

	private static int[] createArray() {
		// TODO create an array of heights
		System.out.println("Please input how many bars are there in the histogram:");
		Scanner input = new Scanner(System.in);
		System.out.print("bars : ");
		int num = input.nextInt();
		input.close();
		
		if(num == 0){
			System.out.println("no bar in the historam.");
			return null;
			
		}
		
		int[] bars = new int[num];
		for(int i=0; i<num; i++){
			
			bars[i] = i; // (int)(Math.random()*10 + 1);
		}
		return bars;
	}//end createArray() method;
	
}//end of everything in LargestRectangleinHistogram class
