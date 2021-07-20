/* over, (4^n)/(sqrt(n)), (4^n)/(sqrt(n)) + n
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parenthesis {
	
	/*
	 *
	 *
	 * Approach 2: Backtracking
Intuition and Algorithm

Instead of adding '(' or ')' every time as in Approach 1, let's only add them when we know it will remain a valid sequence. We can do this by keeping track of the number of opening and closing brackets we have placed so far.

We can start an opening bracket if we still have one (of n) left to place. And we can start a closing bracket if it would not exceed the number of opening brackets.


Complexity Analysis

Our complexity analysis rests on understanding how many elements there are in generateParenthesis(n). This analysis is outside the scope of this article, but it turns out this is the n-th Catalan number \dfrac{1}{n+1}\binom{2n}{n} 
n+1
1
​
 ( 
n
2n
​
 ), which is bounded asymptotically by \dfrac{4^n}{n\sqrt{n}} 
n 
n
​
 
4 
n
 
​
 .

Time Complexity : O(\dfrac{4^n}{\sqrt{n}})O( 
n
​
 
4 
n
 
​
 ). Each valid sequence has at most n steps during the backtracking procedure.

Space Complexity : O(\dfrac{4^n}{\sqrt{n}})O( 
n
​
 
4 
n
 
​
 ), as described above, and using O(n)O(n) space to store the sequence.

	 *
	 */
	
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            //System.out.println(str);
            return;
        }
        
        if(open < max) {
        	
        	//System.out.println(str);
            backtrack(list, str+"(", open+1, close, max);
        }
        if(close < open) {
        	//System.out.println(str);
        	backtrack(list, str+")", open, close+1, max);
        }
            
    }

}
