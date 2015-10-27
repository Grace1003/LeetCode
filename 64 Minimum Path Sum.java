// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        
        // 初始化，第一行第一列均赋值
        int[][] minPathSum = new int[row][col];
        minPathSum[0][0] = grid[0][0];
        for(int i = 1; i < row; i++){
            minPathSum[i][0] = grid[i][0] + minPathSum[i - 1][0];
        }
        for(int j = 1; j < col; j++){
            minPathSum[0][j] = grid[0][j] + minPathSum[0][j - 1];
        }
        
        // 从第二行第二列开始求解
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                minPathSum[i][j] = Math.min(minPathSum[i - 1][j], minPathSum[i][j - 1]) + grid[i][j];
            }
        }
        
        return minPathSum[row - 1][col - 1];
    }
}