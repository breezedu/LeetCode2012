package leetCode2012;

import java.util.Scanner;

/***************
 * Given an Roman numeral, convert it to a Integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Frog
 *
 */
public class TransRomantoInteger {

	public static void main(String[] args){
		
		System.out.println("This is Roman numeral to Integer program.");
		
		//1st, ask user to input Roman numerals
		System.out.println("Please input the Roman numeral:");
		Scanner input = new Scanner(System.in);
		System.out.print("Roman: ");
		String roman = input.next();
		input.close();
		
		
		//2nd, transfer the Roman numeral to Integer
		int num = romanToInt(roman);
		
		//printout the integer after transformation;
		System.out.println("The integer is: " + num);
		
	}//end main();

	/**********
	 * transfer Roman letters into an array num[] of integers: I->1, v->5... 
	 * Traversal the number array; if num[i]<=num[i-1], sum += num[i];
	 * else sum = num[i] - 2*num[i-1];
	 * return sum;
	 * @param roman
	 * @return
	 */
	private static int romanToInt(String roman) {
		// TODO transfer roman to integer
		if(roman.length()==0) return 0;
		
		int Len = roman.length();
		int[] num = new int[Len];
		for(int i=0; i<Len; i++){
			
			num[i] = charToInt(roman.charAt(i));
		}//end for i<Len loop; Roman numerals transfered into integers;
		
		printArray(num);	//printout the num[] array;
		
		int sum = num[0];
		for(int i=1; i<Len; i++){
			
			if(num[i] <= num[i-1]){
				sum += num[i];
				
			} else {
				sum += num[i] - num[i-1]*2;
				
			}//end if-else num[i]<=>num[i-1] conditions;
			
		}//end for i<Len loop;
		
		return sum;
	}//end romanToInt() method;
	
	private static void printArray(int[] num) {
		// TODO printout an array
		if(num == null) return;
		int Len = num.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + num[i]);
		}
		
		System.out.println();
	}//end printArray() method;

	private static int charToInt(char c) {
		// TODO Transfer I V X L C D M into 1, 5, 10, 50, 100, 500, 1000;
		int n = 0;
		switch (c) {
		case 'I' : n = 1; break;
		case 'V' : n = 5; break;
		case 'X' : n = 10; break;
		case 'L' : n = 50; break;
		case 'C' : n = 100; break;
		case 'D' : n = 500; break;
		case 'M' : n = 1000; break;		
		}				
		return n;
	}//end charToInt() method;	
	
}//end of everything in TransRomantoInteger class
