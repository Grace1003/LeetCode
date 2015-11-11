Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

O(mn) space：用一个二维数组记录
O(m + n) space：用两个一维数组记录
constant space：用原数组中某行某列记录

九章思路：用首行首列记录该行该列是否应该都被变成0
注意首行首列不参与主遍历循环

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRow = false;
        boolean firsrCol = false;
        
        // 可拆开写。先做标记，表明首行/首列是否该变为0。再遍历其他行和列，用首行首列记录。
        for(int i = 0; i < row; i++){ 
            for(int j = 0; j < col; j++){
                if(i == 0){    
                    if(matrix[i][j] == 0){
                        firstRow = true;
                    }
                }
                if(j == 0){  // 注意这里不能是else if判断，要考虑到matrix[0][0]=0表明首行首列都要变0.
                    if(matrix[i][j] == 0){
                        firsrCol = true;
                    }
                }
                if(i != 0 && j != 0 && matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // 根据首行首列更改其他行列的数值
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // 最后根据标记情况来更改首行首列数值
        if(firstRow){
            for(int j = 0; j < col; j++){
                matrix[0][j] = 0;
            }
        }
        if(firsrCol){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}