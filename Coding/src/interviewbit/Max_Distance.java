//completed
/*
 * Max Distance
Asked in:  
Google
Amazon
Microsoft
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4)
 */

package interviewbit;

public class Max_Distance {
public int maximumGap(final int[] arr) {
        int n=arr.length;
        if(n==1)    return 0;
        int maxDiff;
        int i, j;
 
        int RMax[] = new int[n];
        int LMin[] = new int[n];
 
        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(arr[i], LMin[i - 1]);
 
        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(arr[j], RMax[j + 1]);
 
        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n) 
        {
            if (LMin[i] <=RMax[j]) 
            {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } 
            else
                i = i + 1;
        }
 
        return maxDiff;
        
    }
}
