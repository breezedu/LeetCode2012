package leetcode2017;
/*****************************
 * 
 * @author jeffd
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], 
 * after calling your function, nums should be [1, 3, 12, 0, 0].
 * 
 * Note: 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */
public class No283_MoveZeroes {
	
	public static void main(String[] args){
		
		//start with initialling an array of intgers
		int n = 10;
		int[] nums = createArrayWithZeros(n);
		printArray(nums);
		
	}//end main();

	
	private static void printArray(int[] nums) {
		// TODO Auto-generated method stub
		for(int ele : nums){
			System.out.print(ele + " ");
		}
		
		System.out.println();
		
	}//end printArray() 

	
	
	private static int[] createArrayWithZeros(int n) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[n];
		
		for(int i=0; i<n; i++){
			
			int random = (int)(Math.random()*n);
			
			if(random < n/3) {
				nums[i] = 0;
			
			} else {
				nums[i] = random - n/3;
			
			}
			
		}
		
		return nums;
	}//end createArrayWithZeros() method; 

}//ee
