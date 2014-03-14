package leetCode2012;

import java.util.Scanner;

/******************
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "*") ¡ú true
 * isMatch("aa", "a*") ¡ú true
 * isMatch("ab", "?*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú false
 * 
 * @author Frog
 *
 */
public class WildCardMatching {	
	
	public static void main(String[] args){
		
		System.out.println("This is Wild Card Matching program.");
		
		//1st, ask user to input two strings
		System.out.println("Please input two strings:");
		Scanner input = new Scanner(System.in);
		System.out.print("string p: ");
		String strP = input.nextLine();
		
		System.out.print("string s: ");
		String strS = input.nextLine();
		input.close();
		
		
		//2nd, call wildCardMatch() method to check if the two strings match
		boolean match = wildCardMatch(strS, strP);
		
		//printout the match result
		if(match){
			System.out.println("Yes, the two strings match!");
		} else {
			System.out.println("No, they do not match.");
		}
	}//end of main()

	private static boolean wildCardMatch(String s, String p) {
		  
        if(p.length()==0) return s.length()==0;
        
        //compare two string char by char till reach end or reach '*';
        int i=0;
        while(i<p.length() && i<s.length() && p.charAt(i)!='*'){
            if(p.charAt(i)!=s.charAt(i) && p.charAt(i)!='?')
                return false;
            i++;
        }
        if(i==s.length()){
              while(i<p.length())
                if(p.charAt(i++)!='*') return false;
            return true;
        }
        else if(i==p.length()) 
            return false;
        else{
           s=s.substring(i);
           p=p.substring(i);
        }
        
        //deal with tail 
        i=p.length()-1;
        int j = s.length()-1;
        while(i>=0 && j>=0 && p.charAt(i)!='*'){
            if(p.charAt(i)!=s.charAt(j) && p.charAt(i)!='?')
                return false;
            i--;
            j--;
        }
        if(j<0){
            while(i>=0)
                if(p.charAt(i--)!='*') return false;
            return true;
        }
        else if(i<0)
            return false;
        else{
            s=s.substring(0,j+1);
            p=p.substring(0,i+1);
        }
        
        String[] pattern = p.split("[*]");
        for(String temp:pattern){
            if(temp.length()>0){
                int index = getFirstIndex(s,temp);
                if(index<0) 
                    return false;
                else
                    s=s.substring(index+temp.length());
            }    
        }   
        return true;
	
	}//end wildCardMatch() method;

	private static int getFirstIndex(String s, String p) {
		// TODO Auto-generated method stub
		
		if(s.length()<p.length()) return -1;
        int i=0;
        while(i<=s.length()-p.length()){
            while(i<s.length() && p.charAt(0)!='?' && p.charAt(0)!=s.charAt(i))
                i++;
            if(s.length()-i<p.length()) return -1;
            
            int j=i;
            while(j-i<p.length() && (p.charAt(j-i)=='?'||p.charAt(j-i)==s.charAt(j)))
                j++;
            if(j-i==p.length()) return i;
            i++;
        }
        return -1;
		
	}//end of getFirstIndex() method

}//end of everything in WildCardMatching class
