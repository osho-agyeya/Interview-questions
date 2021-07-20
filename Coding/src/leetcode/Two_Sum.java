/* over, n, n
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 */

package leetcode;
import java.util.*;

public class Two_Sum {
	
	/*
	 * Approach 3: One-pass Hash Table
It turns out we can do it in one-pass. While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table. If it exists, we have found a solution and return immediately.


Complexity Analysis:

Time complexity : O(n)O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1)O(1) time.

Space complexity : O(n)O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
	 * 
	 */
	
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
   for (int i = 0; i < nums.length; i++) {
       int complement = target - nums[i];
       if (map.containsKey(complement)) {
           return new int[] { map.get(complement), i };
       }
       map.put(nums[i], i);
   }
       return new int[]{0};  //good way of avoiding temp variables or unnecessary new variables
       
       
   }

}