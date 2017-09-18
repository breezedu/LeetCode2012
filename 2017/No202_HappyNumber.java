import java.util.HashSet;

/******************************
 *  * 
 * @author Jeff
 * 
 * Write an algorithm to determine if a number is "happy". 
 * 
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay), 
 * or it loops endlessly in a cycle which does not include 1.
 *  
 * Those numbers for which this process ends in 1 are happy numbers.
 * 		Example: 19 is a happy number
 * 		1^2 + 9^2 = 82
 * 		8^2 + 2^2 = 68
 * 		6^2 + 8^2 = 100
 * 		1^2 + 0^2 + 0^2 = 1
 * 
 */
public class No202_HappyNumber {
	
	public static void main(String[] args){
		
		int num = 7;
				
		boolean HY = isHappy(num);
		
		if(HY){
			System.out.println("It is a happy number: " + num);
		} else {
			System.out.println("It is NOT a happy number: " + num);
		}
		
	}//end main();

	//1st, check if the num is in the HashSet, if yes, return False;
	//2nd, if NO, add the num to the HashSet, 
	//3rd, calculate the next sum of each digit square.
	private static boolean isHappy(int num) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<Integer>();
						
		return recurrsion(num, set);
	}

	private static boolean recurrsion(int num, HashSet<Integer> set) {
		// TODO Auto-generated method stub
		
		if(num == 1){
			return true;
		}
		
		if( set.contains(num)){
			return false;
			
		} else {
			set.add(num);
		}
		
		int num2 = breakNum(num);
		
		return recurrsion(num2, set);
	}

	private static int breakNum(int num) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		
		while(num > 0){
			
			sum += (num%10)*(num%10);
			
			num = num/10;
		}
		
		
		
		System.out.println(sum);
		return sum;
	}

}//ee
