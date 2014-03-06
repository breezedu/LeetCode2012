package leetCode2012;

import java.util.Scanner;

/******************
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string 
 * by deleting some (can be none) of the characters without disturbing 
 * the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * @author Frog
 *  Time Limit Exceeded ==!
 */
public class DistinctSubsequencesDP {
	
	public static void main(String[] args){
		
		System.out.println("This is Distinct Subsequences program.");
		
		//1st, ask user to input the original string and the target string;
		System.out.println("Please input the original and target strings:");
		Scanner input = new Scanner(System.in);
		System.out.print("original string: ");
		String oriStr = input.next();
		
		System.out.print("target string: ");
		String target = input.next();
		input.close();
		
		
		//2nd, calculate the distinct subsequences:
		Stopwatch timmer = new Stopwatch();
		int dist = numDistinct(oriStr, target);
		
		//printout the result
		System.out.println("There are " + dist + " distinct subsequences in the original string.");
		System.out.println("The time used is: " + timmer.elapsedTime());
		
	}//end main()

	/**********
	 * matrix(i, j) stand for the number of subsequences of target(0, i) in oriStr(0, j). 
	 * If target.charAt(i) == oriStr.charAt(j), matrix(i, j) = matrix(i-1, j-1) + matrix(i-1,j); 
	 * Otherwise, matrix(i, j) = matrix(i-1,j).
	 * 
	 * @param oriStr
	 * @param target
	 * @return
	 */
	private static int numDistinct(String oriStr, String target) {
		// TODO calculate the num of distinct target subsequences in the original string;
		if(target.length() > oriStr.length()) return 0;
		
	    int[][] matrix = new int[oriStr.length() + 1][target.length() + 1];
	    
		for (int i = 0; i < oriStr.length(); i++)
			matrix[i][0] = 1;
	 
		for (int i = 1; i <= oriStr.length(); i++) {
			for (int j = 1; j <= target.length(); j++) {
				
				if (oriStr.charAt(i - 1) == target.charAt(j - 1)) {
					matrix[i][j] += matrix[i - 1][j] + matrix[i - 1][j - 1];
					
				} else {
					matrix[i][j] += matrix[i - 1][j];
					
				} //end if-else conditions;
				
			}//end for j<=target.length loop;
		}//end for i<= oriStr.length loop;
	 
		return matrix[oriStr.length()][target.length()];
		
	}//end of numDistinct() method;

}//end of everything in DistinctSubsequences class
