//ddoe
/*
 * Reverse the String
Asked in:  
Qualcomm
Amazon
Microsoft
Cisco
Facebook
Given a string A.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.

Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.

If there are multiple spaces between words, reduce them to a single space in the reversed string.



Input Format

The only argument given is string A.
Output Format

Return the string A after reversing the string word by word.
For Example

Input 1:
    A = "the sky is blue"
Output 1:
    "blue is sky the"

Input 2:
    A = "this is ib"
Output 2:
    "ib is this"
 */

package interviewbit;

public class Reverse_the_String {
	 public String reverseWords(String a) {
        a=a.trim();
        String arr[]=a.split("\\s+");
        int le=arr.length;
        String res="";
        for (int i=le-1;i>=0;i--) {
            res+=(arr[i]+" ");
        }
        res=res.trim();
        return res;
    }
	

}
