//completed
/*
 * Valid Path
Asked in:  
Morgan Stanley
Amazon
Codenation
Problem Setter: glowing_glare Problem Tester: dhruvi
There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.


Input Format

1st argument given is an Integer x.
2nd argument given is an Integer y.
3rd argument given is an Integer N, number of circles.
4th argument given is an Integer R, radius of each circle.
5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
Output Format

Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
Constraints

0 <= x, y, R <= 100
1 <= N <= 1000
Center of each circle would lie within the grid
For Example

Input:
    x = 2
    y = 3
    N = 1
    R = 1
    A = [2]
    B = [3]
Output:
    NO
   
Explanation:
    There is NO valid path in this case
 */
package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class Valid_Path {
	
	public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
	    boolean[][] visited = new boolean[A + 1][B + 1];
	        
	        boolean[][] possible = new boolean[A + 1][B + 1];
	        
	        for (int i = 0; i < possible.length; i++) {
	            Arrays.fill(possible[i], true);
	        }
	        
	        for (int i = 0; i < possible.length; i++) {
	            for (int j = 0; j < possible[i].length; j++) {
	                for (int k = 0; k < E.size(); k++) {
	                    int x = E.get(k);
	                    int y = F.get(k);
	                    
	                    if ((x - i) * (x - i) + (y - j) * (y - j) <= D * D) {
	                        possible[i][j] = false;
	                        break;
	                    }
	                }
	            }
	        }
	        
	        // for (int i = 0; i < possible.length; i++) {
	        //     System.out.println(Arrays.toString(possible[i]));
	        // }
	        
	        if (path(0, 0, possible, visited)) {
	            return "YES";
	        } else {
	            return "NO";
	        }
	        
	    }
	
	 private boolean path(int x, int y, boolean[][] possible, boolean[][] visited) {
	        if (x >= possible.length || x < 0 || y >= possible[0].length || y < 0) {
	            return false;
	        }
	        
	        if (visited[x][y]) {
	            return false;
	        }
	        
	        if (!possible[x][y]) {
	            return false;
	        }
	        
	        if (x == possible.length - 1 && y == possible[possible.length - 1].length - 1) {
	            return true;
	        }
	        
	        visited[x][y] = true;
	        
	        return path(x + 1, y, possible, visited) || path(x + 1, y + 1, possible, visited) || path(x, y + 1, possible, visited) || path(x + 1, y - 1, possible, visited) || path(x - 1, y + 1, possible, visited) || path(x - 1, y, possible, visited) || path(x, y - 1, possible, visited) || path(x - 1, y - 1, possible, visited);
	    }
	

}
