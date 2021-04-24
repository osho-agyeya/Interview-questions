//completed
/*
 * Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
Example 2:

Input: board = [["X"]]
Output: [["X"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'. */

package leetcode;

public class Surrounded_Regions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int rows = board.length;
        int cols = board[0].length;
        
        //check first and last col
        for (int i=0;i<rows;i++){
            if (board[i][0] == 'O')
                dfs(i,0,board);
            if (board[i][cols-1] == 'O')
                dfs(i,cols-1,board);
        }
        
        // check first row and last row
        for (int i=0;i<cols;i++){
            if (board[0][i] == 'O')
                dfs(0,i,board);
            if (board[rows-1][i] == 'O')
                dfs(rows-1,i,board);
        }
        
        // flip O to X, '*' to 'O',
        // skip the boulders 
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                        board[i][j] = 'O';
            }
        }
    }
    
    public void dfs(int i,int j, char[][]board){
        if (i<0 || j<0||i>board.length-1||j>board[0].length-1||board[i][j] == 'X' || board[i][j] == '*')
            return;
            board[i][j] = '*';
        
        
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }
}