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

	private static int maxProfit(int[] prices) {
		// TODO To calculate the max profit
		int Len = prices.length;
		if(Len < 2){
			return 0;
		} // end if condition;
		
        int minLR = prices[0];
        int maxRL = prices[prices.length - 1];
        
        int[] dpLR = new int[prices.length];
        int[] dpRL = new int[prices.length];
        int max = 0;
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minLR) 
            	minLR = prices[i];
            
            dpLR[i] = Math.max(dpLR[i - 1], prices[i] - minLR);
        }
        
        for(int i = prices.length - 2; i > -1; i--){
            if(prices[i] > maxRL) 
            	maxRL = prices[i];
            
            dpRL[i] = Math.max(dpRL[i + 1], maxRL - prices[i]);
        }
        
        for(int i = 0; i < prices.length; i++){
        	
        	System.out.print(" (" + dpLR[i] +", " + dpRL[i] +")");
            max = Math.max(max, dpLR[i] + dpRL[i]);
        }
        System.out.println();
        
        return max;
		
	} // end maxProfit() method;
	
	
} // end everything in BestTimetoBuyandSellStock class;
