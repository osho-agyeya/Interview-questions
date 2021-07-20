/* completedd
 * On a campus represented as a 2D grid, there areNworkers andMbikes, withN <= M. Each worker and bike is a 2D coordinate on this grid.
We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker and their assigned bike is minimized.
The Manhattan distance between two pointsp1andp2isManhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.
Example 1:

Input: 
workers = 
[[0,0],[2,1]]
, bikes = 
[[1,2],[3,3]]
Output: 
6
Explanation: 

We assign bike 0 to worker 0, bike 1 to worker 1. The Manhattan distance of both assignments is 3, so the output is 6.
Example 2:

Input: 
workers = 
[[0,0],[1,1],[2,0]]
, bikes = 
[[1,0],[2,2],[2,1]]
Output: 
4
Explanation: 

We first assign bike 0 to worker 0, then assign bike 1 to worker 1 or worker 2, bike 2 to worker 2 or worker 1. Both assignments lead to sum of the Manhattan distances as 4.
Note:
0
<
= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1]
<
1000
All worker and bike locations are distinct.
1
<
= workers.length
<
= bikes.length
<
= 10
 */

package leetcodePremium;

public class Campus_Bikes_II {
	
	 int min = Integer.MAX_VALUE;
	    public int assignBikes(int[][] workers, int[][] bikes) {
	        dfs(new boolean[bikes.length], workers, 0, bikes, 0);
	        return min;
	    }
	    public void dfs(boolean[] visit, int[][] workers, int i, int[][] bikes, int distance) {
	        if (i >= workers.length) {
	            min = Math.min(distance, min);
	            return ;
	        }
	        if (distance > min) {
	            return ;
	        }
	        for (int j = 0; j < bikes.length; j++) {
	            if (visit[j]) {
	                continue;
	            }
	            visit[j] = true;
	            dfs(visit, workers, i + 1, bikes, distance + dis(bikes[j], workers[i]));
	            visit[j] = false;
	        }
	        
	    }
	    public int dis(int[] p1, int[] p2) {
	        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	    }

}
