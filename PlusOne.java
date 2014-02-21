package leetCode2012;

import java.util.Scanner;

/****************
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author Frog
 */

public class PlusOne {
	
	public static void main(String[] args){
		
		System.out.println("This is a Plue One program.");
		
		//1st, create an array with integers <10;
		int[] array = createArray();
		System.out.println("The original array has been created:");
		printArray(array);
		
		//2nd, plus one to the array;
		int[] plusOne = plusOne(array);
		System.out.println("After PlueOne, the new array is:");
		printArray(plusOne);
		
		
		
	}//end main();

	private static int[] plusOne(int[] array) {
		// TODO Auto-generated method stub
		

        if(array.length == 0) {
            int[] ret = new int[1];
            ret[0] = 1;
            return ret;
        }
        
        int Len = array.length;
      
        int plus = 1;
        for(int i=Len-1; i>=0; i--){
            
            if(array[i] == 9){
                
            	array[i] = 0;
            
                plus = 1;
            } else {
            	array[i] = array[i]+1;
                plus = 0;
                break;
            }
            
        }//end for i>=0 loop;
        
        if(plus == 0) {
            return array;
            
        } else {
            int[] ret = new int[Len+1];
            ret[0] = plus;
            for(int i=1; i<=Len; i++){
                ret[i] = array[i-1];
            }
         
            return ret;
        }
		
	}//end plusOne() method;

	private static void printArray(int[] array) {
		// TODO printout the array
		if(array == null){
			System.out.println("There's nothing in the array.");
			return;
		}
		
		int Len = array.length; 
		for(int i=0; i<Len; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
		
	}//end printArray() method;

	private static int[] createArray() {
		// TODO create an array with integers less than 10
		
		System.out.println("Please input the length of the array:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		input.close();
		if(num == 0) return null;
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			
			array[i] = (int)(Math.random() * 9);
		}
		return array;
	}// end createArray() method;

}//end of everything in PlusOne class
