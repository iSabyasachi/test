package test.arrays;

import java.util.*;
/**
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 */
public class BuyAndSellStock{  

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4}; //Result : 7
        //int[] prices = new int[]{1,2,3,4,5};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public static int maxProfit(int[] prices){
        int total=0;
        int peak = Integer.MAX_VALUE;
        int valley = peak;

        for(int i = 0; i < prices.length ; i++){
            if(prices[i] < peak){              
                total += peak - valley;
                valley = prices[i];
                peak = valley;
            }else{
                peak = prices[i];
            }
        }
        total += peak - valley;
        return total;
    }
}

