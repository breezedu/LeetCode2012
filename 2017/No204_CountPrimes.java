

/*******************************
 * 
 * @author Jeff
 * 
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 */
public class No204_CountPrimes {
	
	public static void main(String[] args){
		
		int n = 5;
		
		int primes = countPrimes(n);
		
		System.out.println("There are " + primes + " primes less than " + n + ". ");
		
	} //end main(); 

	
	
	private static int countPrimes(int n) {
		// TODO Auto-generated method stub
		//initial a boolean array, assuming they are all Non-prime; 
		boolean[] noPrime = new boolean[n];
		//System.out.println("n=3 " + noPrime[3]);
		
		int count = 0;
		//as we know, 2 is a prime; so, we start with 2, the boolean value is false, then all numbers 2*x will be no-prime
		//			so, we assign true to all boolean[2*x], here x could be any number less than n/2 
		for(int i=2; i<n; i++){
			
			if(noPrime[i] == false){
				count++;
				
				for(int j=2; i*j < n; j++){
					noPrime[i*j] = true; 
				}
				
			}
			
		}//end i<n loop; 
		
		return count;
		
	}//end countPrimes()
	
}//ee
