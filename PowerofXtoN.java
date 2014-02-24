package leetCode2012;

import java.util.Scanner;

/********
 * Implement pow(x, n).
 * @author Frog
 *
 */
public class PowerofXtoN {

	public static void main(String[] args){
		
		System.out.println("This is PowerofXtoN program.");
		
		//1st, input double x and integer n;
		Scanner input = new Scanner(System.in);
		System.out.print("x = ");
		double x = input.nextDouble();
		
		System.out.print("n = ");
		int n = input.nextInt();
		
		input.close();
		
		double pXtoN = pow(x, n);
		
		System.out.println("The power of " + x +" to " + n +" is: " + pXtoN);
		
	}//
	
	public static double pow(double x, int n) {
        
        if(n==0) return 1.0;
        if(x==0) return 0.0;
        
        if(n==1) return x;
        
        if(n<0){
            n = -n;
            x = 1/x;
        }
        
        double retP = pow(x, n / 2);
 
    	if (n % 2 == 0) {
	    	return retP * retP;
	    	
	    } else {
		    return retP * retP * x;
		    
    	}
    }//end of pow() method;
	
}//end of everything in PowerofXtoN class
