package leetCode2012;

import java.util.HashMap;
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

class Path{
	String word;
	int level;
	Path(String word, int level){
		this.word = word;
		this.level = level;
	}
}

public class WordLadderIIAccepted {

	public static void main(String[] args){
		
		System.out.println("This is Word Ladder II program.");
		
		//1st, input two words start and end, as well as the HashSet dict
		/*
		String start = "hit";
		String end = "cog";
		String[] set = {"hot","dot","dog","fit","fix","fox","fog","lot","log"};
	
		*/
		String start = "qa";
		String end = "sq";	
		String[] set = {
				"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le",
				"av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya",
				"cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo",
				"as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha",
				"hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la",
				"st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni",
				"mr","pa","he","lr","sq","ye"
				};
		/**/
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
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        if(start.equals(end)) return results;
 
        Queue<Path> q = new LinkedList<Path>();
        int maxLevel = dict.size() + 2; //the worst condition, every word in the set combine the ladder
        int nowLevel = 1; //the fast condition, no word in the set would be used.
        
        HashMap<String, ArrayList<String>> backTraceTable = new HashMap<String, ArrayList<String>>();
        
        //put every word in the dictionary into a hash, along with an empty arrayList
        for(String word: dict) backTraceTable.put(word, new ArrayList<String>());
        
        //also put the start and end into the hashMap;
        backTraceTable.put(start, new ArrayList<String>());
        backTraceTable.put(end, new ArrayList<String>());
        
        //declare a toBeRemove hashSet:
        HashSet<String> toBeRemove = new HashSet<String>();
        
        Path begin = new Path(start, 1);
        q.add(begin); //add or offer :)
        
        while(!q.isEmpty()){
        	Path path = q.poll();
        	if(path.level > nowLevel){
        		dict.removeAll(toBeRemove);
        		toBeRemove.clear();
        		nowLevel = path.level;
        	}
        	
        	if(path.level > maxLevel) break;
        	char[] chars = path.word.toCharArray();
        	
    		for(int i = 0; i < chars.length; i++){
    			for(char j = 'a'; j <= 'z'; j++){
    				char odd = chars[i];
    				
    				if(chars[i] != j){
    					chars[i] = j;
    					String newWord = String.valueOf(chars);
    					if(newWord.equals(end)) maxLevel = path.level;
    					
    					if(!newWord.equals(start) && (dict.contains(newWord) || newWord.equals(end))){
    						backTraceTable.get(newWord).add(path.word);
    						if(!toBeRemove.contains(newWord)) q.offer(new Path(newWord, path.level + 1));
    						toBeRemove.add(newWord);
    					}
    					
    				}//end if chars[i]!= char(j) condition; 
    				
    				chars[i] = odd;
    				
    			}//end for j<=122 loop;
    			
    		}//end for i<chars.length loop;
    		
        }//end while 1.isEmpty() loop;
        
        
        ArrayList<String> result = new ArrayList<String>();
        
        //call getResults() method to backTrace the path(s)
        getResults(end, backTraceTable, result, results, start);
 
        for(int i = 0; i < results.size(); i++){
        	results.get(i).add(start);
        	revert(results.get(i));
        }
        
        return results;
    }//end findLadders() method;
 
	/**********
	 * reverse an arrayList
	 * @param result
	 */
    public static void revert(ArrayList<String> result){
    	int begin = 0;
    	int end = result.size() - 1;
    	while(begin < end){
    		String swap = result.get(begin);
    		result.set(begin, result.get(end));
    		result.set(end, swap);
    		begin++;
    		end--;
    	}
    }//end revert() method;
 
    /*************
     * 
     * @param word
     * @param backTraceTable
     * @param result
     * @param results
     * @param start
     */
    public static void getResults(String word, HashMap<String, ArrayList<String>> backTraceTable,
    		ArrayList<String> result, ArrayList<ArrayList<String>> results, String start){
    	//kind of dfs
    	if(backTraceTable.get(word).isEmpty() && word.equals(start)){
    		results.add(new ArrayList<String>(result));
    		return;
    	}
    	
    	result.add(word);
    	
    	for(String nextWord: backTraceTable.get(word))
    		getResults(nextWord, backTraceTable, result, results, start);
    	
    	result.remove(result.size() - 1);
 
    }//end getResults() method;
    
    
    /*********
     * Printout everything arrayList of strings in the Results ArrayList of ArrayList.
     * @param ladder
     */
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
