//doe
/*
 * Distinct Numbers in Window
Asked in:  
Amazon
You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:

 If K > N, return empty array.
 A[i] is a signed integer
For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].
 */
package interviewbit;

import java.util.HashMap;

public class Distinct_Numbers_in_Window {
	
	public int[] dNums(int[] A, int B) {
        int n = A.length;
        int[] ans = new int[n-B+1];
        HashMap<Integer,Integer> mapping = new HashMap <Integer, Integer>();
        for (int i=0; i<B; i++){
            if (mapping.containsKey(A[i]))
                mapping.put(A[i], mapping.get(A[i])+1);
            else
                mapping.put(A[i], 1);
        }
        ans[0] = mapping.size();
        //System.out.println("jj" + (n-B));
        for(int i=1; i<=n-B; i++){
            int prev= i-1;
            //System.out.println(i+"  " + A[prev]);
            
            if (mapping.get(A[prev]) == 1)
                mapping.remove(A[prev]);
            else
                mapping.put(A[prev], mapping.get(A[prev]) - 1);
                
            int next = i+B-1;
            if (mapping.containsKey(A[next]))
                mapping.put(A[next], mapping.get(A[next])+1);
            else
                mapping.put(A[next], 1);
            
            ans[i] = mapping.size();
        }
        return ans;
    }

}
