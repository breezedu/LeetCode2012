package leetCode2012;

import java.util.ArrayList;
import java.util.Arrays;

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
		int[] array = {79,-82,-37,-93,57,-6,-94,38,94,88,-60,-22,77,-44,-38,0,99,-57,-69,-78,
				85,78,-3,-5,89,-11,93,42,-9,-74,90,96,54,-91,34,-14,52,96,5,18,93,76,-95,-86,
				36,-83,65,-80,-63,74,4,-82,12,-78,11,-78,-57,-21,37,87,-32,-64,79,-14,46,-72,
				75,-6,-63,-71,11,-10,68,85,-3,-9,-72,31,-83,-24,32,45,-82,26,-67,85,10,-78,-92,
				-14,65,-63,-63,-53,38,-6,-5,42,-35,97,-30,-12,-7,-51,85,26,21,52,48,-62,48,21,
				86,5,64,56,49,-67,-91,-21,16,25,-1,54,48,0,49,81,16,89,53,40,-44,-58,-91,77,58,
				77,-10,-74,-11,86,27,27,-84,-23,92,38,35,-3,-6,-99,47,55,71,-82,-34,8,32,-4,17,-52};
		//int target = -141;
		
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

	private static void printArrayList(ArrayList<Integer> al) {
		// TODO printout arrayList
		for(int e:al){
			System.out.print(" " +e);
		}
		
		System.out.println();
	}

}//end of everything in ThreeSum class
