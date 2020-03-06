//done
/*
 * NUMRANGE
Given an array of non negative integers A, and a range (B, C),
find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
where 0 <= i <= j < size(A)

Example :

A : [10, 5, 1, 0, 2]
(B, C) : (6, 8)
ans = 3
as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]

 NOTE : The answer is guranteed to fit in a 32 bit signed integer. 
 */

package interviewbit;

public class NUMRANGE {

    public int numRange(int[] A, int B, int C) {
        
        return findSubSumLtoR(A, A.length, B, C);
    }
    
    
     // Function to find number 
    // of subarrays having sum  
    // less than or equal to x. 
     int countSub(int arr[],  
                        int n, int x) 
    { 
      
        // Starting index of 
        // sliding window. 
        int st = 0; 
      
        // Ending index of  
        // sliding window. 
        int end = 0; 
      
        // Sum of elements currently  
        // present in sliding window. 
        int sum = 0; 
      
        // To store required  
        // number of subarrays. 
        int cnt = 0; 
      
        // Increment ending index  
        // of sliding window one 
        // step at a time. 
        while (end < n)  
        { 
      
            // Update sum of sliding  
            // window on adding a 
            // new element. 
            sum += arr[end]; 
      
            // Increment starting index  
            // of sliding window until 
            // sum is greater than x. 
            while (st <= end && sum > x)  
            { 
                sum -= arr[st]; 
                st++; 
            } 
      
            // Update count of  
            // number of subarrays. 
            cnt += (end - st + 1); 
            end++; 
        } 
      
        return cnt; 
    } 
      
    // Function to find number  
    // of subarrays having sum  
    // in the range L to R. 
     int findSubSumLtoR(int arr[], int n, 
                              int L, int R) 
    { 
      
        // Number of subarrays  
        // having sum less than  
        // or equal to R. 
        int Rcnt = countSub(arr, n, R); 
      
        // Number of subarrays  
        // having sum less than  
        // or equal to L-1. 
        int Lcnt = countSub(arr, n, L - 1); 
      
        return Rcnt - Lcnt; 
    } 
	
}
