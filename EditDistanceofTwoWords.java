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
 *
 */
public class EditDistanceofTwoWords {
	
	public static void main(String[] args){
		
		System.out.println("This is Edit Distance of Two Words program.");
		
		//1st, input two words:
		System.out.println("Please input two words:");
		Scanner input = new Scanner(System.in);
		System.out.print("word1: ");
		String word1 = input.next();
		System.out.print("word2: ");
		String word2 = input.next();
		input.close();
		
		//2nd, calculate the edit distance:
		int dis = minDistance(word1, word2);
		
		System.out.println("To edit from word1 to word2, we need " + dis +" steps at least.");
		
	}//end main();

	private static int minDistance(String word1, String word2) {
		// TODO to calculate the distance of editing from word1 to word2
		
		if(word1=="") return word2.length();
		if(word2=="") return word1.length();
		
		//use dynamic programming method:
		//1st, build a match matrix first;
		int[][] match = buildMatchMatrix(word1, word2);
		System.out.println("Printout the match matrix: ");
		printMatrix(match, word1, word2);
		
		//2nd, find the longest path from 
		//build a path matrix
		int[][] pathMatrix = buildPathMatrix(match);
		System.out.println("Printout the path matrix:");
		printMatrix(pathMatrix, word1, word2);
		
		//3rd, build a backtrack matrix from pathMatrix
		char[][] backTrack = buildBackTrack(pathMatrix);
		printMatrix(backTrack, word1, word2);
		
		//4th, travel the backTrack matrix from down-right to up-left
		//int conserve = checkBackTrackMatrix(backTrack);
		
		//5th, Printout word1 and word2 after modification (alignment)
		
		String newWord1 = rebuildWord1(backTrack, word1);
		System.out.println("Word1: " + newWord1);
		
		String newWord2 = rebuildWord2(backTrack, word2);
		System.out.println("Word2: " + newWord2);
		
		
		int conserve = compareAlignedWords(newWord1, newWord2);
		
		//so, we return those needed to be edited;
		return conserve;
		
	}//end minDistance() method;


	private static int compareAlignedWords(String word1, String word2) {
		// TODO Auto-generated method stub
		int Len = word1.length();
		
		int misMatch = 0;
		for(int i=0; i<Len; i++){
			System.out.print(" " + i +",");
			if(word1.charAt(i) != word2.charAt(i)){
				misMatch++;
				i++;
			}
		}
		
		return misMatch;
	}

	private static String rebuildWord2(char[][] backTrack, String word2) {
		// TODO Auto-generated method stub
		int row = backTrack.length;
		int col = backTrack[0].length;
		
		word2 = " " +word2;
		String retWord = "";
		retWord = checkMatrixRight(backTrack, row-1, col-1, retWord, word2);
		
		return retWord;
	}
	
	private static String checkMatrixRight(char[][] backTrack, int m, int n, String retWord, String word2) {
		// TODO Auto-generated method stub
		if(m==0 && n==0){
			return retWord;
		}
		
		if(backTrack[m][n] == 'O'){
			retWord = word2.charAt(n) + retWord;
			retWord = checkMatrixRight(backTrack, m-1, n-1, retWord, word2);
		}
		
		if(backTrack[m][n] == 'L'){
			retWord = word2.charAt(n) + retWord;
			retWord = checkMatrixRight(backTrack, m, n-1, retWord, word2);
			
		}
		
		if(backTrack[m][n] == 'U'){
			retWord = '#' + retWord;
			retWord = checkMatrixRight(backTrack, m-1, n, retWord, word2);
			
		}
		
		return retWord;
	}	
	
	private static String rebuildWord1(char[][] backTrack, String word1) {
		// TODO rebuild word1 according to the backTrack matrix;
		int row = backTrack.length;
		int col = backTrack[0].length;
		word1 = " " + word1;
		
		String retWord = "";
		retWord = checkMatrixLeft(backTrack, row-1, col-1, retWord, word1);
		
		return retWord;
	}//end rebuildWord1() method;

	private static String checkMatrixLeft(char[][] backTrack, int m, int n,	String retWord, String word1) {
		// TODO check backTrack[m][n], if it equals to 'O' or 'L', add it to retWord
		if(m==0 && n==0){
			return retWord;
		}
		
		if(backTrack[m][n] == 'O'){
			retWord = word1.charAt(m) + retWord;
			retWord = checkMatrixLeft(backTrack, m-1, n-1, retWord, word1);
		}
		
		if(backTrack[m][n] == 'U'){
			retWord = word1.charAt(m) + retWord;
			retWord = checkMatrixLeft(backTrack, m-1, n, retWord, word1);
			
		}
		
		if(backTrack[m][n] == 'L'){
			retWord =  '*' + retWord;
			retWord = checkMatrixLeft(backTrack, m, n-1, retWord, word1);
		}
		
		
		return retWord;
	}//end checkMatrix(char[][]) method;

