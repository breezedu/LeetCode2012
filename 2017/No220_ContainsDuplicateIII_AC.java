import java.util.TreeSet;

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
public class No220_ContainsDuplicateIII_AC {
	
	public static void main(String[] args){
		int n = 2; 
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


		/*******************
		 * pretty much like a heap sort method; 
		 * 
		 * @param nums
		 * @param k
		 * @param t
		 * @return
		 */
		public static boolean containsDuplicate(int[] nums, int k, int t) {	        

			int len = nums.length;
        	if (k < 1 || t < 0 || len < 1) return false;
	        
			TreeSet<Integer> set = new TreeSet<Integer>();
			
			//build the initial tree-set, with k elements in it;
			for(int i=0; i<len; i++){
			
				Integer floor = set.floor(nums[i]);
				Integer ceil = set.ceiling(nums[i]);
				
				if(floor!= null){
					long abs = (long)nums[i] - floor; 
					if(abs <= t) return true; 
				}
				
				if(ceil != null){
					
					long abs = (long)ceil - nums[i];
					if(abs <= t ) return true; 
				}
				
				set.add(nums[i]);
				
				//only keep less than k elements in the treeset
				if(i >= k){
					set.remove(nums[i-k]);
				}
			}
			
			return false; 
	    }

}//ee
