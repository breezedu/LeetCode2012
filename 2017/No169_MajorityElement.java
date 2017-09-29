import java.util.HashMap;

/**************
 * 
 * @author Jeff
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 */
public class No169_MajorityElement {

	public static void main(String[] args){
		
		//step 1, create an array, with duplicated elements;
		int n = 10;
		int[] nums = createArray(n);
		
		
		//step 2, find out the majority element in the array;
		int mEle = majorityElement(nums);
		
		System.out.println("The majority element in the array is: " + mEle);
		
	}//end main();
	
	private static int majorityElement(int[] nums) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++){
			
			if(!map.containsKey(nums[i])){
				
				map.put(nums[i], 1);
			
			} else {
				
				map.put(nums[i], map.get(nums[i]) + 1);
								
			}
			
			if(map.get(nums[i]) > nums.length/2) return nums[i];
			
		}
		
		return 0;
	}

	/**********
	 * create an array of integers;
	 * @param n
	 * @return
	 */
	private static int[] createArray(int n) {
		// TODO Auto-generated method stub
		
		int nums[] = new int[n];
		for(int i=0; i<n; i++){
			nums[i] = (int)(Math.random() * 5);
		}
		
		return nums;
	}//end createArray() method; 
	
}//ee;
