//doe

//this is using kruskal's algorithm
/*
 *Commutable Islands
Asked in:  
Amazon
Problem Setter: amitkgupta94 Problem Tester: archit.rai
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.

Input Format:

The first argument contains an integer, A, representing the number of islands.
The second argument contains an 2-d integer matrix, B, of size M x 3:
    => Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
Output Format:

Return an integer representing the minimal cost required.
Constraints:

1 <= A, M <= 6e4
1 <= B[i][0], B[i][1] <= A
1 <= B[i][2] <= 1e3
Examples:

Input 1:
    A = 4
    B = [   [1, 2, 1]
            [2, 3, 4]
            [1, 4, 3]
            [4, 3, 2]
            [1, 3, 10]  ]

Output 1:
    6

Explanation 1:
    We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.

Input 2:
    A = 4
    B = [   [1, 2, 1]
            [2, 3, 2]
            [3, 4, 4]
            [1, 4, 3]   ]

Output 2:
    6

Explanation 2:
    We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the to 
 */
package interviewbit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Commutable_Islands {
	
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
        
        return ans;
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
	    while(!pq.isEmpty()){
	        int[] removed=pq.poll();
	        int key=removed[0];
	        int u=removed[1];
	        if(visited[u])continue;
	        visited[u]=true;
	        ans+=key;   
	        Map<Integer,Integer> neighbours=costs.get(u);
	        neighbours.forEach((v,w)->
	        {
	        	if(!visited[v]) pq.add(new int[]{w,v});
	        }
	        );
	    }
	    
	    return ans;
	        
	    }
}
