//completed
/*
 * Array 3 Pointers
Asked in:  
Google
Microsoft
Yahoo
You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 
 */

package interviewbit;

import java.util.List;

public class Array_3_Pointers {
	
	 public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int m=A.size();
        int n=B.size();
        int o=C.size();
        int i=0;
        int j=0;
        int k=0;
        int minMax=Integer.MAX_VALUE;
        while(i<m && j<n && k<o){
            int a=A.get(i);
            int b=B.get(j);
            int c=C.get(k);
            int curDiff=Math.max(Math.abs(a-b),Math.max(Math.abs(b-c),Math.abs(c-a)));
            if(curDiff<minMax){
                minMax=curDiff;
            }
            int min=Math.min(a,Math.min(b,c));
            if(min==a){
                i++;
            }else if(min==b){
                j++;
            }else{
                k++;
            }
        }
        return minMax;
        
    }

}
