package leetCode2012;

import java.util.Scanner;

/************
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * @author Frog
 * Divide and Conquer!
 */
public class MaximumSubarray {
	
	public static void main(String[] args){
		
		System.out.println("This is Maximum Sub-Array program.");
		
		//1st, create an array with positive and negative numbers
		int[] array = createArray();
		printArray(array);
		
		//2nd, check the longest sub-array
		int maxSubArray = maxSubArray(array);
		System.out.println("The maximum sub-array sum up to: " + maxSubArray);
		
	}//end main();

	/**************
	 * divide and conquer :) 
	 * if the length is less than 100, just calculate with Bruce-force method;
	 * if the length is longer, divide the array into 3 parts: left, right and middle;
	 * 1st, calculate maxLeft with Bruce force;
	 * 2nd, calculate the maxRight with Bruce force;
	 * 3rd, calculate the maxMid, with liner running time;
	 * 
	 * @param array
	 * @return
	 */
	private static int maxSubArray(int[] array) {
		// TODO Divide and Conquer
		if(array==null) return 0;
		if(array.length<100){
			int max = array[0];
			int Len = array.length;
			
			for(int i=0; i<Len; i++){
				int sum = 0;
				for(int j=i; j<Len; j++){
					sum += array[j];
					if(sum > max) max = sum;
				}
			}
			
			return max;
		}//end if Len<100 condition;
		
		//if array.length>=100;
		int low = 0;
		int hight = array.length-1;
		int mid = hight/2;
		
		//get maxLeft;
		int maxLeft = array[low];
				
		for(int i=low; i<=mid; i++){
			int sum = 0;
			for(int j=i; j<=mid; j++){
				sum += array[j];
				if(sum > maxLeft) maxLeft = sum;
			}
		}
				
		//got maxRight;
		int maxRight = array[mid];
		int Len = array.length;
		
		for(int i=mid; i<Len; i++){
			int sum = 0;
			for(int j=i; j<Len; j++){
				sum += array[j];
				if(sum > maxRight) maxRight = sum;
			}
		}
		
		//the the max-across mid;
		int maxMidR = 0;
		int sumR = 0;
		for(int i=mid+1; i<Len; i++){
			
			sumR += array[i];
			if(sumR > maxMidR) maxMidR = sumR;
		}
		
		int sumL = 0;
		int maxMidL=0;
		for(int i=mid-1; i>=0; i--){
			
			sumL += array[i];
			if(sumL > maxMidL) maxMidL = sumL;
		}
		
		int maxMid = maxMidR + maxMidL + array[mid];		
		
		return maxOfThree(maxRight, maxLeft, maxMid);
	}

	private static int maxOfThree(int m, int n, int o) {
		// TODO pick the max interger of three
		
		int max = m;
		if(n>max) max = n;
		if(o>max) max = o;
		return max;
	}

	private static void printArray(int[] array) {
		// TODO Printout an array
		
		if(array == null){
			System.out.println("Nothing in the array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
	}//end printArray() method;

	private static int[] createArray() {
		// TODO create an array with both positive and negative numbers
		System.out.println("Please input the length of the array:");
		System.out.print("Length = ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		if(num==0){
			System.out.println("That's an empty array.");
			return null;
		}
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*10 -20);
		}
		
		return array;
	}
}//end everything in MaximumSubarray class
