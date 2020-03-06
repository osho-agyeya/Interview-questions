//done
/*
 * PRETTYPRINT
Print concentric rectangular pattern in a 2d matrix.
Let us show you some examples to clarify what we mean.

Example 1:

Input: A = 4.
Output:

4 4 4 4 4 4 4 
4 3 3 3 3 3 4 
4 3 2 2 2 3 4 
4 3 2 1 2 3 4 
4 3 2 2 2 3 4 
4 3 3 3 3 3 4 
4 4 4 4 4 4 4 
Example 2:

Input: A = 3.
Output:

3 3 3 3 3 
3 2 2 2 3 
3 2 1 2 3 
3 2 2 2 3 
3 3 3 3 3 
The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */

package interviewbit;

import java.util.ArrayList;

public class PRETTYPRINT {
	
	 public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        int siz=2*a-1;
        int ci=a-1,cj=a-1;
        int l=0,r=siz-1,t=0,b=siz-1;
        for (int i = 0; i <siz; i++) {
            ArrayList<Integer> arr=new ArrayList<>();
            for (int j = 0; j < siz; j++) {
                arr.add((Math.max(Math.abs(i-ci), Math.abs(j-cj)))+1);
            }
            ar.add(arr);
        }
        return ar;
        
        
    }

}
