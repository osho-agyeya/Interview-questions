//completed

/*
 Given an unsorted integer array nums, find the smallest missing positive integer.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
 

Constraints:

0 <= nums.length <= 300
-231 <= nums[i] <= 231 - 1
 * 
 */

package leetcode;

public class First_Missing_Positive {
	
	 public int firstMissingPositive(int[] A) {
	        int i = 0;
	        while(i < A.length){
	            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
	            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
	            else i++;
	        }
	        i = 0;
	        while(i < A.length && A[i] == i+1) i++;
	        return i+1;
	    }
	    
	    private void swap(int[] A, int i, int j){
	        int temp = A[i];
	        A[i] = A[j];
	        A[j] = temp;
	    }

}
