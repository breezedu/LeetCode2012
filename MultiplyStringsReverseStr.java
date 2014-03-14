package leetCode2012;

import java.util.Scanner;

/*************
 * Input two strings of integers, printout the multiply result;
 * 
 * @author Frog
 *
 */
public class MultiplyStringsReverseStr {
	
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
		Stopwatch timmer = new Stopwatch();
		String res = multiplyStrings(num1, num2);
		
		//printout the result
		System.out.println("Time used: " + timmer.elapsedTime());
		System.out.println("The result after mutiply is: " + res);
		
	}//end main()

	/*************
	 * This method works faster than the naive method.
	 * here we use another method, 1st, reverse the two strings, then multiply each two chars
	 * at num1.charAt(i) and num2.charAt(j); the result should be res[i+j];
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	private static String multiplyStrings(String num1, String num2) {
		// TODO multiply two integer strings		
		if(num1.equals("0") || num2.equals("0")) return "0";
		if(num1.equals("1")) return num2;
		if(num2.equals("1")) return num1;
		
		String n1 = new StringBuilder(num1).reverse().toString();  
        String n2 = new StringBuilder(num2).reverse().toString();  
          
        int[] digit = new int[n1.length()+n2.length()];     //
        for(int i=0; i<n1.length(); i++){  
            for(int j=0; j<n2.length(); j++){  
                digit[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');      //
            }  
        }  
          
        //StringBuilder sb = new StringBuilder();  
        String retStr = "";
        for(int i=0; i<digit.length; i++){  
            int currDigit = digit[i]%10;        //
            int carry = digit[i]/10;        // 
            if(i+1<digit.length){  
                digit[i+1] += carry;  
            }  
            //sb.insert(0, digit);        // prepend
            retStr = currDigit + retStr;
        }  
          
        //clear the '0's in the front of the string :)
        int index = 0;
        while(retStr.charAt(index)=='0'){  
            index++;
            if(index==retStr.length()) return "";
        }  
        return retStr.substring(index);  
		
	}//end of addTwoString() method;

}//end of everything in MultiplyStrings class
