/*completedd
 * 
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].

The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.

A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).

 

Example 1:



Input: [[5,4,5],[1,2,6],[7,4,6]]
Output: 4
Explanation: 
The path with the maximum score is highlighted in yellow.
Example 2:



Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
Output: 2
Example 3:



Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
Output: 3
 

Note:

1 <= R, C <= 100
0 <= A[i][j] <= 10^9
 * 
 */

package leetcodePremium;

public class Path_With_Maximum_Minimum_Value {

	// DP (2D)
private static int maxScore2D(int[][] grid) {
  // Assume there is at least one element
  int r = grid.length, c = grid[0].length;
  int[][] dp = new int[r][c];
  // Init
  dp[0][0] = Integer.MAX_VALUE; // first entry is not considered
  for (int i = 1; i < r; ++i) dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);
  for (int j = 1; j < c; ++j) dp[0][j] = Math.min(dp[0][j - 1], grid[0][j]);
  // DP
  for (int i = 1; i < r; ++i) { // row by row
    for (int j = 1; j < c; ++j) {
      if (i == r - 1 && j == c - 1) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // last entry is not considered
      } else {
        int score1 = Math.min(dp[i][j - 1], grid[i][j]); // left
        int score2 = Math.min(dp[i - 1][j], grid[i][j]); // up
        dp[i][j] = Math.max(score1, score2);
      }
    }
  }
  return dp[r - 1][c - 1];
}

//DP (One Row or Column)
private static int maxScore1D(int[][] grid) {
// Assume there is at least one element
int r = grid.length, c = grid[0].length;
int[] dp = new int[c];
// Init
dp[0] = Integer.MAX_VALUE; // first entry is not considered
for (int j = 1; j < c; ++j) dp[j] = Math.min(dp[j - 1], grid[0][j]);
// DP (for each row)
for (int i = 1; i < r; ++i) {
 // update the first element in each row
 dp[0] = Math.min(dp[0], grid[i][0]);
 for (int j = 1; j < c; ++j) {
   if (i == r - 1 && j == c - 1) {
     dp[j] = Math.max(dp[j - 1], dp[j]); // last entry is not considered
   } else {
     int score1 = Math.min(dp[j - 1], grid[i][j]); // left  dp[i][j-1]
     int score2 = Math.min(dp[j], grid[i][j]);     // up    dp[i-1][j]
     dp[j] = Math.max(score1, score2);
   }
 }
}
return dp[c - 1];
}
	
}
