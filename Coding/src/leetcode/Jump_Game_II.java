/* over, n, 1
 * 
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 105 
 */

package leetcode;

public class Jump_Game_II {
	
	/*
	 * Overview
To find the minimum number of jumps, the brute force solution would be to exhaustively test all possible routes connecting the start and the end of nums. This can be achieved by backtracking. If you are not so sure about how backtracking works or how to implement backtracking, 55. Jump Game - Approach 1 Backtracking has a very clear explanation. Also, feel free to check out our Backtracking Explore Card. This problem is very similar to Jump Game so we only need to make one change to the solution. While exploring every jump pattern that takes us from the first position to the last position, we must also keep track of the number of jumps.

However, an exhaustive search would lead to Time Limited Exceeded, because we are literally finding every possible route and its time complexity is O(2^N)O(2 
N
 ) in the worst case. A key observation is that we don't have to explore every route. Instead, we can find the shortest jumps by making locally optimal choices at each index which leads to a globally optimal solution. Henceforth, this article will focus on introducing an optimized solution: Greedy algorithm.


Approach: Greedy
Intuition

Imagine that you are at index i in the array, the element in your current position defines the maximum distance that you can jump. Therefore, your next step will fall somewhere in the range [start, end], where start is the place right next to you and end is i + nums[i]. Then the question is, where to jump?

How to choose where to jump.

Figure 1. How to choose where to jump.

To answer this question, let's think about it in the following way. Our next move will fall somewhere between [start : end] and to find the minimum number of jumps to reach the end of the array, we must determine which place will take us the farthest in the next jump.

Choose the one that leads us farther.

Figure 2. Choose the one that leads us farther.

As you may notice, we are using a greedy approach: always jump to the place that will take us the farthest. Greedy algorithms always make locally optimal decisions, which may or may not lead to the globally optimal solution. Therefore, we must test our greedy algorithm to see if we can prove that it leads to the globally optimal solution.

We will use proof by contradiction to verify that the greedy algorithm is correct. Our statement is if at any step, we make a different choice than what our greedy algorithm would make, we can find a better solution to the problem.

Proof of correctness of our greedy approach.

Figure 3. Proof of correctness for our greedy approach.

As shown in Figure 3, consider two people A and B, where A follows our greedy strategy and B follows the optimal solution. The number at each index defines the maximum jump distance. Let's assume that until this point, their decisions have been identical, and this is when the disagreement happens.

Note that the choice they make for this jump will define the subarray for the next jump. The greedy solution always picks the largest subarray. Thus A will always have a larger subarray than B. Henceforth, it's not possible to beat the greedy algorithm at any step and reach the end of the array in fewer jumps; this contradicts our statement.

Algorithm

Initialize three integer variables: jumps to count the number of jumps, currentJumpEnd to mark the end of the range that we can jump to, and farthest to mark the farthest place that we can reach. Set each variable to zero.
Iterate over nums. Note that we exclude the last element from our iteration because as soon as we reach the last element, we do not need to jump anymore.
Update farthest to i + nums[i] if the latter is larger.
If we reach currentJumpEnd, it means we finished the current jump, and can begin checking the next jump by setting currentJumpEnd = farthest.
Return jumps.

Complexity Analysis

Time Complexity: O(N)O(N) because there are NN elements in the array and we visit each element in the array only once.

Space Complexity: O(1)O(1) because we don't use any additional data structures.
	 * 
	 * 
	 */
	public int jump(int[] A) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}
}
