package leetCode2012;

import java.util.Scanner;

public class SetMatrixZeros {

	public static void main(String[] args){
		
		System.out.println("This is a Set matrix Zeros program.");
		
		//1st, create a matrix of m*n;
		int[][] matrix = createMatrix();
		System.out.println("Printout the original matrix:");
		printMatrix(matrix);
		
		//2nd, set the row and col of the matrix to be 0, if m[i][j] ==0;
		setZeroes(matrix);
		System.out.println("After the setZeros operation:");
		printMatrix(matrix);
		
	}//end main();
	
	
	
	/**********
	 * 1st, check if the first row and first col should be zero or not, assign rowZero/colZero;
	 * 
	 * 2nd, traversal through the matrix from 1-row and 1-col: 
	 * if matrix[i][j]==0; set matrix[0][j] and matrix[i][0] to be zero;
	 * 
	 * 3rd, traversal first column, if matrix[i][0]==0, then the whole row of matrix[i] should be zero;
	 * 4th, traversal first row, if matrix[0][j]==0, then the whole cold of matrix[][j] should be zero;
	 * 
	 * 5th, check rowZero and colZero, set the first row and first column accordingly;
	 * @param matrix
	 */
	public static void setZeroes(int[][] matrix) {
        
        if(matrix.length ==0) return;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean rowZero = false;
        boolean colZero = false;
        for(int i=0; i<row; i++){
            if(matrix[i][0] == 0) rowZero = true;
        }
        
        for(int j=0; j<col; j++){
            if(matrix[0][j] == 0) colZero = true;
            
        }
        
        
        for(int i=1; i<row; i++){
            
            for(int j=1; j<col; j++){
                
                if(matrix[i][j] == 0){
                    
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                   
                }
                
            }// inner for j<col loop;
            
        }// out for i<row loop;
        
        
        for(int i=1; i<row; i++){
            if(matrix[i][0] ==0){
                
                for(int k=0; k<col; k++) matrix[i][k] = 0;
            }
        }
        
        for(int j=1; j<col; j++){
            
            if(matrix[0][j] == 0){
                
                for(int k=0; k<row; k++) matrix[k][j] = 0;
            }
        }
        
        if(rowZero){
            
            for(int i=0; i<row; i++) matrix[i][0] = 0;
        }
        
        if(colZero){
            
            for(int j=0; j<col; j++) matrix[0][j] = 0;
        }
        
        
    }//end setZeroes() method;
	
	
	private static int[][] createMatrix() {
		// TODO create a matrix of m*n
		System.out.println("Please input the row and col of the matrix:");
		
		Scanner input = new Scanner(System.in);
		System.out.print("row = ");
		int row = input.nextInt();
		System.out.print("col = ");
		int col = input.nextInt();
		
		input.close();
		if(row==0 || col==0) return null;
		
		int[][] matrix = new int[row][col];
		
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				matrix[i][j] = (int)(Math.random() * row*col/4);
			}
		}//end out for i<row loop;
		
		return matrix;
	}//end createMatrix() method;
	
	

	private static void printMatrix(int[][] matrix) {
		// TODO printout a matrix;
		if(matrix == null || matrix.length==0 || matrix[0].length==0){
			System.out.println("Nothing in the matrix.");
			return;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				if(matrix[i][j] < 10){
					System.out.print("  " + matrix[i][j]);
				
				} else {
					System.out.print(" " +matrix[i][j]);
				
				}
			}
			
			System.out.println();
		}
		System.out.println();
	}//end printMatrix() method;
	
	
}//end of everything in SetMatrixZeros class
