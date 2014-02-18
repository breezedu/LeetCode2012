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

public class AddBinary {

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
		
		int Len1 = string1.length();
		int Len2 = string2.length();
		int lenMax = Math.max(Len1,  Len2);
		
		//make the two strings the same length;
		if(Len1>Len2){
			for(int i=0; i<Len1-Len2; i++){
				string2 = '0' + string2;
			}
		}
		
		if(Len1<Len2){
			for(int i=0; i<Len2-Len1; i++){
				string1 = '0' + string1;
			}
		}
		
		String retStr = "";
		int last = 0;
		int sum = 0;
		for(int i=0; i<lenMax; i++){
			char atStr1 = string1.charAt(lenMax-1-i);
			char atStr2 = string2.charAt(lenMax-1-i);
			
			if(atStr1 == '1'){
				sum += 1;
			}
			if(atStr2 == '1'){
				sum += 1;
			}
			
			sum += last;
			
			if(sum == 0){
				last = 0;
				retStr = '0' + retStr;
			}
			if(sum == 1){
				last = 0;
				retStr = '1' + retStr;
				
			}
			if(sum == 2){
				last = 1;
				retStr = '0' + retStr;
				
			}
			
			if(sum == 3){
				last =1;
				retStr = '1' + retStr;
			}
			
			sum = 0; //reset the value of sum;
			
		}
		if(last > 0){
			retStr = '1' + retStr;
		}
	
		return retStr;
	}//end addBinary() method;
	
}//end everything in AddBinary class
