package leetCode2012;

import java.util.Scanner;

/********
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author Frog
 *
 */
public class PalindromeNumber {

	public static void main(String[] args){
		
		System.out.println("This is a Palindrome Number problem.");
		
		//1st, input an integer
		Scanner input = new Scanner(System.in);
		System.out.print("number = ");
		int num = input.nextInt();
		input.close();
		
		
		//2nd, check if the inputed integer is palindrome or not;
		boolean palin = isPalindrome(num);
		
		if(palin){
			System.out.println("Yes, " + num +" is a Palindrome number.");
			
		} else {
			System.out.println("No, that's not a palindrome number.");
			
		}//end if-else conditions;
		
	}//end main();

	private static boolean isPalindrome(int num) {
		// TODO check if a number is palindrome;
		if(num <0) return false;
		if(num <10) return true; //0-9 are palindromes;
		
		//diff means the 'figures' of num: 10 for 10-99, 100 for 100-999.... 
		int diff = 10;
		while(num/diff >= 10){
			diff *= 10;
		}
		System.out.println("diff = " +diff);
		
		return checkPalindrome(num, diff);
		
	}//end isPalindrome() method;

	private static boolean checkPalindrome(int num, int diff) {
		// TODO check if a num of diff levels is palindrome or not;
		if(diff==0 || diff==1){
			return true;
		}//end directly return conditions;
		
		System.out.println("num= " + num +" num/diff=" + num/diff +", num%10=" + num%10);
		if(num/diff != num%10) return false;
		
		num = num%diff;
		num = num/10;		
		return checkPalindrome(num, diff/100); //recursion
		
	}//end checkPalindrome() method;
	
}//end of everything in PalindromeNumber class;
