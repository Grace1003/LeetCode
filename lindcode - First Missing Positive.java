/*
Given an unsorted integer array, find the first missing positive integer.

Example
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

*/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here   
        if (A == null || A.length == 0){
            return 1;
        }
        
        int len = A.length;
        Arrays.sort(A);
        boolean hasOne = (A[0] == 1);   //要考虑A[0]，因为for循环从1开始的
        for (int i = 1; i < len; i++){
            if (A[i] == 1){
                hasOne = true;
            }
            if (A[i] != A[i - 1] + 1 && A[i] != A[i - 1] && A[i - 1] + 1 > 0 && hasOne){
                return A[i - 1] + 1;
            }
        }
        return hasOne ? A[len - 1] + 1 : 1;  
    }
}

// [2,2,2]
// [-3,-2,-5]
// [1]
// 重复数 [0,1,2,2,3,3,4]


注意可能出现的情况：
1. 数组全是负数 => 返回1
2. 数组中最小数都大于1 => 返回1 => 需要有hasOne来标记
3. 数组只有一位数，不进行for循环 => 检查这个数是不是1
4. 有重复数字出现 => A[i] != A[i - 1] + 1 && A[i] != A[i - 1]
