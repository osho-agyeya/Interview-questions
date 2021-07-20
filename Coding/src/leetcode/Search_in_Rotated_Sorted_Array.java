/* over, ln n, 1 
 * There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
 

Follow up: Can you achieve this in O(log n) time complexity?
 */

package leetcode;

public class Search_in_Rotated_Sorted_Array {
	
	/*
	 * 
	 * Approach 2: One-pass Binary Search
Instead of going through the input array in two passes, we could achieve the goal in one pass with an revised binary search.

The idea is that we add some additional condition checks in the normal binary search in order to better narrow down the scope of the search.

Algorithm

As in the normal binary search, we keep two pointers (i.e. start and end) to track the search scope. At each iteration, we reduce the search scope into half, by moving either the start or end pointer to the middle (i.e. mid) of the previous search scope.

Here are the detailed breakdowns of the algorithm:

Initiate the pointer start to 0, and the pointer end to n - 1.

Perform standard binary search. While start <= end:

Take an index in the middle mid as a pivot.

If nums[mid] == target, the job is done, return mid.

Now there could be two situations:

Pivot element is larger than the first element in the array, i.e. the subarray from the first element to the pivot is non-rotated, as shown in the following graph.
pic

  - If the target is located in the non-rotated subarray:
  go left: `end = mid - 1`.

  - Otherwise: go right: `start = mid + 1`.
Pivot element is smaller than the first element of the array, i.e. the rotation index is somewhere between 0 and mid. It implies that the sub-array from the pivot element to the last one is non-rotated, as shown in the following graph.
pic

  - If the target is located in the non-rotated subarray:
  go right: `start = mid + 1`.

  - Otherwise: go left: `end = mid - 1`.
We're here because the target is not found. Return -1.

Implementation


Complexity Analysis

Time complexity: \mathcal{O}(\log{N})O(logN).
Space complexity: \mathcal{O}(1)O(1).
	 * 
	 */
	
	public int search(int[] nums, int target) {
	    int start = 0, end = nums.length - 1;
	    while (start <= end) {
	      int mid = start + (end - start) / 2;
	      if (nums[mid] == target) return mid;
	      else if (nums[mid] >= nums[start]) {
	        if (target >= nums[start] && target < nums[mid]) end = mid - 1;
	        else start = mid + 1;
	      }
	      else {
	        if (target <= nums[end] && target > nums[mid]) start = mid + 1;
	        else end = mid - 1;
	      }
	    }
	    return -1;
	  }

}
