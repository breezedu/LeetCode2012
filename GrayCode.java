package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/**************
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. 
 * Sorry about that.
 * 
 * @author Frog
 *
 */
public class GrayCode {

	public static void main(String[] args){
	
		System.out.println("This is GrayCode program.");
		
		//1st, input an integer
		System.out.println("Please input the integer to convert into GrayCode:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		//2nd, convert the integer into an arrayList of gray code
		
		ArrayList<Integer> grayCode = convertGrayCode(num);
		System.out.println("Printout the gray codes:");
		printArrayList(grayCode);
		
	}//end of main()
	
	

	private static ArrayList<Integer> convertGrayCode(int num) {
		// TODO convert an integer into gray code
		
		int size = 1 << num;        // the maximum value, 2^n, if n=3, 1<<n = 111 in binary code;
        ArrayList<Integer> ret = new ArrayList<Integer>();  
          
        for(int i=0; i<size; i++){  
            // shift one figure right
            ret.add(i ^ (i>>1));  
        }  
        return ret;  
    }//end GrayCode() method

	private static void printArrayList(ArrayList<Integer> al) {
		// TODO Printout an arrayList
		
		if(al == null){
			System.out.println("It's an empty arrayList.");
			return;
		}
		
		for(int e:al){
			System.out.print(" " + e);
		}
		System.out.println();
	}//end of printArrayList() method
	
}//end of everything in GrayCode class
