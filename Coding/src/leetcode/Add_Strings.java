/*completedd
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
 

Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.
 

Follow up: Could you solve it without using any built-in BigInteger library or converting the inputs to integer directly?
 * 
 */

package leetcode;

public class Add_Strings {
	 public String addStrings(String num1, String num2) {
	        StringBuilder sb = new StringBuilder();
	        int carry = 0;
	        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
	            int x = i < 0 ? 0 : num1.charAt(i) - '0';
	            int y = j < 0 ? 0 : num2.charAt(j) - '0';
	            sb.append((x + y + carry) % 10);
	            carry = (x + y + carry) / 10;
	        }
	        return sb.reverse().toString();
	    }
	

}
