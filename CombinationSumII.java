package leetCode2012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/******************
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. 
 * (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * 
 * @author Frog
 *
 */

public class CombinationSumII {

	public static void main(String[] args){
		
		System.out.println("This is Combination Sum I program.");
		
		//1st, create an array of random integers;
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the num of elements in the array:");
		System.out.println("num = ");
		int num = input.nextInt();
		
		int[] array = createArray(num);
		printArray(array);
		
		//2nd, ask use to input the target integer:
		System.out.println("Please input the target integer:");
		System.out.print("target = ");
		int target = input.nextInt();
		input.close();
		
		
		//3rd, find out the combinations 
		ArrayList<ArrayList<Integer>> combAL = combinationSum(array, target);
		
		printALofAL(combAL);
		
		
	}//end main();

	
	
	private static ArrayList<ArrayList<Integer>> combinationSum(int[] array, int target) {
		// TODO find out all possible combinations to sum up to target
		ArrayList<ArrayList<Integer>> retAL = new ArrayList<ArrayList<Integer>>();
		if(array == null || array.length==0) return retAL;
				
		Arrays.sort(array);
		printArray(array);
		
		int Len = array.length;
		if(array[0] > target) return retAL;
		
		int end = 0;
		for(int i=0; i<Len; i++){
			if(array[i] > target) {
				end = i;
				break;
			}
		}
		if(end == 0) end = Len;
		
	//	System.out.println(" end " + end);
		
		int sum = 0;
		int start = 0;
		while(array[start] == 0) start++; //if there's 0 in the array, then we will get stackOverFlow
				
		ArrayList<Integer> oneCombination = new ArrayList<Integer>();
		getAllCombinations(array,start, end, sum, target, oneCombination, retAL);
		
		return retAL;
	}//end combinationSum() method;



	private static void getAllCombinations(int[] array,int start, int end, int sum, int target,
			ArrayList<Integer> oneCombination, ArrayList<ArrayList<Integer>> retAL) {
		// TODO Auto-generated method stub
		
		if(sum == target && (!retAL.contains(oneCombination))){
			ArrayList<Integer> tempComb = new ArrayList<Integer>(oneCombination);			
			retAL.add(tempComb);
						
		} else if(sum < target) {
			
		//	System.out.println("sum " +sum);
			
			for(int i=start; i<end; i++){
				oneCombination.add(array[i]);
				int newSum = array[i] + sum;				
				getAllCombinations(array, i+1, end, newSum, target, oneCombination, retAL);
				oneCombination.remove(oneCombination.size()-1);
			}
			
		}//end if-else conditions;
		
	}//end getAllCombinations() method;



	private static void printALofAL(ArrayList<ArrayList<Integer>> combAL) {
		// TODO call printArrayList() to print all ALs in ALofAL
		if(combAL==null) return;
		
		for(ArrayList<Integer> al:combAL){
			printArrayList(al);
		}
		
	}//end printALofAL() method;



	private static void printArrayList(ArrayList<Integer> al) {
		// TODO print out all integers in an arrayList
		if(al == null || al.size()==0){
			return;
		}
		for(int e:al){
			System.out.print(" " + e);
		}
		System.out.println();
	}//end printArrayList() method;

	private static int[] createArray(int num) {
		// TODO Create an array of num elements
		if(num == 0){
			return null;
		}
		
		int[] array = new int[num];
		
		for(int i=0; i<num; i++){
			array[i] = (int) (Math.random() * 25);
		}
		
		return array;
	}//end of createArray() method;

	private static void printArray(int[] array) {
		// TODO printout an array
		if(array == null || array.length==0){
			System.out.println("It's an empty array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " + array[i]);
		}
		System.out.println();
		
	}//end of printArray() method;
	
	
}//end of everything in CombinationSumI class
