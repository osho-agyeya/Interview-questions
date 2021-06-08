/*completedd
 * Given the position of a Bishop (A, B) on an 8 * 8 chessboard.

Your task is to count the total number of squares that can be visited by the Bishop in one move.

The position of the Bishop is denoted using row and column number of the chessboard.



Problem Constraints
1 <= A, B <= 8



Input Format
First argument is an integer A denoting the row number of the bishop.

Second argument is an integer B denoting the column number of the bishop.



Output Format
Return an integer denoting the total number of squares that can be visited by the Bishop in one move.



Example Input
Input 1:

 A = 4
 B = 4


Example Output
Output 1:

 13
 */
package interviewbit;

public class Total_Moves_For_Bishop {
	
    public int solve(int A, int B) {
        int l1 = Math.min(A,B)-1;
int l2 = 8 - Math.max(A,9-B);
int r1 = Math.min(A,9-B)-1;
int r2 = 8 - Math.max(A,B);
return (l1+l2+r2+r1);

}

}
