/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.

Example
For [4, 5, 1, 2, 3] and target=1, return 2.
For [4, 5, 1, 2, 3] and target=0, return -1.

Challenge
O(logN) time

*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0){
            return -1;
        }
        int len = A.length;
        int start = 0;
        int end = len - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] == target){
                return mid;
            } else if (A[mid] >= A[start]){  
                // if (target > A[mid] || target <= A[end]){   //这样写会出错！！！不能用||
                //     start = mid;
                if (target >= A[start] && target < A[mid]){  //target在mid左边
                    end = mid;
                }else {
                    start = mid;
                }
            } else if (A[mid] <= A[end]){
                if (target <= A[end] && target > A[mid]){  //target在mid右边
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (A[start] == target){
            return start;
        } else if (A[end] == target){
            return end;
        } else {
            return -1;
        }
    }
}


注意分情况讨论，就用最基本的分类方法。
一定要按照有“&&”的条件去判断，不能用注释里面”||“的条件，不然在数组单调递增的情况下会出错！！

        1
    mid 
  1
1
             1
           1
↑↑↑这种情况，if条件里面只能对应mid左边的情况，否则就会出错
