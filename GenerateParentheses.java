package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*******************
 * Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author Frog
 *
 */
public class GenerateParentheses {
	
	public static void main(String[] args){
		
		System.out.println("This is Generate Parentheses program.");
		
		//1st, ask user to input the num of parentheses
		System.out.println("Please input the num of parentheses:");
		Scanner input = new Scanner(System.in);
		System.out.print(" num = ");
		int num = input.nextInt();
		input.close();
		
		
		//2nd, generate an arrayList storing all strings of combinations of parentheses
		ArrayList<String> parentheses = generateParentheses(num);
		printArrayList(parentheses);
		
		
	}//end main()
	
	
	/**********
	 * generateParentheses() method;
	 * create two stacks (stackL and stackR) to store all "("s and ")"s;
	 * call pickParenthesesfromStacks() to pickup one "(" or ")", add it to the string;
	 * when both stacks are empty, add final string(s) to an ArrayList; 
	 * return the ArrayList;
	 * @param num
	 * @return
	 */
	private static ArrayList<String> generateParentheses(int num) {
		// TODO Auto-generated method stub
		ArrayList<String> retAL = new ArrayList<String>();
		if(num == 0){
			return retAL;
		}
		
		Stack<String> stackL = new Stack<String>();
		Stack<String> stackR = new Stack<String>();
		//push all "(" to the stackL, ")" to the stackR;
		for(int i=0; i<num; i++){
			stackL.push("(");
			stackR.push(")");
		}
				
		String temStr = ""; 
		int left = 0;		//the num of "(" in the string;
		int right = 0;		//the num of ")" in the string;
		pickParenthesesfromStacks(temStr, retAL, stackL, left, stackR, right); //we can pass 0, 0 here;
		
		return retAL;
	}//end of generateParentheses() method;

	/************
	 * pickup one "(" or ")" from stack and add it to the string;
	 * if both stacks are empty, add the string to the ArrayList, return;
	 * if only stackL is empty, add all ")" in the stackR to the string;
	 * add the string to the ArrayList, return;
	 * 
	 * if there are equal "("s and ")"s in the string, we can only pick "(" from left;
	 * 
	 * if we can pick either "(" or ")", there are two options:
	 * clone both stackL and stackR, pick "(" from stackL, pass original pair to next pickParenthesesfromStacks();
	 * pick ")" from stackR_clone, pass cloned pair to next pickParenthesesfromStacks() call;
	 * 
	 * @param temStr
	 * @param retAL
	 * @param stackL
	 * @param left
	 * @param stackR
	 * @param right
	 */
	private static void pickParenthesesfromStacks(String temStr, ArrayList<String> retAL, 
			Stack<String> stackL, int left,	Stack<String> stackR, int right) {
		// TODO pick another parentheses from either stack, or just from left stack
		//if both stacks are empty, add the string to the ArrayList, return
		//if only stackL is empty, we can only pick ")" from stackR, add them all;
		if(stackR.isEmpty()){
			retAL.add(temStr);
			return;
		
		} else if(stackL.isEmpty()){
			
			while(!stackR.isEmpty()){
				temStr += stackR.pop();
			}
			retAL.add(temStr);
			return;
		}//end directly return conditions;
		
		//if left == right, the string is valid parentheses, we can only pick "(" from stackL;
		if(left == right){
			temStr += stackL.pop();
			left++;
			
			pickParenthesesfromStacks(temStr, retAL, stackL, left, stackR, right);
		
		} else {
			
			//there are two options: pick one from stackL or pick one from stackR;
			//here we have to clone both stacks, and pass them to two different calls
			//clone the stacks:
			Stack<String> stackLnew = new Stack<String>();
			stackLnew.addAll(stackL);
			Stack<String> stackRnew = new Stack<String>();
			stackRnew.addAll(stackR);
			
			//pick one "(" from stackL, and call pickParenthesesfromStacks(); pass original stacks;
			String leftStr = new String(temStr);
			leftStr += stackL.pop();
			pickParenthesesfromStacks(leftStr, retAL, stackL, left+1, stackR, right);
			
			//pick one ")" from stackR, and call pickParenthesesfromStacks(); pass cloned stacks;
			String rightStr = new String(temStr);
			rightStr += stackRnew.pop();
			pickParenthesesfromStacks(rightStr, retAL, stackLnew, left, stackRnew, right+1);
			
		}//end if-else conditions;
		
	}//end pickParenthesesfromStacks() method;

	private static void printArrayList(ArrayList<String> al) {
		// TODO printout an arrayList of strings
		if(al==null || al.size()==0){
			System.out.println("It's an empty arrayList.");
			return;
		}
		
		for(String s:al){
			System.out.println(" " + s);
		}
		
		System.out.println();
	}//end of printArrayList() method;

}//end of everything in GenerateParentheses class
