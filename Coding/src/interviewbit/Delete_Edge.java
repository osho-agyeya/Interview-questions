/*completedd
 * 
 * Given a undirected tree with N nodes labeled from 1 to N.

Each node has a certain weight assigned to it given by an integer array A of size N.

You need to delete an edge in such a way that Product between sum of weight of nodes in one subtree with sum of weight of nodes in other subtree is maximized.

Return this maximum possible product modulo 109 + 7.

NOTE:

The tree is rooted at node labeled with 1.


Problem Constraints
2 <= N <= 105

1 <= A[i] <= 103



Input Format
First argument is an integer array A of size N denoting the weight of each node.

Second argument is a 2-D array B of size (N-1) x 2 denoting the edge of the tree.



Output Format
Return a single integer denoting the maximum product prossible of sum of weights of nodes in the two subtrees formed by deleting an edge with modulo 109 + 7.



Example Input
Input 1:

 A = [10, 5, 12, 6]
 B = [

        [1, 2]
        [1, 4]
        [4, 3]
     ]
Input 2:

 A = [11, 12]
 B = [

        [1, 2]
     ]


Example Output
Output 1:

 270
Output 2:

 132


Example Explanation
Explanation 1:

 Removing edge (1, 4) created two subtrees.
 Subtree-1 contains nodes (1, 2) and Subtree-2 contains nodes (3, 4)
 So product will be = (A[1] + A[2]) * (A[3] + A[4]) = 15 * 18 = 270
Explanation 2:

 Removing edge (1, 2) created two subtrees.
 Subtree-1 contains node (1) and Subtree-2 contains node (3)
 So product will be = (A[1]) * (A[2]) = 11 * 12 = 132
 */

package interviewbit;

public class Delete_Edge {
	
	int x=-1,y=-1;
    int MOD=(int)1e9+7;
    public long dfs(int u,boolean[] visited,int[] A,ArrayList<ArrayList<Integer>> adj){
        long sum=A[u-1];
        visited[u]=true;
        for(int v:adj.get(u)){
            if(!visited[v] && !((x==u && y==v)||(x==v && y==u))){
                sum+=dfs(v,visited,A,adj);
            }
        }
        return sum;
    }
    public int deleteEdge(int[] A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        long totalSum=0;
        for(int i=0;i<=A.length;i++){
            adj.add(new ArrayList<>());
            if(i<A.length)
                totalSum+=A[i];
        }
        boolean[] visited = new boolean[A.length+1];
        for(int i=0;i<B.length;i++){
            adj.get(B[i][0]).add(B[i][1]);
            adj.get(B[i][1]).add(B[i][0]);
        }
        long maxProd=0;
        for(int i=0;i<B.length;i++){
            Arrays.fill(visited,false);
            x=B[i][0];
            y=B[i][1];
            long m1=dfs(x,visited,A,adj);
            long m2=totalSum-m1;
            maxProd=Math.max(maxProd,((m1%MOD)*(m2%MOD))%MOD);
        }
        return (int)maxProd;
    }

}
