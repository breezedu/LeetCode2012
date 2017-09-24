package leetcode2017;

/*************************************
 * 
 * @author jeffd
 * 
 * Given a non-empty string s, you may delete at most one character. 
 * Judge whether you can make it a palindrome.
 * 
 */

public class No680_ValidPalindromeII {
	
	public static void main(String[] args){
		
		String s = "abc";
		
		boolean isP = validPalindrome(s);
		
		if(isP){
			System.out.println("String " + s + " is a Palindrome.");
		} else {
			System.out.println("String " + s + " is not a Palidrome.");
		}

	}//end main();

	private static boolean validPalindrome(String s) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = s.length() - 1; 
		while(i<j && s.charAt(i) == s.charAt(j) ){
			i++;
			j--;
		}
		
		if(i >= j) {
			return true; 
			
		} else {
			return(Palindrome( s.substring(i+1, j+1) ) || Palindrome( s.substring(i, j)) );
				
		}
		
	}//end validPalindrome();

	private static boolean Palindrome(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
		int i = 0;
		int j = s.length() - 1; 
		while(i<j && s.charAt(i) == s.charAt(j) ){
			i++;
			j--;
		}
		
		if(i >= j) {
			return true; 
		} else {
			return false;
		}
	}//end 
	
	

}//ee
