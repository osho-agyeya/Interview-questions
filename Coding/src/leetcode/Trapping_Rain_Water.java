/* over, n,  1
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105
 */
package leetcode;

public class Trapping_Rain_Water {
	
	/*
	 * 
	 * Approach 4: Using 2 pointers
Intuition

As in Approach 2, instead of computing the left and right parts seperately, we may think of some way to do it in one iteration. From the figure in dynamic programming approach, notice that as long as \text{right\_max}[i]>\text{left\_max}[i]right_max[i]>left_max[i] (from element 0 to 6), the water trapped depends upon the left_max, and similar is the case when \text{left\_max}[i]>\text{right\_max}[i]left_max[i]>right_max[i] (from element 8 to 11). So, we can say that if there is a larger bar at one end (say right), we are assured that the water trapped would be dependant on height of bar in current direction (from left to right). As soon as we find the bar at other end (right) is smaller, we start iterating in opposite direction (from right to left). We must maintain \text{left\_max}left_max and \text{right\_max}right_max during the iteration, but now we can do it in one iteration using 2 pointers, switching between the two.

Algorithm

Initialize \text{left}left pointer to 0 and \text{right}right pointer to size-1
While \text{left}< \text{right}left<right, do:
If \text{height[left]}height[left] is smaller than \text{height[right]}height[right]
If \text{height[left]} \geq \text{left\_max}height[left]≥left_max, update \text{left\_max}left_max
Else add \text{left\_max}-\text{height[left]}left_max−height[left] to \text{ans}ans
Add 1 to \text{left}left.
Else
If \text{height[right]} \geq \text{right\_max}height[right]≥right_max, update \text{right\_max}right_max
Else add \text{right\_max}-\text{height[right]}right_max−height[right] to \text{ans}ans
Subtract 1 from \text{right}right.
Current
1 / 11

Complexity analysis

Time complexity: O(n)O(n). Single iteration of O(n)O(n).
Space complexity: O(1)O(1) extra space. Only constant space required for \text{left}left, \text{right}right, \text{left\_max}left_max and \text{right\_max}right_max.
	 * 
	 */
	
	public int trap(int[] height) {
        if (height.length==0) return 0; 
        int left = 0, right = height.length-1; 
        int leftMax=0, rightMax=0; 
        int ans = 0; 
        while (left < right) {
            if (height[left] > leftMax) leftMax = height[left]; 
            if (height[right] > rightMax) rightMax = height[right];
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax-height[left]); 
                left++; 
            } else {
                ans += Math.max(0, rightMax-height[right]); 
                right--; 
            }
        }
        return ans; 
    }

}
