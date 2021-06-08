/*completed
 * Given an integer A find the Ath number whose binary representation is a palindrome.

NOTE:

Consider the 1st number whose binary representation is palindrome as 1, instead of 0
Do not consider the leading zeros, while considering the binary representation.


Problem Constraints
1 <= A <= 2104



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the Ath number whose binary representation is a palindrome.



Example Input
Input 1:

 A = 1
Input 1:

 A = 9


Example Output
Output 1:

 1
Output 2:

 27


Example Explanation*
Explanation 1:

 1st Number whose binary representation is palindrome is 1
Explanation 2

 9th Number whose binary representation is palindrome is 27 (11011)
 */

package interviewbit;

public class Palindromic_Binary_Representation {

	public int solve(int n) {
        Queue<String> q = new LinkedList<>();

       // base case
       if (n == 1)
           return 1;
       n = n - 1;

       // add 2nd binary palindrome string
       q.add("11");

       // runs till the nth binary palindrome number
       while (n-- > 0) {

           // remove curr binary palindrome string from
           // queue
           String curr = q.remove();

           // if n==0 then we find the n'th binary
           // palindrome so we return our answer
           if (n == 0)
               return Integer.parseInt(curr,2);

           // calculate length of curr binary palindrome
           // string
           int len = curr.length();

           // if length is even .so it is our first case
           // we have two choices
           if (len % 2 == 0) {
               q.add(curr.substring(0, len / 2) + "0"
                     + curr.substring(len / 2));
               q.add(curr.substring(0, len / 2) + "1"
                     + curr.substring(len / 2));
           }

           // if length is odd .so it is our second case
           // we have only one choice
           else {
               char midChar = curr.charAt(len / 2);
               q.add(curr.substring(0, len / 2) + midChar
                     + curr.substring(len / 2));
           }
       }
       return -1;
   }
	
}
