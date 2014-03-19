package leetCode2012;

import java.util.Scanner;
import java.util.Stack;

/****************
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * @author Frog
 *
 */
public class SudokuSolve {

	public static void main(String[] args){
		
		System.out.println("This is a Soduku Solve program.");
		
		//1st, ask user to input 9*9 characters
		System.out.println("Please input the 9*9 original board, with '.' standing for blank cell.");
		
		char[][] board = new char[9][9];
		Scanner input = new Scanner(System.in);
		for(int i=0; i<9; i++){
			String temp = input.next();
		//	System.out.print("Row[" + (i+1) +"]: ");
			board[i] = temp.toCharArray();			
		}		
		input.close();
		
		//printout the board[][] matrix
		printMatrix(board);
		
				
		//2nd call solveSudoku() method to solve the board;
		solveSudoku(board);
		
		//printout the result after solveSudoku
		System.out.println("After solveSudoku: ");
		printMatrix(board);
		
	}//end main();

	/**********
	 * create a stack to store all index of empty cells, index = row*9+col;
	 * call permulateFill() method to fill the board[][];
	 * @param board
	 */
	private static void solveSudoku(char[][] board) {
		// TODO solve the Sudoku board with empty cells
		Stack<Integer> emptyCells = new Stack<Integer>();
		
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(board[i][j]=='.') emptyCells.push(i*9+j);
			}
		}//end i<9 loop;
		
		permulateFill(emptyCells, board);
		
	}//end solveSudoku() method;

	/***************
	 * recovery index into [row, col];
	 * try every possible letter from '0' to '9', to see if that letter is a valid option for that
	 * cell 'currently', if yes, update board[row][col] to be that valid letter, then call permulateFill()
	 * to check next empty cell from emptyCells stack;
	 * 
	 * @param emptyCells
	 * @param board
	 * @return
	 */
	private static boolean permulateFill(Stack<Integer> emptyCells, char[][] board) {
		
		if(emptyCells.isEmpty()) return true;

		int index = emptyCells.pop();
		int row = index/9;
		int col = index%9;
			
		for(char letter = '1'; letter <='9'; letter++){
				
			if( isValid(letter, row, col, board) ){
				board[row][col] = letter;				
					
				if(permulateFill(emptyCells, board)) return true;
				board[row][col] = '.';
			}
					
		}//for letter<='9' loop;	
			
		emptyCells.push(index);
		return false;
		
	}//end permulateFill() method

	private static boolean isValid(char letter, int row, int col, char[][] board) {
		// TODO check if letter is a valid character at board[row][col];
		//1st, check the current row and col;
		for(int i=0; i<9; i++){
			if(board[row][i] == letter) return false;
			if(board[i][col] == letter) return false;
		}
		
		//2nd, check current small 3*3-cell board
		int startRow = row/3*3;
		int startCol = col/3*3;
		for(int i=startRow; i<startRow+3; i++){
			
			for(int j=startCol; j<startCol+3; j++){
				
				if(board[i][j] == letter) return false;
			}			
		}//end for i<startRow+3 loop;
		
		return true;
	}//end isValid() method;

	private static void printMatrix(char[][] board) {
		// TODO printout a matrix
		if(board==null ||board.length==0 || board[0].length==0) {
			System.out.println("It's an empty matrix.");
			return;
		}
		
		int row = board.length;
		int col = board[0].length;
		
		for(int i=0; i<row; i++){
			if(i%3==0) System.out.println();
			
			for(int j=0; j<col; j++){
				if(j%3==0) System.out.print(" ");
				System.out.print(" " + board[i][j]);
			}
			
			System.out.println();
		}
		
		System.out.println();
	}//end printMatrix() method;

}//end of everything in SudokuSolve class
