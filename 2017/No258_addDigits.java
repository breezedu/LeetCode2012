package leetcode2017;

/***************************
 * 
 * @author jeffd
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example: 
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 */

public class No258_addDigits {
	
	public static void main(String[] args){
		
		int num = 1234;
		
		System.out.println("The ultimate single digit of " + num + " is " + addDigits(num));
		
	}//end main();
	
    public static int addDigits(int num) {
        
        if(num < 10) return num;
        
        if(num%9 == 0) {
            return 9;
        } else {
            return num%9;
        }
        
    }//end addDigits();

}//ee
