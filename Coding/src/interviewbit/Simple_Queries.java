//not done
/*
 * Simple Queries
You are given an array A having N integers.

You have to perform the following steps in a given order.

generate all subarrays of A.
take the maximum element from each subarray of A and insert it into a new array G.
replace every element of G with the product of their divisors mod 1e9 + 7.
sort G in descending order
perform Q queries
In each query, you are given an integer K, where you have to find the Kth element in G.

Note: Your solution will run on multiple test cases so do clear global variables after using them.


Input Format

The first argument given is an Array A, having N integers.
The second argument given is an Array B, where B[i] is the ith query.
Output Format

Return an Array X, where X[i] will have the answer for the ith query.
Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e5
1 <= Q <= 1e5
1 <= k <= (N * (N + 1))/2 
For Example

Input:
    A = [1, 2, 4]
    B = [1, 2, 3, 4, 5, 6]
Output:
    X = [8, 8, 8, 2, 2, 1]
   
Explanation:
    subarrays of A	  maximum element
    ------------------------------------
    1. [1]							1
    2. [1, 2]						2
    3. [1, 2, 4]					4
    4. [2]							2
    5. [2, 4]						4
    6. [4]							4

	original
	G = [1, 2, 4, 2, 4, 4]
	
	after changing every element of G with product of their divisors
	G = [1, 2, 8, 2, 8, 8]
	
	after sorting G in descending order
	G = [8, 8, 8, 2, 2, 1]
 */

package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Simple_Queries {
	
 public static int MOD = (int) 1e9 + 7;
 
    private int multiplyDivisors(int n) {
        long result = 1;
        int i;
        for (i = 1; i * i < n; i++) {
            if (n % i == 0)
                result = (result * n) % MOD;
        }
        if (i * i == n) // perfect square
            result = (result * i) % MOD;
        return (int) result;
    }
    
    private class Pair {
        Pair(int n, int freq) {
            this.prod = multiplyDivisors(n);
            this.freq = freq;
        }
        Integer prod, freq;
        Long sum;
    }
    
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        Pair[] G = new Pair[A.size()];
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            int j = i - 1;
            while (j >= 0 && A.get(j) <= A.get(i))
                j -= left[j];
            left[i] = i - j;
        }
        for (int i = A.size() - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < A.size() && A.get(j) < A.get(i))
                j += right[j];
            right[i] = j - i;
        }
        for (int i = 0; i < A.size(); i++) {
            G[i] = new Pair(A.get(i), left[i] * right[i]);
        }
        
        // sort descending
        Arrays.sort(G, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p2.prod.compareTo(p1.prod);
            }
        });
 
        long sum = 0;
        for (Pair p : G) {
            p.sum = sum;
            sum += p.freq;
            //System.out.println(p.prod +" " + p.freq+" "+p.sum);
        }
 
        // answer queries
        ArrayList<Integer> res = new ArrayList<>(B.size());
        for (int i : B) {
            int start = 0, stop = A.size() - 1;
            while (start <= stop) {
                int mid = (start + stop) / 2;
                if (i <= G[mid].sum) {
                    stop = mid - 1;
                } else if (i > G[mid].sum + G[mid].freq) {
                    start = mid + 1;
                } else {
                    res.add(G[mid].prod);
                    break;
                }
            }
        }
        
        return res;
    }	

}
