package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/******************
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author Frog
 */
public class PermutationsI {
	
	public static void main(String[] args){
		
		System.out.println("This is PermutationsI program.");
		
		//1st, create an array
		int[] array = createArray();
		System.out.println("Printout the original array:");
		printArray(array);
		
		//2nd, build an arrayList storage all permutations of num:
		ArrayList<ArrayList<Integer>> permuteAL = permute(array);
		
		
		//3rd, printout the permutations
		System.out.println("Printout the ArrayList of ArrayList:");
		printALofAL(permuteAL);
		
		
	}//end main()


	private static ArrayList<ArrayList<Integer>> permute(int[] array) {
		// TODO arrange all possible permutations
		ArrayList<Integer> empty = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> retAL = new ArrayList<ArrayList<Integer>>();
		retAL.add(empty);
			
		for(int i=0; i<array.length; i++){
			
			ArrayList<ArrayList<Integer>> tempAL = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> al:retAL){
				int size = al.size();
				
				for(int j=0; j<size+1; j++){
					ArrayList<Integer> temp = new ArrayList<Integer>(al);
					temp.add(j, array[i]);
					
					tempAL.add(temp);
				}
				
			}
			
			retAL = tempAL;
		}//end for i<=num loop;
		
		return retAL;
	}

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


	private static void printArray(int[] array) {
		// TODO printout an array
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
	}//end printArray() method;

	private static int[] createArray() {
		// TODO create an array of num elements
		System.out.print("Please input the integer: num = ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		if(num == 0) return null;
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random() * 25);
		}
		
		return array;
	}//end createArray() method;
	
}//end of everything in PermutationsI class
