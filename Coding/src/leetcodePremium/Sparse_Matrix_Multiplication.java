/*completedd
 *
 * 
 * Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 * 
 */

package leetcodePremium;

public class Sparse_Matrix_Multiplication {
	
	public int[][] multiply(int[][] A, int[][] B) {
	    //validity check
	 
	    int[][] C = new int[A.length][B[0].length];
	 
	    for(int i=0; i<C.length; i++){
	        for(int k=0; k<A[0].length; k++){
	            if(A[i][k]!=0){
	                for(int j=0; j<C[0].length; j++){
	                    C[i][j] += A[i][k]*B[k][j];
	                }
	            }
	        }
	    }
	 
	    return C;
	}

}
