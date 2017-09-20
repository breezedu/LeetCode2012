import java.util.HashMap;

/*************************************
 * 
 * @author Jeff
 *	
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * 
 */
public class No219_ContainsDuplicateII {
	
	public static void main(String[] args){
		
		int n = 15; 
		int k = 6;
		int[] nums = createArray(n);
		printArray(nums);
		
		boolean conDup =  containsDuplicate(nums, k);
		
		if(conDup){
			System.out.println("There is at least one pair of duplicate numbers.");
		} else {
			System.out.println("There is NO duplicate numbers.");
		}
	}
	
	
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


	public static boolean containsDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++){
            
          if(  !map.containsKey(nums[i]) ){
        	  map.put(nums[i], i);
        	  
          } else {
        	  
        	  if( i - map.get(nums[i]) <= k ) return true; 
        	  
          }
            
        }
        return false; 
    }
	
}
