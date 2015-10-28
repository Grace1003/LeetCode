// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

public class Solution {
    public int numSquares(int n) {
        int[] minNum = new int[n + 1];  //使用从1到n的下标，方便处理
        minNum[1] = 0;
        
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;  
            for(int j = 1; j <= n; j++){   // 循环每一个可能的i=a+j^2的组合，找出最小值赋值给f[i]
                if(j * j == i){
                    min = 1;
                    break;
                }else if(j * j < i){
                    min = Math.min(minNum[i - j * j] + 1, min);  // 求i固定时不同j对应的min的最小值
                }else{
                    break;
                }
            }
            minNum[i] = min;
        }
        
        return minNum[n];
    }
    
}

// 动态规划，用一维数组表示不同n对应的最小的完全平方数之和
// state：i是由最少f[i]个完全平方数（1，4，9.。。）组成的

// 如果一个数x可以表示为一个任意数a加上一个平方数bｘb，也就是x=a+bｘb，那么能组成这个数x最少的平方数个数，就是能组成a最少的平方数个数加上1
// 例如：16=7+3*3，16=0+4*4，16=12+2*2
// function：f[i] = Math.min(所有的i=a+j^2组合下最小的的平方数个数)