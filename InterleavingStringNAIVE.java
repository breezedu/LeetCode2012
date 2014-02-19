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
 * This program will result in TLE time limit exceeded;
 */
public class InterleavingStringNAIVE {

	public static void main(String[] args){
		
		System.out.println("This is a Interleaving String problem.");
		System.out.println("Please input two original strings:");
		Scanner input = new Scanner(System.in);
		
		String s1 = input.next();
		String s2 = input.next();
		
		System.out.println("Please input the last string to check:");
		String s3 = input.next();
		input.close();
		
		boolean isInterleaving = isInterleave(s1, s2, s3);
		
		if(isInterleaving){
			System.out.println("S3 is a Interleaving String.");
			
		} else {
			System.out.println("S3 is NOT a Interleaving String.");
			
		}
		
	}//end main();

	private static boolean isInterleave(String s1, String s2, String s3) {
		// TODO Auto-generated method stub
		if(s3==null &&s1==null &&s2==null){
			return true;
		}
		if(s1==null && s2!=null){
			return s2.equals(s3);
		}
		
		if(s2==null && s1!=null){
			return s1.equals(s3);
		}
		
		int Len3 = s3.length();
		int Len2 = s2.length();
		int Len1 = s1.length();
		if(Len3 != Len1+Len2) return false;
		
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		
		if(s3.charAt(p3)!=s1.charAt(p1) && s3.charAt(p3)!=s2.charAt(p2)){
			return false;
			
		} else if(s3.charAt(p3)==s1.charAt(p1) && s3.charAt(p3)!=s2.charAt(p2)){
			if(s1.length()==1){
				return s2.equals(s3.substring(p3+1));
				
			} else	return isInterleave(s1.substring(p1+1), s2, s3.substring(p3+1));
			
		} else if(s3.charAt(p3)!=s1.charAt(p1) && s3.charAt(p3)==s2.charAt(p2)){
			if(s2.length()==1){
				return s1.equals(s3.substring(p3+1));
			} else return isInterleave(s1, s2.substring(p2+1), s3.substring(p3+1));
			
		} else if(s3.charAt(p3) == s1.charAt(p1) && s3.charAt(p3) == s2.charAt(p2)){
			
			if(s2.length()==1){
				return s1.equals(s3.substring(p3+1));
			}
			
			if(s1.length()==1){
				return s2.equals(s3.substring(p3+1));
			}
			
			return isInterleave(s1.substring(p1+1), s2, s3.substring(p3+1)) || isInterleave(s1, s2.substring(p2+1), s3.substring(p3+1));
		}
		
		return false;
		
	}//end isInterleave() method;
	
	
	
}//end everything in InterleavingString class
