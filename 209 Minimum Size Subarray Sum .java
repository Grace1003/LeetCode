// Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
// For example, given the array [2,3,1,2,4,3] and s = 7,
// the subarray [4,3] has the minimal length under the problem constraint.

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int start = 0, end = 0;  // end取0不取1，因为要考虑只含数组的第一个值的情况
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(start <= end && end < nums.length){
            sum += nums[end];   // 解决了只含数组的第一个值的情况，不用单独考虑
            while(start <= end && sum >= s){
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        
        if(minLen == Integer.MAX_VALUE){
            return 0;
        }else{
            return minLen;
        }
    }
}


// 用前后两个游标滑动遍历，减少时间复杂度。
// 注意两个游标在初始状态的情况。