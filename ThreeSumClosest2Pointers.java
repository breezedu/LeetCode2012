package leetCode2012;

import java.util.Arrays;
import java.util.Scanner;

import leetCode2012.Stopwatch;

/******************
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Frog
 *
 */
public class ThreeSumClosest2Pointers {
	
	public static void main(String[] args){
		
		System.out.println("This is 3-Sum closest program.");
		
		//1st, create an array of integers
		System.out.println("Please input the num of elements in the array:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		
		int[] array = createArray(num);
	//	int[] array = {79,-82,-37,-93,57,-6,-94,38,94,88,-60,-22,77,-44,-38,0,99,-57,-69,-78,85,78,-3,-5,89,-11,93,42,-9,-74,90,96,54,-91,34,-14,52,96,5,18,93,76,-95,-86,36,-83,65,-80,-63,74,4,-82,12,-78,11,-78,-57,-21,37,87,-32,-64,79,-14,46,-72,75,-6,-63,-71,11,-10,68,85,-3,-9,-72,31,-83,-24,32,45,-82,26,-67,85,10,-78,-92,-14,65,-63,-63,-53,38,-6,-5,42,-35,97,-30,-12,-7,-51,85,26,21,52,48,-62,48,21,86,5,64,56,49,-67,-91,-21,16,25,-1,54,48,0,49,81,16,89,53,40,-44,-58,-91,77,58,77,-10,-74,-11,86,27,27,-84,-23,92,38,35,-3,-6,-99,47,55,71,-82,-34,8,32,-4,17,-52};
		printArray(array);
		
		
		//2nd, ask user to input a target
		System.out.print("target: ");
		int target = input.nextInt();
		input.close();
		
		//3rd, checkout the closest sum to target
		Stopwatch timmer = new Stopwatch();
		int triSum = threeSumClosest(array, target);
		System.out.println("The clostest sum we can get from the array is: " + triSum +" time used:" + timmer.elapsedTime());
		
	}//end main()

	private static int threeSumClosest(int[] array, int target) {
		// TODO calculate the three-sum from the array, return the closest result to target
		int retSum = 0;
		int min = Integer.MAX_VALUE;
		Arrays.sort(array);
		
		for(int i=0; i<array.length; i++){
			int end = array.length-1;
			int j=i+1;
			
			while(j<end){
				
				int sum = array[i] + array[j] + array[end];
				int diff = Math.abs(sum - target);
				if(diff < min) {
					min = diff;
					retSum = sum;
				}
				
				if(sum <= target){
					j++;
				} else {
					end--;
				}
				
			}//end while loop;

		}//end for loop;		
		return retSum;
	}

	private static int[] createArray(int num) {
		// TODO create an array of num elements
		if(num == 0){
			return null;
		}
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random() * 25);
		}
		return array;
	}//end createArray() method;

	private static void printArray(int[] array) {
		// TODO Printout an array
		if(array == null || array.length==0){
			System.out.println("Nothing in the array");
		}
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}//end printArray() method

}//end everything in ThreeSumClosest class
