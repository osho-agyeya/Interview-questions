/* over, mn, n 
 * 
 * 
 * 
 * 
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 

Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 * 
 * 
 * 
 */

package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Evaluate_Division {
	
	
	/*
	 * 
	 * Overview
As revealed by the hints, the problem can be solved with two important data structures, namely Graph and Union-Find.

In the following sections, we will explain how to solve the problem respectively with regards to the data structures.

Approach 1: Path Search in Graph
Intuition

First, let us look at the example given in the problem description. Given two equations, namely \frac{a}{b} = 2, \space \frac{b}{c} = 3 
b
a
​
 =2,  
c
b
​
 =3, we could derive the following equations:

1). \frac{b}{a} = \frac{1}{2}, \space \frac{c}{b} = \frac{1}{3} 
a
b
​
 = 
2
1
​
 ,  
b
c
​
 = 
3
1
​
 

2). \frac{a}{c} = \frac{a}{b} \cdot \frac{b}{c} = 2 \cdot 3 = 6 
c
a
​
 = 
b
a
​
 ⋅ 
c
b
​
 =2⋅3=6

Each division implies the reverse of the division, which is how we derive the equations in (1). While by chaining up equations, we could obtain new equations in (2).

We could reformulate the equations with the graph data structure, where each variable can be represented as a node in the graph, and the division relationship between variables can be modeled as edge with direction and weight.

The direction of edge indicates the order of division, and the weight of edge indicates the result of division.

With the above formulation, we then can convert the initial equations into the following graph:

graph example

To evaluate a query (e.g. \frac{a}{c}=? 
c
a
​
 =?) is equivalent to performing two tasks on the graph: 1). find if there exists a path between the two entities. 2). if so, calculate the cumulative products along the paths.

In the above example (\frac{a}{c}=? 
c
a
​
 =?), we could find a path between them, and the cumulative products are 66. As a result, we can conclude that the result of \frac{a}{c} 
c
a
​
  is 2 \cdot 3 = 62⋅3=6.

Algorithm

As one can see, we just transform the problem into a path searching problem in a graph.

More precisely, we can reinterpret the problem as "given two nodes, we are asked to check if there exists a path between them. If so, we should return the cumulative products along the path as the result.

Given the above problem statement, it seems intuitive that one could apply the backtracking algorithm, or sometimes people might call it DFS (Depth-First Search).

Essentially, we can break down the algorithm into two steps overall:

Step 1). we build the graph out of the list of input equations.

Each equation corresponds to two edges in the graph.
Step 2). once the graph is built, we then can evaluate the query one by one.

The evaluation of the query is done via searching the path between the given two variables.

Other than the above searching operation, we need to handle two exceptional cases as follows:

Case 1): if either of the nodes does not exist in the graph, i.e. the variables did not appear in any of the input equations, then we can assert that no path exists.

Case 2): if the origin and the destination are the same node, i.e. \frac{a}{a} 
a
a
​
 , we can assume that there exists an invisible self-loop path for each node and the result is one.

Here we give one sample implementation on the backtracking algorithm.


Note: with the built graph, one could also apply the BFS (Breadth-First Search) algorithm, as opposed to the DFS algorithm we employed.

However, the essence of the solution remains the same, i.e. we are searching for a path in a graph.

Complexity Analysis

Let NN be the number of input equations and MM be the number of queries.

Time Complexity: \mathcal{O}(M \cdot N)O(M⋅N)

First of all, we iterate through the equations to build a graph. Each equation takes \mathcal{O}(1)O(1) time to process. Therefore, this step will take \mathcal{O}(N)O(N) time in total.

For each query, we need to traverse the graph. In the worst case, we might need to traverse the entire graph, which could take \mathcal{O}(N)O(N). Hence, in total, the evaluation of queries could take M \cdot \mathcal{O}(N) = \mathcal{O}(M \cdot N)M⋅O(N)=O(M⋅N).

To sum up, the overall time complexity of the algorithm is \mathcal{O}(N) + \mathcal{O}(M \cdot N) = \mathcal{O}(M \cdot N)O(N)+O(M⋅N)=O(M⋅N)

Space Complexity: \mathcal{O}(N)O(N)

We build a graph out the equations. In the worst case where there is no overlapping among the equations, we would have NN edges and 2N2N nodes in the graph. Therefore, the sapce complexity of the graph is \mathcal{O}(N + 2N) = \mathcal{O}(3N) = \mathcal{O}(N)O(N+2N)=O(3N)=O(N).

Since we employ the recursion in the backtracking, we would consume additional memory in the function call stack, which could amount to \mathcal{O}(N)O(N) space.

In addition, we used a set visited to keep track of the nodes we visited during the backtracking. The space complexity of the visited set would be \mathcal{O}(N)O(N).

To sum up, the overall space complexity of the algorithm is \mathcal{O}(N) + \mathcal{O}(N) + \mathcal{O}(N) = \mathcal{O}(N)O(N)+O(N)+O(N)=O(N).

Note that we did not take into account the space needed to hold the results. Otherwise, the total space complexity would be \mathcal{O}(N + M)O(N+M).


	 * 
	 */
	
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
	    Map<String, Map<String, Double>> map = new HashMap<>();
	    //map is like { a:map of a, ...}   and map of a is like {b:2.0} (a/b=2.0)
	    for (int i = 0; i < values.length; i++) {
	        map.putIfAbsent(equations.get(i).get(0), new HashMap<>());//only put if absent
	        map.putIfAbsent(equations.get(i).get(1), new HashMap<>());
	        map.get( equations.get(i).get(0) ).put( equations.get(i).get(1), values[i] );
	        map.get( equations.get(i).get(1) ).put( equations.get(i).get(0), 1 / values[i] );
	    }
	    double[] res = new double[ queries.size() ];
	    for (int i = 0; i < queries.size(); i++)
	        res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1, map, new HashSet<>());
	    return res;
	}
	private double dfs(String numerator, String denominator, double r, Map<String, Map<String, Double>> map, Set<String> seen) {
	    
	    if (!map.containsKey(numerator) || !seen.add(numerator)) return -1;//if seen has numerator already, return false; other wise,add numerator and return true
	   
	    if (numerator.equals(denominator)) return r;
	    
	    //for example:   query "a/c", if map of a only has a/b, then, arrording to a/c = (a/b)*(b/c) , we need to check b/c   
	    Map<String, Double> map_of_numerator = map.get(numerator);
	    for (String interVariable : map_of_numerator.keySet()) {
	        double result = dfs(interVariable, denominator, r * map_of_numerator.get(interVariable), map, seen);
	        if (result != -1) return result;//got the query answer
	    }
	    return -1;
	}

}
