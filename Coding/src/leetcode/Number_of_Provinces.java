/* completed
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */

package leetcode;

public class Number_of_Provinces {
	
	
	/*
	 * public int findCircleNum(int[][] M) {
        int m = M.length, cnt = 0;
        int[] root = new int[m]; 
        for (int i = 0; i < m; i++) root[i] = i; 
        for (int i = 0; i < m; i++) 
            for (int j = i + 1; j < m; j++)
                if (M[i][j] == 1) unionFind(root, i, j);

        for (int i = 0; i < m; i++)
            if (i == root[i]) cnt++;
        return cnt;
    }
    
    void unionFind (int[] root, int v1, int v2) {
        while (root[v1] != v1) v1 = root[v1]; //find v1's root
        while (root[v2] != v2) v2 = root[v2]; //find v2's root
        if (root[v1] != root[v2]) root[v2] = v1; //unite the 2 subtrees 
    }
    
    
    --------------
    
    static int[] father;
    public int findCircleNum(int[][] M) {
        //corner case
        if(M.length == 0 || M[0].length == 0) return 0;

        int m = M.length;
        father = new int[m];
        for(int i = 0; i < m; i++){
            father[i] = i;
        }
        int counter = m;//initial counter as m

        for(int i = 0; i < m ; i++){
            for(int j = i + 1; j < m; j++){
                if(M[i][j] == 1){
                    //Only need to union when they are in different groups
                    int father1 = find(i);
                    int father2 = find(j);
        if(father1 != father2){
            father[father1] = father2;
            counter--;
        }
                    
                }
            }
        }

        return counter;
    }

    private int find(int root){
        if(father[root] == root) return father[root];

        father[root] = find(father[root]);
        return father[root];
    }

    
    
    
	 * 
	 * 
	 * 
	 * 
	 */
	 public void dfs(int[][] M, int[] visited, int i) {
	        for (int j = 0; j < M.length; j++) {
	            if (M[i][j] == 1 && visited[j] == 0) {
	                visited[j] = 1;
	                dfs(M, visited, j);
	            }
	        }
	    }
	    public int findCircleNum(int[][] M) {
	        int[] visited = new int[M.length];
	        int count = 0;
	        for (int i = 0; i < M.length; i++) {
	            if (visited[i] == 0) {
	                dfs(M, visited, i);
	                count++;
	            }
	        }
	        return count;
	    }

}
