package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/******************
 * Given two integers n and k, 
 * return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *   ]
 *   
 * @author Frog
 *
 */
public class Combinations {
	
	public static void main(String[] args){
		
		System.out.println("This is Combinations program.");
		
		//1st, build an array of n;
		System.out.println("Please input n and k:");
		Scanner input = new Scanner(System.in);
		System.out.print("k= " );
		int k = input.nextInt();
		
		System.out.print("n= ");
		int n = input.nextInt();
		input.close();
		
		
		//2nd, solve the combinations problem:
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
		combinations = combine(n, k);
		
		System.out.println("Build combinations of " + k+ " elements set from an array of " + n +" elems.");
		printALofAL(combinations);
				
		
	}//end main()

	private static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> combSets = new ArrayList<ArrayList<Integer>>();
		if(k>n || k==0) return combSets;
		
		//1st, create an array of 1---n;
		int[] array = new int[n];
		for(int i=0; i<n; i++){
			array[i] = i+1;
		}
		
		ArrayList<Integer> combine = new ArrayList<Integer>();
		
		int startPoint = 0;
		buildCombineSets(array, n, k, startPoint, combine, combSets);
		
		return combSets;
	}//end of combine() method;

	private static void buildCombineSets(int[] array,int n, int k, int startPoint,
			ArrayList<Integer> combine, ArrayList<ArrayList<Integer>> combSets) {
		// TODO build combine, if it meets the requirement of combSets, add it.
		
		if(combine.size() == k){
			
		//	ArrayList<Integer> addCombine = new ArrayList<Integer>(combine);
			combSets.add(combine);
			
		} else {
			
			for(int i= startPoint; i<n; i++){
				
				ArrayList<Integer> temp = new ArrayList<Integer>(combine);
				temp.add(array[i]);
				buildCombineSets(array, n, k, i+1, temp, combSets);
			//3rd step:	combine.remove(combine.size()-1); //confused about this step :)
				//these 3 steps are very interesting: at 1st, I though these would not go on
				//then, I found the 3rd step is supper important.
				//take k==1 as an example: without step 3, the program will stop and jump out at step 2;
				//with step three, all other elements could be added to other 'combine' arrayList;
			}
			
		} //end if-else conditions;
		
		
	}//end buildCombineSets() method;

	private static void printALofAL(ArrayList<ArrayList<Integer>> combinations) {
		// TODO printout all arrayLists in an ALofAL
		if(combinations == null){
			System.out.println("It's empty.");
			return;
		}
		
		for(ArrayList<Integer> al:combinations){
			printArrayList(al);
		}
		
		System.out.println();
	}//end printALofAL() method;

	private static void printArrayList(ArrayList<Integer> al) {
		// TODO printout all elements in an arrayList
		if(al==null){
			return;
		}
		
		for(int e:al){
			System.out.print(" " + e);
		}
		System.out.println();
		
	}//end of printArrayList() method;
	

}//end of everything in Combinations class
