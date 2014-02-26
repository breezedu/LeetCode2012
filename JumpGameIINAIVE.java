package leetCode2012;

import java.util.Scanner;

/*******************
 * Given an array of non-negative integers, 
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * @author Frog
 *
 */
public class JumpGameIINAIVE {

	public static void main(String[] args){
		
		System.out.println("This is Jump Game II program.");
		
		//1st, create an array
		int[] array = createArray();
		printArray(array);
		
		
		//2nd, find out the shortest steps to jump from array[0] to array[n]
		int steps = jump(array);
		
		System.out.println("We need " + steps +" steps to jump from start to the end.");
		
	}//end main();

	private static int jump(int[] array) {
		// TODO Auto-generated method stub
		if(array == null || array.length==0){
			return 0;
		}
		
		int Len = array.length;
		int[] steps = new int[Len];
		for(int i=0; i<Len; i++){
			steps[i] = 1000000;
		}
		steps[0] = 0;
		
		for(int i=1; i<Len; i++){
			
			for(int j=0; j<i; j++){
				
				if(array[j] > (i-j)){
					steps[i] = Math.min(steps[i], steps[j] + 1);
				}
				
			}
			
		}
		
		printArray(steps);
		return steps[Len-1];
	}

	private static int[] createArray() {
		// TODO create an array
		
		System.out.println("Please input how many elements in the array:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*10 + 1);
		}
		
		return array;
	}//end createArray() method;

	private static void printArray(int[] array) {
		// TODO printout an array
		if(array == null){
			System.out.println("It's an empty array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " +array[i]);
		}
		
		System.out.println();
	}//end of printArray() method;
	
}//end of everything in JumpGameII class
