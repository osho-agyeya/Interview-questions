//doe

/*T=N
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
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
