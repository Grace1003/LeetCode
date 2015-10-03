//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
//You may assume all four edges of the grid are all surrounded by water.

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    changeValue(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void changeValue(char[][] grid, int i, int j){
        if(i<0 || i >= grid.length || j>=grid[0].length || j<0 || grid[i][j] == '0'){ //handle the IndexOufOfBoundsException
            return;
        }
        
        grid[i][j] = '0';
        changeValue(grid, i-1, j);
        changeValue(grid, i+1, j);
        changeValue(grid, i, j-1);
        changeValue(grid, i, j+1);
        
    }
}

// 递归，DFS
// 遍历二维数组，找到1后，计数，并用辅助函数把1的上下左右格子变成1
// ！！注意处理数组越界异常的方法，直接在函数第一行判断