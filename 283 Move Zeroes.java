Given an array nums, write a function to move all 0s to the end of it while maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.


public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null){
            return;
        }
        
        int len = nums.length;
        int tail = 0;
        for(int i = 0; i < len; i++){  
            if(nums[i] != 0){
                nums[tail] = nums[i];
                tail++;
            }
        }
        
        for(; tail < len; tail++){
            nums[tail] = 0;
        }
        
    }
}

先把所有非零的数复制到前面，用指针记录复制到哪个点了
再把所有剩下的数置为0