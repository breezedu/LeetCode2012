package leetCode2012;

import java.util.Scanner;

/****************
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", 
 * where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * @author Frog
 *
 */
public class LongestValidParenthesesNAIVEDP {

	public static void main(String[] args){
		
		System.out.println("This is Longest Valid Parentheses program.");
		
		//1st, ask user to input the parentheses string
		System.out.println("Please input the parentheses string:");
		Scanner input = new Scanner(System.in);
		System.out.print("parentheses: ");
		String parentheses = input.next();
		input.close();
		
		
		//2nd, call longestValidParentheses() method to calculate the longest valid Parentheses
		int LVP = longestValidParentheses(parentheses);
		System.out.println("The longest valid Parentheses' length is: " + LVP);
		
		
	}//end main()
	
	/********
	 * DP, check neighbors first, if s.charAt(i) ='(' and s.charAt(i+1)=')', we got a pair.
	 * check s.charAt(i) and s.charAt(j) if s.charAt(i+1)-s.charAt(j-1) is valid, then (i,j) is valid
	 * check (i, j) is valid and (j+1, k) is valid, then (i,k) is valid;
	 * update the longest distance to maxLen;
	 * O(n^3), DP is OK, but not always works.
	 * @param s
	 * @return
	 */
	private static int longestValidParentheses(String s){
		if(s=="" || s.length()==0) return 0;
		
		int Len = s.length();
		int[][] matrix = new int[Len][Len];
		int maxLen = 0;
		for(int i=0; i<Len-1; i++){
			if(s.charAt(i) == '(' && s.charAt(i+1)==')'){
				matrix[i][i+1] = 1;
				maxLen = 1;
			}
		}
		
		for(int i=0; i<Len-2; i++){
			for(int j=i+1; j<Len; j++){
				
				if(s.charAt(i)=='(' && s.charAt(j)==')' && matrix[i+1][j-1]==1){
					matrix[i][j] =1;
					if((j-i+1)/2>maxLen) maxLen = (j-i+1)/2;
				}
				
				for(int k=j+1; k<Len; k++){
					if(matrix[i][j] == 1 && matrix[j+1][k]==1){
						matrix[i][k] = 1;
						if((k-i+1)/2>maxLen) maxLen = (k-i+1)/2;
						
					}
				}//end for k<Len loop;
			}
		}
		
		
		for(int i=0; i<Len-2; i++){
			for(int j=i+1; j<Len-1; j++){
				
				for(int k=j+1; k<Len; k++){
					
					if(matrix[i][j] == 1 && matrix[j+1][k]==1){
						matrix[i][k] = 1;
						if((k-i+1)/2>maxLen) maxLen = (k-i+1)/2;
						
					}
				}
			}
		}
		
		return maxLen;
		
	}//end of longestValidParentheses() method;
	
}//end of everything in LongestValidParentheses class
