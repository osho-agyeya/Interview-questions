/* over, 1, 1
 * 
 * 
 * Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

A valid square has four equal sides with positive length and four equal angles (90-degree angles).

 

Example 1:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: true
Example 2:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
Output: false
Example 3:

Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
Output: true
 

Constraints:

p1.length == p2.length == p3.length == p4.length == 2
-104 <= xi, yi <= 104
 * 
 */

package leetcode;

public class Valid_Square {
	
	/*
	 * If we calculate all distances between 4 points, 4 smaller distances should be equal (sides), and 2 larger distances should be equal too (diagonals). As an optimization, we can compare squares of the distances, so we do not have to deal with the square root and precision loss.

Therefore, our set will only contain 2 unique distances in case of square (beware of the zero distance though).
	 */
	
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
	      HashSet<Integer> set = new HashSet<>(Arrays.asList(distance(p1, p2), distance(p1, p3), distance(p1, p4),
	            distance(p2, p3), distance(p2, p4), distance(p3, p4)));
	    return !set.contains(0) && set.size() == 2;
	  }

	private int distance(int[] a, int[] b) {
	    return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}

}
