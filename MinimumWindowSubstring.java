package leetCode2012;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**************
 * Given a string S and a string T, 
 * find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * @author Frog
 *
 */
public class MinimumWindowSubstring {

	public static void main(String[] args){
		
		System.out.println("This is Minimum Windows Substring program.");
		
		//1st, ask user to input S and T strings
		System.out.println("Please input the String S:");
		System.out.print("S = ");
		Scanner input = new Scanner(System.in);
		String S = input.next();
		
		System.out.print("T = ");
		String T = input.next();
		input.close();
		
		
		//2nd, check the mini window of substring in S
		String miniWin = minWindow(S, T);
		
		//printout the minimum window substring
		System.out.println("The minimum window of substring is: " + miniWin);
		
		
	}//end main()

	/*********
	 * create two hashMaps, one to store all characters found in string T, which is the 'toFind' hashmap
	 * the other to store all characters 'Found' when traveling through the string S;
	 * create a Queue to store all valid indices for valid characters in string S, exm: 
	 * if s.charAt(i) is contained in the toFind() hashmap, then i is a potential valid index
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	private static String minWindow(String s, String t) {
		// TODO Auto-generated method stub
		System.out.println("s : " + s +". t : " + t);
		
		if(s.length() < t.length()) return "";
		Queue<Integer> indexQ = new LinkedList<Integer>(); 
		//use a queue to store indices of all characters in string t;
		
		HashMap<Character, Integer> toFind = new HashMap<Character, Integer>(); //add every char of T into a hashset
		HashMap<Character, Integer> Found = new HashMap<Character, Integer>();
		
		for(int i=0; i<t.length(); i++){
			char curr = t.charAt(i);
			
			if(toFind.containsKey(curr)){
				toFind.put(curr, toFind.get(curr)+1);
				
			} else {
				toFind.put(curr, 1);				
			}
			
			Found.put(curr, 0);
		}//end for i<t.length loop; toFind and Found sets are created;
		
		int minStart = -1;
		int minEnd = s.length(); //the worst condition for min-win
		
		int start = 0;
		int Len = 0;
		
		for(int i=0; i<s.length(); i++){
			char curr = s.charAt(i);
			
			if(Found.containsKey(curr)){
				indexQ.add(i);				
				Found.put(curr, Found.get(curr)+1);
				
				if(Found.get(curr) <= toFind.get(curr)){
					Len++;					
				}
				
				if(Len == t.length()){
					while(Found.get(s.charAt(indexQ.peek()))>toFind.get(s.charAt(indexQ.peek()))){
						
						if(toFind.containsKey(s.charAt(indexQ.peek()))){
							Found.put(s.charAt(indexQ.peek()), Found.get(s.charAt(indexQ.peek()))-1);
						}
						
						indexQ.poll();
					}//end while loop, get the valid start index;
					
					start = indexQ.peek();
					
					if(i-start < minEnd-minStart){
						minStart = start;
						minEnd = i;
					}
					
				}//end if Len == t.length condition;
				
			}//end if Found.containsKey(curr) condition;
			
		}//end for i<s.length() loop;
		
		if(minStart == -1) return "";
		
		return s.substring(minStart, minEnd+1);
	
	}
	
}//end of everything in Minimum Window Substring class;
