package leetCode2012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

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
		Stopwatch timmer = new Stopwatch();
		ArrayList<String> anagrams = anagramWords(words);
		
		//printout arrayList of strings
		printArrayList(anagrams);
		System.out.println("Time used is: " + timmer.elapsedTime()+". ");
		
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
	private static ArrayList<String> anagramWords(String[] words) {
		// TODO get all anagrams
		ArrayList<String> anagrams = new ArrayList<String>();
		if(words==null || words.length<2) return anagrams;
		
		HashMap<String, ArrayList<String>> anagMap = new HashMap<String, ArrayList<String>>();
		
		int Len = words.length;
		for(int i=0; i<Len; i++){
			char[] tempChar = words[i].toCharArray();
			Arrays.sort(tempChar);
			String tempWord = new String(tempChar); 
			
			if(!anagMap.containsKey(tempWord)){
				ArrayList<String> tempAL = new ArrayList<String>();
				tempAL.add(words[i]);
				anagMap.put(tempWord, tempAL);
				
			} else {
			//	if(anagMap.get(tempWord).size()==1) keys.push(tempWord);				
				anagMap.get(tempWord).add(words[i]);
				
			}//end if-else conditions
			
		}//end for i<Len loop;
		
		Set<String> set = anagMap.keySet(); 
		for(String s:set){
			if(anagMap.get(s).size()>1)
				anagrams.addAll(anagMap.get(s));
		}
		
		return anagrams;
	}//end anagramWords() method;

	private static void printArrayList(ArrayList<String> al) {
		// TODO Auto-generated method stub
		for(String e:al){
			System.out.print(" '" + e +"' ");
		}
		
		System.out.println();
	}//end printArrayList() method;

}//end of everything in Anagrams class
