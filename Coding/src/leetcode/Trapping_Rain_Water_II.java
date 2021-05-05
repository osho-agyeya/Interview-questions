//completed
/*
 * Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

 

Example 1:


Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small pounds 1 and 3 units trapped.
The total volume of water trapped is 4.
Example 2:


Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
 

Constraints:

m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 104
 */
package leetcode;

public class Trapping_Rain_Water_II {
	
	int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
	public int trapRainWater(int[][] heightMap) {
	    int m = heightMap.length;
	    int n = (m == 0 ? 0 : heightMap[0].length);
	    int res = 0;
	        
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
	    boolean[][] visited = new boolean[m][n];
	        
	    for (int i = 0; i < m; i++) {
	        pq.offer(new int[] {i, 0, heightMap[i][0]});
	        pq.offer(new int[] {i, n - 1, heightMap[i][n - 1]});
	        visited[i][0] = visited[i][n - 1] = true;
	    }
	        
	    for (int j = 1; j < n - 1; j++) {
	        pq.offer(new int[] {0, j, heightMap[0][j]});
	        pq.offer(new int[] {m - 1, j, heightMap[m - 1][j]});
	        visited[0][j] = visited[m - 1][j] = true;
	    }
	        
	    while (!pq.isEmpty()) {
	        int[] cell = pq.poll();
	        	
	        for (int[] d : dirs) {
	            int i = cell[0] + d[0], j = cell[1] + d[1];
	            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) continue;
	            res += Math.max(0, cell[2] - heightMap[i][j]);
	            pq.offer(new int[] {i, j, Math.max(heightMap[i][j], cell[2])});
	            visited[i][j] = true;
	        }
	    }
	        
	    return res;
	}
	
}
