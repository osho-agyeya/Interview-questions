//doe
/*
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 */

package leetcode;

import java.util.Arrays;

public class Wiggle_Sort_II {
	
	public void wiggleSort(int[] nums) {
        int n = nums.length;
   int[] copy = Arrays.copyOf(nums, n);
   Arrays.sort(copy);
       
       int k=n-1;
   for(int odd_index=1;odd_index<n;odd_index+=2){
       nums[odd_index]=copy[k--];
   }
       
   for(int even_index=0;even_index<n;even_index+=2){
       nums[even_index]=copy[k--];
   }
       
   }

}
