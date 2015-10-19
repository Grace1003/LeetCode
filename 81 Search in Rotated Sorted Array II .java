// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?
// Would this affect the run-time complexity? How and why?
// Write a function to determine if a given target is in the array.

// 搜索旋转有序数组，多了一个含重复值的条件

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            // make sure nums[start] > nums[end]
            while(start + 1 < end && nums[start] == nums[end]){
                start++;
            }
            if(start + 1 >= end){
                break;
            }
            
            int mid = start + (end - start) / 2;
            if(target == nums[start] || target == nums[end] || target == nums[mid]){
                return true;
            }
            
            if(nums[mid] >= nums[start]){  // mid is in the increasing part
                if(target > nums[start] && target < nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{   // mid is in the decreasing part
                if(target > nums[mid] && target < nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        
        if(nums[start] == target || nums[end] == target){
            return true;
        }else{
            return false;
        }
    }
}


// 二分法，比普通的搜索旋转有序数组的问题多了一步要考虑nums[start]是否和nums[end]相等的问题。
// 不排除相等情况， 在nums[mid]==nums[start]==nums[end]时，无法得知取mid左边还是右边一段。