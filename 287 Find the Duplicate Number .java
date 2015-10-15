// Hard!

// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. 
// Assume that there is only one duplicate number, find the duplicate one.

// You must not modify the array (assume the array is read only).
// You must use only constant, O(1) extra space.
// Your runtime complexity should be less than O(n2).
// There is only one duplicate number in the array, but it could be repeated more than once.


// 解析：1到n的数，其中有一个数重复了，重复次数不定，找到这个树。不能改动数组，不用额外空间，不用暴力方法。

public class Solution {
    public int findDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;  // end = n
        while(start < end){
            int mid = start + (end - start) / 2;
            
            // count the numbers that are less than the middle number
            int leftCount = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){  // "="!!
                    leftCount++;
                }
            }
            
            if(leftCount <= mid){  // "="!!
                start = mid + 1;  // +1 !!
            }else{
                end = mid;
            }
            
        }
        
        return start; 
        
    }
}

// 怎么转化？ 虽然数组无序，但可以用数字1-n模拟这些数。因为总共有n+1个数，可以让0加入数组，变成0-n的数组，因为0不会是找到的答案。
// 什么变量？ 用start、end来标记数组里被怀疑的区间。start、mid、end与题中数组下标没有对应关系，只是来模拟一个0-n的数组，用二分法找到重复的数即可。
// 怎么找？ 二分法，找小于等于mid的数的个数，如果个数小于等于mid，说明mid右边(不含mid)有重复数，start移到mid右边一个数；如果个数大于mid，说明mid左边(含mid)有重复数，end移到mid位置。
// 最后状态？ 必须保证最后start和end指向同一个值，不能用start+1<end，因为无法最后确认start和end中哪一个是结果。

// 深入挖掘
// 1. 如果是统计<=mid的值，则以leftCount<=mid判断。同时，start等于mid右边的数，或者等于mid.
// 2. 如果是统计<mid的值呢？不可以！因为，mid可能是重复的数，所以start=mid。而计算mid的两种方法都是向下取整的，有可能新的mid一直被赋值为start，但接着执行start=mid，死循环，超时。比如：[1,1,2]


