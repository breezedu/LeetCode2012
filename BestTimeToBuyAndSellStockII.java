package leetCode2012;

import java.util.Scanner;

/***********
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * 
 * @author Frog
 *
 */

public class BestTimeToBuyAndSellStockII {
	
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

	/*********
	 * just calculate everyday 'rise";
	 * @param prices
	 * @return
	 */
	private static int maxProfit(int[] prices) {
		// TODO To calculate the max profit
		int Len = prices.length;
		if(Len == 0){
			return 0;
		}
		
		int max = 0; // this is the worst condition, no profit;
		for(int i=0; i<Len-1; i++){
			
			if(prices[i+1]>prices[i]){
				max += prices[i+1]-prices[i];
			}
		} // end for i<Len-1 loop;
		
		return max;
	} // end maxProfit() method;
	
	
} // end everything in BestTimetoBuyandSellStock class;
