package leetCode2012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/****************
 * Given an array S of n integers, are there elements a, b, c, and d 
 * in S such that a + b + c + d = target? Find all unique quadruplets 
 * in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
 * The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 *     
 * @author Frog
 *
 */

public class FourSumQuestion {

	public static void main(String[] args){
		
		System.out.println("This is Four Sum program.");
		
		//1st, create an array of num elements;
		System.out.println("Pleaes input the num of elements in the array:");
		Scanner input = new Scanner(System.in);
		System.out.print(" num = ");
		int num = input.nextInt();
		
		int[] array = createArray(num);
		printArray(array);
		
		
		//2nd, ask user to input the target:
		System.out.println("Please input the target: ");
		System.out.print(" target = ");
		int target = input.nextInt();
		input.close();
		
		
		//3rd, build the arrayList of 4-Sum combinations
		ArrayList<ArrayList<Integer>> fourSum = fourSum(array, target);
		System.out.println("Printout the 4Sum combinations.");
		printALofAL(fourSum);
		
		
	}//end main();
	
	/*************
	 * sort the array with Arrays.sort() method;
	 * use 4 pointers: i from 0 to array.length-3;
	 * j from i+1 to array.length-2;
	 * and another two (start, end) to traversal all pairs to the right side of j-pointer;
	 * calculate the sum of array[i, j, start, end], if sum==target, add all these 4 elements
	 * to an ArrayList, check if there's already one such AL in the hashSet, if yes, ignore
	 * if no, add the arrayList to both retAL (returnALofAL) and the hashSet;
	 * return the retAL
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	private static ArrayList<ArrayList<Integer>> fourSum(int[] array, int target) {
		// TODO get all four sum sets, store them in an ALofAL
		HashSet<ArrayList<Integer>> currentSets = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> retAL = new ArrayList<ArrayList<Integer>>();
		
		Arrays.sort(array); //have to sort the array first;
		int Len = array.length;
		for(int i=0; i<Len-3; i++){
			
			for(int j=i+1; j<Len-2; j++){
				
				int start = j+1;
				int end = Len-1;
				
				while(start < end){
					int sum = array[i] + array[j] + array[start] + array[end];
				
					if(sum == target){
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(array[i]);
						temp.add(array[j]);
						temp.add(array[start]);
						temp.add(array[end]);
					
						if(!currentSets.contains(temp)){
							currentSets.add(temp);
							retAL.add(temp);
						}
					
						start++;
						end--;
				
					} else if(sum < target){
						start++;
					
					} else {
						end--;
					
					}//end if-else sum==target conditions;
				
				} //end while loop;
			}//end inner for j<Len-2 loop;
			
		}//end outer for i<Len-3 loop;
		
		return retAL;
	}//end fourSum() method;

	private static void printALofAL(ArrayList<ArrayList<Integer>> fourSum){
		if(fourSum == null || fourSum.isEmpty()){
			System.out.println("The arrayList is empty.");
			return;
		}
		
		for(ArrayList<Integer> al:fourSum){
			printArrayList(al);
		}
		
		System.out.println();
	}//end printALofAL() method;
	
	private static void printArrayList(ArrayList<Integer> al){
		
		if(al==null || al.isEmpty()){
			System.out.println();
			return;
		}
		
		for(int e:al){
			System.out.print(" " +e);
		}
		
		System.out.println();
	}//end printArrayList() method;
	
	private static int[] createArray(int num){
		if(num == 0) return null;
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			
			array[i] = (int)(Math.random() * 25);
		}
		
		return array;
	}//end createArray() method
	
	private static void printArray(int[] array){
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
	
}//end of everything in FourSumQuestion class
