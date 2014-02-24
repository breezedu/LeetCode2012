package leetCode2012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/************
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @author Frog
 *
 */
public class ReverseInteger {

	public static void main(String[] args){
		
		System.out.println("This is a Reverse Integer program.");
		
		//1st, input an integer
		Scanner input = new Scanner(System.in);
		System.out.print("num = " );
		int num = input.nextInt();
		
		input.close();
		
		int revNum = reverse(num);
		
		System.out.println("The reverse integer of num is: " + revNum);
		
	}//end of main();

	private static int reverse(int num) {
		// TODO reverse an intger;
		if(num>-10 && num<10) return num;
		
		Queue<Integer> storNums = new LinkedList<Integer>();
		
		while(num<-9 || num>9){
			storNums.add(num%10);
			num = num/10;
		}
		storNums.add(num);
		
		int retNum = 0;
		while(!storNums.isEmpty()){
			retNum = retNum*10 + storNums.poll();
			
		}
			
		return retNum;
	}
	
}//end of everything in ReverseInteger class
