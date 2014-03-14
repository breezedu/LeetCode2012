package leetCode2012;

import java.util.Scanner;

/***************
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "a*") ¡ú true
 * isMatch("aa", ".*") ¡ú true
 * isMatch("ab", ".*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú true
 * 
 * @author Frog
 *
 */
public class RegularExpressionMatch {
	
	public static void main(String[] args){
		
		System.out.println("This is Regular Expression Match program.");
		
		//1st, ask user to input two strings
		System.out.println("Please input two Strings.");
		Scanner input = new Scanner(System.in);
		System.out.print("String s=");
		String s = input.nextLine();
		
		System.out.print("String p=");
		String p = input.nextLine();
		input.close();
		
		
		//2nd, check if the two strings s and p match
		boolean match = isMatch(s, p);
		
		//printout the result
		if(match){
			System.out.println("The two strings match.");
		}
		
	}//end main()

	private static boolean isMatch(String s, String p) {
		// TODO Auto-generated method stub
		if(p.length() == 0)
            return s.length() == 0;
 
        //if p has only one character or, the second char of p is not *:
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));    
 
        }else{
            int len = s.length();
 
            int i = -1; 
            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(2))) return true;
                i++;
            }
            
            return false;
        }//end if-else 

	}//end isMatch() method;

}//end of everything in RegularExpressionMatch class
