/*completedd
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.

Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (0, 1)

Output: "lul"
Explanation: There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".

Example 2

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (3, 0)
Output: "impossible"
Explanation: The ball cannot reach the hole.

Note:
There is only one ball and one hole in the maze.
Both the ball and hole exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.*/

package leetcodePremium;

public class The_Maze_III {

	 class Point implements Comparable<Point> {
	        int distance;  // distance from ball
	        int row;
	        int col;
	        String directions;  // directions from ball

	        Point(int distance, int row, int col, String directions) {
	            this.distance = distance;
	            this.row = row;
	            this.col = col;
	            this.directions = directions;
	        }
	        public int compareTo(Point other) {
	            if (this.distance == other.distance) {
	                return this.directions.compareTo(other.directions);     
	            }
	            return this.distance - other.distance;
	        }
	    }
	    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
	        boolean[][] visited = new boolean[maze.length][maze[0].length];

	        PriorityQueue<Point> pq = new PriorityQueue<>();

	        pq.offer(new Point(0, ball[0], ball[1], ""));

	        // arrays used for exploring 4 directions from a point
	        char[] dstr = {'d', 'l', 'r', 'u'};
	        int[][] dirs = {{1,0},{0,-1},{0,1},{-1,0}};

	        while (!pq.isEmpty()) {
	            Point pt = pq.poll();
	            if (pt.row == hole[0] && pt.col == hole[1]) {
	                return pt.directions;
	            }
	            visited[pt.row][pt.col] = true;

	            for (int i = 0; i < dirs.length; i++) {
	                int newRow = pt.row;
	                int newCol = pt.col;
	                int distance = pt.distance;
	                String directions = pt.directions;

	                // Explore current direction until hitting a wall or the hole
	                while (newRow + dirs[i][0] >= 0 &&
	                       newRow + dirs[i][0] < maze.length &&
	                       newCol + dirs[i][1] >= 0 &&
	                       newCol + dirs[i][1] < maze[0].length &&
	                       maze[newRow + dirs[i][0]][newCol + dirs[i][1]] != 1) {

	                    newRow += dirs[i][0];
	                    newCol += dirs[i][1];
	                    distance += 1;

	                    if (newRow == hole[0] && newCol == hole[1]) {
	                        break;
	                    }
	                }
	                if (!visited[newRow][newCol]) {
	                    pq.offer(new Point(distance, newRow, newCol, directions + dstr[i]));
	                }
	            }
	        }
	        return "impossible";
	    }
	
}
