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
	
	/********
	 * main() 
	 * @param args
	 */
	public static void main(String[] args){
		
		//start with initialling an array of intgers
		int n = 10;
		int[] nums = createArrayWithZeros(n);
		System.out.println("Printout the original array.");
		printArray(nums);
		
		//remove zeroes in the array to the tail part;
		moveZeroes(nums);
		System.out.println("Printout the array after removing zeros to the tail.");
		printArray(nums);
		
	}//end main();

	/***********************************
	 * use a pointer pointing to the indices of no-zero elements
	 * iterate the array, whenever there's a non-zero element, put it to the num[pointer], pointer ++
	 * iterate from pointer to nums.length, assign 0 to them. 
	 * @param nums
	 */
	private static void moveZeroes(int[] nums) {
		// TODO Auto-generated method stub
		
		int pointer = 0;		
		for(int i = 0; i<nums.length; i++){			
			
			if(nums[i] != 0){
				nums[pointer] = nums[i];
				pointer ++;
			}
		
		}//end for i<nums loop;
		
		for(int i=pointer; i<nums.length; i++){
			nums[i] = 0;
		}
		
	}//end moveZeroes() method; 

	/*********
	 * just printout the whole array in one line; 
	 * @param nums
	 */
	private static void printArray(int[] nums) {
		// TODO Auto-generated method stub
		for(int ele : nums){
			System.out.print(ele + " ");
		}
		
		System.out.println();
		
	}//end printArray() 

	
	/****************
	 * initial an array of n integers;
	 * the range for these integers would be (0-n);
	 * if the random element's value is less than n/3, make the correspond value to be zero;
	 * thus, 33% of the elements in the array would be zero.
	 * 
	 * @param n
	 * @return
	 */
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
			
		}//end for i<n loop; 
		
		return nums;
	}//end createArrayWithZeros() method; 

}//ee
