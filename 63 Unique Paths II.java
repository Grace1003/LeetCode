// Follow up for "Unique Paths":
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

// 在矩阵中加入了障碍格子

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        
        
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1){
            return 0;
        }
        
        int[][] path = new int[row][col];
        path[0][0] = 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(obstacleGrid[i][j] == 1){  // 先判断这个格是不是障碍格，若是，直接赋值0
                    path[i][j] = 0;
                    continue;
                }
                if(i - 1 >= 0){
                   path[i][j] += path[i - 1][j];
                }
                if(j - 1 >= 0){
                   path[i][j] += path[i][j - 1];
                }
            }
        }
        
        return path[row - 1][col - 1];
    }
}