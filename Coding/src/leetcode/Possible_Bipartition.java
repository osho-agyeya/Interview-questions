/* completedd
 * Given a set of n people (numbered 1, 2, ..., n), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Constraints:

1 <= n <= 2000
0 <= dislikes.length <= 10000
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
 */

package leetcode;

public class Possible_Bipartition {

	public boolean possibleBipartition(int n, int[][] dislikes) {
	    int colors[] = new int[n+1];
	        Map<Integer, List<Integer>> graph = new HashMap<>();
	        for (int[] edge : dislikes) {
	            graph.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
	            graph.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
	        }
	        
	        for (int i = 1; i <= n; i++) {
	            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) 
	                return false;            
	        }
	        return true;
	    }
	    
	    private boolean dfs(Map<Integer, List<Integer>> graph, int[] colors, int i, int color) {
	        colors[i] = color;
	        for (int k:graph.getOrDefault(i, new ArrayList<>())) {
	            if (colors[k] == color || (colors[k]==0 && !dfs(graph, colors, k, -color))) return false;
	        }
	        return true;
	    }
	
}
