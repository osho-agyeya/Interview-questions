/* over, mn, 1
 * 
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
 */
package leetcode;

public class Minimum_Path_Sum {
	
	/*
	 * 
	 * Approach 4: Dynamic Programming (Without Extra Space)
Algorithm

This approach is same as Approach 2, with a slight difference. Instead of using another dpdp matrix. We can store the minimum sums in the original matrix itself, since we need not retain the original matrix here. Thus, the governing equation now becomes:

\mathrm{grid}(i, j)=\mathrm{grid}(i,j)+\min \big(\mathrm{grid}(i+1,j), \mathrm{grid}(i,j+1)\big)grid(i,j)=grid(i,j)+min(grid(i+1,j),grid(i,j+1))


Complexity Analysis

Time complexity : O(mn)O(mn). We traverse the entire matrix once.

Space complexity : O(1)O(1). No extra space is used.
	 * 
	 */
	
	public int minPathSum(int[][] grid) {
    	int m = grid.length;// row
int n = grid[0].length; // column
for (int i = 0; i < m; i++) {
	for (int j = 0; j < n; j++) {
		if (i == 0 && j != 0) {
			grid[i][j] = grid[i][j] + grid[i][j - 1];
		} else if (i != 0 && j == 0) {
			grid[i][j] = grid[i][j] + grid[i - 1][j];
		} else if (i == 0 && j == 0) {
			grid[i][j] = grid[i][j];
		} else {
			grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
					+ grid[i][j];
		}
	}
}

return grid[m - 1][n - 1];
    
}
}
