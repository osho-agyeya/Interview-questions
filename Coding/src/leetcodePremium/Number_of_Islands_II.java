//completed
/*
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Example:
Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]
Challenge:
Can you do it in time complexity O(k log mn), where k is the length of the positions?
 * 
 */

package leetcodePremium;

public class Number_of_Islands_II {
	
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] lands = new int[m*n];
        ArrayList<Integer> result = new ArrayList<>();
        int count =0;
        int[][] neighbors = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0; i< m*n; i++){
            lands[i] = -1;
        }
        for(int i=0; i<positions.length;i++){

            int pX= positions[i][0];
            int pY = positions[i][1];
            if(lands[pX*n+pY]!= -1) continue;
            count++;
            lands[pX*n+pY] = pX*n+pY;
            for(int k=0; k<neighbors.length; k++){
                int nX = pX+ neighbors[k][0];
                int nY = pY + neighbors[k][1];

                if(nX >=0 && nX<m && nY >=0 && nY <n && lands[nX*n+nY]!=-1){
                    int pRoot = find(lands, pX*n+pY);
                    int nRoot = find(lands, nX*n+nY);
                    if(pRoot != nRoot){
                        count--;
                        lands[pRoot] = nRoot;// union happens here
                    }

                }
            }

            result.add(count);
        }

        return result;
    }

    private int find(int[] lands, int index){
        while(index != lands[index]) index = lands[index];
        return index;
    }
	
}
