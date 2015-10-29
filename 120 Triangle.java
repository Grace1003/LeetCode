// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        
        int row = triangle.size();
        int[][] total = new int[row][row];  // 把金字塔转化为左下部分有值的矩阵
        total[0][0] = triangle.get(0).get(0);
        
        // 用二维数组的左下部分来表示从顶点到各点的最小路径和
        for(int i = 1; i < row; i++){
            for(int j = 0; j <= i; j++){  // 在循环内分情况考虑，这样写更好
                if(j == 0){  // 最左边一列
                    total[i][j] = total[i - 1][j] + triangle.get(i).get(j);
                }else if(j == i){   // 对角线一列
                    total[i][j] = total[i - 1][j - 1] + triangle.get(i).get(j);
                }else{
                    total[i][j] = Math.min(total[i - 1][j], total[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        
        int minTotal = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++){
            if(total[row - 1][i] < minTotal){
                minTotal = total[row - 1][i];
            }
        }
        return minTotal;
    }
}