package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/***************
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 *   ]
 *   
 * @author Frog
 *
 */
public class SubsetsOneLoop {
	
	public static void main(String[] args){
		
		System.out.println("This is Subsets program.");
		
		//1st, create an array of non-descending order;
		int[] array = createArray();
		printArray(array);
		
		
		//2nd, build the sub-arrays set
		Stopwatch timmer = new Stopwatch();
		ArrayList<ArrayList<Integer>> subSet = buildSubsets(array);
		
		System.out.println("The subset has been built, time used: " +timmer.elapsedTime());
		printALofAL(subSet);
		
	}//end main();

	/************
	 * traversal the whole array, for each array[i];
	 * 1st, get all subsets already in the AlofAl;
	 * add array[i] to each subsets;
	 * add array[i] to a new empty subset;
	 * add the new subset with only array[i] to the return AlofAl;
	 * @param array
	 * @return
	 */
	private static ArrayList<ArrayList<Integer>> buildSubsets(int[] array) {
		// TODO Auto-generated method stub
		if (array == null)	return null;
		
		int Len = array.length;
	 
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		for (int i=0; i<Len; i++) {
			Stack<ArrayList<Integer>> temp = new Stack<ArrayList<Integer>>();
	 
			//get sets that are already in result
			for (ArrayList<Integer> a : result) {
				ArrayList<Integer> tempAL = new ArrayList<Integer>(a);
				tempAL.add(array[i]);
				temp.push(tempAL);
			}
	 
			//add array[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(array[i]);
			result.add(single);
	 
			result.addAll(temp);
		}
	 
		//add another empty set
		result.add(new ArrayList<Integer>());
	 
		return result;

	}

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
		
		array[0] = 10;// (int)(Math.random()*10);
		for(int i=1; i<num; i++){
			array[i] = array[i-1] + 1;// (int)(Math.random()*10 + 1);
		}
		
		return array;
	}//end create non-descending array;

}//end of everything in Subsets class;
