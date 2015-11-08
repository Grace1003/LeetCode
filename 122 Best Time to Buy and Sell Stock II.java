Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

思路：把每个上升区间当做一次交易，最左点买，最右点卖。

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null){
            return 0;
        }
        
        int len = prices.length;
        int profit = 0;
        for(int i = 1; i < len; i++){
            if(prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }
}