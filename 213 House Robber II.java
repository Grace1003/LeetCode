// Note: This is an extension of House Robber.
// This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
// Meanwhile, the security system for these houses remain the same as for those in the previous street.
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// 所有house排成一个圈，可以理解为原来的一维数组中收尾两个值只能至多取一个。

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }else if(len == 2){
            return Math.max(nums[0], nums[1]);
        }else if(len == 3){
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }

        // 1. robbed the first house
        int[] maxSum1 = new int[len];
        maxSum1[0] = nums[0];
        maxSum1[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len - 1; i++){
            maxSum1[i] = Math.max(maxSum1[i - 1], maxSum1[i - 2] + nums[i]);
        }
        maxSum1[len - 1] = maxSum1[len - 2];
        
        // 2. robbed the last house
        int[] maxSum2 = new int[len];
        maxSum2[0] = 0;
        maxSum2[1] = nums[1];
        for(int i = 2; i < len; i++){
            maxSum2[i] = Math.max(maxSum2[i - 1], maxSum2[i - 2] + nums[i]);
        }
        
        return Math.max(maxSum1[len - 1], maxSum2[len - 1]);
    }
}