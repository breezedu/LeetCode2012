package leetCode2012;

import java.util.Scanner;
import java.util.Stack;

/****************
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", 
 * where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * @author Frog
 *
 */
public class LongestValidParenthesesSTACK {

	public static void main(String[] args){
		
		System.out.println("This is Longest Valid Parentheses program.");
		
		//1st, ask user to input the parentheses string
		System.out.println("Please input the parentheses string:");
		Scanner input = new Scanner(System.in);
		System.out.print("parentheses: ");
		String parentheses = input.next();
		input.close();
		
		
		//2nd, call longestValidParentheses() method to calculate the longest valid Parentheses
		int LVP = longestValidParentheses(parentheses);
		System.out.println("The longest valid Parentheses' length is: " + LVP);
		
		
	}//end main()
	
	/********
	 * create a stack to store all indices of '(' characters;
	 * and initial the start-index of invalid ')' character;
	 * traversal through the string, if s.charAt(i)=='(', push the index into the stack;
	 * if s.charAt(j)==')', check if the stack is empty, if so, update the start-index;
	 * 
	 * if the stack is not empty, pop() out one index. check if the stack is empty;
	 * if the stack is empty, then the valid Parentheses pairs could count till start-index 
	 * of last invalid ')';
	 * if the stack is not empty, then the valid Parentheses pairs could count till last
	 * '(' stored in the stack;
	 * 
	 * @param s
	 * @return
	 */
	private static int longestValidParentheses(String oriStr){
		if(oriStr=="" || oriStr.length()==0) return 0;
		
		Stack<Integer> leftIndex = new Stack<Integer>();
		int Len = oriStr.length();
		int maxLen = 0;
		int startPoint = -1; //this is the start point of invalid ')'
		
		//traversal through the string:
		for(int i=0; i<Len; i++){
			if(oriStr.charAt(i) == '('){ //push index of '(' into the stack;
				leftIndex.push(i);
				
			} else if(oriStr.charAt(i)==')' && leftIndex.isEmpty()){
				//update the last invalid index of ')';				
				startPoint = i;
				
			} else if(oriStr.charAt(i)==')' && !leftIndex.isEmpty()){
				//if the stack is not empty, we got one () pair;
				leftIndex.pop();
				
				//after popping out another '(' index, if the stack is Empty,
				//then from last invalid ')' to current index i, are valid parentheses;
				if(leftIndex.isEmpty()){
					int lastDis = i-startPoint;
					if(lastDis > maxLen) maxLen = lastDis;
					
				} else if(!leftIndex.isEmpty()){
					//if the stack is not empty, then we can calculate the valid parentheses
					//from the peek() of the stack to current index i;
					int currentDis = (i - leftIndex.peek());					
					if(currentDis > maxLen) maxLen = currentDis;
					
				}//end if-else leftIndex.isEmpty() conditions				
				
			}//end if-else s.charAt(i) = ')' or '(';
			
		}//end for i<Len loop;
		
		return maxLen;
	}//end of everything in longestPalindrome() method;
	
	
}//end of everything in LongestValidParentheses class
