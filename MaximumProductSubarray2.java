package leetcode2017;

public class MaximumProductSubarray2 {

	
	public static void main(String[] args){
		
	//	int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
		int[] nums = {-1,-2,3,-1,-2,1,1};
		
		System.out.println("max: " + maxProduct(nums));
		
	}


	
    public static int maxProduct(int[] nums) {
        
        if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		
		int len = nums.length;
		int[][] matrix = new int[len][len];
		
		int max = nums[0]; 
		
		for(int i=0; i<len; i++){
		    matrix[i][i] = nums[i];
		    
		    if(nums[i] > max) max = nums[i];
		}
		
		for(int i=0; i<len; i++){
			for(int j=i+1; j<len; j++){
				
				matrix[i][j] = matrix[i][j-1] * nums[j];
				if(matrix[i][j] > max)
					max = matrix[i][j];
			}
			
			printMatrix(matrix);
		}
		
		return max;
		
    }//end maxProduct()



	private static void printMatrix(int[][] matrix) {
		// TODO Auto-generated method stub
		
		int row = matrix.length; 
		int col = matrix[0].length; 
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				System.out.print(matrix[i][j] + "\t");
			}
			
			System.out.println();
		}
		
		System.out.println();
	}//end printMatrix() method; 
    
}//ee
