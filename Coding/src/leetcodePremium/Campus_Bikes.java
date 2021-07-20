/*completed
 * On a campus represented as a 2D grid, there are Nworkers and Mbikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.

Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike) pair with the shortest Manhattan distance between each other, and assign the bike to that worker. (If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index; if there are multiple ways to do that, we choose the pair with the smallest bike index). We repeat this process until there are no available workers.

The Manhattan distance between two points p1and p2is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|. Return a vector ansof length N, where ans[i]is the index (0-indexed) of the bike that the i-th worker is assigned to.

Example 1:



Input: 
workers = [[0,0],[2,1]], 
bikes = [[1,2],[3,3]]
Output: 
[1,0]
Explanation: 

Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
Example 2:



Input: 
workers = [[0,0],[1,1],[2,0]], 
bikes = [[1,0],[2,2],[2,1]]
Output: 
[0,2,1]
Explanation: 

Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].
Note:

0 <= workers[i][j], bikes[i][j] < 1000
All worker and bike locations are distinct.
1 <= workers.length <= bikes.length <= 1000
Thoughts:

number of workers and bikes is bounded -> Bucket sort Pigeonhole sort: buckets[i]: a list with <worker id, bike id> pair with distance i (Original post, Java post)
Priority queue when number of workers and bikes is not bounded (Original post, Python post)
 */

package leetcodePremium;

public class Campus_Bikes {
	
	public int[] assignBikes(int[][] workers, int[][] bikes) {
	    boolean[] vw = new boolean[workers.length], vb = new boolean[bikes.length];
	    ArrayList<int[]> arr = new ArrayList<>();
	    for(int i = 0; i < workers.length; i++) {
	        for(int j = 0; j < bikes.length; j++) {
	            int[] distance = new int[] {i, j, Math.abs(workers[i][0]-bikes[j][0])+Math.abs(workers[i][1]-bikes[j][1])};
	            arr.add(distance);
	        }
	    }
	    Collections.sort(arr, (a,b)->(a[2]-b[2] == 0 ? a[0]-b[0] : a[2]-b[2]));
	    int[] result = new int[workers.length];
	    for(int[] p : arr) {
	        if(vw[p[0]] || vb[p[1]]) continue;
	        vw[p[0]] = true;
	        vb[p[1]] = true;
	        result[p[0]] = p[1];
	    }
	    return result;
	}
	
}
