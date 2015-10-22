// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
// For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        int max_sum = nums[0];
        
        for(int i = 1; i < len; i++){
            if(sum + nums[i] > nums[i]){
                sum = sum + nums[i];
            }else{
                sum = nums[i];
            }
            max_sum = Math.max(sum, max_sum);
        }
        
        return max_sum;
    }
}


// DP可以让时间复杂度将为O(n)

// 从头遍历这个数组。对于数组中的其中一个元素，它只有两个选择：1. 要么加入之前的数组加和之中（跟别人一组）2. 要么自己单立一个数组（自己单开一组）
// 所以对于这个元素应该如何选择，就看他能对哪个组的贡献大。如果跟别人一组，能让总加和变大，还是跟别人一组好了；如果自己起个头一组，自己的值比之前加和的值还要大，那么还是自己单开一组好了。