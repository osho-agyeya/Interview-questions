/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell. 
Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * 
 * 
 */
package leetcodePremium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Bomb_Enemy {

	
	public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] kill = new int[m][n];
        int cnt;

        // left to right
        for(int i = 0; i < m; i++) {
            cnt = 0;
            for(int j = 0; j < n; j++) {
                if(grid[i][j]=='E') cnt++;
                else if(grid[i][j] == 'W') cnt = 0;
                else kill[i][j] += cnt;
            }
        }

        // right to left
        for(int i = 0; i < m; i++) {
            cnt = 0;
            for(int j = n-1; j >= 0; j--) {
                if(grid[i][j]=='E') cnt++;
                else if(grid[i][j] == 'W') cnt = 0;
                else kill[i][j] += cnt;
            }
        }

        // up to down
        for(int j = 0; j < n; j++) {
            cnt = 0;
            for(int i = 0; i < m; i++) {
                if(grid[i][j]=='E') cnt++;
                else if(grid[i][j] == 'W') cnt = 0;
                else kill[i][j] += cnt;
            }
        }

        // down to up
        for(int j = 0; j < n; j++) {
            cnt = 0;
            for(int i = m-1; i >= 0; i--) {
                if(grid[i][j]=='E') cnt++;
                else if(grid[i][j] == 'W') cnt = 0;
                else kill[i][j] += cnt;
            }
        }

        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Integer.max(kill[i][j], max);
            }
        }
        return max;
    }
}
