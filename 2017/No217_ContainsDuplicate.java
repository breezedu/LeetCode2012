import java.util.HashSet;

/*************************************
 * 
 * @author Jeff
 *	
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * 
 */
public class No217_ContainsDuplicate {
	
	public static void main(String[] args){
		
		int n = 5; 
		int[] nums = createArray(n);
		printArray(nums);
		
		boolean conDup =  containsDuplicate(nums);
		
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


	public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<nums.length; i++){
            
            if( set.contains(nums[i])){
                return true;
            } else {
                set.add(nums[i]);
            }
            
            
            
        }
        return false; 
    }
	
}
