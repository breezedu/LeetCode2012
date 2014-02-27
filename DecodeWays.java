package leetCode2012;

import java.util.Scanner;

/******************
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 * @author Frog
 *
 */
public class DecodeWays {

	public static void main(String[] args){
		
		System.out.println("This is Decode Ways program.");
		
		//1st, ask use to input a string of integers
		System.out.println("Please input the number:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		String numStr = input.nextLine();
		input.close();
		
		//2nd, praseInt characters to integers;
		int ways = numDecodings(numStr);
		
		System.out.println("There are " + ways +" ways to reconstruct the string.");
	}//end main();

	/****************
	 * Dynamic Programming method :)
	 * the key is to figure out the condition of less than 2 characters;
	 * 0, 01, 10, 20, 30, 27, 11 etc......
	 * 
	 * then following steps are straight forward;
	 * @param numStr
	 * @return
	 */
	private static int numDecodings(String numStr) {
		// TODO Auto-generated method stub
		if(numStr.length()==0 || numStr.charAt(0) == '0') return 0;
		if(numStr.length()==1 && numStr.charAt(0) != '0') return 1;		
		
		int Len = numStr.length();
		int[] ways = new int[Len];
		
		System.out.println("subStr: " + Integer.parseInt(numStr.substring(0,2) ) );
		ways[0] = 1; //unless the first character is '0';

		if(numStr.charAt(1) == '0'){
			if(numStr.charAt(0) == '0' || Integer.parseInt(numStr.substring(0,2)) >26){
				return 0;
				
			} else {
				ways[1] = 1;
				
			}
			
		} else {			
			if(Integer.parseInt(numStr.substring(0,2)) >26) {
				ways[1] = 1;
			} else {
				ways[1] = 2;
			}
			
		}//end if-else chatAt(1)=0 conditions;
		
		if(Len ==2) return ways[1];
		
		for(int i=2; i<Len; i++){
			int twoChar = Integer.parseInt(numStr.substring(i-1, i+1));
			if(twoChar == 0) return 0;
			
			if(numStr.charAt(i) == '0' && twoChar>26){
			    return 0;
			
			} else if(numStr.charAt(i) =='0' && twoChar<27) {
				ways[i] = ways[i-2];
				
			} else if(twoChar >9 && twoChar<27){
				ways[i] = ways[i-1] + ways[i-2];
				
			} else if(twoChar <10 || twoChar>26 ){
				ways[i] = ways[i-1];
				
			}
		}//end for i<Len loop;
		
		return ways[Len-1];		

		
	}//end of numDecodings() method;
	
}//end of everything in DecodeWays class
