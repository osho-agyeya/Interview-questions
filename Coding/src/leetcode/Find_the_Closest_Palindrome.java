/*completedd
 * Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.

The closest is defined as the absolute difference minimized between two integers.

 

Example 1:

Input: n = "123"
Output: "121"
Example 2:

Input: n = "1"
Output: "0"
Explanation: 0 and 2 are the closest palindromes but we return the smallest which is 0.
 

Constraints:

1 <= n.length <= 18
n consists of only digits.
n does not have leading zeros.
n is representing an integer in the range [1, 1018 - 1].
 */

package leetcode;

public class Find_the_Closest_Palindrome {
	
	 public String nearestPalindromic(String n) {
	        int len = n.length();
	        boolean isEven = (len & 1) == 0;
	        int i = isEven ? (len >> 1) : (len >> 1) + 1;
	        long left = Long.parseLong(n.substring(0, i));
	        
	        // input: n 12345
	        List<Long> candidate = new ArrayList<>();
	        
	        candidate.add(getPalindrome(left, isEven)); // 12321
	        candidate.add(getPalindrome(left + 1, isEven)); // 12421
	        candidate.add(getPalindrome(left - 1, isEven)); // 12221
	        candidate.add((long)Math.pow(10, len - 1) - 1); // 9999
	        candidate.add((long)Math.pow(10, len) + 1); // 100001
	        
	        long minDiff = Long.MAX_VALUE;
	        long res = 0;
	        long nl = Long.parseLong(n);
	       for (long cand : candidate) {
	            long curDiff = Math.abs(cand - nl);
	            if (cand != nl) {
	                if (curDiff < minDiff) {
	                    minDiff = curDiff;
	                    res = cand;
	                } else if (curDiff == minDiff) {
	                    res = Math.min(res, cand);
	                }
	            }            
	        }
	        
	        return String.valueOf(res);
	    }
	    
	    private long getPalindrome(long left, boolean isEven) {
	        long res = left;
	        if (!isEven) {
	            left = left / 10;
	        }
	        while (left > 0) {
	            res = res * 10 + left % 10;
	            left /= 10;
	        }
	        return res;
	        
	    }

}
