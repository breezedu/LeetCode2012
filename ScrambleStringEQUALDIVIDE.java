package leetCode2012;

import java.util.Scanner;

/*******************
 ***THIS WORKS FOR BINARY SPLITING ONLY: EVERYTHING WE DIVIDE THE NODE EQUALLY.
 * Given a string s1, we may represent it as a binary tree 
 * by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 *    great
 *   /    \
 *  gr    eat
 * / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children, 
 * it produces a scrambled string "rgeat".
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", 
 * it produces a scrambled string "rgtae".

 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *       / \
 *      t   a
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * 
 * @author Frog
 *
 */
public class ScrambleStringEQUALDIVIDE {
	
	public static void main(String[] args){
		
		System.out.println("This is Scramble String program.");
		
		//1st, ask user to input two strings;
		System.out.println("Please input two strings.");
		Scanner input = new Scanner(System.in);
		System.out.print("strOne: ");
		String strOne = input.next();
		
		System.out.print("strTwo: ");
		String strTwo = input.next();
		input.close();
		
		
		//2nd, call isScramble() method to check if the two strings inputed are Scramble or not
		boolean scram = isScramble(strOne, strTwo);
		
		//printout the result:
		if(scram) System.out.println("The inputed two strings are scramble.");
		else System.out.println("They are not scramble.");
		
	}//end main()

	/********
	 * This is wrong, but I think it's interesting. and of course I don't think anyone would read :)
	 * Just a kidding program (trash program here);
	 * if the node's string is equally divided, the children nodes should have equal strings
	 * or only one more or less letter; 
	 * in this pattern, we can 'recurssionly' call the isScramble() method to check left-right part
	 * of the parent's string;
	 * @param strOne
	 * @param strTwo
	 * @return
	 */
	private static boolean isScramble(String strOne, String strTwo) {
		// TODO check if two words are scramble or not		
		if( strOne.equals(strTwo) ) return true;
		
		if(strOne.length()<2) return strOne.equals(strTwo);
		
		int Len = strOne.length();
		if(strOne.length()%2==0){
			String leftOne = strOne.substring(0, Len/2);
			String leftTwo = strTwo.substring(0, Len/2);
			String rightOne = strOne.substring(Len/2);
			String rightTwo = strTwo.substring(Len/2);
			
			return (isScramble(leftOne, leftTwo) && isScramble(rightOne, rightTwo)) || (isScramble(leftOne, rightTwo) && isScramble(rightOne, leftTwo));
		
		} else {
			//here we can divide the two strings in two different combinations:
			//1st, short front strOne.substring(0, Len/2), strOne.subString(Len/2);
			String leftOne = strOne.substring(0, Len/2);
			String leftTwo = strTwo.substring(0, Len/2);
			String rightOne = strOne.substring(Len/2);
			String rightTwo = strTwo.substring(Len/2);
			
			if(isScramble(leftOne, leftTwo) && isScramble(rightOne, rightTwo)) return true;
			
			leftTwo = strTwo.substring(0, Len/2+1);
			rightTwo = strTwo.substring(Len/2+1);
			if(isScramble(leftOne, rightTwo) && isScramble(rightOne, leftTwo)) return true;
			
			//2nd, long front strOne.substring(0, Len), strOne.substring(Len);
			leftOne = strOne.substring(0, Len/2+1);
			rightOne = strOne.substring(Len/2+1);
			
			if(isScramble(leftOne, leftTwo) && isScramble(rightOne, rightTwo)) return true;
			
			leftTwo = strTwo.substring(0, Len/2);
			rightTwo = strTwo.substring(Len/2);
			if(isScramble(leftOne, rightTwo) && isScramble(rightOne, leftTwo)) return true;
			
		}
		
		return false;
	}

}//end of everything in ScrambleString class
