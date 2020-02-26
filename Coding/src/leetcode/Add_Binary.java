//ddone
//t=max(a,b)
//s=1

/*
 * 
 * 
 * Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 * 
 * 
 */
package leetcode;

public class Add_Binary {

	
	public String addBinary(String a, String b) {
        int lena = a.length();
    int lenb = b.length();
    int i =0, carry = 0;
    String res = "";
    while(i<lena || i<lenb || carry!=0){
        int x = (i<lena) ? Character.getNumericValue(a.charAt(lena - 1 - i)) : 0;
        int y = (i<lenb) ? Character.getNumericValue(b.charAt(lenb - 1 - i)) : 0;
        res = (x + y + carry)%2 + res;
        carry = (x + y + carry)/2;
        i++;
    }
    return res;
    }
	
}
