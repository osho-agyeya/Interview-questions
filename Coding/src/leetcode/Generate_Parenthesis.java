//ddoe

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 * 
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parenthesis {
	
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
