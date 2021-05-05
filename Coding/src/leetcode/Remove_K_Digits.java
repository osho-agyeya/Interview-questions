/*completed
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */

package leetcode;

public class Remove_K_Digits {
	 public String removeKdigits(String num, int k) {        
	        if(k >= num.length()) return "0";

	        Deque<Character> stack = new ArrayDeque<>();
	        for(char c : num.toCharArray()) {
	            while(k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
	                stack.removeLast();
	                k--;
	            }
	            stack.addLast(c);
	        }
	        
	        while(k>0) {
	            stack.removeLast();
	            k--;
	        }
	        
	        // Remove all zeros from the front of the stack and then if stack is empty, return "0"
	        while(!stack.isEmpty() && stack.peekFirst()== '0') stack.removeFirst();
	        if(stack.isEmpty()) return "0";

	        // build the number from the stack
	        StringBuilder sb = new StringBuilder();
	        while(!stack.isEmpty()) {
	            sb.append(stack.removeFirst());
	        }
	        return sb.toString();
	    }
}
