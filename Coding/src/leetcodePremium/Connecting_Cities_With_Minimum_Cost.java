/* completedd
 * 
 * There are N cities numbered from 1 to N.

You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together. (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)

Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together. The cost is the sum of the connection costs used. If the task is impossible, return -1.

Example 1:

 

Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: 
Choosing any 2 edges will connect all cities so we choose the minimum 2.
1
2
3
4
Example 2:

 

Input: N = 4, connections = [[1,2,3],[3,4,4]]
Output: -1
Explanation: 
There is no way to connect all cities even if all edges are used.
1
2
3
4
Note:

1 <= N <= 10000
1 <= connections.length <= 10000
1 <= connections[i][0], connections[i][3] <= N
0 <= connections[i][2] <= 10^5
connections[i][0] != connections[i][4]
 * 
 */

package leetcodePremium;

public class Connecting_Cities_With_Minimum_Cost {
	

	//kruskals
	/*
	public int solve(int A, int[][] B) {
        
        Arrays.sort(B, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                return arr1[2] - arr2[2];
            }
        });
        
        //for (int i = 0; i < B.length; i++){
        //    System.out.println(Arrays.toString(B[i]));
        //}
        
        int ans = 0;
        int count = 0;
        
        int[] parent = new int[A];
        int[] rank = new int[A];
        
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);
        
        for (int i = 0; i < B.length; i++){
            if (count == A)
                break;
                
            int x = find(parent, B[i][0] - 1);
            int y = find(parent, B[i][1] - 1);
            
            if (x == y)
                continue;
                
            if (rank[x] < rank[y]){
                parent[x] = y;
            }else if(rank[x] > rank[y]){
                parent[y] = x;
            }else{
                parent[x] = y;
                rank[y]++;
            }
            
            ans += B[i][2];
            count++;
        }
        
        return count==A?ans:-1;
    }
    
    int find(int[] parent, int v){
        if (parent[v] == -1){
            return v;
        }else{
            parent[v] = find(parent, parent[v]);
            return parent[v];
        }
        
        
    }
    
    */
	
	
	//prims
	public int solve(int A, int[][] B) {
	    int ans=0;
	    //adjacency list
	    Map<Integer, Map<Integer, Integer>> costs = new HashMap<>();
	    for (int[] f : B) {
	        if (!costs.containsKey(f[0])) costs.put(f[0], new HashMap<>());
	        costs.get(f[0]).put(f[1], f[2]);
	        if (!costs.containsKey(f[1])) costs.put(f[1], new HashMap<>());
	        costs.get(f[1]).put(f[0], f[2]);
	    }
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
	    boolean visited[]=new boolean[A+1];
	    pq.add(new int[] {0,1});
	    int count=0;
	    while(!pq.isEmpty()){
	        int[] removed=pq.poll();
	        int key=removed[0];
	        int u=removed[1];
	        if(visited[u])continue;
	        visited[u]=true;
	        count++;
	        ans+=key;   
	        Map<Integer,Integer> neighbours=costs.get(u);
	        neighbours.forEach((v,w)->
	        {
	        	if(!visited[v]) pq.add(new int[]{w,v});
	        }
	        );
	    }
	    
	    return count==A?ans:-1;
	        
	    }
	

}
