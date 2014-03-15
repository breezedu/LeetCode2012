package leetCode2012;

import java.util.Scanner;

/****************
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area.
 * 
 * @author Frog
 *
 */
public class MaximalRectangleNAIVE {

	public static void main(String[] args){
		
		System.out.println("This is Maximal Rectangle program.");
		
		//1st, create a matrix of '0's and '1's
		char[][] matrix = createMatrix();
		
		//printout the matrix;
		printMatrix(matrix);
		
		
		//2nd, check out the max rectangle in the matrix with '1';
		int max = maximalRectangle(matrix);
		
		//printout the maximal rectangel's area;
		System.out.println("The maximal rectangel's area is: " + max);
		
	}//end main()

	private static int maximalRectangle(char[][] matrix) {
		// TODO check the maximal rectangle in the matrix with only '1', return it's area;
		int max = 0;
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return max;
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				if(matrix[i][j] == '1'){
					int tempRec = getRectangle(matrix, i, j);					
					if(tempRec > max) max = tempRec;
					
				}//end if matrix[i,j]=='1' condition;
				
			}//end for j<col loop;
		}//end for i<row loop;
		
		return max;
	}//end maximalRectangle() method;

	private static int getRectangle(char[][] matrix, int m, int n) {
		// TODO matrix[m][n]=='1', get the maximal rectangle with [m,n] as the left-up corner
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		int j = n; 
		while(j<col && matrix[m][j]=='1'){
			j++;			
		}
		
		int upBoundary = j-1;
		System.out.print("j=" + j);
		
		int Max = j-n;
		int i=m;
		
		while(i<row-1 && matrix[i][n]=='1'){
			i++;
			int currCol = n;			
			
			while(currCol<upBoundary && matrix[i][currCol]=='1'){
				currCol++;
			}
			if(currCol<upBoundary) upBoundary = currCol;
			
			int currMax = (i-m+1) * (currCol-n);
	//		System.out.println(" i=" +i +" currmax=" + currMax);
			
			if(currMax > Max) Max = currMax;
			
		}//end while outer loop;
		
		return Max;
	}//end getRectangle() method;

	private static char[][] createMatrix() {
		// TODO ask user to input row and col of a matrix;
		System.out.println("Please input the row and col of the matrix.");
		Scanner input = new Scanner(System.in);
		System.out.print("row = ");
		int row = input.nextInt();
		
		System.out.print("col = ");
		int col = input.nextInt();
		input.close();
		
		if(row==0 || col==0) return null;
		//assign random 1 to the matrix;
		char[][] matrix = new char[row][col];
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if((int)(Math.random()*2)==1) matrix[i][j] = '1';
				else matrix[i][j] = '0';
				
			}//end for j<col loop;
		}//end for i<row loop;
		
		return matrix;
	}//end createMatrix() method;

	private static void printMatrix(char[][] matrix) {
		// TODO printout a matrix
		if(matrix==null || matrix.length==0 || matrix[0].length==0){
			System.out.println("It's empty.");
			return;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
	}//end of printMatrix() method;
	
}//end of everything in MaximalRectangle class
