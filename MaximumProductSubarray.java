package leetcode2017;

public class MaximumProductSubarray {

	
	public static void main(String[] args){
		
		int[] nums = {-2, 3, -4};
		
		System.out.println("max: " + maxProduct(nums));
		
	}


	
    public static int maxProduct(int[] nums) {
        
        if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		
		int len = nums.length;
		int[][] matrix = new int[len][len];
		
		//define a negative matrix[][] to record the minimium negative value; 
		int[][] matrix_negative = new int[len][len];
		
		int max = nums[0]; 
		
		for(int i=0; i<len; i++){
		    matrix[i][i] = nums[i];
		    
		    if(nums[i] < 0) matrix_negative[i][i] = nums[i];
		    
		    if(nums[i] > max) max = nums[i];
		}
		
		
		
		for(int i=0; i<len-1; i++){
		    
		    for(int j=i+1; j<len; j++){
		    		if(nums[j] > 0){
		    			
		    			matrix[i][j] = nums[j];
		            
		    			int newValueP = matrix[i][j-1] * nums[j]; 
		    			
		    			if(newValueP > matrix[i][j-1] && newValueP > nums[j])
		    				matrix[i][j] = newValueP;
		            
		    			if(matrix[i][j] > max) max = matrix[i][j];
		    			
		    			matrix_negative[i][j] = matrix_negative[i][j-1] * nums[j];
		    			
		    		} else if(nums[j] < 0){
		    			
		    			int newValueP = matrix_negative[i][j-1] * nums[j];
		    			if(newValueP > matrix[i][j-1]) matrix[i][j] = newValueP;
		    			
		    			int newValueN = matrix[i][j-1] * nums[j];
		    			if(newValueN < matrix_negative[i][j-1]) matrix_negative[i][j] = newValueN;
		    			
		    			if(newValueP > max) max = newValueP;
		    		}

		        
		        
		    }
		    
		}
		
		return max;
		
    }//end maxProduct()
    
}
