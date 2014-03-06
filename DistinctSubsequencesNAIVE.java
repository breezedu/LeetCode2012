package leetCode2012;

import java.util.Scanner;
import java.util.Stack;

/******************
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string 
 * by deleting some (can be none) of the characters without disturbing 
 * the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * @author Frog
 *  Time Limit Exceeded ==!
 */
public class DistinctSubsequencesNAIVE {
	
	public static void main(String[] args){
		
		System.out.println("This is Distinct Subsequences program.");
		
		//1st, ask user to input the original string and the target string;
		System.out.println("Please input the original and target strings:");
		Scanner input = new Scanner(System.in);
		System.out.print("original string: ");
		String oriStr = input.next();
		
		System.out.print("target string: ");
		String target = input.next();
		input.close();
		
		
		//2nd, calculate the distinct subsequences:
		Stopwatch timmer = new Stopwatch();
		int dist = numDistinct(oriStr, target);
		
		//printout the result
		System.out.println("There are " + dist + " distinct subsequences in the original string.");
		System.out.println("The time used is: " + timmer.elapsedTime());
		
	}//end main()

	private static int numDistinct(String oriStr, String target) {
		// TODO calculate the num of distinct target subsequences in the original string;
		if(target.length() > oriStr.length()) return 0;
		
		Stack<Integer> num = new Stack<Integer>();
		num.push(0);
		int startOri = 0;
		int startTar = 0;
		
		calculateDistinct(oriStr, target, startOri, startTar, num);
		
		return num.pop();
	}//end of numDistinct() method;

	private static void calculateDistinct(String oriStr, String target,	int startOri, int startTar, Stack<Integer> num) {
		// TODO calculate if there's equal letter of target.charAt(startTar) in the oriStr after startOri
	//	System.out.print(" startTar=" +startTar +". ");
		if(startTar >= target.length()){
			int n = num.pop();
	//		System.out.print("get one");
			num.push(n+1);
			return;
		}
		
		char temp = target.charAt(startTar);
		for(int i= startOri; i<oriStr.length(); i++){
			
			if(oriStr.charAt(i) == temp){
	//			System.out.print(" (" + oriStr.charAt(i) +")");
				int oriNext = i+1;
				int tarNext = startTar+1;
				calculateDistinct(oriStr, target, oriNext, tarNext, num);
			}
			
		}//end for i<oriStr loop;
		
	}//end calculateDistinct() method;
	
	

}//end of everything in DistinctSubsequences class
