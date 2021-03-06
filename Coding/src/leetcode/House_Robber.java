//done
/*
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * 
 */
package leetcode;

public class House_Robber {
	
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
