package leetCode2012;

import java.util.Scanner;

/*****************
 * Given two binary strings, 
 * return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * @author Frog
 * This is the NAIVE code, it only works for Integers, does not work for Long; 
 */

public class AddBinaryNAIVE {

	public static void main(String[] args){
		
		System.out.println("This is a Add Binary program.");
		
		//1st, input two strings;
		Scanner input = new Scanner(System.in);
		System.out.println("Please input two strings:");
		System.out.print("String1= ");
		String String1 = input.next();
		
		System.out.println();
		System.out.print("String2= ");
		String String2 = input.next();
		input.close();
		
		//2nd, print out two strings:
		System.out.println("Str1: " +String1);
		System.out.println("Str2: " + String2);
		
		String combine = addBinary(String1, String2);
		
		System.out.println("Str:: " +combine);
		
	}//end main();

	private static String addBinary(String string1, String string2) {
		// TODO add two binary strings
		if(string1==null && string2==null){
			return null;
			
		} else if(string1==null && string2!=null){
			return string2;
			
		} else if(string1!=null && string2==null){
			return string1;
			
		} //end straight return conditions;
		
		int num1 = getVal(string1);
		int num2 = getVal(string2);
		
		System.out.println("num1=" + num1 +". num2=" + num2);
		int num = num1 + num2;
		System.out.println("num= " + num);
		
		String retStr = "";
		while(num/2 > 0){
			
			System.out.println(" " + num%2);
			retStr = Integer.toString(num%2) + retStr; //Character.toString(num/2) + retStr;
			num = num/2;
			
		}
		retStr = Integer.toString(num) + retStr;
		
		return retStr;
	}

	private static int getVal(String str) {
		// TODO convert a binary string into a dec number
		int Len = str.length();
		int val = 0;
		for(int i=0; i<Len; i++){
			val = Character.getNumericValue(str.charAt(i)) +val*2;
		}
		
		return val;
	}
	
}//end everything in AddBinary class
