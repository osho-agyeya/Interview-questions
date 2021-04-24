//completed

//t=S
//s=

/*
 * 
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
 * 
 * 
 */
package leetcode;


import java.util.Stack;

public class Basic_Calculator_II {
	
	public int calculate(String s) {
        int len;
if(s==null || (len = s.length())==0) return 0;
Stack<Integer> stack = new Stack<Integer>();
int num = 0;
char sign = '+';
for(int i=0;i<len;i++){
    if(Character.isDigit(s.charAt(i))){
        num = num*10+s.charAt(i)-'0';
    }
    if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
        if(sign=='-'){
            stack.push(-num);
        }
        if(sign=='+'){
            stack.push(num);
        }
        if(sign=='*'){
            stack.push(stack.pop()*num);
        }
        if(sign=='/'){
            stack.push(stack.pop()/num);
        }
        sign = s.charAt(i);
        num = 0;
    }
}

int re = 0;
for(int i:stack){
    re += i;
}
return re;
}

}
