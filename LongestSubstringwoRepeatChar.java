package leetCode2012;

import java.util.Scanner;

/*****************
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author Frog
 *
 */
public class LongestSubstringwoRepeatChar {

	public static void main(String[] args){
		
		System.out.println("This is Longest Substring without Repeat Characters program.");
		
		//1st, ask user to input a string
		System.out.println("Please input the string:");
		Scanner input = new Scanner(System.in);
		System.out.print(" string: ");
		String oriStr = input.next();
		input.close();
		
		
		//2nd, calculate the longest substring without repeat character
		int Len = lengthOfLongestSubstring(oriStr);
		System.out.println("The longest unique subString's length is: " + Len);
		
		
	}//end main();

	/***********
	 * pretty much like DP, create an array of equal length to the string;
	 * each array[i] record the length of longest substring to it: 
	 * array[0] = 1;
	 * if s.charAt(1)==s.chatAt(0), then array[1] = 1; else array[1] = 2;
	 * the to every point of index i, array[i-1] record longest substring to s.charAt(i-1);
	 * suppose array[i-1] = 6, then there are 6 different letters before s.charAt(i);
	 * compare s.charAt(i) to every letter in front of s.charAt(i), if no match, the array[i]++;
	 * if we get one match, then break, that point is the longest unique subString ended at s.charAt(i);
	 * once we get an array[i], compare it with the maxLen, if array[i]>maxLen, update maxLen's value;
	 * if we get 26, which is the longest substring we can get, return 26 directly;
	 * 
	 * @param oriStr
	 * @return
	 */
	private static int lengthOfLongestSubstring(String oriStr) {
		// TODO Auto-generated method stub
		if(oriStr.length() == 0) return 0;
		if(oriStr.length() == 1) return 1;
		
		int Len = oriStr.length();
		int[] subLen = new int[Len];
		
		subLen[0] = 1; 	//this is the start point;
		int maxLen = 1;	//the worst condition;
		
		for(int i=1; i<Len; i++){
			subLen[i] = 1;
			for(int j=1; j<=subLen[i-1]; j++){
				if(oriStr.charAt(i) != oriStr.charAt(i-j)){
					subLen[i]++;
				
				} else {
					break;
				}
				
			}//end inner for loop;
			
			//compare subLen[i] with maxLen, and 26.
			if(subLen[i] > maxLen) {
				maxLen = subLen[i];
				
				if(maxLen == 26) return 26;
			}
			
			System.out.println("i=" +i+ ", " + subLen[i]);
			
		}//end outer for loop;
		
		return maxLen;
	}//end lengthOfLongestSubstring() method;
	
	
}//end of everything in LongestSubstringwoRepeatChar class
