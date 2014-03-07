package leetCode2012;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/***********
 * Given two words (start and end), and a dictionary, 
 * find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 *  [
 * 		["hit","hot","dot","dog","cog"],
 * 	    ["hit","hot","lot","log","cog"]
 *  ]
 *  
 * @author Frog
 *
 */
public class WordLadderII {

	public static void main(String[] args){
		
		System.out.println("This is Word Ladder II program.");
		
		//1st, input two words start and end, as well as the HashSet dict
		String start = "hit";
		String end = "cog";
		String[] set = {"hot","dot","dog","lot","log"};
		HashSet<String> dict = new HashSet<String>();
		
		int Len = set.length;
		for(int i=0; i<Len; i++){
			dict.add(set[i]);
		}
		
		
		//2nd, find out all word ladders to transfer start to end string;
		ArrayList<ArrayList<String>> ladders = findLadders(start, end, dict);
		
		System.out.println("After findLadders, there are " + ladders.size() +" sets found.");
		printALofAL(ladders);
		
		
	}//end main();


	private static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		// TODO find out word ladders
		ArrayList<String> ladder = new ArrayList<String>();
		ArrayList<ArrayList<String>> ladderSets = new ArrayList<ArrayList<String>>();
		if(dict.size()==0) return ladderSets;
		
		Queue<String> word = new LinkedList<String>();
		word.add(start);
	//	ladder.add(start);
		dict.add(end);
		
		checkLadders(end, ladder, word, ladderSets, dict);
		
		return ladderSets;
	}//end findLadders() method;


	private static void checkLadders(String end, ArrayList<String> ladder, 
			Queue<String> word, ArrayList<ArrayList<String>> ladderSets, HashSet<String> dict) {
		// TODO Auto-generated method stub
		String currentWord = word.poll();
		ladder.add(currentWord);
	//	System.out.print(" " +currentWord +",");
		
		if(currentWord.equals(end)){
			
			if(ladderSets.isEmpty()) {
				ladderSets.add(ladder);
				
			} else {
				if(ladder.size() == ladderSets.get(0).size()){
					ladderSets.add(ladder);
					
				} else if(ladder.size() < ladderSets.get(0).size()){
					ladderSets.clear();
					ladderSets.add(ladder);
					
				} //end ladderSet.add(ladder) conditions;
					
			}
	//		ladderSets.add(ladder);
	//		printArrayList(ladder);
			return;
		
		} else {
			
			for(int i=0; i<currentWord.length(); i++){
				
				char[] currCharArr = currentWord.toCharArray();
	            for(char c='a'; c<='z'; c++){
	                currCharArr[i] = c;
	 
	                String newWord = new String(currCharArr);
	             
	                if(dict.contains(newWord)){
	                    
	                	Queue<String> wordNext = new LinkedList<String>(word);
	                	wordNext.add(newWord);
	                	ArrayList<String> ladderNext = new ArrayList<String>(ladder);
	                	HashSet<String> dictNext = new HashSet<String>(dict);
	                    
	                    dictNext.remove(newWord);
	                    
	                    checkLadders(end, ladderNext, wordNext, ladderSets, dictNext);
	                }
	                
	            }//end for c<='z' loop
				
			}//end for i<currentWord.length loop;
			
		}//end if-else currentWord==end condition
				
	}//end checkLadders() method; 


	private static void printALofAL(ArrayList<ArrayList<String>> ladder) {
		// TODO printout ALofAL
		if(ladder == null || ladder.isEmpty()){
			System.out.println("Empty ladders.");
			return;
		}
		
		for(ArrayList<String> al:ladder){
			printArrayList(al);
		}
		
		System.out.println();
	}//end printALofAL() method;
	
	private static void printArrayList(ArrayList<String> ladder) {
		// TODO printout all strings in an ArrayList<String>
		if(ladder==null || ladder.size() == 0) {
			System.out.println("The arrayList is empty.");
			return;
		}
		
		for(String s:ladder){
			
			System.out.print(" " + s +",");
		}
		
		System.out.println();
	}//end printArrayList() method;

}//end of everything in WordLadderII class
