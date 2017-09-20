import java.util.ArrayList;

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
		
		int n = 2;
		
		int primes = countPrimes(n);
		
		System.out.println("There are " + primes + " primes less than " + n + ". ");
		
	} //end main(); 

	
	
	private static int countPrimes(int n) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> counts = new ArrayList<Integer>(); 
		
		for(int i=2; i<n; i++){
			
			int currCount = 0; 
			for(int j=0; j<counts.size(); j++){
				if(i%counts.get(j) == 0)
					currCount++;
			}
			
			if(currCount < 1){
				counts.add(i);
				System.out.println("add " + i);
			}
			
		}//end i<n loop; 
		
		return counts.size();
		
	}//end countPrimes()
	
}//ee
