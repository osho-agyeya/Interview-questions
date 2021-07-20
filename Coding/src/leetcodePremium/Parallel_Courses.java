/* completedd
 * There are N courses, labelled from 1 to N.

We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.

In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.

Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.

Example 1:
Input: N = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: 
In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.

Example 2:
Input: N = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: 
No course can be studied because they depend on each other.

Note:
1 <= N <= 5000
1 <= relations.length <= 5000
relations[i][0] != relations[i][1]
There are no repeated relations in the input.
 */

package leetcodePremium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Parallel_Courses {

public int canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
	    int[] indegree = new int[numCourses+1];

	    // Create the adjacency list representation of the graph
	    for (int i = 0; i < prerequisites.length; i++) {
	      int dest = prerequisites[i][1];
	      int src = prerequisites[i][0];
	      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
	      lst.add(dest);
	      adjList.put(src, lst);

	      // Record in-degree of each vertex
	      indegree[dest] += 1;
	    }

	    // Add all vertices with 0 in-degree to the queue
	    Queue<Integer> q = new LinkedList<Integer>();
	    for (int i = 1; i <= numCourses; i++) {
	      if (indegree[i] == 0) {
	        q.add(i);
	      }
	    }
	    

	    int i = 0,ans=0;
	    // Process until the Q becomes empty
	    while (!q.isEmpty()) {
	    	int size=q.size();
	    	i+=size;
	    	for(int i=0;i<size;i++) {
	    		int node = q.remove();
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
	    	ans++;
	    	
	    }

	    // Check to see if topological sort is possible or not.
	    return (i == numCourses)?ans:-1; 
        
        
        
    }
	
}
