/* over, e+v, e+v
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Course_Schedule {
	
	/*
	 * 
	 * Approach 3: Topological Sort
Intuition

Actually, the problem is also known as topological sort problem, which is to find a global order for all nodes in a DAG (Directed Acyclic Graph) with regarding to their dependencies.

A linear algorithm was first proposed by Arthur Kahn in 1962, in his paper of "Topological order of large networks". The algorithm returns a topological order if there is any. Here we quote the pseudo code of the Kahn's algorithm from wikipedia as follows:

L = Empty list that will contain the sorted elements
S = Set of all nodes with no incoming edge

while S is non-empty do
    remove a node n from S
    add n to tail of L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S

if graph has edges then
    return error   (graph has at least one cycle)
else 
    return L   (a topologically sorted order)
To better understand the above algorithm, we summarize a few points here:

In order to find a global order, we can start from those nodes which do not have any prerequisites (i.e. indegree of node is zero), we then incrementally add new nodes to the global order, following the dependencies (edges).
Once we follow an edge, we then remove it from the graph.
With the removal of edges, there would more nodes appearing without any prerequisite dependency, in addition to the initial list in the first step.
The algorithm would terminate when we can no longer remove edges from the graph. There are two possible outcomes:
1). If there are still some edges left in the graph, then these edges must have formed certain cycles, which is similar to the deadlock situation. It is due to these cyclic dependencies that we cannot remove them during the above processes.
2). Otherwise, i.e. we have removed all the edges from the graph, and we got ourselves a topological order of the graph.
Algorithm

Following the above intuition and pseudo code, here we list some sample implementations.

Current
1 / 7

Note that we could use different types of containers, such as Queue, Stack or Set, to keep track of the nodes that have no incoming dependency, i.e. indegree = 0. Depending on the type of container, the resulting topological order would be different, though they are all valid.

Complexity

Time Complexity: \mathcal{O}(|E| + |V|)O(∣E∣+∣V∣) where |V|∣V∣ is the number of courses, and |E|∣E∣ is the number of dependencies.

As in the previous algorithm, it would take us |E|∣E∣ time complexity to build a graph in the first step.
Similar with the above postorder DFS traversal, we would visit each vertex and each edge once and only once in the worst case, i.e. |E| + |V|∣E∣+∣V∣.
As a result, the overall time complexity of the algorithm would be \mathcal{O}(2\cdot|E| + |V|) = \mathcal{O}(|E| + |V|)O(2⋅∣E∣+∣V∣)=O(∣E∣+∣V∣).

Space Complexity: \mathcal{O}(|E| + |V|)O(∣E∣+∣V∣), with the same denotation as in the above time complexity.

We built a graph data structure in the algorithm, which would consume |E| + |V|∣E∣+∣V∣ space.
In addition, we use a container to keep track of the courses that have no prerequisite, and the size of the container would be bounded by |V|∣V∣.
As a result, the overall space complexity of the algorithm would be \mathcal{O}(|E| + 2\cdot|V|) = \mathcal{O}(|E| + |V|)O(∣E∣+2⋅∣V∣)=O(∣E∣+∣V∣).
	 * 
	 */
	
	
public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
	    int[] indegree = new int[numCourses];

	    // Create the adjacency list representation of the graph
	    for (int i = 0; i < prerequisites.length; i++) {
	      int dest = prerequisites[i][0];
	      int src = prerequisites[i][1];
	      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
	      lst.add(dest);
	      adjList.put(src, lst);

	      // Record in-degree of each vertex
	      indegree[dest] += 1;
	    }

	    // Add all vertices with 0 in-degree to the queue
	    Queue<Integer> q = new LinkedList<Integer>();
	    for (int i = 0; i < numCourses; i++) {
	      if (indegree[i] == 0) {
	        q.add(i);
	      }
	    }
	    

	    int i = 0;
	    // Process until the Q becomes empty
	    while (!q.isEmpty()) {
	      int node = q.remove();
            i++;

	      // Reduce the in-degree of each neighbor by 1
	      if (adjList.containsKey(node)) {
	        for (Integer neighbor : adjList.get(node)) {
	          indegree[neighbor]--;

	          // If in-degree of a neighbor becomes 0, add it to the Q
	          if (indegree[neighbor] == 0) {
	            q.add(neighbor);
	          }
	        }
	      }
	    }

	    // Check to see if topological sort is possible or not.
	    return (i == numCourses); 
        
        
        
    }

}
