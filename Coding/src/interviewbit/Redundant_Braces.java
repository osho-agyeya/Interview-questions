//ddoe
/*
 * Redundant Braces
Asked in:  
Amazon
Given a string A denoting an expression. It contains the following operators ’+’, ‘-‘, ‘*’, ‘/’.

Chech whether A has redundant braces or not.

Return 1 if A has redundant braces, else return 0.

Note: A will be always a valid expression.



Input Format

The only argument given is string A.
Output Format

Return 1 if string has redundant braces, else return 0.
For Example

Input 1:
    A = "((a + b))"
Output 1:
    1
    Explanation 1:
        ((a + b)) has redundant braces so answer will be 1.

Input 2:
    A = "(a + (a + b))"
Output 2:
    0
    Explanation 2:
        (a + (a + b)) doesn't have have any redundant braces so answer will be 0.
 */

package interviewbit;

import java.util.Stack;

public class Redundant_Braces {
	
	public int braces(String a) {
	    Stack<Character> stack = new Stack<Character>();
	    for(int i = 0; i < a.length(); i++) {
	        if(a.charAt(i) == '(' || a.charAt(i) == '+' || a.charAt(i) == '-' || a.charAt(i) == '*' || a.charAt(i) == '/') {
	            stack.push(a.charAt(i));
	        } else if (a.charAt(i) == ')') {
	            boolean didPopSymbol = false;
	            while(stack.peek() != '(') {
	                didPopSymbol = true;
	                stack.pop();	           
	            }
	            if(!didPopSymbol) return 1;
	            stack.pop();
	        }
	    }
	    return 0;
	}

}
