// A peak element is an element that is greater than its neighbors.
// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
// You may imagine that num[-1] = num[n] = -∞.
// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.


public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(mid + 1 <= nums.length - 1){   // 这个if可以省略，因为mid是不可能取到len-1的。可以直接用mid和mid+1对应的值来判断
                if(nums[mid] < nums[mid + 1]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        
        if(nums[start] < nums[end]){
            return end;   // 注意返回的是index还是index对应的值
        }else{
            return start;
        }
    }
}


// 二分法。注意，不是拿nums[start]、nums[end]与nums[mid]相比，而是判断nums[mid]处于上升阶段还是下降阶段。
// 本题巧妙的地方是用nums[mid]与nums[mid+1]比较，并且不用考虑mid+1越界问题，因为mid在start+1<end的条件下永远不会取到数组最后一个数。
