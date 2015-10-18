// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int i = row - 1;
        int j = 0;
        while(i >= 0 && j < col){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                i--;
            }else{
                j++;
            }
        }
        return false;
    }
}

// 对角线上二分法可以做，遍历左下和右上矩阵即可。
// 但是，根据矩阵从上到下从左到右递增的关系，有简单方法：从左下角或者右上角遍历。