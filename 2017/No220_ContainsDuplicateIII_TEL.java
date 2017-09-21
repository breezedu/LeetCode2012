/****************************************
 * 
 * @author Jeff
 * 
 * Given an array of integers, 
 * find out whether there are two distinct indices i and j in the array 
 * such that the absolute difference between nums[i] and nums[j] is at most t 
 * and the absolute difference between i and j is at most k.
 * 
 * This code passed 39 out of 40 test cases. 
 * 
 */
public class No220_ContainsDuplicateIII_TEL {
	
	public static void main(String[] args){
		int n = 15; 
		int k = 3;
		int t = 2;
		
		int[] nums = createArray(n);
		printArray(nums);
		
		boolean conDup =  containsDuplicate(nums, k, t);
		
		if(conDup){
			System.out.println("There is at least one pair of duplicate numbers.");
		} else {
			System.out.println("There is NO duplicate numbers.");
		}
		
	}//end main()
	
	
	 private static void printArray(int[] nums) {
			// TODO Auto-generated method stub
			for(int i=0; i<nums.length; i++){
				System.out.print(" " + nums[i]);
			}
			
			System.out.println();
		}


		private static int[] createArray(int n) {
			// TODO Auto-generated method stub
	    	int[] array = new int[n];
	    	for(int i=0; i<n; i++){
	    		array[i] = (int)(Math.random()*10);
	    	}
			return array;
		}


		public static boolean containsDuplicate(int[] nums, int k, int t) {
	        
			int len = nums.length;
	        
			
			for(int i=0; i<len; i++){
				
				int bucket = Math.min(i+k, len);
				
				for(int j=i+1; j<bucket; j++){
					
					long value = (long) nums[j] - (long)(nums[i]);
					if(value < 0) value = -value; 
					
					if(value <= t){
						System.out.println("i=" + i + ", j=" + j +", dis=" + value);
						return true; 
					} //end if
					
				}//end for j<len; 
				
			}//end i<len; 
			
			
			
			return false; 
	    }

}//ee
