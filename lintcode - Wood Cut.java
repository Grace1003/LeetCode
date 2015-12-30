/*
Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

Example
For L=[232, 124, 456], k=7, return 114.

Note
You couldn't cut wood into float length.

*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0 || k <= 0){
            return 0;
        }
        int len = L.length;
        long sum = 0;
        for (int i = 0; i < len; i++){
            sum += L[i];
        }
        
        long start = 1;  // 等于0会导致下面出现除数为零的情况
        long end = Math.max(1, sum / k);  // 要避免除数为0的情况
        while (start + 1 < end){
            long mid = start + (end - start) / 2;
            if (count(L, mid) >= k){
                start = mid;  //小心写反了
            } else {
                end = mid;
            }
        }
        
        if (count(L, end) >= k){
            return (int)end;
        } else if (count(L, start) >= k){
            return (int)start;
        } else {
            return 0;
        }
        
    }
    
    public long count(int[] L, long len){
        long count = 0;
        for (int i = 0; i < L.length; i++){
            count += L[i] / len;
        }
        return count;
    }
}


我的思路：找到最大可能的长度sum/k，再用二分查找找到最大的可分k份的长度。
注意用一个辅助函数来遍历数组，判断当前长度下的份数与k的大小。

九章思路：找到数组中最大的一个数，作为最大可能的长度。。。 （后面相同）