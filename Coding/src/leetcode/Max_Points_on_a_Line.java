//completed

/*
 * 
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

 

Example 1:


Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:


Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
 

Constraints:

1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Max_Points_on_a_Line {
	
	 public int maxPoints(int[][] points) {
	     if (points == null || points.length == 0) return 0;
	        int result = 0;
	        Map<String, Integer> map = new HashMap<>();
	        // double for loop to try all points. O(n^2)
	        for (int i = 0; i < points.length; i++) {
	            int max = 0, overlap = 0;
	            map.clear();
	            for (int j = i + 1; j < points.length; j++) {
	                int x = points[j][0] - points[i][0];
	                int y = points[j][1] - points[i][1];
	                if (x == 0 && y == 0) {
	                    overlap++;
	                    continue;
	                }
	                int gcd = findGCD(x, y);
	                if (gcd != 0) {
	                    x /= gcd;
	                    y /= gcd;
	                }
	                String key = x + "@" + y;
	                if (map.containsKey(key)) {
	                    map.put(key, map.get(key) + 1);
	                } else {
	                    map.put(key, 1);
	                }
	                max = Math.max(max, map.get(key));
	            }
	            result = Math.max(result, max + overlap + 1);
	        }
	        return result;
	    }

	    private int findGCD(int a, int b) {
	        if (b == 0) return a;
	        return findGCD(b, a % b);
	    }

}
