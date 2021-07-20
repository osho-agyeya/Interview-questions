/* over, n, 1
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"
Example 2:

Input: nums = [], lower = 1, upper = 1
Output: ["1"]
Explanation: The only missing range is [1,1], which becomes "1".
Example 3:

Input: nums = [], lower = -3, upper = -1
Output: ["-3->-1"]
Explanation: The only missing range is [-3,-1], which becomes "-3->-1".
Example 4:

Input: nums = [-1], lower = -1, upper = -1
Output: []
Explanation: There are no missing ranges since there are no missing numbers.
Example 5:

Input: nums = [-1], lower = -2, upper = -1
Output: ["-2"]
 

Constraints:

-109 <= lower <= upper <= 109
0 <= nums.length <= 100
lower <= nums[i] <= upper
All the values of nums are unique.
 * 
 */

package leetcodePremium;

import java.util.ArrayList;
import java.util.List;

public class Missing_Ranges {
	
	/*
	 * 
	 * Approach 1: Linear Scan
Intuition and Algorithm

Since the input array, nums, is sorted ascendingly and all the elements in it are within the given [lower, upper] bounds, we can simply check consecutive elements to see if they differ by one or not. If they don't, then we have found a missing range.

When nums[i] - nums[i-1] == 1, we know that there are no missing elements between nums[i-1] and nums[i].
When nums[i] - nums[i-1] > 1, we know that the range of elements, [nums[i-1] + 1, nums[i] - 1], is missing.
missing ranges

However, there are two edge cases:

Edge case 1: If we don't start with lower as the first element of the array, we will need to include [lower, num[0] - 1] as a missing range as well.
missing ranges

Edge case 2: Similarly, if we don't end with upper as the last element of the array, we will need to include [nums[n-1] + 1, upper] as a missing range as well. Note n here is the length of the input array, nums.

Complexity Analysis

Let NN be the length of the input array.

Time complexity : O(N)O(N).

This is because we are only iterating over the array once, and at each step, we're performing O(1)O(1) operations. We treat the string building as O(1)O(1) because the strings can never be more than a fixed size.

Space complexity : O(1)O(1).

The output list has a worst case size of O(N)O(N). This case occurs when we have a missing range between each of the consecutive elements in the input array (for example, if the input array contains all even numbers between lower and upper). We aren't using any other additional space, beyond fixed-sized constants that don't grow with the size of the input.

However, output space that is simply used to return the output (and not to do any processing) is not counted for the purpose of space complexity analysis. For this reason, the overall space complexity is O(1)O(1).
	 * 
	 */

	
	 public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	        List<String> result = new ArrayList<>();
	        int prev = lower;
	        for (int i = 0; i <= nums.length; i++) {
	            int curr = (i < nums.length) ? nums[i] : upper + 1;
	            if (prev <= curr - 1) {
	                result.add(formatRange(prev, curr - 1));
	            }
	            prev = curr+1;
	        }
	        return result;
	    }

	    // formats range in the requested format
	    private String formatRange(int lower, int upper) {
	        if (lower == upper) {
	            return String.valueOf(lower);
	        }
	        return lower + "->" + upper;
	    }
	
}
