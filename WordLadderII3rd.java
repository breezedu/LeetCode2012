package leetCode2012;

import java.util.HashSet;
import java.util.ArrayList;
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
public class WordLadderII3rd {

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
		Stopwatch timmer = new Stopwatch();
		ArrayList<ArrayList<String>> ladders = findLadders(start, end, dict);
		
		System.out.println("After findLadders, there are " + ladders.size() +" sets found.");
		printALofAL(ladders);
		
		//check out the time used
		System.out.println("Time used: " + timmer.elapsedTime() +".");
		
		
	}//end main();


	private static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		// TODO find out word ladders
		ArrayList<String> ladder = new ArrayList<String>();
		ArrayList<ArrayList<String>> ladderSets = new ArrayList<ArrayList<String>>();
		if(dict.size()==0) return ladderSets;
		
		ladder.add(start); 	//add start word to the ladder
		dict.add(end);		//add end word to the hashSet
		
		checkLadders(end, ladder, ladderSets, dict);
		
		return ladderSets;
	}//end findLadders() method;


	/****************
	 * checkLadders() method, to check all possible word ladders, only put shortest into AL
	 * 1st peep the last word in the ladder arrayList, compare it with the end:
	 * 		if match, we got one valid ladder, compare the ladder with ALs the ladderSets ALofAL;
	 * 		only add the shortest ladder to the ladderSets; if the new ladder we got is shorter
	 * 		than the ladderSets.get(0), then clear() the ladderSets, add new ladder to ladderSets;
	 * 2nd if the peep word does not match the end word:
	 * 		change each one character of the peeped word with 'a' to 'z' (word.length*26 possibilities)
	 * 		if the hashSet contains the new word (currentWord) we just got:
	 * 			add the currentWord to the ladder, and delete it from the hashSet (to prevent dead-lock loop)
	 * 		pass the new ladder and new hashSet to checkLadders() method;
	 * 
	 * @param end
	 * @param ladder
	 * @param word
	 * @param ladderSets
	 * @param dict
	 */
	private static void checkLadders(String end, ArrayList<String> ladder, 
		ArrayList<ArrayList<String>> ladderSets, HashSet<String> dict) {
		// TODO check the word ladders, put those shortest into the ladderSets
		String currentWord = ladder.get(ladder.size()-1);
		System.out.println("currentWord: " +currentWord);
		if(currentWord.equals(end)){
			
			if(ladderSets.isEmpty() || ladder.size() == ladderSets.get(0).size()){
					ArrayList<String> tempLadder = new ArrayList<String>(ladder);
					ladderSets.add(tempLadder);
					
				} else if(ladder.size() < ladderSets.get(0).size()){
					ladderSets.clear();
					ArrayList<String> tempLadder = new ArrayList<String>(ladder);
					ladderSets.add(tempLadder);
					
				} //end ladderSet.add(ladder) conditions;
		
		} else {
			
			for(int i=0; i<currentWord.length(); i++){
				
				char[] currCharArr = currentWord.toCharArray();
	            for(char c='a'; c<='z'; c++){
	                currCharArr[i] = c;
	                String newWord = new String(currCharArr);
	             
	                if(dict.contains(newWord)){
	                	ladder.add(newWord);
	                	dict.remove(newWord);
	                    
	                    checkLadders(end, ladder, ladderSets, dict);
	                    
	                    ladder.remove(ladder.size()-1);
	                    dict.add(newWord);
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
