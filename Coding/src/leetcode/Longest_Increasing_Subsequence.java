//completed

/*
 * 
 * 
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up:

Could you come up with the O(n2) solution?
Could you improve it to O(n log(n)) time complexity?
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
