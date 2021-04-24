//completed

/*
 * t=O(NXH) OR WORST IS O(N^2)
 * S=O(N)
 * 
 * There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.

 

Example 1:

Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
Explanation:

Example 2:

Input: [[1,2],[2,2],[4,2]]
Output: [[1,2],[2,2],[4,2]]
Explanation:

Even you only have trees in a line, you need to use rope to enclose them. 
 

Note:

All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
All input integers will range from 0 to 100.
The garden has at least one tree.
All coordinates are distinct.
Input points have NO order. No order required for output.
input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * 
 * 
 * 
 * 
 * 
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Erect_the_Fence {
	
	  public int[][] outerTrees(int[][] points) {
	        
	        Point[] pointss=new Point[points.length];
	        int i=0;
	     
	        for(int[] point:points){
	            pointss[i++]=new Point(point[0],point[1]);
	        }
	        
	        List<Point> ansl=findConvexHull(pointss);
	        
	        int[][] ans=new int[ansl.size()][2];
	         i=0;
	        for(Point point:ansl){
	            ans[i][0]=point.x;
	            ans[i++][1]=point.y;
	        }
	        
	        return ans;
	        
	    }
	        
	    class Point{
	        int x;
	        int y;
	        Point(int x, int y){
	            this.x = x;
	            this.y = y;
	        }
	    }

	    public List<Point> findConvexHull(Point[] points) {
	        //first find leftmost point to start the march.
	        Point start = points[0];
	        for (int i = 1; i < points.length; i++) {
	            if (points[i].x < start.x) {
	                start = points[i];
	            }
	        }
	        Point current = start;
	        //use set because this algorithm might try to insert duplicate point.
	        Set<Point> result = new HashSet<>();
	        result.add(start);
	        List<Point> collinearPoints = new ArrayList<>();
	        while (true) {
	            Point nextTarget = points[0];
	            for (int i = 1; i < points.length; i++) {
	                if (points[i] == current) {
	                    continue;
	                }
	                int val = crossProduct(current, nextTarget, points[i]);
	                //if val > 0 it means points[i] is on left of current -> nextTarget. Make him the nextTarget.
	                if (val > 0) {
	                    nextTarget = points[i];
	                    //reset collinear points because we now have a new nextTarget.
	                    collinearPoints = new ArrayList<>();
	                } else if (val == 0) { //if val is 0 then collinear current, nextTarget and points[i] are collinear.
	                    //if its collinear point then pick the further one but add closer one to list of collinear points.
	                    if (distance(current, nextTarget, points[i]) < 0) {
	                        collinearPoints.add(nextTarget);
	                        nextTarget = points[i];
	                    } else { //just add points[i] to collinearPoints list. If nextTarget indeed is the next point on
	                        //convex then all points in collinear points will be also on boundary.
	                        collinearPoints.add(points[i]);
	                    }
	                }
	                //else if val < 0 then nothing to do since points[i] is on right side of current -> nextTarget.
	            }

	            //add all points in collinearPoints to result.
	            for (Point p : collinearPoints) {
	                result.add(p);
	            }
	            //if nextTarget is same as start it means we have formed an envelope and its done.
	            if (nextTarget == start) {
	                break;
	            }
	            //add nextTarget to result and set current to nextTarget.
	            result.add(nextTarget);
	            current = nextTarget;
	        }
	        return new ArrayList<>(result);
	    }
	        
	           /**
	     * Returns < 0 if 'b' is closer to 'a' compared to 'c', == 0 if 'b' and 'c' are same distance from 'a'
	     * or > 0 if 'c' is closer to 'a' compared to 'b'.
	     */
	    private int distance(Point a, Point b, Point c) {
	        int y1 = a.y - b.y;
	        int y2 = a.y - c.y;
	        int x1 = a.x - b.x;
	        int x2 = a.x - c.x;
	        return Integer.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
	    }

	    /**
	     * Cross product to find where c belongs in reference to vector ab.
	     * If result > 0 it means 'c' is on left of ab
	     *    result == 0 it means 'a','b' and 'c' are collinear
	     *    result < 0  it means 'c' is on right of ab
	     */
	    private int crossProduct(Point a, Point b, Point c) {
	        int y1 = a.y - b.y;
	        int y2 = a.y - c.y;
	        int x1 = a.x - b.x;
	        int x2 = a.x - c.x;
	        return y2 * x1 - y1 * x2;
	    }
	        

}
