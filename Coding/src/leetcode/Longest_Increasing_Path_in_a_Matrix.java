/* over, mn, mn
 * 
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
 * 
 */

package leetcode;

public class Longest_Increasing_Path_in_a_Matrix {
	
	/*
	 * 
	 * Approach #2 (DFS + Memoization) [Accepted]
Intuition

Cache the results for the recursion so that any subproblem will be calculated only once.

Algorithm

From previous analysis, we know that there are many duplicate calculations in the naive approach.

One optimization is that we can use a set to prevent the repeat visit in one DFS search. This optimization will reduce the time complexity for each DFS to O(mn)O(mn) and the total algorithm to O(m^2n^2)O(m 
2
 n 
2
 ).

Here, we will introduce more powerful optimization, Memoization.

In computing, memoization is an optimization technique used primarily to speed up computer programs by storing the results of expensive function calls and returning the cached result when the same inputs occur again.

In our problem, we recursively call dfs(x, y) for many times. But if we already know all the results for the four adjacent cells, we only need constant time. During our search if the result for a cell is not calculated, we calculate and cache it; otherwise, we get it from the cache directly.


Complexity Analysis

Time complexity : O(mn)O(mn). Each vertex/cell will be calculated once and only once, and each edge will be visited once and only once. The total time complexity is then O(V+E)O(V+E). VV is the total number of vertices and EE is the total number of edges. In our problem, O(V) = O(mn)O(V)=O(mn), O(E) = O(4V) = O(mn)O(E)=O(4V)=O(mn).

Space complexity : O(mn)O(mn). The cache dominates the space complexity.
	 * 
	 */
	
	public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public int longestIncreasingPath(int[][] matrix) {
	    if(matrix.length == 0) return 0;
	    int m = matrix.length, n = matrix[0].length;
	    int[][] cache = new int[m][n];
	    int max = 1;
	    for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++) {
	            int len = dfs(matrix, i, j, m, n, cache);
	            max = Math.max(max, len);
	        }
	    }   
	    return max;
	}

	public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
	    if(cache[i][j] != 0) return cache[i][j];
	    int max = 1;
	    for(int[] dir: dirs) {
	        int x = i + dir[0], y = j + dir[1];
	        if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
	        int len = 1 + dfs(matrix, x, y, m, n, cache);
	        max = Math.max(max, len);
	    }
	    cache[i][j] = max;
	    return max;
	}

}
