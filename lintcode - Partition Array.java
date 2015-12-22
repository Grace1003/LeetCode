/*
Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.

Challenge
Can you partition the array in-place and in O(n)?
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if (nums == null || nums.length == 0){
	        return 0;
	    }
	    
	    int len = nums.length;
	    int i = 0, j = len - 1; 
	    while (i < j){
	        while (i < j && nums[i] < k){
	            i++;
	        }
	        while (i < j && nums[j] >= k){
	            j--;
	        }
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	        //i++;  不需要，交换后会进入上面两个while循环
	        //j--;  
	    }
	    
	    if (nums[j] < k){
	        return j + 1;
	    } else {
	        return i;
	    }
    }
}

类似quick sort！
1. 不用i+1<j，否则退出循环的时候，还可能要交换一次nums[i]和nums[j]，这题要交换，不止旦旦找数字。像quick sort那样。
2. 交换后不用再i++和j--，首先不需要，下一个循环中的while会处理；而且，对于数组全部数字<k这样的情况，j不应该移动。
3. 最后返回判断的时候，要考虑全部数字>k的情况，返回j+1;其他情况，i指向第一个>=k的数的下标。


