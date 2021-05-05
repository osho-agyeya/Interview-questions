//completed
/*
 * 
 *In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with n nodes (with distinct values from 1 to n), with one additional directed edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi] that represents a directed edge connecting nodes ui and vi, where ui is a parent of child vi.

Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
Output: [4,1]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ui, vi <= n
ui != vi
 * 
 * 
 */
package leetcode;

import java.util.*;
public class Redundant_Connection_II {
	 public int[] findRedundantConnection(int[][] edges) {
	        int[] parent = new int[2001];
	        for (int i = 0; i < parent.length; i++) parent[i] = i;
	        
	        for (int[] edge: edges){
	            int f = edge[0], t = edge[1];
	            int parent_f=find(parent, f);
	            int parent_t=find(parent, t);
	            if (parent_f == parent_t) return edge;
	            else parent[parent_f] = parent_t;
	        }
	        
	        return new int[2];
	    }
	    
	    private int find(int[] parent, int f) {
	        if (f != parent[f]) {
	          parent[f] = find(parent, parent[f]);  
	        }
	        return parent[f];
	    }
}
