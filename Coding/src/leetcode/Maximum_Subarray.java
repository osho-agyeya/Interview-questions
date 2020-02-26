//ddone

/*
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 */
package leetcode;

public class Maximum_Subarray {
	
	public int maxSubArray(int[] A) {
        int n = A.length;
        int start=0,end=0,s=0;
        int max_so_far=Integer.MIN_VALUE,max_here=0;
        /*
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
        */
        
        for(int i=0;i<n;i++) {
        	max_here+=A[i];
        	
        	if (max_so_far < max_here) 
            { 
                max_so_far = max_here; 
                start = s; 
                end = i; 
            } 
      
            if (max_here < 0) 
            { 
                max_here = 0; 
                s = i + 1; 
            } 
        	
        }
        
        return max_so_far;
        
        //System.out.println(max_so_far+",,,,,"+start+",,,,"+end);
    }
	
	/*
	public static void main(String[] args) {
		new Maximum_Subarray().maxSubArray(new int[] {0,-1,-1});
	}
	*/

}
