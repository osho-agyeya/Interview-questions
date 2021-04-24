//completed
/*
 * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

You may assume the input array always has a valid answer.

 

Example 1:

Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.
Example 2:

Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
0 <= nums[i] <= 5000
It is guaranteed that there will be an answer for the given input nums.
 

Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?*/

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
