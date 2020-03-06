//done
/*
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Remove_Invalid_Parentheses {
	
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
      if (s == null) return res;
      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();
      queue.add(s);
      visited.add(s);
      while (!queue.isEmpty()) {
        s = queue.poll();    
        if (isValid(s)) {
          res.add(s);
          break;
        } 
        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
          String t = s.substring(0, i) + s.substring(i + 1);
          if (!visited.contains(t)) {
            queue.add(t);
            visited.add(t);
          }
        }
      }
        while(!queue.isEmpty()) {
                String ll = queue.poll();
                if(isValid(ll)) res.add(ll);
            }
      
      return res;
    }
    
    boolean isValid(String s) {
      int count = 0;
      for (char c : s.toCharArray()) {
        if (c == '(') count++;
        if (c == ')' && count-- == 0) return false;
      }
      return count == 0;
    }

}
