/* completedd
 * Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 105

1 <= M <= min(200000,A(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format
Return 1 if cycle is present else return 0.



Example Input
Input 1:

 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation*
Explanation 1:

 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:

 The given graph doesn't contain any cycle.
 */

package interviewbit;

public class Cycle_In_Directed_Graph {
	
	public int solve(int A, int[][] edges) {
	       boolean[] visited = new boolean[A];
	        boolean[] recStack = new boolean[A];
	        Map<Integer, ArrayList<Integer>> m= new HashMap<>();
	        for(int edge[]:edges){
	            ArrayList<Integer> a = m.getOrDefault(edge[0]-1, new ArrayList<>());
	            a.add(edge[1]-1);
	            m.put(edge[0]-1, a);
	        }
	        for (int i = 0; i < A; i++)
	            if (isCyclicUtil(i, visited, recStack,m))
	                return 1;
	 
	        return 0;
	   }
	   
	   private boolean isCyclicUtil(int i, boolean[] visited,
	                                      boolean[] recStack, Map<Integer, ArrayList<Integer>> m)
	    {
	         
	        // Mark the current node as visited and
	        // part of recursion stack
	        if (recStack[i])
	            return true;
	 
	        if (visited[i])
	            return false;
	             
	        visited[i] = true;
	 
	        recStack[i] = true;
	        ArrayList<Integer> children = m.getOrDefault(i,new ArrayList<>());
	         
	        for (int c: children)
	            if (isCyclicUtil(c, visited, recStack,m))
	                return true;
	                 
	        recStack[i] = false;
	 
	        return false;
	    }

}
