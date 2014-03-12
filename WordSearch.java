package leetCode2012;

import java.util.Scanner;

/***************
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * For example,
 * Given board = 
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * @author Frog
 *
 */


public class WordSearch {

	public static void main(String[] args){
		
		System.out.println("This is WordSearch program.");
		
		//1st, build a board[][]
		String[] str = {"ABCE","SFCS","ADEE"};
		char[][] board = buildBoard(str);
		printMatrix(board);
		
				
		//2nd, input the target word
		System.out.println("Please input the target word:");
		Scanner input = new Scanner(System.in);
		System.out.print("target: ");
		String target = input.next();
		input.close();
		System.out.println("target.length = " + target.length());
		
		
		//3rd, check if the target word input could be found in the matrix board:
		boolean exist = existInBoard(board, target);
		
		if(exist) {
			System.out.println("Yes, there's one match in the board.");
			
		} else {
			System.out.println("No, no such a word in the board.");
			
		}
		
	}//end main()

	private static boolean existInBoard(char[][] board, String target) {
		// TODO check if the target word could be found in the board
		if(board==null || board.length==0 || board[0].length==0) return false;
		
		int row = board.length;
		int col = board[0].length;
		if(target.length() > row*col) return false;
		
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				
				if(board[i][j] == target.charAt(0)){
		
					int[][] matrix = new int[row][col];
					matrix[i][j] = 1; 	//to record all points in the board that has been visited
					int index = 1;
					
					if( checkAround(board, target, index, i, j, matrix) ){
						return true;
					}
					
				}//end if board[i][j]==target.charAt(0) condition
			}
		}
		
		return false;
	}

	private static boolean checkAround(char[][] board, String target, int index, int i, int j, int[][] matrix) {
		// TODO check the spots around board[i][j], if anyone match the target.charAt(index), check next index
		if(index == target.length()) return true;
	//	System.out.print(" " + target.charAt(index) +", ");
		//check up
		if(i!=0){
			if(matrix[i-1][j]==0 && board[i-1][j]==target.charAt(index)){
				matrix[i-1][j] = 1;
				if(checkAround(board, target, index+1, i-1, j, matrix)) {
					return true;
				} else {
					matrix[i-1][j] = 0;
				}
			}
			
		}//end check up;
		
		//check right
		if(j<board[0].length-1){
			if(matrix[i][j+1]==0 && board[i][j+1]==target.charAt(index)){
				matrix[i][j+1] = 1;
				if(checkAround(board, target, index+1, i, j+1, matrix))
					return true;
				else matrix[i][j+1] = 0;
			}
			
		}//end check right
		
		//check down
		if(i<board.length-1){
			if(matrix[i+1][j]==0 && board[i+1][j]==target.charAt(index)){
				matrix[i+1][j] = 1;
				if(checkAround(board, target, index+1, i+1, j, matrix))
					return true;
				else matrix[i+1][j] = 0;
			}
			
		}//end check down
		
		//check left
		if(j!=0){
			if(matrix[i][j-1]==0 && board[i][j-1]==target.charAt(index)){
				matrix[i][j-1] =1;
				if(checkAround(board, target, index+1, i, j-1, matrix))
					return true;
				else matrix[i][j-1] = 0;
			}
			
		}//check left
		
		return false;
	}//end checkAround() method

	private static void printMatrix(char[][] board) {
		// TODO printOut a matrix
		if(board==null ||board.length==0) return;
		
		int row = board.length;
		int col = board[0].length;
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
	}//end of printMatrix() method;

	private static char[][] buildBoard(String[] str) {
		// TODO build a char[][] board base on an string array
		
		int row = str.length;
		int col = str[0].length();
		char[][] board = new char[row][col];
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				board[i][j] = str[i].charAt(j);
			}
		}
		
		return board;
	}//end of buildBoard() method;
	
	
	
}//end of everything in WordSearch class
