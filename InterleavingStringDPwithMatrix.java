package leetCode2012;

import java.util.Scanner;

/*******************
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * @author Frog
 * This program remove s1 from s3 then compare the left string to s2 :)
 */

public class InterleavingStringDPwithMatrix {

	public static void main(String[] args){
		
		System.out.println("This is a Interleaving String problem.");
		System.out.println("Please input two original strings:");
		Scanner input = new Scanner(System.in);
		
		System.out.print("s1= ");
		String s1 = input.nextLine();
		System.out.print("s2= ");
		String s2 = input.nextLine();
		
		System.out.println("Please input the last string to check:");
		System.out.print("s3= ");
		String s3 = input.nextLine();
		input.close();
		Stopwatch timmer = new Stopwatch();
		
		boolean isInterleaving = isInterleave(s1, s2, s3);
		
		if(isInterleaving){
			System.out.println("S3 is a Interleaving String.");
			
		} else {
			System.out.println("S3 is NOT a Interleaving String.");
			
		}
		
		System.out.print("The time uses is: " + timmer.elapsedTime() +" seconds.");
		
	}//end main();

	private static boolean isInterleave(String s1, String s2, String s3) {
		// TODO Auto-generated method stub
				
		int Len3 = s3.length();
		int Len2 = s2.length();
		int Len1 = s1.length();
		
		if(Len3 != Len1+Len2) return false;
		if(Len1==0 && Len2==0 &&Len3==0) return true;
		if(Len1==0) return s2.equals(s3);
		if(Len2==0) return s1.equals(s3);		
	
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		char[] str3 = s3.toCharArray();
		
		//create a matrix, matrix[i][j] represents whether str3[i+j] is reachable or not;
		boolean[] reach = new boolean[Len3+1];
		
		int[][] matrix = new int[Len1+1][Len2+1];
		matrix[0][0] = 1;
		int index=0;
		while(str3[index]==str1[index]) {
			matrix[index+1][0]=1;
			reach[index] = true;
			index++;
		}
		index = 0;
		while(str3[index]==str2[index]) {
			matrix[0][index+1]=1;
			reach[index] = true;
			index++;
		}
		
		for(int row=0; row<str1.length; row++){
			
			for(int col=0; col<str2.length; col++){
				
				index = row+col+1;
				if(!reach[index-1]) return false; //if at any point we could not go to next char;
				
				if(str1[row] == str3[index] && matrix[row][col+1]==1){
                    matrix[row+1][col+1]=1; 
                    reach[index] = true;
                }
                if(str2[col] == str3[index] &&matrix[row+1][col]==1){
                	matrix[row+1][col+1] =1;
                	reach[index] = true;
                	//matched[i1][i2] |= matched[i1][i2 - 1];
                }
				
			}//end for col<str2.length loop;
		
		}//end for row<str1.length loop
		
		printMatrix(matrix, str1, str2, str3);
		
		return reach[Len3-1];
	}//end isInterleave() method;

	private static void printMatrix(int[][] matrix, char[] str1, char[] str2, char[] str3) {
		// TODO Auto-generated method stub
		
		System.out.println("Matrix plus three strings.");
		int Len1 = str1.length;
		int Len2 = str2.length;
	
		System.out.print("   ");
		
		//printout str2
		for(int i=0; i<Len2; i++){
			System.out.print(" " +str2[i]);
		}
		System.out.println();
		
		System.out.print(" ");
		
		for(int i=0; i<Len2+1; i++){
			
			//System.out.print(" " + matrix[0][i]);
			if(matrix[0][i]==1 && i-1>=0)
				System.out.print(" " + str3[i-1]);
			else System.out.print(" " +".");
		}
		System.out.println();
		
		for(int i=1; i<=Len1; i++){
			
			System.out.print(str1[i-1]);
			for(int j=0; j<Len2+1; j++){	
				//System.out.print(" " + matrix[i][j]);
				if(matrix[i][j]==1)
					System.out.print(" " + str3[i+j-1]);
				else System.out.print(" " +".");
			}
			
			System.out.println();
		}
	}//end printMatrix() method;
	
	
	
}//end everything in InterleavingString class
