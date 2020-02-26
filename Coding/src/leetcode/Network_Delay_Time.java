//ddoe


/*
 * There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

 

Example 1:



Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2
 

Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 * 
 */
package leetcode;

import java.util.Arrays;

public class Network_Delay_Time {
	
	//Floyd–Warshall algorithm
	//Time complexity: O(N^3), Space complexity: O(N^2)
	
	public int networkDelayTime_FW(int[][] times, int N, int K) {
	    double[][] disTo = new double[N][N];
	    for (int i = 0; i < N; i++) {
	        Arrays.fill(disTo[i], Double.POSITIVE_INFINITY);
	    }
	    for (int i = 0; i < N; i++) {
	        disTo[i][i] = 0;
	    }
	    for (int[] edge: times) {
	        disTo[edge[0] - 1][edge[1] - 1] = edge[2];
	    }
	    for (int k = 0; k < N; k++) {
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (disTo[i][j] > disTo[i][k] + disTo[k][j])
	                    disTo[i][j] = disTo[i][k] + disTo[k][j];
	            }
	        }
	    }
	    double max = Double.MIN_VALUE;
	    for (int i = 0; i < N; i++) {
	        if (disTo[K - 1][i] == Double.POSITIVE_INFINITY) return -1;
	        max = Math.max(max, disTo[K - 1][i]);
	    }
	    return (int) max;
	}
}
	
	/*
	 * 
	 * Bellman-Ford algorithm
Time complexity: O(N*E), Space complexity: O(N)
public int networkDelayTime_BF(int[][] times, int N, int K) {
    double[] disTo = new double[N];
    Arrays.fill(disTo, Double.POSITIVE_INFINITY);
    disTo[K - 1] = 0;
    for (int i = 1; i < N; i++) {
        for (int[] edge : times) {
            int u = edge[0] - 1, v = edge[1] - 1, w = edge[2];
            disTo[v] = Math.min(disTo[v], disTo[u] + w);
        }
    }
    double res = Double.MIN_VALUE;
    for (double i: disTo) {
        res = Math.max(i, res);
    }
    return res == Double.POSITIVE_INFINITY ? -1 : (int) res;
}


Dijkstra's algorithm
Time complexity: O(Nlog(N) + E), Space complexity: O(N + E)
public int networkDelayTime_Dijkstra(int[][] times, int N, int K) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] edge: times) {
        graph.putIfAbsent(edge[0], new ArrayList<>());
        graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
    boolean[] visited = new boolean[N + 1];
    int[] minDis = new int[N + 1];
    Arrays.fill(minDis, Integer.MAX_VALUE);
    minDis[K] = 0;
    pq.offer(new int[]{0, K});
    int max = 0;
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int currNode = curr[1];
        if (visited[currNode]) continue;
        visited[currNode] = true;
        int currDis = curr[0];
        max = currDis;
        N--;
        if (!graph.containsKey(currNode)) continue;
        for (int[] next : graph.get(currNode)) {
            if (!visited[next[0]] && currDis + next[1] < minDis[next[0]])
                pq.offer(new int[]{currDis + next[1], next[0]});
        }
    }
    return N == 0 ? max : -1;
}
	 * 
	 * 
	 * 
	 */
