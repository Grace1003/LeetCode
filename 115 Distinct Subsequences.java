// Given a string S and a string T, count the number of distinct subsequences of T in S.
// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
// Here is an example: S = "rabbbit", T = "rabbit". Return 3.

// 给定两个字符串S和T，求S有多少个不同的子串与T相同

public class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null){
            return 0;
        }
        
        int sLen = s.length();
        int tLen = t.length();
        if(sLen < tLen){    // 要排除s比t短的情况
            return 0;
        }
        
        int[][] dp = new int[tLen + 1][sLen + 1];
        for(int i = 0; i <= tLen; i++){
            for(int j = 0; j <= sLen; j++){
                if(i == 0){
                    dp[i][j] = 1;
                }else if(j == 0){
                    dp[i][j] = 0;
                }else{
                	// 如果s增加一个字符，dp[i][j]至少等于s每增加新字符时的值
                    dp[i][j] += dp[i][j - 1];

                    // 如果两个字符串中，最后一个字符相同，则加上左上角的数字（注意不是对比第i,j个字符，因为i和j比字符串下标多一）
                    if(t.charAt(i - 1) == s.charAt(j - 1)){   // 注意s/t与i/j的对应关系，容易越界
                        dp[i][j] += dp[i - 1][j - 1];
                    } 
                }
            }
        }
        
        return dp[tLen][sLen];
    }
}

// 动态规划，自己画表去理解推导关系。解答参见：http://blog.csdn.net/abcbc/article/details/8978146

// 无论T的字符与S的字符是否匹配，dp[i][j] = dp[i][j - 1].就是说，假设S已经匹配了j - 1个字符，得到匹配个数为dp[i][j - 1].现在无论S[j]是不是和T[i]匹配，匹配的个数至少是dp[i][j - 1]。
// 除此之外，当S[j]和T[i]相等时，我们可以让S[j]和T[i]匹配，然后让S[j - 1]和T[i - 1]去匹配。


