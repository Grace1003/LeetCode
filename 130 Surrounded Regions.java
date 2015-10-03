// Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
// 与边界相连的O不变，内部的O变为X

// 1.BFS
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        
        // mark the Os that are on the border
        for(int i=0; i<row; i++){
            if(board[i][0] == 'O'){
                queue.offer(i*col);
                board[i][0] = 'M';
            }
            if(board[i][col-1] == 'O'){
                queue.offer(i*col + (col - 1));
                board[i][col-1] = 'M';
            }
        }
        for(int j=1; j<col-1; j++){ //avoid the duplicate two columns (first & last)
            if(board[0][j] == 'O'){
                queue.offer(j);
                board[0][j] = 'M';
            }
            if(board[row-1][j] == 'O'){
                queue.offer((row - 1) *col + j);
                board[row-1][j] = 'M';
            }
        }
        
        // mark the Os that connect to the border undirectly
        while(!queue.isEmpty()){
            int num = queue.poll();
            int i = num / col;  //!!! don't need to create a pair(i,j) class 
            int j = num % col;  //!!! use @col, not @row
            
            if(i-1>=0 && i-1<row && j>=0 && j<col && board[i-1][j]=='O'){
                queue.offer((i-1)*col + j);
                board[i-1][j] = 'M';
            }
            if(i+1>=0 && i+1<row && j>=0 && j<col && board[i+1][j]=='O'){
                queue.offer((i+1)*col + j);
                board[i+1][j] = 'M';
            }
            if(i>=0 && i<row && j-1>=0 && j-1<col && board[i][j-1]=='O'){
                queue.offer(i*col + (j-1));
                board[i][j-1] = 'M';
            }
            if(i>=0 && i<row && j+1>=0 && j+1<col && board[i][j+1]=='O'){
                queue.offer(i*col + (j+1));
                board[i][j+1] = 'M';
            }
        }
        
        // switch O to X and F to O
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }
            }
        }
    }

}

// 用队列装单个点，单个点用（横坐标*col+纵坐标）表示，比单独写一个pair(x,y)的类要简单
// 先把边界上O点都放进queue，并且先用M标记。再用BFS把队列里面点的周围是O的点都放进队列，并标记M，直到结束。最后遍历二维数组，O->X & M->O

// 2. DFS
// 思路同第200题，但是此题用DFS会导致栈溢出
// 也是先遍历边界点，把O点和其周围的O点标记为M，最后遍历二维数组，O->X & M->O