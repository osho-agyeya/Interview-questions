//completed

/*T=N
 * 
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
Example 4:

Input: columnNumber = 2147483647
Output: "FXSHRXW"
 

Constraints:

1 <= columnNumber <= 231 - 1
 * 
 * 
 */
package leetcode;

public class Excel_Sheet_Column_Title {
	
	public String convertToTitle(int n) {
        String res = "";
    while(n != 0) {
        char ch = (char)((n - 1) % 26 + 65);
        n = (n - 1) / 26;
        res = ch + res;
    }
    return res;
    }

}
