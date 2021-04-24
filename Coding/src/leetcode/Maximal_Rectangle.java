//completed

/*
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
	
	public int maximalRectangle(char[][] matrix) {
	    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
	    
	    int[] height = new int[matrix[0].length];
	    for(int i = 0; i < matrix[0].length; i ++){
	        if(matrix[0][i] == '1') height[i] = 1;
	    }
	    int result = largestInLine(height);
	    for(int i = 1; i < matrix.length; i ++){
	        resetHeight(matrix, height, i);
	        result = Math.max(result, largestInLine(height));
	    }
	    
	    return result;
	}

	private void resetHeight(char[][] matrix, int[] height, int idx){
	    for(int i = 0; i < matrix[0].length; i ++){
	        if(matrix[idx][i] == '1') height[i] += 1;
	        else height[i] = 0;
	    }
	}    

	public int largestInLine(int[] height) {
	    if(height == null || height.length == 0) return 0;
	    int len = height.length;
	    Stack<Integer> s = new Stack<Integer>();
	    int maxArea = 0;
	    for(int i = 0; i <= len; i++){
	        int h = (i == len ? 0 : height[i]);
	        if(s.isEmpty() || h >= height[s.peek()]){
	            s.push(i);
	        }else{
	            int tp = s.pop();
	            maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
	            i--;
	        }
	    }
	    return maxArea;
	}

}
