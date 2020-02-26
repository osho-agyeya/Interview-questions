//ddoe

/*
 * 
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:

Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2 
Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
             and 2 is the max number no larger than k (k = 2).
Note:

The rectangle inside the matrix must have an area > 0.
What if the number of rows is much larger than the number of columns?
 * 
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
