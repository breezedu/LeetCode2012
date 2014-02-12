package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/*************
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 * 
 * @author Frog
 *
 */

public class Triangle {

	public static void main(String[] args){
		
		System.out.println("This is a Triangle problem from LeetCode.");
		System.out.println("Please input how many rows in the triangle:");
		
		//1st, build a triangle, with random numbers for each node;
		Scanner input = new Scanner(System.in);
		int Row = input.nextInt();
		input.close();
		
		ArrayList<ArrayList<Integer>> triangle = buildTriangle(Row);
		System.out.println("Printout the original triangle: (size " + triangle.size() +") ");
		printTriangle(triangle);
		
		//2nd, calculate the smallest sum from top to the bottom;
		int minSum = minimumTotal(triangle);
		
		System.out.println("The minimum sum from top to bottom is: " +minSum);
		
		
	} // end main();

	/**********************
	 * Typical Dynamic Programming method
	 * 1st, if the arrayList is empty, just return null, 
	 * if there's only 1 element in the arrayList, just return that only one number;
	 * otherwise, "reverse the triangle upside down"; 
	 * build a matrix of sum[][], sum[row-1][i] = triangle's last row;
	 * according to dynamic programming principle:
	 * sum[i][k] = Min(sum[i+1][k], sum[i+1][k+1] + triangle's ith arrayList's k number;
	 * 
	 * @param triangle
	 * @return
	 */
	private static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// TODO Calculate the minimum sum from top to bottom
		if(triangle == null){
			return 0;
		}
		if(triangle.size() == 1){
			System.out.print(" (" + triangle.get(0).get(0) +") ");
			return triangle.get(0).get(0);
		}
		
		//put the triangle upside down
		int rows = triangle.size();
		int[][] sum = new int[rows][rows];
		
		for(int i=0; i<rows; i++){
			sum[rows-1][i] = triangle.get(rows-1).get(i);
			
		} // assign the last row of sum[][] matrix;
		
		for(int k= rows-2; k>=0; k--){
			
			for(int j=0; j<=k; j++){
				
				sum[k][j] = Math.min(sum[k+1][j], sum[k+1][j+1]) + triangle.get(k).get(j);
			}
		} // end for al:triangle loop;
		
		return sum[0][0];
	} // end minimumTotal() method;

	private static void printTriangle(ArrayList<ArrayList<Integer>> triangle) {
		// TODO printout a triangle
		
		int size = triangle.size();
		//size = size/2;
		
		for(ArrayList<Integer> row:triangle){
			
			size--;
			for(int i=0; i<size; i++){
				System.out.print("  ");
			}
						
			for(int e:row){
				
				if(e<10){
					System.out.print("   " + e);
					
				} else if(e<100) {
					System.out.print("  " +e);
					
				} else {
					System.out.print(" " +e);
					
				} // end if-else condition;
				
				
			} // end inner for loop; all integers in a row printed;
			
			System.out.println();
		} // end outer for loop; all arrayList in the triangle printed;
		
		System.out.println();
	} // end printTriangle() method;

	private static ArrayList<ArrayList<Integer>> buildTriangle(int row) {
		// TODO Create a triangle
		ArrayList<ArrayList<Integer>> triangleList = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<row; i++){
			
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			for(int j=0; j<=i; j++){
				
				tempList.add((int)(Math.random() *100) );
			} // end inner for j<i loop;
			
			triangleList.add(tempList); // add the integers AL to the tiangleList
			
		} // end for i<row loop;
		
		return triangleList;
		
	} // end buildTriangle() method;
	
} // end everything in Triangle class;
