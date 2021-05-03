/*completed
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree. 
For example: 
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true. 
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false. 
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges. 
 */

package leetcodePremium;

public class Graph_Valid_Tree {
	
	public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
 
        //build the graph
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
 
            list.get(a).add(b);
            list.get(b).add(a);
        }
 
        //use queue to traverse the graph
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(0);
 
        while(!q.isEmpty()){
            int head = q.poll();
 
            if(visited.contains(head)){
                return false;
            }
 
            visited.add(head);
 
            ArrayList<Integer> vList = list.get(head);
            for(int v: vList){
                if(!visited.contains(v)){
                    q.offer(v); 
                }     
            }
        }
 
        if(visited.size()<n){
            return false;
        }
 
        return true;
    }
	

}
