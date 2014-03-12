package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/***************
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chess board 
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *   
 *   ["..Q.",  // Solution 2
 *    "Q...",
 *    "...Q",
 *    ".Q.."] 
 *    ]
 *    
 * @author Frog
 *
 */
public class NQueensPuzzle {

	public static void main(String[] args){
		
		System.out.println("This is a N-Queens problem.");
		
		//1st, ask user to input the size of the chess board N;
		System.out.println("Please input the N of the chess board:");
		Scanner input = new Scanner(System.in);
		System.out.print(" N= ");
		int n = input.nextInt();
		input.close();
		
		
		//2nd, call solveNQueens() method to create ArrayList
		ArrayList<String[]> queenPuzzle = solveNQueens(n);
		
		printArrayList(queenPuzzle);
		
		
	}//end main()

	/************
	 * initial an board matrix to record the valid queens' position;
	 * if matrix[i][j] ==0, it means there's no Queen there; otherwise there's a Queen
	 * call dfsBoard() to dfs-traversal the matrix row by row: 
	 * for each position of current row, check if matrix[row][i] is a valid position 
	 * for another Queen, if YES, update matrix[row][i]; 
	 * call dfsBoard() method to check next row;
	 * 
	 * !!! recovery the matrix[row][i] back to 0, then we do not need to initial a new matrix;
	 * when row reaches n, it means a valid board has been build, create String[] array 
	 * according to the matrix: 0-> '.', 1->'Q';
	 * add the string into an ArrayList, return the ArrayList;
	 * @param n
	 * @return
	 */
	private static ArrayList<String[]> solveNQueens(int n) {
		// TODO place n queens in a chess board
		ArrayList<String[]> retAL = new ArrayList<String[]>();
		if(n==0) return retAL;
		
		int[][] matrix = new int[n][n];	//a matrix[][] to check if next 
		
		dfsBoard(matrix, 0, n, retAL);
		
		return retAL;
	}//end solveNQueens() method;


	private static void dfsBoard(int[][] matrix, int n, int row, ArrayList<String[]> retAL) {
		// TODO deep-first-search the board matrix, check if there's any location at row n valid for another queen
		//return retAL condition
		if(row == n){
			System.out.println("Got one board.");
			printMatrix(matrix);
			
			//create an string[] array based on the matrix: 0-> '.', 1->'Q';
			//add string[] array to arrayList
			String[] queens = new String[n];
			for(int q=0; q<n; q++){
				queens[q] = ""; 	//initialization queens[] string array;
						
				for(int j=0; j<n; j++){
					if(matrix[q][j]==0) queens[q] += ".";
					else queens[q] += "Q";
				}
						
			}//end for q<n loop;
			retAL.add(queens);
		}//end return condition.
		
		//dfs current row:
		for(int i=0; i<n; i++){
			if(isValid(matrix, row, i)){
				
				matrix[row][i] = 1;
				dfsBoard(matrix, row+1, n, retAL);//call dfsBoard() for next row;
				
				//recovery matrix
				matrix[row][i] = 0;
			}
			
		}//end for i<n; loop;
		
	}//end dfsBoard() method;

	/********
	 * check if matrix[row][col] is a valid position for another queen;
	 * 1st, check the column from matrix[0][col] till matrix[row][col];
	 * 2nd, check the up-left line, from matrix[row][col] to [row-1][col-1]-----
	 * 3rd, check the up-right line, from [row][col] to [row-1][col+1]-----
	 * if in any position there's another queen exist, then return false;
	 * 
	 * after traversal all three lines, no queen exist, return true;
	 * @param matrix
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean isValid(int[][] matrix, int row, int col) {
		// TODO to check if a location in [row,col] is valid for another queen;
		//1st, check column
		for(int i=0; i<row; i++){
			if(matrix[i][col]==1) return false;
			
		}
		
		//2nd, check up-left Os
		int i=row; 
		int j=col;
		while(i>0 && j>0){
			if(matrix[i-1][j-1]==1) return false;
			i--;
			j--;
			
		}
		
		//3nd, check up-right Os
		i=row; j=col;
		while(i>0 && j<matrix.length-1){
			if(matrix[i-1][j+1]==1) return false;
			i--;
			j++;
		}
		
		return true;
	}//end isValid() method;

	
	private static void printMatrix(int[][] matrix) {
		// TODO printout a matrix
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				System.out.print(" " + matrix[i][j]);
			}
			
			System.out.println();
		}
		
		System.out.println();
	}//end printMatrix() method;
	
	private static void printArrayList(ArrayList<String[]> queenPuzzle) {
		// TODO printout all string[] array in an arrayList
		if(queenPuzzle==null || queenPuzzle.size()==0) return;
		
		for(String[] array:queenPuzzle){
			printArray(array);
		}
		
		System.out.println();
	}//end printArrayList() method

	private static void printArray(String[] array) {
		// TODO printout an array
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.println(" " +array[i]);
		}
		
		System.out.println();
	}//end printArray() method;
	
}//end of everything in NQueensPuzzle class
