/* over, nm, m 
 * 
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = []
Output: 0
Example 3:

Input: matrix = [["0"]]
Output: 0
Example 4:

Input: matrix = [["1"]]
Output: 1
Example 5:

Input: matrix = [["0","0"]]
Output: 0
 

Constraints:

rows == matrix.length
cols == matrix[i].length
0 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
 */
package leetcode;

import java.util.Stack;

public class Maximal_Rectangle {
	
	/*
	 * 
	 * Approach 3: Using Histograms - Stack
Algorithm

In the previous approach we discussed breaking the input into a set of histograms - one histogram representing the substructure at each column. To compute the maximum area in our rectangle, we merely have to compute the maximum area of each histogram and find the global maximum (note that the below approach builds a histogram for each row instead of each column, but the idea is still the same).

Since Largest Rectangle in Histogram is already a problem on leetcode, we can just borrow the fastest stack-based solution here and apply it onto each histogram we generate. For an in-depth explanation on how the Largest Rectangle in Histogram algorithm works, please use the links above.


Note that the code under the function leetcode84 is a direct copy paste from the final solution in 84 - Largest Rectangle in Histogram.

Complexity Analysis

Time complexity : O(NM)O(NM). Running leetcode84 on each row takes M (length of each row) time. This is done N times for O(NM)O(NM).

Space complexity : O(M)O(M). We allocate an array the size of the the number of columns to store our widths at each row.

	 * 
	 */
	
	 // Get the maximum area in a histogram given its heights
    public int leetcode84(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {

                // update the state of this row's histogram using the last row's histogram
                // by keeping track of the number of consecutive ones

                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            // update maxarea with the maximum area from this row's histogram
            maxarea = Math.max(maxarea, leetcode84(dp));
        } return maxarea;
    }

}
