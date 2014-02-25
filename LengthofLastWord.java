package leetCode2012;

import java.util.Scanner;

/*****************
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,
 * Given s = "Hello World",
 * return 5.
 * 
 * @author Frog
 *
 */
public class LengthofLastWord {

	public static void main(String[] args){
		
		System.out.println("This is Length of Last Word program.");
		
		//1st, ask user to input a line of strings including ' ' spaces.
		Scanner input = new Scanner(System.in);
		System.out.print("String = ");

		String sentence = input.nextLine();
		input.close();
		
		//2nd, call lengthOfLastWord() to calculate the length of the last word in the sentence
		int lengthLastWord = lengthOfLastWord(sentence);
		
		System.out.println("The length of the last word in the sentence is: " + lengthLastWord);
		
	}//end main()

	private static int lengthOfLastWord(String sentence) {
		// TODO Calculate the length of the last word
		if(sentence.length() == 0) return 0;
		
		int Len = sentence.length();		
		int endPoint = Len-1;
		
		while(sentence.charAt(endPoint) == ' '){
			endPoint--;
			if(endPoint<0) return 0; 
		
		}
		
		String lastWord = "";
		int frontPoint = endPoint;
		
		while(sentence.charAt(frontPoint) != ' '){
			lastWord = sentence.charAt(frontPoint) + lastWord;			
			frontPoint--;			
			if(frontPoint<0) return endPoint-frontPoint;
		}		
		
		System.out.println("The last word is: " + lastWord);
		return endPoint-frontPoint;
		
	}//end of lengthOfLastWord() method;
	
	
	
}//end of everything in LengthofLastWord class;
