// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that 
// adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// 一维数组，相邻两个数不能同时取值，求最大取值数的和

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
        }
        
        int[] maxSum = new int[len];
        maxSum[0] = nums[0];
        maxSum[1] = Math.max(nums[0], nums[1]);
        
        // maxSum[i]表示到第i个数为止，最大的取值数之和
        for(int i = 2; i < len; i++){
            maxSum[i] = Math.max(maxSum[i - 1], maxSum[i - 2] + nums[i]);
        }
        return maxSum[len - 1];
    }
}

// 动态规划中一位数组类

// state：f[i]表示到第i个数为止，最大的取值数之和（与第i个数是否取值无关）
// function: 1.若不取第i个数，则f[i]=f[i-1]; (与是否取i-1个数无关，只于第i-1个数为止最大和有关即f[i-1])
//			 2.若取第i个数，则i-1个数必不取，有f[i-1]=f[i-2]，第i个数为止的最大和等于第i-2个数为止的最大和加上第i个数的权重，故f[i]=f[i-2]+nums[i]。 
//			   (不能用f[i]=f[i-1]+nums[i]，虽然此时f[i-1]=f[i-2]，但是f[i-1]在全局中表示可以取到i-1的)