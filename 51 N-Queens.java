The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

n*n的矩阵上摆放n个皇后，并满足：
1. 每行每列都只能有一个皇后
2. 任意两个皇后都不在一条斜线上 => 任意两点坐标差(x-y)、和(x+y)均不相等

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<List<String>>();
        ArrayList<Integer> cols = new ArrayList<Integer>();  // 记录每行的queen在第几列
        findSolution(n, cols, results);
        return results;
    }
    
    // 回溯法找到所有满足题意的solution
    public void findSolution(int n, ArrayList<Integer> cols, List<List<String>> results){
    	// 判断是否找到一个solution，需要判断与n的关系。 => 用普通int[]数组就不行，因为length固定，并且数组有初始值
        if(cols.size() == n){   
            List<String> solution = drawSolution(cols);
            results.add(solution);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(isValid(i, cols)){
                cols.add(i);
                findSolution(n, cols, results);
                cols.remove(cols.size() - 1);
            }
        }
    }
    
    // 判断新一行中第x个能否成为queen
    public boolean isValid(int x, ArrayList<Integer> cols){
        for(int i = 0; i < cols.size(); i++){
            if(x == cols.get(i)){  // same colume
                return false;
            } 
            if(cols.size() - x == i - cols.get(i)){  //  "\" position
                return false;
            }  
            if(cols.size() + x == i + cols.get(i)){  //  "/" position
                return false;
            } 
        }
        return true;
    }
    
    // 把一个完整的记录每行皇后位置的arraylist转成题目要求的arraylist
    public ArrayList<String> drawSolution(ArrayList<Integer> cols){
        ArrayList<String> solution = new ArrayList<String>();
        for(int i = 0; i < cols.size(); i++){
            String row = "";
            for(int j = 0; j < cols.size(); j++){
                if(j == cols.get(i)){
                    row += "Q";
                }else{
                    row += ".";
                }
            }
            solution.add(row);
        }
        return solution;
    }
}

回溯法
难点：1.把每行皇后的位置用一个arraylist记录；
     2. 如何判断两个皇后是不是在一条斜线上

