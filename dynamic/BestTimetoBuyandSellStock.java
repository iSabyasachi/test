package test.dynamic;
import java.util.*;
import java.io.*;

public class BestTimetoBuyandSellStock{
    public static void main(String[] args) {
        BestTimetoBuyandSellStock obj = new BestTimetoBuyandSellStock();
       int[] prices = {7,1,5,3,6,4};    
       //int[] prices = {7,6,4,3,1};      
       int results = obj.maxProfit(prices);
       System.out.println(results);
    } 
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;        
        for(int i = 0 ; i < prices.length ; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }        
        return maxProfit;
    }
    /**
    Time Complexity : O(N ^ 2)
    Space Complexity : O(1)
     */
    public int maxProfitOld(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length ; i++){           
            for(int j = i ; j < prices.length ; j++){
                if(prices[j] > prices[i]){                    
                    int currProfit = prices[j] - prices[i];
                    maxProfit = Math.max(maxProfit, currProfit);
                }
            }
        }
        return maxProfit;
    }
}