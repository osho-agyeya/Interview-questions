/* over, n, 1
 * 
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 * 
 * 
 */
package leetcode;

public class House_Robber {
	
	/*
	 * Approach 3: Optimized Dynamic Programming
Intuition

This is the exact same solution as the previous one with the exception that we will be optimizing the space complexity here. Let's look at the recursive relation again to see where we can reduce the amount of space used.

\text{robFrom}(i) = \text{max}(\text{robFrom}(i + 1), \text{robFrom}(i + 2) + \text{nums}(i))robFrom(i)=max(robFrom(i+1),robFrom(i+2)+nums(i))

To calculate the current value, we just need to rely on the next two consecutive values/recursive calls.

Porting this idea over to our dynamic programming solution we see that in order to calculate the value at a current index in the dynamic programming table, we simply need to know the next two values i.e. maxRobbedAmount[i + 1] and maxRobbedAmount[i + 2]. In the end we will return the value of maxRobbedAmount[0].

Instead of keeping an entire table for storing these cached values, we can get by with simply keeping track of the "next" two values.

Let's see this more concretely in the algorithm section.

Algorithm

We will make use of two variables here called robNext and robNextPlusOne which at any point will represent the optimal solution for maxRobbedAmount[i + 1] and maxRobbedAmount[i + 2]. These are the two values that we need to calculate the current value.

We set robNextPlusOne to 0 since this means the robber doesn't have any houses left to rob, thus zero profit. Additionally, we set robNext to nums[N - 1] because in this case there is only one house to rob which is the last house. Robbing it will yield the maximum profit.

Note We are assuming that robNextPlusOne is the value of maxRobbedAmount[N] and robNext is maxRobbedAmount[N-1] initially.

We iterate from N - 2 down to 0 and set current = max(robNext, robNextPlusOne + nums[i]). Note that this is the same as the dynamic programming solution except that we are making use of our variables and not entries from the table.

Set robNextPlusOne = robNext.

Set robNext = current. Updating the two variables is important as we iterate down to 0.

We return the value in robNext.

Implementation


Time Complexity

Time Complexity: O(N)O(N) since we have a loop from N - 2 \cdots 0N−2⋯0 and we use the precalculated values of our dynamic programming table to calculate the current value in the table which is a constant time operation.

Space Complexity: O(1)O(1) since we are not using a table to store our values. Simply using two variables will suffice for our calculations.


	 * 
	 * 
	 */
	
	public int rob(int[] nums) {
		int ifRobbedPrevious = 0; 	// max monney can get if rob current house
			    int ifDidntRobPrevious = 0; // max money can get if not rob current house
			    
			    // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
			    for(int i=0; i < nums.length; i++) 
			    {
			    	// If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
			        int currRobbed = ifDidntRobPrevious + nums[i];
			        
			        // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
			        int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious); 
			        
			        // Update values for the next round
			        ifDidntRobPrevious  = currNotRobbed;
			        ifRobbedPrevious = currRobbed;
			    }
			    
			    return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
		        
		    }

}
