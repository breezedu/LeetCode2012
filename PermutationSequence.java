package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/******************
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive. 
 * @author Frog
 */
public class PermutationSequence {
	
	public static void main(String[] args){
		
		System.out.println("This is PermutationsI program.");
		
		//1st, create an array
		System.out.print("Please input the integer: num = ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		System.out.print("Please input the Kth permutation sequence: k=" );
		int k = input.nextInt();
		
		input.close();
		
		
		//2nd, build an arrayList storage all permutations of num:
		ArrayList<ArrayList<Integer>> permuteAL = permute(num);
		
		String kthPermutation = getPermutation(num, k);
		
		//3rd, printout the permutations
		System.out.println("Printout the ArrayList of ArrayList: " + permuteAL.size());
		printALofAL(permuteAL);
		
		System.out.println("The Kth, permutation sequence is: " + kthPermutation);
		
		
	}//end main()


	private static String getPermutation(int num, int k) {
		// TODO get the kth permutation sequence of num integers;
		
		String retStr = "";
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int totalPer = 1;
		
		for(int i=1; i<=num; i++){
			nums.add(i);
			totalPer *= i;
		}
	
		int n = num; 
		k=k-1;
		while(n>0){
			
			totalPer = totalPer/n;
			
			int curr = k/totalPer;
			retStr += nums.get(curr);
			nums.remove(curr);
			
			k = k%totalPer;
			n = n-1;
		}

		return retStr;
	}


	private static ArrayList<ArrayList<Integer>> permute(int num) {
		// TODO arrange all possible permutations
		ArrayList<Integer> empty = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> retAL = new ArrayList<ArrayList<Integer>>();
		retAL.add(empty);
		
		for(int i=num; i>0; i--){
			
			ArrayList<ArrayList<Integer>> tempAL = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> al:retAL){
				int size = al.size();
				
				for(int j=0; j<size+1; j++){
					ArrayList<Integer> temp = new ArrayList<Integer>(al);
					temp.add(j, i);
					
					if(!tempAL.contains(temp)){
						tempAL.add(temp);
					}
				}
				
			}
			
			retAL = tempAL;
		}//end for i<=num loop;
		
		return retAL;
	}

	/*****************
	 * algo as below:
	 * [1]
	 * [2, 1]
	 * [1, 2]
	 * [3, 2, 1]
	 * [2, 3, 1]
	 * [2, 1, 3]
	 * [3, 1, 2]
	 * [1, 3, 2]
	 * [1, 2, 3]
	 * @param permuteAL
	 */
	private static void printALofAL(ArrayList<ArrayList<Integer>> permuteAL) {
		// TODO print ArrayList of ArrayList
		if(permuteAL == null || permuteAL.size()==0){
			System.out.println("The ArrayList of ArrayList is Empty!");
			return;
		}
		
		for(ArrayList<Integer> al: permuteAL){
			printArrayList(al);
		}
		
		System.out.println();
	}//end printALofAL() method;

	private static void printArrayList(ArrayList<Integer> al) {
		// TODO printout an arrayList
		if(al == null || al.size()==0){
			System.out.println("one empty arraylist.");
			return;
		}
		
		for(int e:al){
			System.out.print(" " +e);
		}
		
		System.out.println();
	}//end printArrayList() method;
	
}//end of everything in PermutationsI class
