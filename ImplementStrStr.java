package leetCode2012;

import java.util.Scanner;

/**********
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, 
 * or return null if needle is not part of haystack.
 * 
 * @author Frog
 *
 */
public class ImplementStrStr {

	public static void main(String[] args){
		
		System.out.println("This is Implement StrStr program.");
		
		//1st, ask user to input two strings: haystack and needle
		System.out.println("Please input the haystack and needle strings.");
		Scanner input = new Scanner(System.in);
		System.out.print("haystack: ");
		String haystack = input.nextLine();
		
		System.out.print("needle: ");
		String needle = input.nextLine();
		input.close();
		
		
		//2nd, call strStr() method
		String res = strStr(haystack, needle);
		
		//printout the result:
		System.out.println("The result string is: " + res);
	}//end main()

	private static String strStr(String haystack, String needle) {
		// TODO Auto-generated method stub
		int nLen = needle.length();
		int hLen = haystack.length();
		
		if (nLen == 0) return haystack;
	 
		for (int i = 0; i < hLen; i++) {
			// return null if hLen-i is shorter than needle.length;
			if (hLen - i + 1 < nLen) return null;	 
			int k = i;
			int j = 0;
			//compare char by char; compare subString also works;
			while (j < nLen && k < hLen && needle.charAt(j) == haystack.charAt(k)) {
				j++;
				k++;
				if (j == nLen) return haystack.substring(i);
				
			}//end while() loop;
	 
		}//end for i<haystackLen loop;

		return null;
	}//end of strStr() method;
	
	
}//end of everything in ImplementStrStr class
