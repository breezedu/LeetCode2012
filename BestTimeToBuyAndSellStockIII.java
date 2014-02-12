package leetCode2012;

import java.util.Scanner;

/***********
 * Say you have an array for which the ith element is 
 * the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * @author Frog
 *
 */

public class BestTimeToBuyAndSellStockIII {
	
	public static void main(String[] args){
		
		//1st, input the Length of the array;
		Scanner input = new Scanner(System.in);
		int Num = input.nextInt();
		input.close();
		
		//2nd, generate an array of stock price at day i;
		int[] prices = buildArray(Num); // new int[Num];
		
		
		//3rd, calculate the max profit;
		int max = maxProfit(prices);
		
		System.out.println("The max profit is: " + max);
		
	} // end main();

	private static int[] buildArray(int num) {
		// TODO Auto-generated method stub
		int[] prices = new int[num];
		for(int i=0; i<num; i++){
			
			prices[i] = (int)(Math.random() * 100);
			System.out.print(" " + prices[i]);
		}
		System.out.println();
		
		return prices;
	} // end buildArray() loop;

	/************
	 * Break the prices[] array into '2' sections;
	 * use the bestTimeSellBuy-i method, we can calculate the maximum maxL[i] profit from day[0] to day[i];
	 * then use similar method to calculate the maximum profit maxR[i] from day[i+1] to day[Len-1];
	 * At the last loop, 
	 * @param prices
	 * @return
	 */
	private static int maxProfit(int[] prices) {
		// TODO To calculate the max profit
		int Len = prices.length;
		if(Len < 2){
			return 0;
		} // end if condition;
		
		int minL = prices[0];
		int maxR = prices[prices.length - 1];
		
		//dayProfitLeft and dayProfitRight
		int[] dpL = new int[prices.length]; // the profit between day 0 and day i;
		int[] dpR = new int[prices.length]; // the profit between day i and day Len-1;
		
		int max = 0;
		
		for(int i = 1; i < Len; i++){
			if(prices[i] < minL)
				minL = prices[i];
			
			dpL[i] = Math.max(dpL[i - 1], prices[i] - minL);
		} // end for i<price.length loop;
		
		for(int i = Len - 2; i > -1; i--){
			if(prices[i] > maxR) 
				maxR = prices[i];
			
			dpR[i] = Math.max(dpR[i + 1], maxR - prices[i]);
		} // end for i>=0 loop;
		
		for(int i = 0; i < Len; i++){
			System.out.print(" (" + dpL[i] +", " + dpR[i] +")");
			max = Math.max(max, dpL[i] + dpR[i]);
		} // end for i<Len loop; got the max profit of two sections: day[0-i] and day[i-Len];
		
		System.out.println();
		
		return max;
		
	} // end maxProfit() method;
	
	
} // end everything in BestTimetoBuyandSellStock class;
