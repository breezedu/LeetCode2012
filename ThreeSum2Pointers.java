package leetCode2012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/******************
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 *     
 * @author Frog
 *
 */

public class ThreeSum2Pointers {
	
	public static void main(String[] args){
		
		System.out.println("This is Three Sum program.");
		
		//1st, build an array
		System.out.println("Please input the num of elements in the array.");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		int[] array = createArray(num);
		printArray(array);
		
		
		//2nd, static 3-sum to 0;		
		ArrayList<ArrayList<Integer>> ALofAL = threeSum(array);
		
		printALofAL(ALofAL);
		
	}//end main();

	private static ArrayList<ArrayList<Integer>> threeSum(int[] array) {
		// TODO statistic all sets with sum == 0;
		ArrayList<ArrayList<Integer>> retAL = new ArrayList<ArrayList<Integer>>();
		
		Arrays.sort(array);
	//	printArray(array);
		
		checkAllThreeSets(array, retAL);
		
		return retAL;
	}

	private static void checkAllThreeSets(int[] array, ArrayList<ArrayList<Integer>> retAL) {
		// TODO Auto-generated method stub
		int i=0;
		while(i<array.length-2){
			int j=i+1; 
			int end = array.length-1;
						
			while(j<end){

				int sum = array[i] + array[j] + array[end];
				
				if(sum == 0){
					ArrayList<Integer> threeSet = new ArrayList<Integer>();
					threeSet.add(array[i]);
					threeSet.add(array[j]);
					threeSet.add(array[end]);
					j++;
					end--;
					
					retAL.add(threeSet);
					while (j < end && array[end] == array[end + 1])
						end--;
 
					while (j < end && array[j] == array[j - 1])
						j++;
					
				} else if(sum <0){
					j++;
					
				} else {
					
					end--;
				} //end if-else sum>=<0 conditions;
				
			}//end while loop;
			
			i++;
			while(array[i] == array[i-1]) i++;
			
		}//end outer while loop;
	}

	private static void printALofAL(ArrayList<ArrayList<Integer>> ALofAL) {
		// TODO printout ArrayList of ArrayList
		
		for(ArrayList<Integer> al:ALofAL){
			printArrayList(al);
		}
		System.out.println();
	}
	
	private static int[] createArray(int num){
		if(num == 0) return null;
		int[] array = new int[num];
		
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random() * 15);
		}
		
		return array;
	}//end createArray() method;
	
	private static void printArray(int[] array){
		if(array == null){
			System.out.println("it's an empty array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " +array[i]);
		}
		
		System.out.println();
	}//end printArray() method;

	private static void printArrayList(ArrayList<Integer> al) {
		// TODO printout arrayList
		for(int e:al){
			System.out.print(" " +e);
		}
		
		System.out.println();
	}

}//end of everything in ThreeSum class
