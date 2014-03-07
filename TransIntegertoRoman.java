package leetCode2012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/***************
 * Given an integer, convert it to a Roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Frog
 *
 */
public class TransIntegertoRoman {

	public static void main(String[] args){
		
		System.out.println("This is Transfer Integer to Roman numeral program.");
		
		//1st, ask user to input an Integer;
		System.out.println("Please input the integer:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		
		//2nd, transfer the Integer into Roman numeral:
		String roman = intToRoman(num);
		
		//printout the Roman numeral
		System.out.println("The Roman numeral is: " + roman +". ");
		
	}//end main();

	private static String intToRoman(int num) {
		// TODO Transfer Integer to Roman numeral
		if(num == 0) return "";
		
		HashMap<Integer, String> romans = new HashMap<Integer, String>();
        romans.put(1, "I");
        romans.put(5, "V");
        romans.put(10, "X");
        romans.put(50, "L");
        romans.put(100, "C");
        romans.put(500, "D");
        romans.put(1000, "M");
        
        ArrayList<Integer> keys = new ArrayList<Integer>(romans.keySet());
        Collections.sort(keys);
        
        for (int i = keys.size() - 1; i >= 0; i--) {
            int ki = keys.get(i);
            String si = romans.get(ki);
            if (num >= ki) 
                return si + intToRoman(num - ki);
                
            if (i > 0) {
                int kj = keys.get(i - 1 - ((i - 1) % 2));
                String sj = romans.get(kj);
                if (num >= ki - kj) 
                    return sj + si + intToRoman(num - (ki - kj));
            }
        }
        return "";

	}//end intToRoman() method;
	
	
}//end of everything in TransIntegertoRoman class
