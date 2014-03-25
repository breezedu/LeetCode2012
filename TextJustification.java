package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/**************
 * Given an array of words and a length L, format the text such that each line has exactly 
 * L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 *    [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 *    ]
 *    
 * @author Frog
 *
 */

public class TextJustification {
	
	public static void main(String[] args){
	
		System.out.println("This is Text Justification program.");
		
		//1st, ask user to input an integer, which is the width of length the output strings
		System.out.println("Please input the width of output strings.");
		Scanner input = new Scanner(System.in);
		System.out.print(" L = ");
		int L = input.nextInt();
		input.close();
		
		
		//2nd, build the string[] array;
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		
		
		//3rd, call fullJustify() method to build the ArrayList of output strings
		ArrayList<String> justedString = fullJustify(words, L);
		
		//printout the result:
		printArrayList(justedString);
		
	}//end of main();


	private static ArrayList<String> fullJustify(String[] words, int L){
		 
        int wordsCount = words.length;
        ArrayList<String> result = new ArrayList<String>();
        int curLen = 0;
        int lastI = 0;
        for (int i = 0; i <= wordsCount; i++) {
            
            if (i == wordsCount || curLen + words[i].length() + i - lastI > L) {
                StringBuffer buf = new StringBuffer();
                int spaceCount = L - curLen;
                int spaceSlots = i - lastI - 1;
                
                if (spaceSlots == 0 || i == wordsCount) {
                    
                    for(int j = lastI; j < i; j++){
                        buf.append(words[j]);
                        if(j != i - 1)
                            appendSpace(buf, 1);
                    }
                    
                    appendSpace(buf, L - buf.length());
                    
                } else {
                    int spaceEach = spaceCount / spaceSlots;
                    int spaceExtra = spaceCount % spaceSlots;
                    for (int j = lastI; j < i; j++) {
                        buf.append(words[j]);
                        if (j != i - 1)
                            appendSpace(buf, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
                    }
                    
                }//end else
                
                result.add(buf.toString());
                lastI = i;
                curLen = 0;
                
            }//end if (i==wordsCount||curLen +words[i].length() + i-lastI > L) condition;
            
            if (i < wordsCount) curLen += words[i].length();
                
        }//end for i<=wordsCount loop;
        
        
        return result;		
		
	}//end of fullJustify() method;
	
	
	private static void appendSpace(StringBuffer buf, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++)
            buf.append(' ');
	}//end appendSpace() method;


	private static void printArrayList(ArrayList<String> strings) {
		// TODO printout all strings in an arrayList
		if(strings==null || strings.isEmpty()){
			System.out.println("It's empty.");
			return;
		}
		
		for(String s:strings){
			System.out.println(" " + s +". ");
		}
		
		System.out.println();
	}//end of printArrayList() method;
	
}//end of everything in Textjustification class
