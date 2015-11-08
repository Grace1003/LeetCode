Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        
        int rightSum = nums.length * (nums.length + 1) / 2;
        return rightSum - sum;
    }
}

用完整数组的和减去差一个数的数组的和，得到所缺少的数。
但这种方法在n较大时可能导致溢出。