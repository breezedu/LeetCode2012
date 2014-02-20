package leetCode2012;

import java.util.Scanner;

/*******************
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. 
 * How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 *   ]
 * The total number of unique paths is 2.
 *   
 * @author Frog
 *
 */
public class UniquePathII {

	public static void main(String[] args){
		
		System.out.println("This is a Unique Path II program.");
		
		//1st, build a matrix of row*col;
		int[][] obstacleGrid = buildMatrix();
		System.out.println("printout the original matrix with obstacles:");
		printMatrix(obstacleGrid);
		
		int path = uniquePathsWithObstacles(obstacleGrid);
		
		System.out.println("There are "+path+" pathes to go from up-left to down-right corner.");
		
	}//end main();
	
	private static void printMatrix(int[][] matrix) {
		// TODO printout an matrix
		if(matrix==null ||matrix.length==0){
			System.out.println("It's an empty matrix.");
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				
				System.out.print(" " +matrix[i][j]);
			}
			
			System.out.println();
		}//end outer for i<row loop;
		
	}//end printMatrix() method;

	private static int[][] buildMatrix() {
		// TODO Auto-generated method stub
		System.out.println("Please input the row and col of obstacle matrix:");
		Scanner input = new Scanner(System.in);
		
		System.out.print("row= ");
		int row = input.nextInt();
		System.out.print("col= ");
		int col = input.nextInt();
		input.close();
		int[][] matrix = new int[row][col];
		
		//set some obstacles
		int obs = (int)(Math.random()*row*col/4); 
		
		for(int i=0; i<obs; i++){
			int m = (int)(Math.random()*row);
			int n = (int)(Math.random()*col);
			matrix[m][n] = 1;
		}
		
		return matrix;
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null) return 0;
        
        int row = obstacleGrid.length; 
            if(row==0) return 0;
            
        int col = obstacleGrid[0].length; 
            if(col==0) return 0;
        
        for(int i=0; i<row-1; i++){
            if(obstacleGrid[i][0] == 1) obstacleGrid[i+1][0] = 1;
        }
        
        for(int j=0; j<col-1; j++){
            if(obstacleGrid[0][j] ==1) obstacleGrid[0][j+1] = 1;
        }
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                
                if(obstacleGrid[i-1][j] ==1 && obstacleGrid[i][j-1] ==1)
                    obstacleGrid[i][j] = 1;
            }
        }
        
        System.out.println("Printout modified matrix:");
        printMatrix(obstacleGrid);
        
        if(obstacleGrid[row-1][col-1] == 1) return 0; //under this condition, there's no way to reach the down-right corner;
        
        boolean[][] travel = new boolean[row][col];
        
        for(int i=0; i<row; i++){
            
            for(int j=0; j<col; j++){
                
                if(obstacleGrid[i][j] == 1){
                    travel[i][j] = false;
                    
                } else {
                    travel[i][j] = true;
                }
                
            }//end inner for j<col loop;
            
        }//end out for i<row loop;
        int[][] path = new int[row][col];
        
        for(int i=0; i<row; i++){
            if(travel[i][0]) path[i][0] = 1;
        }
        for(int j=0; j<col; j++){
            if(travel[0][j]) path[0][j] = 1;
        }
        
        for(int i=1; i<row; i++){
            
            for(int j=1; j<col; j++){
                
                if(travel[i][j]) path[i][j] = path[i-1][j] + path[i][j-1];
                
            }
            
        }// end outer for i<row loop;
        
        return path[row-1][col-1];
        
    }//end of uniquePathsWithObstacles() method;
	
}//end everything in UniquePathII class;
