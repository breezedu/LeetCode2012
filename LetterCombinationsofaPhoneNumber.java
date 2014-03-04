package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/*****************
 * Given a digit string, 
 * return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @author Frog
 *
 */
public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args){
		
		System.out.println("This is Letter Combinations of a Phone Number program.");
		
		//1st, ask user to input a string of integers (0-9)
		System.out.println("please input the string of integers:");
		Scanner input = new Scanner(System.in);
		String integers = input.next();
		input.close();
		
		
		//2nd, get all possible combinations these integers could represent
		ArrayList<String> combinations = letterCombinations(integers);
		
		printArrayList(combinations);
		
	}//end main();

	private static ArrayList<String> letterCombinations(String integers) {
		// TODO build all possible combinations
		ArrayList<String> comb = new ArrayList<String>();
		if(integers == ""){
			return comb;
		}
		
		String blank = "";
		comb.add(blank);
		
		int Len = integers.length();
		for(int i=0; i<Len; i++){
			
			char temp = integers.charAt(i);
			if(temp!= '0' && temp!= '1'){
				comb = addAnotherLetters(comb, temp);
			}
		
		}//end for loop;
		
		return comb;
	}//end letterCombinations() method;

	/***********
	 * 
	 * @param comb 
	 * @param temp
	 * @return
	 */
	private static ArrayList<String> addAnotherLetters(ArrayList<String> comb, char temp) {
		// TODO and another three letters to the comb ArrayList
		
		//create an arrayList to store all letters that digit temp represents:
		ArrayList<String> letters = new ArrayList<String>();
		switch(temp){
		
		case '2': { letters.add("a"); letters.add("b"); letters.add("c"); } break;
		case '3': { letters.add("d"); letters.add("e"); letters.add("f"); }	break;
		case '4': { letters.add("g"); letters.add("h"); letters.add("i"); } break;
		case '5': { letters.add("j"); letters.add("k"); letters.add("l"); } break;
		case '6': { letters.add("m"); letters.add("n"); letters.add("o"); } break;
		case '7': { letters.add("p"); letters.add("q"); letters.add("r"); letters.add("s"); } break;
		case '8': { letters.add("t"); letters.add("u"); letters.add("v"); } break;
		case '9': { letters.add("w"); letters.add("x"); letters.add("y"); letters.add("z"); } break;
		
		}
		
		ArrayList<String> retComb = new ArrayList<String>();
		for(String e:comb){
			
			for(int i=0; i<letters.size(); i++){
				
				String tempStr = e + letters.get(i);
				retComb.add(tempStr);
			}
			
		}//end outer for loop;
				
		return retComb;
	}//end addLetters() method;

	private static void printArrayList(ArrayList<String> combinations) {
		// TODO printout an arrayList of strings
		if(combinations == null){
			System.out.println("The arraylist is empty.");
			return;
		}
		
		for(String e:combinations){
			System.out.print(" <" + e +">");
		}
		
		System.out.println();
	}//end of printArrayList() method;
	
	
}//end of everything in LetterCombinationsofaPhoneNumber class
