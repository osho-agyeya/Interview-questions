/* over, nm, nm 
 *A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
 */
package leetcode;

public class Unique_Paths {

	
	/*
	 * 
	 * Overview
Since robot can move either down or right, there is only one path to reach the cells in the first row: right->right->...->right.

traversal

The same is valid for the first column, though the path here is down->down-> ...->down.

traversal

What about the "inner" cells (m, n)? To such cell one could move either from the upper cell (m, n - 1), or from the cell on the right (m - 1, n). That means that the total number of paths to move into (m, n) cell is uniquePaths(m - 1, n) + uniquePaths(m, n - 1).

traversal

Now, one could transform these ideas into 3-liner recursive solution:


This solution is not fast enough to pass all the testcases, though it could be used as a starting point for the DP solution.


Approach 1: Dynamic Programming
One could rewrite recursive approach into dynamic programming one.

Algorithm

Initiate 2D array d[m][n] = number of paths. To start, put number of paths equal to 1 for the first row and the first column. For the simplicity, one could initiate the whole 2D array by ones.

Iterate over all "inner" cells: d[col][row] = d[col - 1][row] + d[col][row - 1].

Return d[m - 1][n - 1].

Implementation

Current
1 / 13

Complexity Analysis

Time complexity: \mathcal{O}(N \times M)O(N×M).

Space complexity: \mathcal{O}(N \times M)O(N×M).
	 * 
	 */
	
	public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
    for(int i = 0; i<m; i++){
        for(int j = 0; j<n; j++){
            if(i==0||j==0)
                grid[i][j] = 1;
            else
                grid[i][j] = grid[i][j-1] + grid[i-1][j];
        }
    }
    return grid[m-1][n-1];
    }
}
