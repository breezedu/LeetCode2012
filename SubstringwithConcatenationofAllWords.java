package leetCode2012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*******************
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation 
 * of each word in L exactly once and without any intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 * @author Frog
 *
 */
public class SubstringwithConcatenationofAllWords {
	
	public static void main(String[] args){
		
		System.out.println("This is Substring with Concatenation of All Words program.");
		
		//1st, initialization the original string and the string[] array
		//String[] L = {"foo", "bar"};
		String[] L = {"fooo","barr","wing","ding","wing"};
		
		System.out.print("Please input the string: ");
		Scanner input = new Scanner(System.in);
		String S = input.next();
		//input: lingmindraboofooowingdingbarrwingmonkeypoundcake
		input.close();
		
		
		//2nd, findout all valid substrings
		ArrayList<Integer> subs = findSubstring(S, L);
		
		//printout arrayList
		printArrayList(subs);
		
		
	}//end of main()

	/**************
	 * create two hashMaps, toFind() and Found;
	 * for toFind HashMap:
	 * traversal the array[] L, take array[i] as the key, the times it appears as value;
	 * for Found HashMap: array[i] as the key, 0 as the value;
	 * 
	 * for every substring of S with length L.length*L[0].length();
	 * initial count=0;
	 * check each sub-substring of L[0].length: tempStr=S.substring(i, i+L[0].length()):
	 * if it isn't in the toFind() Map, break;
	 * if it is in the Map, Found.getKey(tempStr)+1;
	 * 	if Found.getKey(tempStr)==toFind.getKey(tempStr), count = count+toFind.getKey(tempStr);
	 *  if count = L.length, we got one substring in S which include all Concatenation of L;
	 *  add index i into return-ArrayList;
	 *  
	 * return the return-ArrayList in the end;
	 * @param S
	 * @param L
	 * @return
	 */
	private static ArrayList<Integer> findSubstring(String S, String[] L) {
		// TODO Auto-generated method stub
		ArrayList<Integer> retAL = new ArrayList<Integer>();
		
		if(L==null) return retAL;
		int subLen = L[0].length()*L.length;
		int Len = S.length();
		if(Len < subLen) return retAL;
		
		System.out.println("build hashMaps.");
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		HashMap<String, Integer> Found = new HashMap<String, Integer>();
		for(int i=0; i<L.length; i++){
			Found.put(L[i], 0);
			
			if(toFind.containsKey(L[i])){
				toFind.put(L[i], toFind.get(L[i])+1);
				
			} else {
				toFind.put(L[i], 1);
				
			}
		}//end build hashMaps loop;
		
		for(int i=0; i<=Len-subLen; i++){
			HashMap<String, Integer> tempFound = new HashMap<String, Integer>(Found);
			System.out.print(" i= " + i +". ");
			int count=0;
			for(int j=i; j<i+subLen; j+=L[0].length()){
				String tempStr = S.substring(j, j+L[0].length());
				System.out.print("  " + tempStr);
				
				if(!toFind.containsKey(tempStr)) break;
				else tempFound.put(tempStr, tempFound.get(tempStr)+1);
				
				if(tempFound.get(tempStr) == toFind.get(tempStr)) count += toFind.get(tempStr);
				
				if(count == L.length) retAL.add(i);
			}
			
			System.out.println();
		}
		
		return retAL;
	}

	private static void printArrayList(ArrayList<Integer> subs) {
		// TODO printout an arrayList
		if(subs.size()==0) return;
		
		for(int e:subs){
			System.out.print(" "+ e );
		}
		
		System.out.println();
	}//end of printArrayList() method;

}//end of everything in SubstringwithConcatenationofAllWords class
