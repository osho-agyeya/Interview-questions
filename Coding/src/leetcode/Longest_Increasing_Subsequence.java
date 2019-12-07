//doe

/*
 * 
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * 
 * 
 */

package leetcode;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
	
	public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
       int len = 0;

       for(int x : nums) {
           int i = Arrays.binarySearch(dp, 0, len, x);
           //System.out.println(i);
           if(i < 0) i = -(i + 1);
           dp[i] = x;
           if(i == len) len++;
       }

       return len;
   }
	
	/*
	
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int result = 1;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            result=Math.max(result, dp[i]);
        }
        return result;
        
    }
    */

}
