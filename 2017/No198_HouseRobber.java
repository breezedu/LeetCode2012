/****************************
 * 
 * @author Jeff
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security system connected and it will automatically 
 * contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 */
public class No198_HouseRobber {
	
	public static void main(String[] args){
		
		//step 1, create an array nums[] 
		int n = 10; 
		int[] nums = createArray(n);
		printArray(nums);
		
		
		//step 2, get the max sum of nums[i] to be robbed.
		int rob1 = rob(nums);
		
		System.out.println("The maxium $$ robbers could get from the street is: " + rob1);
		
		
		int rob2 = rob2(nums);
		
		System.out.println("The maxium $$ robbers could get from the street is: " + rob2);
		
		
		
	}//end main();
	
	

	private static int rob2(int[] nums) {
		// TODO Auto-generated method stub
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
        	dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        	dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        
        System.out.println();
        printMatrix(dp);
        
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
	}



	private static int rob(int[] nums) {
		// TODO Auto-generated method stub
		
		int len = nums.length; 
		int[][] rob = new int[2][len + 1];
		
		for(int i=1; i<=len; i++){
			rob[0][i] = Math.max(rob[0][i-1], rob[1][i-1]); //rob[i-1][0]
			rob[1][i] = nums[i-1] + rob[0][i-1];
		}
		
		printMatrix(rob);
		
		return Math.max(rob[0][len], rob[1][len]);
	}



	private static void printMatrix(int[][] rob) {
		// TODO Auto-generated method stub
		int row = rob.length;
		int col = rob[0].length;
		
		for(int i=0; i< row; i++){
			
			for(int j=0; j<col; j++){
				
				System.out.print(rob[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}//



	private static void printArray(int[] nums) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}//end printArray();



	private static int[] createArray(int n) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[n];
		
		for(int i=0; i<n; i++){
			
			nums[i] = (int)(Math.random() * 10);
			
		}
		
		return nums;
	}//end createArray();

}//ee
