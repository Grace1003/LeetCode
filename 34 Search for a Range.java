/*
Given a sorted array of n integers, find the starting and ending position of a given target value.
If the target is not found in the array, return [-1, -1].

Example
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

Challenge
O(log n) time.

*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = {-1, -1};
        if (A == null || A.length == 0){
            return res;
        }
        int len = A.length;
        
        // 找左边界
        int start = 0;
        int end = len - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] >= target){
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target){
            res[0] = start;
        } else if (A[end] == target){
            res[0] = end;
        }
        
        // 找左边界
        start = 0;
        end = len - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] <= target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target){
            res[1] = end;
        } else if (A[start] == target){
            res[1] = start;
        }
        
        return res;
    }
}


一次二分查找没办法找到两边的边界，那就二分查找两次呗！分别找两个边界喽！
