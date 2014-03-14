package leetCode2012;

import java.util.Scanner;

/*************
 * Input two strings of integers, printout the multiply result;
 * 
 * @author Frog
 *
 */
public class MultiplyStrings {
	
	public static void main(String[] args){
		
		System.out.println("This is Multiply Strings class.");
		
		//1st, ask user to input two strings of integers
		System.out.println("Please input two integer-strings:");
		Scanner input = new Scanner(System.in);
		System.out.print("num1 = ");
		String num1 = input.next();
		
		System.out.print("num2 = ");
		String num2 = input.next();
		input.close();
		
		
		//2nd, calculate the multiply result
		String res = multiplyStrings(num1, num2);
		
		//printout the result
		System.out.println("The result after mutiply is: " + res);
		
	}//end main()

	/*******************
	 * whatever the num2 is, the multiply calculation will be num1*0, num1*1....num1*9;
	 * so, we calculate all these 10 possibilities and store the results into a multi[10] array
	 * num1*0 = 0; (string "0")
	 * num1*1 = num1; (string)
	 * num1*2 = num1+num1; thus, we just write a method of adding two integer strings, :)
	 * num1*3 = num1*2 + num1.... as so on;
	 * 
	 * when calculating num1*num2; we simply separate each figure of num2, add some '0's correspondingly;
	 * like 12345 * 12345
	 * we got :
	 *  123450000
	 *   24690000
	 *    3703500
	 *     493800
	 *      61725
	 * sum all these strings we got: 152399025.
	 * 
	 * in this way, we transfer big data multiply into string adding operation;
	 * @param num1
	 * @param num2
	 * @return
	 */
	private static String multiplyStrings(String num1, String num2) {
		// TODO multiply two integer strings
		if(num1=="0" || num2=="0") return "0";
		if(num1=="1") return num2;
		if(num2=="1") return num1;
		
		int Len2 = num2.length();
		
		//create 10 strings, for num1*0, num1*1... till num1*9;
		String[] multi = new String[10];
		multi[0] = "0";
		for(int i=1; i<10; i++){
			multi[i] = addTwoString(multi[i-1], num1);
		}
		
		String result = "0";
		//create Len2 strings, each represent num2.intAt(i)*num1;
		String[] soloMultify = new String[Len2];
		
		for(int i=0; i<Len2; i++){
			int curr = Integer.parseInt(num2.substring(i, i+1));
			soloMultify[i] = multi[curr];
			//add Len2-i "0"s after 
			for(int j=0; j<Len2-i-1; j++){
				soloMultify[i] += 0;
			}
			System.out.println(" " + soloMultify[i]);			
			result = addTwoString(result, soloMultify[i]);
			
		}//end for i<Len2 loop
		
		return result;
	}//end multiplyStrings() method;

	/***********
	 * add two integer strings;
	 * do it as ordinary sum method in math;
	 * parse each character at index i into a integer; 
	 * initial the plus to be 0 at the beginning;
	 * sum two integers at the same index of each string and the plus; 
	 * take sum%10 as the new char at index i of the new string;
	 * plus update to sum/10;
	 * calculate next index to the left, which is i-1;
	 * 
	 * till reach the end of the shorter string;
	 * only add plus and integer at corresponding index of the longer string;
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static String addTwoString(String str1, String str2) {
		// TODO sum two integer strings
		if(str1=="0") return str2;
		if(str2=="0") return str1;
		
		int Len1 = str1.length();
		int Len2 = str2.length();
		String retStr = "";
		int min = Math.min(Len1, Len2);
		
		//add two integers at the same index and the plus, take sum%10 as new string's char
		//update plus to sum/10;
		int plus = 0;
		for(int i=0; i<min; i++){
			int n1 = Integer.parseInt(str1.substring(Len1-1-i, Len1-i));
			int n2 = Integer.parseInt(str2.substring(Len2-1-i, Len2-i));
			int tempSum = n1+n2+plus;
			retStr = tempSum%10 + retStr;
			plus = tempSum/10;
		}//end for i<min loop;
		
		//after reach the end of the shorter string;
		//only add plus and the single integer left at index i of the longer string
		if(Len1>Len2){
			
			for(int i=Len1-Len2-1; i>=0; i--){
				int n1 = Integer.parseInt(str1.substring(i, i+1));
				int tempSum = n1 + plus;
				retStr = tempSum%10 + retStr;
				plus = tempSum/10;
			}//end for i>=0 loop;
			
		} else {
			
			for(int i=Len2-Len1-1; i>=0; i--){
				int n2 = Integer.parseInt(str2.substring(i, i+1));
				int tempSum = n2 + plus;
				retStr = tempSum%10 + retStr;
				plus = tempSum/10;				
			}//end for i>=0 loop;
			
		}//end if-else Len1>Len2 conditions
		
		if(plus>0) retStr = plus + retStr; //clear the 'head';
		
		return retStr;
	}//end of addTwoString() method;

}//end of everything in MultiplyStrings class
