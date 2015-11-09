Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Follow up:
Could you come up with an one-pass algorithm using only constant space?

1.我的方法，同九章：

public class Solution {
    public void sortColors(int[] nums) {
        int head = 0, tail = nums.length - 1;
        for(int i = 0; i <= tail; i++){
            if(nums[i] == 0){
                swap(nums, head, i);
                head++;
            }
            if(nums[i] == 2){
                swap(nums, tail, i);
                tail--;
                i--;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

另一种方法：
public class Solution {
    public void sortColors(int[] nums) {
        int tail1 = 0, tail2 = 0, tail3 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                tail1++;
                tail2++;
                tail3++;
            }else if(nums[i] == 1){
                tail2++;
                tail3++;
            }else{
                tail3++;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i < tail1){
                nums[i] = 0;
            }else if(i < tail2){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
    }
}