/* over, n, 1
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */
package leetcode;

public class Sort_Colors {
	
	
	/*
	 * 
	 * Approach 1: One Pass
Intuition

The problem is known as Dutch National Flag Problem and first was proposed by Edsger W. Dijkstra. The idea is to attribute a color to each number and then to arrange them following the order of colors on the Dutch flag.

bla

Let's use here three pointers to track the rightmost boundary of zeros, the leftmost boundary of twos and the current element under the consideration.

bla

The idea of solution is to move curr pointer along the array, if nums[curr] = 0 - swap it with nums[p0], if nums[curr] = 2 - swap it with nums[p2].

Algorithm

Initialise the rightmost boundary of zeros : p0 = 0. During the algorithm execution nums[idx < p0] = 0.

Initialise the leftmost boundary of twos : p2 = n - 1. During the algorithm execution nums[idx > p2] = 2.

Initialise the index of current element to consider : curr = 0.

While curr <= p2 :

If nums[curr] = 0 : swap currth and p0th elements and move both pointers to the right.

If nums[curr] = 2 : swap currth and p2th elements. Move pointer p2 to the left.

If nums[curr] = 1 : move pointer curr to the right.

Implementation

Current
1 / 13

Complexity Analysis

Time complexity : \mathcal{O}(N)O(N) since it's one pass along the array of length NN.

Space complexity : \mathcal{O}(1)O(1) since it's a constant space solution.
	 * 
	 * 
	 */
	
	/*
	  Dutch National Flag problem solution.
	  */
	  public void sortColors(int[] nums) {
	    // for all idx < i : nums[idx < i] = 0
	    // j is an index of element under consideration
	    int p0 = 0, curr = 0;
	    // for all idx > k : nums[idx > k] = 2
	    int p2 = nums.length - 1;

	    int tmp;
	    while (curr <= p2) {
	      if (nums[curr] == 0) {
	        // swap p0-th and curr-th elements
	        // i++ and j++
	        tmp = nums[p0];
	        nums[p0++] = nums[curr];
	        nums[curr++] = tmp;
	      }
	      else if (nums[curr] == 2) {
	        // swap k-th and curr-th elements
	        // p2--
	        tmp = nums[curr];
	        nums[curr] = nums[p2];
	        nums[p2--] = tmp;
	      }
	      else curr++;
	    }
	  }

}
