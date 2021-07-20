/* 
 * Given a 2D matrix matrix, handle multiple queries of the following types:

Update the value of a cell in matrix.
Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
void update(int row, int col, int val) Updates the value of matrix[row][col] to be val.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 

Example 1:


Input
["NumMatrix", "sumRegion", "update", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [3, 2, 2], [2, 1, 4, 3]]
Output
[null, 8, null, 10]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e. sum of the left red rectangle)
numMatrix.update(3, 2, 2);       // matrix changes from left image to right image
numMatrix.sumRegion(2, 1, 4, 3); // return 10 (i.e. sum of the right red rectangle)
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
-105 <= matrix[i][j] <= 105
0 <= row < m
0 <= col < n
-105 <= val <= 105
0 <= row1 <= row2 < m
0 <= col1 <= col2 < n
At most 104 calls will be made to sumRegion and update.
 */

package leetcodePremium;

public class Range_Sum_Query_2D_Mutable {
	
	 public int[][] colSum;
	    public int[][] matrix;
	    public Range_Sum_Query_2D_Mutable(int[][] matrix) {
	        this.matrix = matrix;
	        if (matrix == null || matrix.length == 0) {
	            return;
	        }
	        if (matrix[0] == null || matrix[0].length == 0) {
	            return;
	        }
	        int m = matrix.length;
	        int n = matrix[0].length;
	        colSum = new int[m + 1][n];
	        for (int i = 1; i <= m; i++) {
	            for (int j = 0; j < n; j++) {
	                colSum[i][j] = colSum[i - 1][j] + matrix[i - 1][j];
	            }
	        }
	    }
	    
	    public void update(int row, int col, int val) {
	        for (int i = row + 1; i < colSum.length; i++) {
	            colSum[i][col] = colSum[i][col] - matrix[row][col] + val;
	        }
	        matrix[row][col] = val;
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        int sum = 0;
	        for (int j = col1; j <= col2; j++) {
	            sum += colSum[row2 + 1][j] - colSum[row1][j]; 
	        }
	        return sum;
	    }

}
