// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
// Find the minimum element.
// You may assume no duplicate exists in the array.

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if(nums[mid] > nums[end]){   // 四种情况，可以用mid和end值比较区分为两种情况
                start = mid;   // 不是mid+1
            }else{
                end = mid;  // 不是mid-1
            }
        }
        
        return Math.min(nums[start], nums[end]);
    }
}

// 二分法
// 1. 注意移动start和end时，不要移动到mid+1或者mid-1。因为nums[mid]可能就是最小值，跳过了。
// 2. 一共四种情况，但是可以用mid和end值区分为两种情况