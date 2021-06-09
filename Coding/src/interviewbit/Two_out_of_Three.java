/* completedd
 * Given are Three arrays A, B and C.

Return the sorted list of numbers that are present in atleast 2 out of the 3 arrays.



Problem Constraints
1 <= |A|, |B|, |C| <= 100000

1 <= A[i], B[i], C[i] <= 100000

A, B, C may or may not have pairwise distinct elements.



Input Format
First argument is the array A.

First argument is the array B.

First argument is the array C.



Output Format
Return a sorted array of numbers.



Example Input
Input 1:

A = [1, 1, 2]
B = [2, 3]
C = [3]
Input 2:

A = [1, 2]
B = [1, 3]
C = [2, 3]


Example Output
Output 1:

[2, 3]
Output 2:

[1, 2, 3]


Example Explanation
Explanation 1:

1 is only present in A. 2 is present in A and B. 3 is present in B and C.
Explanation 2:

All numbers are present in atleast 2 out of 3 lists.
 */

package interviewbit;

public class Two_out_of_Three {
	
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
	    
	    HashMap<Integer, HashSet<Integer>> m=new HashMap<>();
	        for(int i:A){
	            HashSet<Integer> a;
	            if(m.containsKey(i))    a=m.get(i);
	            else    a=new HashSet<Integer>();
	            a.add(1);
	            m.put(i, a);
	        }
	        
	        for(int i:B){
	            HashSet<Integer> a;
	            if(m.containsKey(i))    a=m.get(i);
	            else    a=new HashSet<Integer>();
	            a.add(2);
	            m.put(i, a);
	        }
	        
	        for(int i:C){
	            HashSet<Integer> a;
	            if(m.containsKey(i))    a=m.get(i);
	            else    a=new HashSet<Integer>();
	            a.add(3);
	            m.put(i, a);
	        }
	        
	        ArrayList<Integer> res= new ArrayList<>();
	        for(int i:m.keySet()){
	            if(m.get(i).size()>=2)  res.add(i);
	        }
	        Collections.sort(res);
	        return res;
	    }

}
