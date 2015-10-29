// Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
// You have the following 3 operations permitted on a word: 
// a) Insert a character
// b) Delete a character
// c) Replace a character

// 两个字符串，其中一个通过最少几步增删替换的操作变成另一个字符串

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    }
                }
            }
        }
        
        return dp[len1][len2];
    }
}

// 动态规划，难题。思路参见 http://www.cnblogs.com/yuzhangcmu/p/4190264.html

// 1. 当分别新增的字符相等时，dp[i][j]等于不增加该字符时dp[i-1][j-1]的值
// 2. 当分别新增的字符不相等时，dp[i][j]等于从dp[i][j-1]增加一个字符的操作步数，或者从dp[i-1][j-1]替换一个字符的操作步数，或者从dp[i-1][j]删除一个字符的操作步数，取三者中最小的值。
