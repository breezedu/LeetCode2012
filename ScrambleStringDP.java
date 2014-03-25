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
public class ScrambleStringDP {
	
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
	 * use 3d-DP method; 
	 * @param strOne
	 * @param strTwo
	 * @return
	 */
	private static boolean isScramble(String s1, String s2) {
		// TODO check if two words are scramble or not		
		int n = s1.length();
	    if(n != s2.length()) return false;
	    if(n == 0) return true;
	    // 3D DP method
	    // dp[i][j][k] is true if s1[i:i+k] and s2[j:j+k] is scramble
	    boolean[][][] dp = new boolean[n][n][n + 1];
	        
	    for(int k=1; k<=n; k++){
	        for(int i=0; i<=n-k; i++){
	            for(int j=0; j<=n-k; j++){	                    
	                boolean res = false;
	                    
	                for(int m=1; m<k && !res; m++){
	                    if(dp[i][j][m] && dp[i+m][j+m][k-m]) res = true;
	                    if(dp[i][j+k-m][m] && dp[i+m][j][k-m]) res = true;
	                    
	                }//end for m<k loop;
	                        
	                dp[i][j][k] = res;
	                if(s1.charAt(i) == s2.charAt(j)) dp[i][j][1] = true;
	                    
	            }//end for j<=n-k loop;
	        }//end for i<=n-k loop;
	    }// end for k<=n loop;
	    
	    return dp[0][0][n];
	
	}//end of isScramble() method;

}//end of everything in ScrambleString class
