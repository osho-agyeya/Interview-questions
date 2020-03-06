//done
package interviewbit;
/*
 * Evaluate Expression To True
Asked in:  
Amazon
Given an expression, A, with operands and operators (OR , AND , XOR), in how many ways can you evaluate the expression to true, by grouping in different ways?

Operands are only true and false.

Return the number of ways to evaluate the expression modulo 103 + 3.



Input Format:

The first and the only argument of input will contain a string, A.

The string A, may contain these characters:
    '|' will represent or operator 
    '&' will represent and operator
    '^' will represent xor operator
    'T' will represent true operand
    'F' will false
Output:

Return an integer, representing the number of ways to evaluate the string.
Constraints:

1 <= length(A) <= 150
Example:

Input 1:
    A = "T|F"

Output 1:
    1

Explanation 1:
    The only way to evaluate the expression is:
        => (T|F) = T 

Input 2:
    A = "T^T^F"
    
Output 2:
    0
    
Explanation 2:
    There is no way to evaluate A to a true statement.
 */

public class Evaluate_Expression_To_True {
	
	  public int cnttrue(String s) {
	        pair[][] dp = new pair[s.length()][s.length()];
	        pair ways = getcount(s, 0, s.length() - 1, dp);
	        return ways.tc;
	    }
	    
	    static class pair {
	        int tc;
	        int fc;
	        pair(int tc, int fc) {
	            this.tc = tc;
	            this.fc = fc;
	        }
	    }
	    
	    public static pair getcount(String s, int st, int end, pair[][] dp) {
	        if(st == end) {
	            if(s.charAt(st) == 'T') {
	                return new pair(1, 0);
	            } else {
	                return new pair(0, 1);
	            }
	        } else if(dp[st][end] != null) {
	            return dp[st][end];
	        } else {
	            int i = st + 1;
	            int tc = 0;
	            int fc = 0;
	            while(i < end) {
	                char op = s.charAt(i);
	                pair lp = getcount(s, st, i - 1, dp);
	                pair rp = getcount(s, i + 1, end, dp);
	                int t = 0;
	                int f = 0;
	                if(op == '|') {
	                    t = (((lp.tc % 1003) * (rp.tc % 1003))  % 1003 + 
	                        ((lp.fc % 1003) * (rp.tc % 1003)) % 1003 +
	                        ((lp.tc % 1003) * (rp.fc % 1003)) % 1003) % 1003;
	                    f = ((lp.fc % 1003) * (rp.fc % 1003)) % 1003;
	                } else if(op == '&') {
	                    t = ((lp.tc % 1003) * (rp.tc % 1003)) % 1003;
	                    f = (((lp.fc % 1003) * (rp.fc % 1003)) % 1003 + 
	                        ((lp.fc % 1003) * (rp.tc % 1003)) % 1003 +
	                        ((lp.tc % 1003) * (rp.fc % 1003)) % 1003) % 1003;
	                } else {
	                    t = (((lp.fc % 1003) * (rp.tc % 1003)) % 1003 + 
	                        ((lp.tc % 1003) * (rp.fc % 1003)) % 1003) % 1003;
	                    f = (((lp.tc % 1003) * (rp.tc % 1003)) % 1003 + 
	                        ((lp.fc % 1003) * (rp.fc % 1003)) % 1003) % 1003;
	                }
	                tc = ((tc % 1003) + (t % 1003)) % 1003;
	                fc = ((fc % 1003) + (f % 1003)) % 1003;
	                
	                i = i + 2;
	            }
	            
	            pair p = new pair(tc, fc);
	            dp[st][end] = p;
	            return p;
	        }
	    }

}
