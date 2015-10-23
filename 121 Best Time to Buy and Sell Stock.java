// Say you have an array for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// 利润 = 高价 - (高价前出现的)低价

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){  // 至少有两个price时才能买卖
            return 0;
        }
        
        int max_profit = 0;  //初始值为0，profit最小值为0，而不是prices[0]
        int min_price = prices[0];
        for(int i = 1; i < prices.length; i++){
            min_price = Math.min(min_price, prices[i]);
            max_profit = Math.max(max_profit, prices[i] - min_price);
        }
        
        return max_profit;
    }
}