package leetcode2017;

/***************************
 * 
 * @author jeffd
 * 
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * 
 * Note that 1 is typically treated as an ugly number.
 *  
 */
public class No263_UglyNumber {
		
	public static void main(String[] args){
		
		int num = 12345;
		if(isUgly(num)){
			System.out.println("num " + num + " is an ugly number.");
		} else {
			System.out.println("num " + num + " is NOT an ugly number.");
		}
		
	}//end main();

	private static boolean isUgly(int num) {
		// TODO Auto-generated method stub
		if(num == 1) return true;
		if(num == 0) return false;
		
		while(num%2 == 0)
			num = num/2;
		while(num%3 == 0)
			num = num/3;
		while(num%5 == 0)
			num = num/5;
				
		return num == 1;
	}

}//ee
