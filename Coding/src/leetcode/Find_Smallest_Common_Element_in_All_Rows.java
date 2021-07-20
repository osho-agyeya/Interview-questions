/*completedd
 * 
 * Given a matrix mat where every row is sorted in increasing order, return the smallest common element in all rows.

If there is no common element, return -1.

 

Example 1:

Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
Output: 5
 

Constraints:

1 <= mat.length, mat[i].length <= 500
1 <= mat[i][j] <= 10^4
mat[i] is sorted in increasing order.
 * 
 */

package leetcode;

public class Find_Smallest_Common_Element_in_All_Rows {
	
	public int smallestCommonElement(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return -1;
        int rows = mat.length, columns = mat[0].length;
        int[] indices = new int[rows];
        boolean flag = true;
        int curElement = 0;
        while (flag) {
            int count = 0;
            for (int i = 0; i < rows; i++) {
                int element = mat[i][indices[i]];
                curElement = Math.max(curElement, element);
            }
            for (int i = 0; i < rows; i++) {
                int element = mat[i][indices[i]];
                if (element == curElement)
                    count++;
                else if (element < curElement) {
                    indices[i]++;
                    if (indices[i] >= columns) {
                        flag = false;
                        break;
                    }
                }
            }
            if (count == rows)
                return curElement;
        }
        return -1;
    }

}
