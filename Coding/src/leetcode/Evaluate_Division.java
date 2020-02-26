//ddoe


/*
 * 
 * 
 * 
 * 
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 * 
 * 
 * 
 * 
 * 
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
