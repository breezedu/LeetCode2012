package leetCode2012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*********
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * @author Frog
 *
 */
public class Anagrams {
	
	public static void main(String[] args){
		
		System.out.println("This is Anagrams program.");
		
		//1st, input an array of strings:
		String[] words = {"abc", "bca", "bac", "bbb", "bbca", "abcb"};
		
		
		//2nd, call anagrams() method to group anagrams
		ArrayList<ArrayList<String>> anagrams = anagramWords(words);
		
		//printout alofal
		printALofAL(anagrams);
		
	}//end main()

	/***********
	 * use string.toCharArray() to change string into char[] array;
	 * then use arrays.sort to sort the char[] array: bca -> abc; bac->abc;
	 * then, take the sorted string as key, the original string as 'value'; 
	 * put the pairs into a hashMap; if there's duplicate keys, just add to the value ArrayList
	 * in this way, all strings with the same sorted key will be stored in the same ArrayList
	 * 
	 * when putting new key-value pairs into the hashMap, also put all keys who showed for
	 * the second time into a stack;
	 * 
	 * pop() the stack to get all arrayLists directly, store all these arrayLists into 
	 * the return ALofAL;
	 * 
	 * @param words
	 * @return
	 */
	private static ArrayList<ArrayList<String>> anagramWords(String[] words) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> anagrams = new ArrayList<ArrayList<String>>();
		if(words==null || words.length<2) return anagrams;
		
		HashMap<String, ArrayList<String>> anagMap = new HashMap<String, ArrayList<String>>();
		Stack<String> keys = new Stack<String>();
		
		int Len = words.length;
		for(int i=0; i<Len; i++){
			char[] tempChar = words[i].toCharArray();
			Arrays.sort(tempChar);
			String tempWord = new String(tempChar); 
			System.out.println("sorted: " + tempWord +", ori: " + words[i]);
			
			if(!anagMap.containsKey(tempWord)){
				ArrayList<String> tempAL = new ArrayList<String>();
				tempAL.add(words[i]);
				anagMap.put(tempWord, tempAL);
				
			} else {
				if(anagMap.get(tempWord).size()==1) keys.push(tempWord);				
				anagMap.get(tempWord).add(words[i]);
				
			}//end if-else conditions
			
		}//end for i<Len loop;
		
		while(!keys.isEmpty()){
			anagrams.add(anagMap.get(keys.pop()));
			
		}//end while keys stack is not empty loop;		
		
		return anagrams;
	}//end anagramWords() method;

	private static void printALofAL(ArrayList<ArrayList<String>> anagrams) {
		// TODO printout an al of al
		if(anagrams==null || anagrams.size()==0){
			System.out.println("The AlofAl is empty.");
			return;
		}
		
		for(ArrayList<String> al:anagrams){			
			printArrayList(al);
		}
		
		System.out.println();
	}//end of printALofAL() method;

	private static void printArrayList(ArrayList<String> al) {
		// TODO Auto-generated method stub
		for(String e:al){
			System.out.print(" '" + e +"' ");
		}
		
		System.out.println();
	}//end printArrayList() method;

}//end of everything in Anagrams class
