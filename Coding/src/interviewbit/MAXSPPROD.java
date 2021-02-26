//done
/*
 * MAXSPPROD
You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j.

RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.

Write a program to find the maximum special product of any integer in the array.

Input: You will receive array of integers as argument to function.

Return: Maximum special product of any integer in the array modulo 1000000007.

Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.

Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9
 */

package interviewbit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MAXSPPROD {
public int maxSpecialProduct(ArrayList<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];
        
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        
    	for(int i = 1; i < n; i++){
    		while(!q.isEmpty()){
    			if(A.get(q.getLast()) > A.get(i)) break;
    			q.removeLast();
    		}
    		left[i] = (q.isEmpty()) ? 0 : q.getLast();
    		q.addLast(i);
    	}
    	q = new ArrayDeque<>();
    	q.addLast(n - 1);
    	for(int i = n - 2; i >= 0; i--){
    		while(!q.isEmpty()){
    			if(A.get(q.getLast()) > A.get(i)) break;
    			q.removeLast();
    		}
    		right[i] = (q.isEmpty()) ? 0 : q.getLast();
    		q.addLast(i);
    	}
    	long mx = -1;
    	for(int i = 0; i < n; i++){
    		mx = Long.max(mx, 1L * left[i] * right[i]);
    	}
    	return (int)(mx % 1000000007);
    }
}
