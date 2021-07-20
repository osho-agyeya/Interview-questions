/*completedd
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3].... 
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].  */

package leetcodePremium;

public class Wiggle_Sort {

	public void wiggleSort(int[] nums) {
	    if (nums == null || nums.length <= 1) {
	        return;
	    }
	 
	    for (int i = 1; i < nums.length; i++) {
	        if (i % 2 == 1) {
	            if (nums[i - 1] > nums[i]) {
	                swap(nums, i - 1, i);
	            }
	        } else {
	            if (nums[i - 1] < nums[i]) {
	                swap(nums, i - 1, i);
	            }
	        }
	    }
	}
	 
	private void swap(int[] nums, int i, int j) {
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
		
}