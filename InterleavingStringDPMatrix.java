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
class Pairs{
	int row;
	int col;
}

public class InterleavingStringDPMatrix {

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
		
	//	int[][] matrix = new int[Len1+1][Len2+2];
		int p = 0;
		int row = 0;
		int col = 0;
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		char[] str3 = s3.toCharArray();
		
		return traversalMatrix(str3, p, str1, row, str2, col);
				
	}//end isInterleave() method;

	private static boolean traversalMatrix(char[] str3, int p, char[] str1,	int row, char[] str2, int col) {
		// TODO Auto-generated method stub
		
		if(p==str3.length) {
			System.out.println("one trace.");
			return true;
			
		} else {
			

			if(row<str1.length && str3[p] == str1[row]){
				if(traversalMatrix(str3, p+1, str1, row+1, str2, col)) return true;				
				//reverse p and row;
			}			
			
			if(col<str2.length && str3[p] == str2[col]){
				if( traversalMatrix(str3, p+1, str1, row, str2, col+1)) return true;
				//reverse p and row;
			}			
			
		}	
		
		return false;
	}
	
	
	
}//end everything in InterleavingString class
