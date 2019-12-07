package interviewbit;
/*
 * Ways to color a 3xN Board
Asked in:  
Codenation
Problem Setter: raghav_aggiwal Problem Tester: glowing_glare
Given a 3 x A board, find the number of ways to color it using at most 4 colors such that no 2 adjacent boxes have same color.

Diagonal neighbors are not treated as adjacent boxes.

Return the ways modulo 109 + 7 as the answer grows quickly.

Input Format:

The first and the only argument contains an integer, A.
Output Format:

Return an integer representing the number of ways to color the board.
Constraints:

1 <= A < 100000
Examples:

Input 1:
    A = 1

Output 1:
    36

Input 2:
    A = 2

Output 2:
    588
 */
public class Ways_to_color_a_3xN_Board {
	 public int solve(int A) {
	        long color3=24;
	        long color2=12;
	        
	        for(int i=2;i<=A;i++){
	            long temp=color3;
	            color3=(11*color3+10*color2)%1000000007;
	            color2=(5*temp+7*color2)%1000000007;
	        }
	        long ans=(color2+color3)%1000000007;
	        
	        return (int)ans;
	    }
}