	private static char[][] buildBackTrack(int[][] pathMatrix) {
		// TODO build a back track matrix which will be one size bigger than pathMatrix
		if(pathMatrix==null) return null;
		
		int row = pathMatrix.length;
		int col = pathMatrix[0].length;
		char[][] backTrack = new char[row][col];
		
		//the first column all point to Up;
		for(int i=0; i<row; i++){
			
			backTrack[i][0] = 'U';
		}
		
		//the first row all point to Left;
		for(int j=0; j<col; j++){
			
			backTrack[0][j] = 'L';
		}
		
		for(int i=1; i<row; i++){
			
			for(int j=1; j<col; j++){
				
				if(pathMatrix[i][j] == pathMatrix[i-1][j-1]+1){
					backTrack[i][j] = 'O';
					
				} 						
				
				if(pathMatrix[i][j] == pathMatrix[i][j-1]){
					backTrack[i][j] = 'L';
					
				} 
				if(pathMatrix[i][j] == pathMatrix[i-1][j]){
					backTrack[i][j] = 'U';
					
				} 
				
								
			}//inner for j<col loop;			
			
		}//end outer for i<row loop;
		if(pathMatrix[0][0] == 1) backTrack[0][0] = 'O';
		
		return backTrack;
	}//end buildBackTrack() method;

	private static int[][] buildPathMatrix(int[][] match) {
		// TODO build a path matrix base on match matrix
		if(match.length==0 || match[0].length==0) return null;
		
		int row = match.length+1;
		int col = match[0].length+1;
		
		int[][] pathMatrix = new int[row][col];
		pathMatrix[0][0] = match[0][0];
		
		//setup first column;
		for(int i=0; i<row; i++){
			pathMatrix[i][0] = 0;
		}
		
		//setup first row;
		for(int j=1; j<col; j++){
			pathMatrix[0][j] = 0;
		}
		
		//setup the whole path matrix;
		
		for(int i=1; i<row; i++){
			
			for(int j=1; j<col; j++){
				
				pathMatrix[i][j] = maxOfThree(pathMatrix[i-1][j], pathMatrix[i][j-1], pathMatrix[i-1][j-1] + match[i-1][j-1]);
			
			}	
		}
		
		return pathMatrix;
	}//end buildPathMatrix() method;

	private static int maxOfThree(int i, int j, int k) {
		// TODO return the max of three integers
		int max = i;
		if(j>max) max = j;
		if(k>max) max = k;
		
		return max;
	}//end maxOfThree() method;

	private static void printMatrix(int[][] match, String word1, String word2) {
		// TODO printout a matrix;
		if(match.length==0 || match[0].length==0){
			System.out.println("it's an empty matrix.");
			return;
		}
		word1 = " " +word1;
		word2 = " " +word2;
		
		int row = match.length;
		int col = match[0].length;
		
		//printout the upper boundary;
		System.out.print(" ");
		for(int i=0; i<col; i++){
			System.out.print(" "+word2.charAt(i));
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
	}//end printMatrix(int[][]) method;


	private static void printMatrix(char[][] matrix, String word1,String word2) {
		// TODO Auto-generated method stub
		if(matrix==null){
			System.out.println("Nothing in the char[][] matrix.");
			return;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		word1 = " " + word1;
		word2 = " " +word2;
		
		System.out.print(" ");
		for(int i=0; i<col; i++){
			System.out.print(" " + word2.charAt(i));
		}
		System.out.println();
		
		for(int i=0; i<row; i++){
			
			System.out.print(word1.charAt(i));
			
			for(int j=0; j<col; j++){
				
				System.out.print(" " + matrix[i][j]);
			}
			
			System.out.println();
		}
		
		System.out.println();
	}//end printMatrix(char[][]) method;
	
	
	private static int[][] buildMatchMatrix(String word1, String word2) {
		// TODO build a match matrix;
		int row = word1.length();
		int col = word2.length();
		int[][] matrix = new int[row][col];
		
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				if(word1.charAt(i) == word2.charAt(j))
					matrix[i][j] = 1;
			}
		}
		
		return matrix;
	}//end buildMatchMatrix() method;

}//end everything;
