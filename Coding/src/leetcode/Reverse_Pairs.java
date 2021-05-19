//completed
/*
 * Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
 

Constraints:

1 <= nums.length <= 5 * 104
231 <= nums[i] <= 231 - 1
 */
package leetcode;

public class Reverse_Pairs {

	public int ret;
    public int reversePairs(int[] nums) {
        ret = 0;
        mergeSort(nums, 0, nums.length-1);
        return ret;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int middle = left + (right - left)/2;
        mergeSort(nums, left, middle);
        mergeSort(nums,middle+1, right);

        //count elements
        int count = 0;
        for (int l = left, r = middle+1; l <= middle;) {
            if (r > right || (long)nums[l] <= 2*(long)nums[r]) {
                l++;
                ret += count;
            } else {
                r++;
                count++;
            }
        }
        
        //sort
        Arrays.sort(nums, left, right + 1);   
    }
	
}