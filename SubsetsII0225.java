package leetCode2012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/***************
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * 
 * [
 *   [1],
 *   [2],
 *   [1,2,2],
 *   [1,2],
 *   [2,2],
 *   []
 *   ]
 *   
 * @author Frog
 *
 */
public class SubsetsII0225 {
	
	public static void main(String[] args){
		
		System.out.println("This is Subsets program.");
		
		//1st, create an array of random integers;
		int[] array = createArray();
		printArray(array);
		
		//2nd, build the sub-arrays set
		ArrayList<ArrayList<Integer>> subSet = buildSubsets(array);
		
		System.out.println("The subset has been built:");
		printALofAL(subSet);
		
	}//end main();

	private static ArrayList<ArrayList<Integer>> buildSubsets(int[] array) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> retAL = new ArrayList<ArrayList<Integer>>();
		//retAL is the ALofAL to store all subsets;
		
		if (array == null)	return retAL;
		
		Arrays.sort(array); //to get the correct order, this step is necessary.
		int Len = array.length;		
	 	ArrayList<Integer> levelSet = new ArrayList<Integer>();
	 	//levelSet is the arrayList to store one set of sub-elements;
	 	
	 	int startPoint = 0;
	 	
	 	//here, k is the length of subset, not the index in the array;
	 	for(int k=0; k<=Len; k++){
	 		
	 		buildCombineSubsets(array, Len, k, startPoint, levelSet, retAL);	 		 	
	 	}
	 	
	 	return retAL;
	}//end buildSubsets() method;

	private static void buildCombineSubsets(int[] array, int len, int k, int startPoint, 
				ArrayList<Integer> levelSet,	ArrayList<ArrayList<Integer>> retSets) {
		// TODO Auto-generated method stub
		
		if(levelSet.size() == k){
			//ArrayList<Integer> temp = new ArrayList<Integer>(levelSet);
			//check if there's an equal ArrayList in the result set?
			if(!duplicateAL(retSets, levelSet))
			
				retSets.add(levelSet);
			
			} else {
			
				for(int i=startPoint; i<len; i++){
					
					ArrayList<Integer> temp = new ArrayList<Integer>(levelSet);
					temp.add(array[i]);
					buildCombineSubsets(array, len, k, i+1, temp, retSets);
				//	levelSet.remove(levelSet.size()-1);
				
				}//end for i<len loop
			
			}//end if-else conditions;
		
	}//end buildCombineSubsets() method;

	private static boolean duplicateAL(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> levelSet) {
		// TODO to check if there's a duplicate levelSet in the result ALofAL
		if(result==null) return false;
		
		for(ArrayList<Integer> al:result){
			boolean dup = compareArrayLists(al, levelSet);
			if(dup) return true;
		}
		
		return false;
	}//end duplicateAL() method;

	private static boolean compareArrayLists(ArrayList<Integer> al,	ArrayList<Integer> levelSet) {
		// TODO compare two arrayLists
		if(al==null ||levelSet==null) return false;
		
		int s1 = al.size();
		int s2 = levelSet.size();
		
		if(s1!=s2) return false;
		
		for(int i=0; i<s1; i++){
			if(al.get(i) != levelSet.get(i)) return false;
		}
		
		return true;
	}//end compareArrayList() method;

	private static void printALofAL(ArrayList<ArrayList<Integer>> subset) {
		// TODO printout arrayList of arrayLists
		if(subset == null){
			System.out.println("The ArrayList of arraylist is empty.");
			return;
		}
		
		for(ArrayList<Integer> al:subset){
			printArrayList(al);
		}
		System.out.println();
	}

	private static void printArrayList(ArrayList<Integer> al) {
		// TODO printout an arrayList
		if(al==null){
			return;
		}
		for(int e:al){
			System.out.print(" " +e);
		}
		System.out.println();
		
	}//end printArrayList() method;
	

	private static void printArray(int[] array) {
		// TODO printout an array
		
		if(array==null){
			System.out.println("Nothing in the array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " +array[i]);
		}
		System.out.println();
	}//end printArray() method;

	private static int[] createArray() {
		// TODO create an array of non-descend order;
		System.out.println("Please input the length of the array.");
		
		Scanner input = new Scanner(System.in);
		System.out.print("num = " );
		int num = input.nextInt();
		input.close();
		
		if(num==0){
			System.out.println("That's an empty array.");
			return null;
		}
		
		int[] array = new int[num];
		
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*5 + 1);
		}
		
		return array;
	}//end create non-descending array;

}//end of everything in Subsets class;
