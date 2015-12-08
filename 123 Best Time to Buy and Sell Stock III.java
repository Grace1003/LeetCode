Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).



九章思路： 动态规划
把prices[]分成两部分prices[0...m] 和 prices[m...length]，分别计算在这两部分内做交易的最大收益。
用两个一位数组记录划分处左边部分最大收益和右边部分最大收益。

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1){
            return 0;
        }
        int len = prices.length;
        
        //正向遍历，left[i]表示 prices[0...i]内做一次交易的最大收益.
        int[] left = new int[len];
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < len; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            if (maxProfit < prices[i] - min){
                maxProfit = prices[i] - min;
            }
            left[i] = maxProfit;
        }
        
        //逆向遍历, right[i]表示 prices[i...n-1]内做一次交易的最大收益.
        int[] right = new int[len];
        int max = Integer.MIN_VALUE;
        maxProfit = 0;
        for (int i = len - 1; i >= 0; i--){
            if (prices[i] > max){
                max = prices[i];
            }
            if (maxProfit < max - prices[i]){
                maxProfit = max - prices[i];
            }
            right[i] = maxProfit;
        }
        
        //再进行划分，分别计算两个部分
        maxProfit = 0;
        for (int i = 0; i < len; i++){
            int profit = left[i] + right[i];
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        
        return maxProfit;
    }
}

