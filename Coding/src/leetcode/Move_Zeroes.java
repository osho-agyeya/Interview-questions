//doe

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 * 
 */

package leetcode;

public class Move_Zeroes {

	
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <=1)
            return;
        int last = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[++last] = nums[i];
                if(i != last)
                    nums[i]=0; 
            }
        }
    }
	
}
