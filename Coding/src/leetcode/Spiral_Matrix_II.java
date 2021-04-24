//completed
/*
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
 */
package leetcode;

public class Spiral_Matrix_II {
	
	 public int[][] generateMatrix(int n) {
        // similar to spiral matrix I,done by myself
        int[][] rs = new int[n][n];
        int top = 0,bottom = n-1,left = 0,right = n-1;
        int num = 1;
        
        while(left<=right && top <=bottom){
            for(int i=left;i<=right;i++){
                rs[top][i] = num++;
            }
            top++;
            for(int i= top;i<=bottom;i++){
                rs[i][right] = num++;
            }
            right--;
            for(int i= right;i>=left;i-- ){
                rs[bottom][i] = num++;
            }
            bottom--;
            for(int i = bottom;i>=top;i--){
                rs[i][left] = num++;
            }
            left++;
        }
        return rs;
    }

}
