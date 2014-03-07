package leetCode2012;

import java.util.Scanner;
import java.util.Stack;

/** 
 * Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together
 * such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo". 
 */  
public class SimplifyPath {
	
	public static void main(String[] args){
		
		System.out.println("This is Simplfy Path program.");
		
		//1st, ask user to input a string of path
		System.out.println("Please input the path:");
		Scanner input = new Scanner(System.in);
		System.out.print("path: ");
		String path = input.nextLine();
		input.close();
		
		
		//2nd, call simplifyPath() method to simplify the originat string
		String simPath = simplifyPath(path);
		
		//printout the simplified path
		System.out.println("Simplified path: " + simPath);
		
	}//end main()

	private static String simplifyPath(String path) {
		// TODO simplify the path string;
		if(path.length()==0) return path;
		
		//break the path into string array, separated by "/";
		String[] splits = path.split("/");
		printStringArray(splits);
		
		Stack<String> strStack = new Stack<String>();
		for(int i=0; i<splits.length; i++){
			if(splits[i].length()==0 || splits[i].equals(".")){
				//do nothing;
				
			} else if( splits[i].equals("..")){
				if(!strStack.isEmpty()) strStack.pop();
				
			} else {
				strStack.push(splits[i]);
				
			}//end if-else conditions;
			
		}//end for i<splits.length loop;
		
		if(strStack.isEmpty()) strStack.push("");
		
		String retStr = "";
		while(!strStack.isEmpty()){
			
			retStr += "/" + strStack.pop();
		}
		
		return retStr;
	}//end of simplifyPath() method;

	private static void printStringArray(String[] str) {
		// TODO printout an array of strings
		if(str == null) return;
		
		int Len = str.length;
		for(int i=0; i<Len; i++){
			System.out.print(" " + str[i] +",");
		}
		
		System.out.println();
	}//end printStringArray() method;

	
}//end of everything in SimplifyPath class
