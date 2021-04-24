//completed

/*
 * o(v+e)
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
