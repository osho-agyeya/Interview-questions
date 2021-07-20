/* over, n, 1
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 

Constraints:

1 <= nums.length <= 3 * 104
-105 <= nums[i] <= 105
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
package leetcode;

public class Maximum_Subarray {
	
	/*
	 * 
	 * Approach 2: Dynamic Programming, Kadane's Algorithm
Intuition

Whenever you see a question that asks for the maximum or minimum of something, consider Dynamic Programming as a possibility. The difficult part of this problem is figuring out when a negative number is "worth" keeping in a subarray. This question in particular is a popular problem that can be solved using an algorithm called Kadane's Algorithm. If you're good at problem solving though, it's quite likely you'll be able to come up with the algorithm on your own. This algorithm also has a very greedy-like intuition behind it.

Let's focus on one important part: where the optimal subarray begins. We'll use the following example.

nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

We can see that the optimal subarray couldn't possibly involve the first 3 values - the overall sum of those numbers would always subtract from the total. Therefore, the subarray either starts at the first 4, or somewhere further to the right.

What if we had this example though?

nums = [-2,1000000000,-3,4,-1,2,1,-5,4]

We need a general way to figure out when a part of the array is worth keeping.

As expected, any subarray whose sum is positive is worth keeping. Let's start with an empty array, and iterate through the input, adding numbers to our array as we go along. Whenever the sum of the array is negative, we know the entire array is not worth keeping, so we'll reset it back to an empty array.

However, we don't actually need to build the subarray, we can just keep an integer variable current_subarray and add the values of each element there. When it becomes negative, we reset it to 0 (an empty array).

Current
1 / 10
Algorithm

Initialize 2 integer variables. Set both of them equal to the first value in the array.

currentSubarray will keep the running count of the current subarray we are focusing on.
maxSubarray will be our final return value. Continuously update it whenever we find a bigger subarray.
Iterate through the array, starting with the 2nd element (as we used the first element to initialize our variables). For each number, add it to the currentSubarray we are building. If currentSubarray becomes negative, we know it isn't worth keeping, so throw it away. Remember to update maxSubarray every time we find a new maximum.

Return maxSubarray.

Implementation

A clever way to update currentSubarray is using currentSubarray = max(num, currentSubarray + num). If currentSubarray is negative, then num > currentSubarray + num.


Complexity Analysis

Time complexity: O(N)O(N), where NN is the length of nums.

We iterate through every element of nums exactly once.

Space complexity: O(1)O(1)

No matter how long the input is, we are only ever using 2 variables: currentSubarray and maxSubarray.
	 * 
	 */
	
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
        
        
        
        //System.out.println(max_so_far+",,,,,"+start+",,,,"+end);
      return max_so_far;
    }
	
	/*
	public static void main(String[] args) {
		new Maximum_Subarray().maxSubArray(new int[] {-3,-1,-2});
	}
	*/

}
