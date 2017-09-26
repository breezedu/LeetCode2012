/******************************
 * 
 * @author Jeff
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 * 
 */
public class No268_MissingNumber {
	
	public static void main(String[] args){
		
		//step 1, create an array of integers
		int n = 20;
		int[] nums = createNums(n);
		
		printArray(nums);
		
				
		//2nd, get the missing integer in the array; 
		
		System.out.println("The missing value is: " + missingNumber(nums));
		
		
	}//end main();

	
	/***************************
	 * step 1, get the sum() of all the nums[];
	 * step 2, calculate sum of 0-n;
	 * step1 - step2 = the missing value; 
	 * 
	 * @param nums
	 * @return
	 */
	private static int missingNumber(int[] nums) {
		// TODO Auto-generated method stub
		int sum = 0; 
		int end = nums.length; 
		
        for(int i=0; i<end; i++){
            sum += i;
            sum = sum - nums[i];
        }
        
        sum = sum + end; 
				
		return sum;
	}//end missingNumber() method; 

	
	
	
	private static void printArray(int[] nums) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
		
	}//end printArray() method; 
	

	private static int[] createNums(int n) {
		// TODO Auto-generated method stub
		
		int miss = (int)(Math.random()*n);
		
		System.out.println("The missing value should be: " + miss);
		
		int[] nums = new int[n-1];
		
		for(int i=0; i<n-1; i++){
			
			if(i < miss)	nums[i] = i;
			
			if(i >= miss) nums[i] = i+1;
			
		}
		
		return nums;
	} //end createNums() method; 
	
	

}//ee
