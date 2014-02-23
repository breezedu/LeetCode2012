package leetCode2012;

import java.util.Scanner;

/*******
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * 
 * @author Frog
 *
 */
public class RotateImage {

	public static void main(String[] args){
		
		System.out.println("This is rotate Image program.");
		
		//1st, build an n*n matrix;
		int[][] matrix = buildSymmetricMatrix();
		printMatrix(matrix);
		
		
		//2nd, rotate the matrix;		
		rotateUpRight2DownLeft(matrix);
		System.out.println("After rotation rotateUpRight2DownLeft: ");
		printMatrix(matrix);
		
		roatatUp2Down(matrix);
		System.out.println("After rotation Up2Down: ");
		printMatrix(matrix);
		
	}//end main();

	private static void roatatUp2Down(int[][] matrix) {
		// TODO ratate upside down;
		
		int n=matrix.length;
		
		for(int i=0; i<n/2; i++){
			
			for(int j=0; j<n; j++){
				swap(matrix, i, j, n-i-1, j);
				
			}
		}
		
	}

	private static void rotateUpRight2DownLeft(int[][] matrix) {
		// TODO rotate a matrix;
		if(matrix==null || matrix.length==1){
			return;
		}
		
		int n = matrix.length;
		
		for(int i=0; i<n; i++){
			
			for(int j=i; j<n; j++){
				
				swap(matrix, i, j, j, i);
			}
		}
		
	}//end rotate() method;

	private static void swap(int[][] matrix, int i, int j, int m, int n) {
		// TODO swap two elements in a matrix;
		int temp = matrix[i][j];
		matrix[i][j] = matrix[m][n];
		matrix[m][n] = temp;
		
	}//end swap() method;

	private static void printMatrix(int[][] matrix) {
		// TODO printout a matrix
		
		if(matrix==null) {
			System.out.println("That is an empty matrix.");
			return;
		}
		
		int n = matrix.length; //as a symmetric matrix, not necessary to get the col;
		for(int i=0; i<n; i++){
			
			for(int j=0; j<n; j++){
				
				System.out.print(" " + matrix[i][j]);
			}
			
			System.out.println();
		}
		
	}//end printMatrix() method;

	private static int[][] buildSymmetricMatrix() {
		// TODO build a n*n matrix
		System.out.println("Please input the boundary length of n*n matrix:");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		
		if(n==0){
			System.out.println("That's an empty matrix.");
			return null;
		}
		
		int[][] matrix = new int[n][n];
		for(int i=0; i<n; i++){
			
			for(int j=0; j<n; j++){
				
				matrix[i][j] = (int)(Math.random() * 10);
			}
		}//end outer for loop;
		
		return matrix;
	}//end of buildSymmetricMatrix() method;
	
	
}//end of everything in rotateImage class
