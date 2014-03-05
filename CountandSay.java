package leetCode2012;

import java.util.Scanner;

/******************
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author Frog
 *
 */
public class CountandSay {
	
	public static void main(String[] args){
		
		System.out.println("This is Count and Say program.");
		
		//1st, ask user to input an integer
		System.out.println("Please input the integer:");
		Scanner input = new Scanner(System.in);
		System.out.print("integer = ");
		int digit = input.nextInt();
		input.close();
		
		
		//2nd, calculate and create the nth string of Count&Say
		String nth = countAndSay(digit);
		System.out.println("The " +digit +"th Count&Say is: " + nth);
		
	}//end main()

	/*********
	 * Pick up the string front, calculate it's length;
	 * countAndSay: traversal from index 0 to length-1, take the character at index i;
	 * count all duplications right after i; (count++, index++)
	 * store the count and charAt(i) to the new string, move the traversal pointer 
	 * to the first character which is different to charAt(i), and do the same countAndSay;
	 * 
	 * @param digit
	 * @return
	 */
	private static String countAndSay(int digit) {
		// TODO calculate count and say
		if(digit == 0) return "";
		if(digit == 1) return "1";
		
		String[] countSay = new String[digit];
		countSay[0] = "1";
		
		for(int i=1; i<digit; i++){
			
			StringBuffer tempStr = new StringBuffer(); 
			int Len = countSay[i-1].length();
			int j=0; 
			while(j<Len){
				char temp = countSay[i-1].charAt(j);
				int count=1;
				
				//count duplications of countSay[i-1].charAt(j)
				while(j+1<Len && countSay[i-1].charAt(j+1)==temp){
					count++;
					j++;
				}
				//add the number of duplication and the integer into tempStr string;
				tempStr.append(count).append(temp);
				j++;
			}//end while j<Len loop
			
			countSay[i] = tempStr.toString();
			System.out.println(i + ": " + countSay[i-1]);
				
		}//end for i<digit loop;		
		
		return countSay[digit-1];
	}//end of countAndSay() method;

}//end of everything in CountandSay class
