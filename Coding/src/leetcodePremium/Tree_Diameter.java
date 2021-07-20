/* completedd
 * 
 * Given an undirected tree, return its diameter: the number of edges in a longest path in that tree.

The tree is given as an array of edges where edges[i] = [u, v] is a bidirectional edge between nodes u and v. Each node has labels in the set {0, 1, …, edges.length}.

Example 1:

Input: edges = [[0,1],[0,2]]
Output: 2
Explanation: 
A longest path of the tree is the path 1 - 0 - 2.
Example 2:

Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
Output: 4
Explanation: 
A longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
Constraints:

0 <= edges.length < 10^4
edges[i][0] != edges[i][1]
0 <= edges[i][j] <= edges.length
The given edges form an undirected tree.
 * 
 */

package leetcodePremium;

public class Tree_Diameter {
	
	 public int treeDiameter(int[][] edges) {
		    final int n = edges.length;

		    List<Integer>[] graph = new List[n + 1];

		    for (int i = 0; i < graph.length; ++i)
		      graph[i] = new ArrayList<>();

		    for (int[] edge : edges) {
		      graph[edge[0]].add(edge[1]);
		      graph[edge[1]].add(edge[0]);
		    }

		    maxDepth(graph, 0, -1);

		    return ans;
		  }

		  private int ans = 0;

		  private int maxDepth(List<Integer>[] graph, int node, int parent) {
		    int maxDepth1 = 0; // the max depth
		    int maxDepth2 = -1; // the 2nd max depth

		    for (final int child : graph[node]) {
		      if (child == parent)
		        continue;
		      final int depth = maxDepth(graph, child, node);
		      if (depth > maxDepth1) {
		        maxDepth2 = maxDepth1;
		        maxDepth1 = depth;
		      } else if (depth > maxDepth2) {
		        maxDepth2 = depth;
		      }
		    }

		    ans = Math.max(ans, maxDepth1 + maxDepth2);

		    return 1 + maxDepth1;
		  }
		  
		  
		  /*
		  public int treeDiameter(int[][] edges) {
		        int nodes = edges.length + 1;
		        int[] degrees = new int[nodes];
		        Set<Integer>[] connects = new Set[nodes];
		        for (int i = 0; i < nodes; i++)
		            connects[i] = new HashSet<Integer>();
		        for (int[] edge : edges) {
		            int node1 = edge[0], node2 = edge[1];
		            degrees[node1]++;
		            degrees[node2]++;
		            connects[node1].add(node2);
		            connects[node2].add(node1);
		        }
		        Queue<Integer> queue = new LinkedList<Integer>();
		        for (int i = 0; i < nodes; i++) {
		            if (degrees[i] == 1)
		                queue.offer(i);
		        }
		        int depth = 0;
		        int remaining = nodes;
		        while (!queue.isEmpty() && remaining > 2) {
		            int size = queue.size();
		            for (int i = 0; i < size; i++) {
		                int node = queue.poll();
		                degrees[node]--;
		                Set<Integer> connectSet = connects[node];
		                for (int connect : connectSet) {
		                    degrees[connect]--;
		                    if (degrees[connect] == 1)
		                        queue.offer(connect);
		                }
		            }
		            remaining -= size;
		            depth++;
		        }
		        return remaining == 2 ? 2 * depth + 1 : 2 * depth;
		    }
		    
		    */

}
