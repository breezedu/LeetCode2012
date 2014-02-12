package leetCode2012;

import java.util.Scanner;

/***********
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * @author Frog
 *
 */

public class BestTimeToBuyAndSellStock {
	
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

	private static int maxProfit(int[] prices) {
		// TODO To calculate the max profit
		int Len = prices.length;
		if(Len == 0){
			return 0;
		}
		
		int max = 0; // this is the worst condition, buy and sell the stock at the same day;
		int min = prices[0];
		
		//This is also an algo to calculate max profit from day[0] to day[Len-1];
		for(int i=0; i<Len; i++){
			
			max = Math.max(max, prices[i] - min);
			min = Math.min(min, prices[i]); 
			// the minimum value will update everyday, 
			// then the max profit will update accordingly;
					
		} // end for i<Len loop;
		
		return max;
	} // end maxProfit() method;
	
	
} // end everything in BestTimetoBuyandSellStock class;
