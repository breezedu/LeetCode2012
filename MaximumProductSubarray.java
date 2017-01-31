package leetcode2017;

public class MaximumProductSubarray {

	
	public static void main(String[] args){
		
	//	int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
		int[] nums = {-1,-2,3,-1,-2,1,1};
		
		System.out.println("max: " + maxProduct(nums));
		
	}


	
    public static int maxProduct(int[] nums) {
        
        if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		
		int len = nums.length;
		int max[] = new int[len];
		int min[] = new int[len];
		int maxv = max[0] = min[0] = nums[0];
		
		for(int i=1; i<len; i++){
			
			if(nums[i] > 0){
				
				max[i] = Math.max(nums[i], max[i-1] * nums[i]);
				min[i] = Math.min(nums[i], min[i-1] * nums[i]);
				
			} else {
				
				max[i] = Math.max(max[i-1], min[i-1] * nums[i]);
				min[i] = Math.min(nums[i], max[i-1] * nums[i]);
				
			}
			
			if(max[i] > maxv) maxv = max[i];
	    }//end for length < len loop; 	
		
		return maxv;
		
    }//end maxProduct()


    
}//ee
