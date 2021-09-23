/* over, mn, mn
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal. 
Example:
Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3

Hint: The number of elements in the given matrix will not exceed 10,000. 
 */

package leetcodePremium;

public class Longest_Line_of_Consecutive_One_in_Matrix {
	
	/*
	 * 
	 * Approach 1: Brute Force
Algorithm

The brute force approach is really simple. We directly traverse along every valid line in the given matrix: i.e. Horizontal, Vertical, Diagonal aline above and below the middle diagonal, Anti-diagonal line above and below the middle anti-diagonal. Each time during the traversal, we keep on incrementing the countcount if we encounter continuous 1's. We reset the countcount for any discontinuity encountered. While doing this, we also keep a track of the maximum countcount found so far.


Complexity Analysis

Let mm be the length of the matrix and nn be the width of the matrix. As a result, mnmn would be the total number of cells in the matrix.

Time complexity : O(mn)O(mn). We traverse along the entire matrix 4 times.
Space complexity : O(1)O(1). Constant space is used.
Approach 2: Using 3D Dynamic Programming
Algorithm

Instead of traversing over the same matrix multiple times, we can keep a track of the 1' along all the lines possible while traversing the matrix once only. In order to do so, we make use of a 4mn4mn sized dpdp array. Here, dp[0]dp[0], dp[1]dp[1], dp[2]dp[2] ,dp[3]dp[3] are used to store the maximum number of continuous 1's found so far along the Horizontal, Vertical, Diagonal and Anti-diagonal lines respectively. e.g. dp[i][j][0]dp[i][j][0] is used to store the number of continuous 1's found so far(till we reach the element M[i][j]M[i][j]), along the horizontal lines only.

Thus, we traverse the matrix MM in a row-wise fashion only but, keep updating the entries for every dpdp appropriately.

The following image shows the filled dpdp values for this matrix:

 0 1 1 0

 0 1 1 0
   
 0 0 1 1
   
Longest_Line

While filling up the dpdp, we can keep a track of the length of the longest consecutive line of 1's.

Watch this animation for complete process:

Current
1 / 14

Complexity Analysis

Time complexity : O(mn)O(mn). We traverse the entire matrix once only.

Space complexity : O(mn)O(mn). dpdp array of size 4mn4mn is used, where mm and nn are the number of rows ans coloumns of the matrix.

Approach 3: Using 2D Dynamic Programming
Algorithm

In the previous approach, we can observe that the current dpdp entry is dependent only on the entries of the just previous corresponding dpdp row. Thus, instead of maintaining a 2-D dpdp matrix for each kind of line of 1's possible, we can use a 1-d array for each one of them, and update the corresponding entries in the same row during each row's traversal. Taking this into account, the previous 3-D dpdp matrix shrinks to a 2-D dpdp matrix now. The rest of the procedure remains same as the previous approach.


Complexity Analysis

Time complexity : O(mn)O(mn). The entire matrix is traversed once only.

Space complexity : O(n)O(n). dpdp array of size 4n4n is used, where nn is the number of columns of the matrix.
	 * 
	 */
	
	public int longestLine(int[][] M) {
        int res = 0;
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int m = M.length, n = M[0].length;
        int[][][] dp = new int[m][n][4];
        // dp[x][y][0] is for horizontal
        // dp[x][y][1] is for vertical
        // dp[x][y][2] is for diagonal
        // dp[x][y][3] is for anti-diagonal
        dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = dp[0][0][3]= M[0][0];
        res = Math.max(res, M[0][0]);
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (M[i][j] == 1) {
                    dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = dp[i][j][3] = 1;
                    if (j > 0) {
                        dp[i][j][0] = dp[i][j - 1][0] + 1;
                    }
                    if (i > 0) {
                        dp[i][j][1] = dp[i - 1][j][1] + 1;
                    }
                    if (i > 0 && j > 0) {
                        dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
                    }
                    if (j + 1 < n && i > 0) {
                        dp[i][j][3] = dp[i - 1][j + 1][3] + 1;
                    }
                    res = Math.max(res, dp[i][j][0]);
                    res = Math.max(res, dp[i][j][1]);
                    res = Math.max(res, dp[i][j][2]);
                    res = Math.max(res, dp[i][j][3]);
                }
            }
        }
        return res;
    }

}
