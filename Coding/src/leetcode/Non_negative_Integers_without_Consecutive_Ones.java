//ddone

/*
 * Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.

Example 1:
Input: 5
Output: 5
Explanation: 
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
Note: 1 <= n <= 109
 * 
 */

package leetcode;

public class Non_negative_Integers_without_Consecutive_Ones {
	 public int findIntegers(int num) {
	        StringBuffer sb = new StringBuffer(Integer.toBinaryString(num));
	        //System.out.println(sb);
	        int n = sb.length();
	        // a[i] means length of i and ends with 0.
	        // b[i] means length of i and ends with 1.
	        int[] a = new int[n], b = new int[n];
	        a[0] = b[0] = 1;
	        for(int i = 1; i < n; i++) {
	            a[i] = a[i-1] + b[i-1];
	            b[i] = a[i-1];
	        }
	        int res = a[n-1] + b[n-1];
	        for(int i = 1; i < n; i++) {
	            if(sb.charAt(i) == '1' && sb.charAt(i-1) == '1')    break;
	            if(sb.charAt(i) == '0' && sb.charAt(i-1) == '0')    res = res - b[n-i-1];
	        }
	        return res;
	        
	    }
}
