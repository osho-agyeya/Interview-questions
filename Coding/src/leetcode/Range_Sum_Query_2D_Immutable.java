//completed
/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Implement the NumMatrix class:

NumMatrix(int[][] matrix) initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) returns the sum of the elements of the matrix array inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 

Example 1:


Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
Output
[null, 8, 11, 12]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangele).
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangele).
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangele).
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
-105 <= matrix[i][j] <= 105
0 <= row1 <= row2 < m
0 <= col1 <= col2 < n
At most 104 calls will be made to sumRegion.
 */

package leetcode;

public class Range_Sum_Query_2D_Immutable {

	private int[][] dp;

	public Range_Sum_Query_2D_Immutable
		// TODO Auto-generated constructor stub
	(int[][] matrix) {
	    if (matrix.length == 0 || matrix[0].length == 0) return;
	    dp = new int[matrix.length + 1][matrix[0].length + 1];
	    for (int r = 0; r < matrix.length; r++) {
	        for (int c = 0; c < matrix[0].length; c++) {
	            dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
	        }
	    }
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
	    return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	}
	    
	
}
