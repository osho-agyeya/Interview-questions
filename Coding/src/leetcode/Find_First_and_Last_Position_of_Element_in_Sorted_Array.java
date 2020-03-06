//done
/*
 * 
 * 
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 * 
 * 
 */
package leetcode;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
	
	public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};

    int[] res = new int[]{-1,-1};
    // 1.Find left insert position
    int left = 0, right = nums.length - 1;
    while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] > target)
            right = mid - 1;
        else if(nums[mid] < target)
            left = mid + 1;
        else
            right = mid - 1;  // even equal, still move right to mid - 1, to find the starting point of the numbers
    }
    res[0] = right + 1; // finally it will move one step before the starting of target, so +1 to point to the start
    // 2.Find right insert position
    left = 0; right = nums.length - 1;
    while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] > target)
            right = mid - 1;
        else if(nums[mid] < target)
            left = mid + 1;
        else
            left = mid + 1; // even equal, still move left to mid + 1, to find the ending point of the numbers
    }
    res[1] = left - 1; // finally it will move one step after the ending of target, so -1 to point to the end
    // 3.if target is not found, return {-1,-1}
     if(res[0] >= nums.length || res[0] >= nums.length ||nums[res[0]] != target || nums[res[1]] != target) 
         return new int[]{-1, -1};
    return res;
    }

}
