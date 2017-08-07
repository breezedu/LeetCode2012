package leetcode2017;

/*********
 * 
 * @author jeffd
 * 
 * Given an array of integers that is already sorted in ascending order, 
 * 1ind two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 */

public class TwoSumII {
	
	
	public static void main(String[] args){
		
		
		/**************
		 * Step One
		 */
		int length = 10; 
		int[] ascArray = generateArray(length);
		
		
		/***************
		 * Step Two
		 */
		
		int target = 85;
		int[] indices = twoSum(ascArray, target); 

		
		/************
		 * Step Three
		 */
		System.out.println("The original array:");
		printArray(ascArray);
		
		System.out.println("The target: " + target);
		
		System.out.println("The two indices at which the two elements add up to the target: " );
		printArray(indices); 
		
		
	} //end main();
	

	//print out an array;
	private static void printArray(int[] array) {
		// TODO Auto-generated method stub
		
		System.out.println();
		
		for(int i=0; i<array.length; i++){
			System.out.print( array[i] + "\t");
		}
		
		System.out.println();
		
		
	}



	/**********
	 * Part I method, generating an array of ascending ints
	 * @param length
	 * @return
	 */
	private static int[] generateArray(int length) {
		// TODO Auto-generated method stub
		
		int[] array = new int[length];
		
		array[0] = (int) (Math.random() * 10); 
		for(int i=1; i<length; i++){
			
			array[i] = array[i-1] + (int) (Math.random() * 10);
		}
		
		return array;
		
	}//end generateArray() method; 
	
	
	/************************************************
	 * Part II, get indices of two elements in the array
	 * which sum up to a target integer;
	 * 
	 */
	public static int[] twoSum(int[] numbers, int target) {
		
		//first, get the maxium integer in the array which is less than the target int
		int pivot = 0;
		while( numbers[pivot] < target ){
			pivot ++;
		}
		
		
		int[] indices = new int[2]; 
		
		
		
		
		
		return indices;
        
    }
	
	

}//end of everything; 
