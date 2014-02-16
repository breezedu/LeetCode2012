package leetCode2012;

import java.util.Scanner;

/*******************
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 * 
 * @author Frog
 *
 */
public class ValidNumber {
	
	public static void main(String[] args){
		
		System.out.println("This is a Valid Number program");
		
		//1st, input a string;
		System.out.println("Please input a string:");
		Scanner input = new Scanner(System.in);
		String s = input.next();
		input.close();
		
		boolean isNum = isNumber(s);
		
		if(isNum){
			System.out.println("The inputed string is a number.");
			
		} else {
			System.out.println("It's not a number.");
			
		}
		
	}// end main();

	private static boolean isNumber(String s) {
		// TODO check if a string is a valid number or not
		// through regex expression;

		if(s.trim().isEmpty()){  
            return false;  
        }  
        
        
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";  
        
        if(s.trim().matches(regex)){  
            return true;  
        }else{  
            return false;  
        }
	}// end isNumber() method;

}//end everything of ValidNumber;
