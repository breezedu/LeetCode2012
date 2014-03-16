package leetCode2012;

import java.util.Scanner;

/****************
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area.
 * 
 * @author Frog
 *
 */
public class MaximalRectangleDP {

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

	/**************
	 * This is not an easy problem and the idea is not straightforward.
	 * Since the question requires the area of all ones region, 
	 * first we can define the region (rectangle) in the matrix. 
	 * Any region in the matrix has several basic properties:
	 *    1 corner point,  width, and length.
	 * Also which corner point it is decide the exact place of the region, 
	 * here we consider the bottom-right corner point, because we usually scan the matrix 
	 * from (0,0) to right and down direction. 
	 * For this problem, we also need to consider the "all ones" requirement, 
	 * where all the regions are filled with 1s.
	 * 
	 * We can then have this data structure:
	 * One 2D array(vector) ones[i][j],  where ones[i][j] stores the number of 
	 * contiguous 1s ended at matrix[i][j], along ith row. e.g.  
	 * if matrix[i] = "1011101", then ones[i]=1,0,1,2,3,0,1. 
	 * This array stores the length of the rectangle, for every possible bottom-right corner point.
	 * 
	 * Having this two values, next is to find the height of the rectangle, 
	 * as well as keep the "all ones" requirement.
	 * Start with a corner point [i][j],  since it is the bottom right corner, 
	 * the rectangle search direction is left and up.
	 * For the left we already have the number of contiguous 1s ones[i][j]. 
	 * How to get the height?  We need to scan all the values above ones[i][j], 
	 * it is from i-1 to 0. If meets 0, then stop, else compute the possible rectangle area, 
	 * and store the max. To compute the area, 
	 * the minimum length of rectangle should be compared and stores every time.
	 * @param matrix
	 * @return
	 */
	private static int maximalRectangle(char[][] matrix) {
		// TODO check the maximal rectangle in the matrix with only '1', return it's area;
		int row = matrix.length;  
        if(row == 0){  
            return 0;  
        } //directly return condition
        
        
        int col = matrix[0].length;  
        int[][] hOnes = new int[row][col];
          
        int max = 0;
        for(int i=0; i<row; i++){  
            for(int j=0; j<col; j++){  
            	
                if(matrix[i][j] == '1'){  
                    if(j == 0){ 
                        hOnes[i][j] = 1;  
                        
                    }else{  
                        hOnes[i][j] = hOnes[i][j-1] + 1;  
                        
                    }//end if-else j==0 conditions
                }//end if matrix[i][j]=='1' condition
            }//end inner for j<col loop;
        }//end for i<row loop;
        
        
        for(int i=0; i<row; i++){  
            for(int j=0; j<col; j++){  
                if(hOnes[i][j] != 0){  
                    int minI = i;  
                    int minRowWidth = hOnes[i][j];
                    while(minI >= 0){  
                        minRowWidth = Math.min(minRowWidth, hOnes[minI][j]);  
                        int area = minRowWidth * (i-minI+1);  
                        max = Math.max(max, area);
                        minI--;  
                    }  
                }  
            }  
        }  
          
        return max;  
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
