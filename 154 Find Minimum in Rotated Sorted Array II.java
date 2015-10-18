// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
// Find the minimum element.
// The array may contain duplicates.

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            if(nums[start] == nums[end]){  // 处理从duplicate处rotate的情况
                start = start + 1;
                continue;
            }
            
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[end]){  
                start = mid;
            }else{
                end = mid;
            }
        }
        
        return Math.min(nums[start], nums[end]);
    }
}


// 相较于sorted array找最小值那题，此题多了一个允许有duplicate的情况。
// 只需要单独对从duplicate处翻转的情况即可，例如：[3,3,1,3]