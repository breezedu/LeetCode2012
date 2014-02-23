package leetCode2012;

import java.util.Scanner;

/***************
 * Given two words word1 and word2, 
 * find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * @author Frog
 * IT IS VERY MUCH LIKE A GLOBAL ALIGNMENT WITH SIGMA==1
 * 
 */
public class EditDistanceMatrix {

	public static void main(String[] args){
		
		System.out.println("This is Edit Distance Matrix program.");
		
		//1st, input two strings
		System.out.println("Please input two strings:");
		Scanner input = new Scanner(System.in);
		
		System.out.print("String 1: ");
		String word1 = input.next();
		
		System.out.print("String 2: ");
		String word2 = input.next();
		input.close();
		
		//2nd, build match matrix
		int[][] match = buildMatchMatrix(word1, word2);
		printMatrix(match, word1, word2);
		
		//3rd, build sum-match matrix
		int[][] sumMatch = buildSumMatch(match);
		printMatrix(sumMatch, " "+word1, " " +word2);
		
		System.out.println("The stepps need for editing distance are: " + sumMatch[word1.length()][word2.length()]);
	}//end of main()

	private static int[][] buildSumMatch(int[][] match) {
		// TODO build a sum-match matrix base on match matrix
		int row = match.length+1;
		int col = match[0].length+1;
		
		int[][] sumMatch = new int[row][col];
		
		for(int i=0; i<row; i++){
			sumMatch[i][0] = i;
		}
		for(int j=0; j<col; j++){
			sumMatch[0][j] = j;
		}
		
		for(int i=1; i<row; i++){
			
			for(int j=1; j<col; j++){
				
				sumMatch[i][j] = minOfThree(sumMatch[i-1][j]+1, sumMatch[i][j-1]+1, sumMatch[i-1][j-1]+match[i-1][j-1]);
			}
		}
		
		return sumMatch;
	}//end buildSumMatch() method;

	private static int minOfThree(int i, int j, int k) {
		// TODO Auto-generated method stub
		int min = i;
		if(j<min) min = j;
		if(k<min) min = k;
		
		return min;
	}

	private static void printMatrix(int[][] match, String word1, String word2) {
		// TODO printout a matrix with left and up boundaries:
		int row = match.length;
		int col = match[0].length;
		
		System.out.print(" ");
		for(int i=0; i<word2.length(); i++){
			System.out.print(" " +word2.charAt(i));
		}
		System.out.println();
		
		for(int i=0; i<row; i++){
			
			System.out.print(word1.charAt(i));
			for(int j=0; j<col; j++){
				
				System.out.print(" " + match[i][j]);				
			}
			
			System.out.println();
		}
		System.out.println();
	}//end printMatrix() method;

	private static int[][] buildMatchMatrix(String word1, String word2) {
		// TODO build match matrix
		int row = word1.length();
		int col = word2.length();
		
		int[][] matchMatrix = new int[row][col];
		
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				if(word1.charAt(i)==word2.charAt(j)){
					matchMatrix[i][j] = 0;
					
				} else {
					matchMatrix[i][j] = 1;			
					
				}//end if-else conditions

			}
		}//end outer for i<row loop;
		
		return matchMatrix;
	}//end buildMatchMatrix() method;
	
}//end everything in EditDistanceMatrix class
