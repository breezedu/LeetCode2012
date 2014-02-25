package leetCode2012;

import java.util.Scanner;
import java.util.Stack;

/*************
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author Frog
 *
 */
public class ValidParentheses {
	
	public static void main(String[] args){
		
		System.out.println("This is Valid Parentheses program.");
		
		//1st, input a string of parentheses;
		System.out.println("Please input a string of parentheses:");
		Scanner input = new Scanner(System.in);
		System.out.print("string: ");
		String parentheses = input.nextLine();
		input.close();
		
		boolean validPar = isValid(parentheses);
		
		if(validPar){
		
			System.out.println("The string is a valid parentheses.");
		} else {
			
			System.out.println("The string is not a valid parentheses.");
		}
		
		
	}//end main();

	/*********
	 * traversal the string, delete pair or store every single char into a stack;
	 * if the stack is empty, just push the new char into the stack;
	 * else, pop out last char from the stack, check if the popped one matches to the new one;
	 * if they match, delete them, otherwise, push them both back to the stack.
	 * if the parentheses are valid, there should be nothing left in the stack at the end;
	 * so, if the stack is empty, return true. otherwise, return false.
	 * 
	 * AND, a valid parentheses string must be even in length;
	 * @param parentheses
	 * @return
	 */
	private static boolean isValid(String parentheses) {
		// TODO check if a parentheses string is valid or not
		if(parentheses == null) return true;
		if(parentheses.length()%2 != 0) return false;
		
		//use a stack to store all chars, pop-compare-check :)
		Stack<Character> pareStc = new Stack<Character>();
		
		int Len = parentheses.length();
		for(int i=0; i<Len; i++){
			
			if(pareStc.isEmpty()){
				pareStc.push(parentheses.charAt(i));
			
			} else {
				
				char temp = pareStc.pop();				
				if(!matchPair(temp, parentheses.charAt(i)) ){					
					pareStc.push(temp);
					pareStc.push(parentheses.charAt(i));
				}
				
			}//end if pareStc is empty condition;			
			
		}//end for i<Len loop;
		
		if(pareStc.isEmpty()) return true;
		
		return false;
	}

	private static boolean matchPair(char left, char right) {
		// TODO Check if a pare is a matched parentheses pair
		if(left == '(' && right ==')') return true;
		if(left == '[' && right ==']') return true;
		if(left == '{' && right =='}') return true;
		
		return false;
	}

}//end of everything in ValidParentheses class
