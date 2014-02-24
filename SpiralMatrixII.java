package leetCode2012;

import java.util.Scanner;

public class SpiralMatrixII {

	public static void main(String[] args){
		
		System.out.println("This is Spiral Matrix II program.");
		
		//1st, ask user to input the boundary of matrix (n*n)
		System.out.println("Please input the boundary of matrix: ");
		System.out.print("n = ");
		
		Scanner input = new Scanner(System.in);
		int n= input.nextInt();
		input.close();
		
		//2nd, build a spiral matrix
		int[][] matrix = buildSpiralMatrix(n);
		
		
		//3rd, printout the spiral matrix :)
		System.out.println("After building the spiral matrix:");
		printMatrix(matrix);
		
	}// end main();

	private static int[][] buildSpiralMatrix(int n) {
		// TODO build a spiral matrix;
		if(n==0){
			return null;
		}
		if(n==1){
			int[][] matrix = new int[1][1];
			matrix[0][0] = 1;
			return matrix;
		}
		
		int[][] matrix = new int[n][n];
		
		//add the outer circle; from [0,0] to [0,n-1] to [n-1, n-1] to [n-1,0] to [1,0]
		int beginVal = 1;
		matrix = addCircle(matrix, 0, n, beginVal);
		
		return matrix;
		
	}//end buildSpiralMatrix() method;
	
	/*************
	 * the start point will be [m,m], so we do not need to pass [m, n] to the addCircle mathod
	 * as well as the row and col will always be the same;
	 * 
	 * @param matrix
	 * @param m
	 * @param Len
	 * @param val
	 * @return
	 */
	private static int[][] addCircle(int[][] matrix, int m, int Len, int val) {
		// TODO Add a circle of real values to a matrix
		
		if(matrix[m][m]!=0){
			return matrix;
		}
		if(Len==1){
			matrix[m][m] = val;
			return matrix;
		}
		
		//add upper row
		for(int i=m; i<m+Len; i++){
			matrix[m][i] = val; 
			val++;
		}
		
		//add right column
		for(int i=m+1; i<m+Len; i++){
			matrix[i][m+Len-1] = val;
			val++;
		}
		
		//add down row
		for(int i=m+Len-2; i>=m; i--){
			matrix[m+Len-1][i] = val;
			val++;
		}
		
		//add left column
		for(int i=m+Len-2; i>m; i--){
			matrix[i][m] = val;
			val++;
		}
		
		printMatrix(matrix);
		
		addCircle(matrix, m+1, Len-2, val);
		return matrix;
	}

	private static void printMatrix(int[][] matrix) {
		// TODO printout a matrix
		
		if(matrix == null){
			System.out.println("It's an empty matrix.");
			return;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				if(matrix[i][j] < 10) {
					System.out.print("  " + matrix[i][j]);
					
				} else {
					System.out.print(" " + matrix[i][j]);
					
				}	//end if-else conditions;
			}
			
			System.out.println();
		}//end outer for i<row loop;
		System.out.println();
		
	}//end printMatrix() method;
	
}//end of everything in SpiralMatrixII class
