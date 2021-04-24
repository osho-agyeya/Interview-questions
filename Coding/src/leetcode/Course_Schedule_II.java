//completed

/*
 * 
 * O(v+E)
 * 
 * 
 * 
 * There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 * 
 * 
 * 
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Course_Schedule_II {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
	    Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
	    int[] indegree = new int[numCourses];
	    int[] topologicalOrder = new int[numCourses];

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
	      topologicalOrder[i++] = node;

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
	    if (i == numCourses) {
	      return topologicalOrder;
	    }

	    return new int[0];
	  }
	
}
