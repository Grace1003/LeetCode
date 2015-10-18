// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example, consider the following matrix: 
// [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]]    Given target = 3, return true.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]){
            return false;
        }
        
        int start = 0;
        int end = m*n - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(matrix[mid / n][mid % n] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(matrix[start / n][start % n] ==  target || matrix[end / n][end % n] == target){
            return true;
        }else{
            return false;
        }
    }
}

// 既然逐行从左至右的数字是按顺序排列的，此二维数组可看成一列有序数组，必须是二分法。

// 😄在start+1<end的条件下，start=mid和end=mid是不会导致死循环的，因为mid取不到start值，只有start+1=end时，mid才会取到start值😄