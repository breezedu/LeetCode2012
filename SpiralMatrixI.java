package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/*****************
 * Given a matrix of m x n elements (m rows, n columns)
 * return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 *  ]
 *  
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author Frog
 * 
 */

public class SpiralMatrixI {

	public static void main(String[] args){
		
		System.out.println("This is Spiral Matrix I program.");
		
		//1st, build a matrix of m*n:
		int matrix[][] = buildMatrix();
		printMatrix(matrix);
		
		
		//2nd, put the matrix into an array list as "spiral way"
		ArrayList<Integer> sprialMatrix = spiralOrder(matrix);
		
		//3rd, printout the arrayList
		System.out.println("Print out the array list: ");
		printArrayList(sprialMatrix);
		
	}//end main();

	private static void printArrayList(ArrayList<Integer> arrayList) {
		// TODO printout an arrayList
		if(arrayList==null){
			System.out.println("It's an empty ArrayList.");
			return;
		}
		
		for(int e:arrayList){
			System.out.print(" " +e);
		}
		
		System.out.println();
	}//end printArrayList() method;

	private static ArrayList<Integer> spiralOrder(int[][] matrix) {
		// TODO put each element from matrix to arrayList, in spiral way
		if(matrix == null){
			return null;
		}
		
		ArrayList<Integer> retAL = new ArrayList<Integer>();
		int row = matrix.length;
		int col = matrix[0].length;
		
		int[][] openPosition = new int[row][col];
		System.out.println("openPosition matrix shows whether a position has been visited or not:");
		printMatrix(openPosition);
		
		int m=0;
		int n=0; //(m, n) are the ordinary of the start point of circle
		retAL = addCircle(matrix, openPosition, m, n, row, col, retAL);
		
		
		//recursion:::
		
		
		
		return retAL;
	}

	private static ArrayList<Integer> addCircle(int[][] matrix, int[][] openPosition, int m, int n, int row, int col, ArrayList<Integer> retAL) {
		// TODO add a circle from matrix[m][n] to [m, n+ col-1] to [m+row-1, n+col-1] to [m+row-1, n] to [m+1, n]; 
		if(m>=openPosition.length || n>=openPosition[0].length ||openPosition[m][n] ==1){
			return retAL;
		}
		
		System.out.println("m=" + m+", n=" + n +", row=" + row +", col=" +col);
		
		if(row == 1){
			for(int i=n; i<n+col; i++){
				retAL.add(matrix[m][i]);
			}
			
			return retAL;
		}
		
		if(col == 1){
			for(int i=m; i<m+row; i++){
				retAL.add(matrix[i][n]);
			}
			
			return retAL;
		}
		//add first row;
		for(int i=n; i<n+col; i++){
			retAL.add(matrix[m][i]);
			openPosition[m][i] = 1;
		}
		printMatrix(openPosition);
		
		//add right column
		for(int i=m+1; i<m+row; i++){
			retAL.add(matrix[i][m+col-1]);
			openPosition[i][m+col-1] = 1;
		}
		printMatrix(openPosition);
		
		//add down row
		for(int i=n+col-2; i>=n; i--){
			retAL.add(matrix[m+row-1][i]);
			openPosition[m+row-1][i] = 1;
		}
		printMatrix(openPosition);
		
		//add left column
		for(int i=m+row-2; i>m; i--){
			retAL.add(matrix[i][n]);
			openPosition[i][n] = 1;
			
		}
		System.out.println("After traversal one circle:");
		printMatrix(openPosition);
		
		retAL = addCircle(matrix, openPosition, m+1, n+1, row-2, col-2, retAL);
		
		return retAL;
	}//end addCircle() method;

	private static void printMatrix(int[][] matrix) {
		// TODO printout a matrix
		if(matrix==null){
			System.out.println("This is an empty matrix.");
			return;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		if(row==0 || col==0) {
			System.out.println("Nothing in the matrix.");
			return;
		}
		
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				if(matrix[i][j]<10){
					System.out.print("  " + matrix[i][j]);
					
				} else {
					System.out.print(" " + matrix[i][j]);
				
				}
			}
			
			System.out.println();
		}
		
		System.out.println();
		
	}//end of printMatrix() method;

	private static int[][] buildMatrix() {
		// TODO create a matrix of m*n;
		System.out.println("Please input the row and col of the matrix to build:");
		System.out.print("Row = ");
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		
		System.out.print("Col = ");
		int col = input.nextInt();
		input.close();
		if(row==0 || col==0){
			System.out.println("Thant means an empty matrix.");
			return null;
		}
		
		int[][] matrix = new int[row][col];
		
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				matrix[i][j] = i*col + j +1;
			}
		}
		return matrix;
	}//end buildMatrix() method;
	
}//end of everything in SpiralMatrix I class;
