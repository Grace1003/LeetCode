// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// How many possible unique paths are there?

// m*n的矩阵，从左上角移动到右下角，每一步只能向下或者向右走，求路径数量。

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j - 1 >= 0){
                    matrix[i][j] += matrix[i][j - 1];
                }
                if(i - 1 >= 0){
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        return matrix[m - 1][n - 1];
    }
}

// 九章的做法：把矩阵上面一行左边一行都初始化为1
// 我的做法：把左上起点初始化为1，for循环时加上对下标越界的判断