//completed
/*
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]

 */

package interviewbit;

import java.util.ArrayList;

public class Anti_Diagonals {
	
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    for(int i = 0; i < a.size()*2-1; i++)
	        res.add(new ArrayList<Integer>());
	        
	    for(int i = 0; i < a.size(); i++){
	        for(int j = 0; j < a.get(0).size(); j++){
	            res.get(i+j).add(a.get(i).get(j));
	        }
	    }
	    
	    return res;
	}

}
