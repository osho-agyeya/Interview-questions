//completed

/*
 * 
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 * 
 */

package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Rotting_Oranges {

	    int[] dr = new int[]{-1, 0, 1, 0};
	    int[] dc = new int[]{0, -1, 0, 1};

	    public int orangesRotting(int[][] grid) {
	        int R = grid.length, C = grid[0].length;

	        // queue : all starting cells with rotten oranges
	        Queue<Integer> queue = new ArrayDeque();
	        Map<Integer, Integer> depth = new HashMap();
	        for (int r = 0; r < R; ++r)
	            for (int c = 0; c < C; ++c)
	                if (grid[r][c] == 2) {
	                    int code = r * C + c;
	                    queue.add(code);
	                    depth.put(code, 0);
	                }

	        int ans = 0;
	        while (!queue.isEmpty()) {
	            int code = queue.remove();
	            int r = code / C, c = code % C;
	            for (int k = 0; k < 4; ++k) {
	                int nr = r + dr[k];
	                int nc = c + dc[k];
	                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
	                    grid[nr][nc] = 2;
	                    int ncode = nr * C + nc;
	                    queue.add(ncode);
	                    depth.put(ncode, depth.get(code) + 1);
	                    ans = depth.get(ncode);
	                }
	            }
	        }

	        for (int[] row: grid)
	            for (int v: row)
	                if (v == 1)
	                    return -1;
	        return ans;

	    }
}
