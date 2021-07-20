/* over, n, n
 * 
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 104
-109 <= nums[i] <= 109
 

Follow up: Could you implement the O(n) solution?
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {
	
	/*
	 * Approach 3: HashSet and Intelligent Sequence Building
Intuition

It turns out that our initial brute force solution was on the right track, but missing a few optimizations necessary to reach O(n)O(n) time complexity.

Algorithm

This optimized algorithm contains only two changes from the brute force approach: the numbers are stored in a HashSet (or Set, in Python) to allow O(1)O(1) lookups, and we only attempt to build sequences from numbers that are not already part of a longer sequence. This is accomplished by first ensuring that the number that would immediately precede the current number in a sequence is not present, as that number would necessarily be part of a longer sequence.


Complexity Analysis

Time complexity : O(n)O(n).

Although the time complexity appears to be quadratic due to the while loop nested within the for loop, closer inspection reveals it to be linear. Because the while loop is reached only when currentNum marks the beginning of a sequence (i.e. currentNum-1 is not present in nums), the while loop can only run for nn iterations throughout the entire runtime of the algorithm. This means that despite looking like O(n \cdot n)O(n⋅n) complexity, the nested loops actually run in O(n + n) = O(n)O(n+n)=O(n) time. All other computations occur in constant time, so the overall runtime is linear.

Space complexity : O(n)O(n).

In order to set up O(1)O(1) containment lookups, we allocate linear space for a hash table to store the O(n)O(n) numbers in nums. Other than that, the space complexity is identical to that of the brute force solution.
	 * 
	 * 
	 */
	
	 public int longestConsecutive(int[] nums) {
	        Set<Integer> set = new HashSet<>();
	            for(int n : nums) {
	                set.add(n);
	            }
	            int best = 0;
	            for(int n : set) {
	                if(!set.contains(n - 1)) {  // only check for one direction
	                    int m = n + 1;
	                    while(set.contains(m)) {
	                        m++;
	                    }
	                    best = Math.max(best, m - n);
	                }
	            }
	            return best;
	        
	    }

}
